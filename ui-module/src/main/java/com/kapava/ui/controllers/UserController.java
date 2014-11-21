package com.kapava.ui.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kapava.common.bean.LabelValueBean;
import com.kapava.common.dto.UserDto;
import com.kapava.dao.entity.User;
import com.kapava.service.UserService;

@Controller
@RequestMapping("/protected")
public class UserController {

	@Resource(name="userService")
	UserService userService;

	@RequestMapping(value = "/createUserForm.htm")
	public ModelAndView createForm() {
		ModelAndView mav = new ModelAndView("user.create.page");
		try {
			List<LabelValueBean> userRoleList = userService.getAllRoles();
			mav.addObject("userRoles", userRoleList);
			mav.addObject("user", new User());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/createUser.htm")
	public ModelAndView create(UserDto userDto) {
		try {
			userService.create(userDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("user.show.page");
		mav.addObject("user", userDto);

		return mav;
	}


	@RequestMapping(value = "/createUser.htm", params = "cancelCreateUser")
	public String cancelCreateUser(HttpServletRequest request, HttpServletResponse response) {
		return null; //TODO: list(request, response);
	}

	@RequestMapping(value = "/updateUserForm.htm")
	public ModelAndView updateForm(HttpServletRequest request) {
		UserDto userDto = null;
		List<LabelValueBean> userRoleList = null;
		String userName = request.getParameter("userName");
		try {
			userRoleList = userService.getAllRoles();
			userDto = userService.find(userName);
			userRoleList = userService.getAllRoles();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("user.update.page");
		mav.addObject("user", userDto);
		mav.addObject("userRoles", userRoleList);

		return mav;
	}

	@RequestMapping(value = "/updateUser.htm")
	public ModelAndView update(UserDto userDto) {
		try {
			userService.update(userDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("user.show.page");
		mav.addObject("user", userDto);

		return mav;
	}

	@RequestMapping(value = "/updateUser.htm", params = "cancelUpdateUser")
	public String cancelUpdateUser(HttpServletRequest request, HttpServletResponse response) {
		return null;//TODO: list(request, response);
	}

	@RequestMapping(value = "/showUserDetails.htm")
	public ModelAndView showUserDetails(HttpServletRequest request) {
		UserDto userDto = null;
		String userName = request.getParameter("userName");
		try {
			userDto = userService.find(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("user.show.page");
		mav.addObject("user", userDto);

		return mav;
	}

	@RequestMapping(value = "/listUsersForm.htm")
	public ModelAndView listUsersForm() {
		ModelAndView mav = new ModelAndView("user.list.page");
		return mav;
	}

	@RequestMapping(value = "/listUsers.json", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String list(HttpServletRequest request, HttpServletResponse response) {
		String jsonResponse = null;
		try {
			jsonResponse = userService.jsonUserList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonResponse;
	}

	@RequestMapping(value = "/deleteUser.htm")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		try {
			userService.delete(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; //TODO: list(request, response);
	}
}