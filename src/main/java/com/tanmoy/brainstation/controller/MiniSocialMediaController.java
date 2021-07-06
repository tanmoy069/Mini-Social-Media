package com.tanmoy.brainstation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tanmoy.brainstation.domain.User;
import com.tanmoy.brainstation.service.UserService;

@Controller
public class MiniSocialMediaController {

	private UserService userService;

	@Autowired
	public MiniSocialMediaController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/login")
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.isAuthenticated()) auth.setAuthenticated(false);
		return "Login";
	}

	@GetMapping(value = "/registration")
	public String getRegistrationFrom() {
		return "Registration";
	}

	@PostMapping(value = "/registration")
	public String submitRegistration(Model model, @ModelAttribute("userRegiForm") User user) {
		String bycrptPass = userService.getBycrptPassword(user.getPassword());
		user.setPassword(bycrptPass);
		System.out.println(user.toString());
		model.addAttribute("regiRequest", true);
		boolean isSave = userService.save(user);
		if (isSave) model.addAttribute("successful", true);
		else model.addAttribute("unsuccessful", true);
		return "Registration";
	}

}
