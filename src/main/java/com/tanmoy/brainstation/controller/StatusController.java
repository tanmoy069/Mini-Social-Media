package com.tanmoy.brainstation.controller;

import java.util.Calendar;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tanmoy.brainstation.domain.Status;
import com.tanmoy.brainstation.domain.User;
import com.tanmoy.brainstation.service.LocationService;
import com.tanmoy.brainstation.service.StatusService;
import com.tanmoy.brainstation.service.UserService;

@Controller
public class StatusController {

	private UserService userService;
	private StatusService statusService;
	private LocationService locationService;
	
	public StatusController(UserService userService, StatusService statusService, LocationService locationService) {
		this.userService = userService;
		this.statusService = statusService;
		this.locationService = locationService;
	}
	
	@GetMapping(value="/")
	public String redirectHome(Model model) {
		return getHome(model);
	}
	
	@GetMapping(value="/home")
	public String getHome(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.isAuthenticated()) return "Login";
		User user = userService.findById(auth.getName());
		model.addAttribute("locationList", locationService.findAll());
		model.addAttribute("statusList", statusService.findAllPublicStatus());
		model.addAttribute("userDetails", user);
		model.addAttribute("userId", user.getUserId());
		return "Home";
	}
	
	@PostMapping(value="/home")
	public String setStatus(Model model, @ModelAttribute("statuPostForm") Status status) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.isAuthenticated()) return "Login";
		status.setUserId(auth.getName());
		status.setCreatedDate(Calendar.getInstance().getTime());
		statusService.save(status);
		return "redirect:/home";
	}
}
