package ihundan.wukonglin.synthesize.config;

import ihundan.wukonglin.synthesize.security.model.SecurityRole;
import ihundan.wukonglin.synthesize.security.service.SecurityServiceUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	public SecurityServiceUser securityServiceUser;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/resources/**", "/login**").permitAll()
        .antMatchers("/admin/**").hasRole(SecurityRole.ADMIN.name())
        .antMatchers("/user/**").hasAnyRole(SecurityRole.USER.name(),SecurityRole.ADMIN.name())
        .antMatchers("/other/**").hasRole(SecurityRole.OTHER.name())
//        .antMatchers("/user/**").hasAnyRole("user","USER","admin","ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login.jsp")//// default is /login with an HTTP get
        .loginProcessingUrl("/login")// default is /login with an HTTP post
        .usernameParameter("username")
        .passwordParameter("password")
        .defaultSuccessUrl("/")
        .failureUrl("/login.jsp?failure") // default is /login?error
        .permitAll()
        .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login.jsp?quit")
        .deleteCookies("JSESSIONID")
        /**
         * 单点登陆，当在别的地方有登陆之后，原地址跳转到相应地址
         */
        .and()
        .sessionManagement()
        .maximumSessions(1)
        .expiredUrl("/login.jsp?singlePoint")
        ;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(securityServiceUser);
	}

}
