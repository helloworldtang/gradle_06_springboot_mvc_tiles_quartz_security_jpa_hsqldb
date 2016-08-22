package ihundan.wukonglin.synthesize.controller;

import ihundan.wukonglin.synthesize.security.dataStore.SecurityUserRepository;
import ihundan.wukonglin.synthesize.security.model.SecurityRole;
import ihundan.wukonglin.synthesize.security.model.SecurityUser;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@Autowired
	public SecurityUserRepository userRepository;

	@RequestMapping("/user/edit")
	public String user_edit(HttpServletRequest request, ModelMap model) {
		Object objid = request.getAttribute("objid");
		if (objid != null) {
			SecurityUser user = userRepository.getOne((int) objid);
			model.addAttribute("user", user);
		}
		return "user.edit";
	}

	@RequestMapping("/user/list")
	public String user_list(ModelMap model) {
		model.put("listUser", userRepository.findAll());
		return "user.list";
	}
	
	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	public String user_save(@ModelAttribute SecurityUser user) {
		user.setRoles(SecurityRole.ADMIN.toString());
		userRepository.save(user);
		return "redirect:/user/list";
	}
}
