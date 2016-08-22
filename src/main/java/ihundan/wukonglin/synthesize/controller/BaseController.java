package ihundan.wukonglin.synthesize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	
	@RequestMapping("/")
	public String index() {
		return "index.index";
	}
	
	@RequestMapping("/admin/edit")
	public String admin_edit() {
		return "user.edit";
	}
	
	@RequestMapping("/other/edit")
	public String other_edit() {
		return "user.edit";
	}
}
