package com.kapava.ui.controllers;

import java.security.Principal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kapava.common.util.Constants;
import com.kapava.service.AuthenticationService;

@Controller
public class LoginController {

	@Resource(name="authenticationService")
	AuthenticationService authenticationService;

	@RequestMapping(value = "/protected/welcome.htm", method = RequestMethod.GET)
	public String printWelcome(HttpServletRequest request, ModelMap model, Principal principal) {

    	if (principal != null) {
    		request.getSession().setAttribute(Constants.SESSION_KEY_USER_IS_AUTHENTICATED, Boolean.TRUE);
    	}

		return "auth.welcome.page";

	}

	@RequestMapping(value = "/protected/projects.htm", method = RequestMethod.GET)
	public String projects(ModelMap model, Principal principal) {

    	Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
    	if (currentUser != null) {
    		String username = currentUser.getName();
    		model.addAttribute("username", username);
    	}
		model.addAttribute("message", "Spring Security Custom Form example");

		return "projects.page";

	}

	@RequestMapping(value = "/protected/investments.htm", method = RequestMethod.GET)
	public String investments(ModelMap model, Principal principal) {

    	Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
    	if (currentUser != null) {
    		String username = currentUser.getName();
    		model.addAttribute("username", username);
    	}
		model.addAttribute("message", "Spring Security Custom Form example");

		return "investments.page";

	}

	@RequestMapping(value = "/homePage/login.htm", method = RequestMethod.GET)
	public String login(ModelMap model, HttpServletRequest request) {
		String username = request.getParameter("j_username");
		try {
			authenticationService.authenticate(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login.page";

	}

	@RequestMapping(value = "/homePage/initLogin.htm", method = RequestMethod.GET)
	public String initLogin(ModelMap model, HttpServletRequest request) {
		if (request.getSession().getAttribute(Constants.SESSION_KEY_USER_IS_AUTHENTICATED) != null) {
			return "auth.welcome.page";
		}

		return "login.page";
	}

	@RequestMapping(value = "/homePage/loginfailed.htm", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "true");
		return "login.page";

	}

	@RequestMapping(value = "/homePage/accessDenied.htm", method = RequestMethod.GET)
	public String accessDenied(ModelMap model) {

		model.addAttribute("error", "true");
		return "access.denied.page";

	}

	@RequestMapping(value = "/protected/logout.htm", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login.page";
	}
}