package com.tanmoy.brainstation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tanmoy.brainstation.domain.Status;
import com.tanmoy.brainstation.domain.User;
import com.tanmoy.brainstation.service.LocationService;
import com.tanmoy.brainstation.service.StatusService;
import com.tanmoy.brainstation.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private UserService userService;
	private StatusService statusService;
	private LocationService locationService;

	@Autowired
	public UserController(UserService userService, StatusService statusService, LocationService locationService) {
		this.userService = userService;
		this.statusService = statusService;
		this.locationService = locationService;
	}

	@GetMapping("/profile")
	public String getProfile(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!auth.isAuthenticated()) return "Login";
		User user = userService.findById(auth.getName());
		model.addAttribute("locationList", locationService.findAll());
		model.addAttribute("statusList", statusService.findByUserId(user.getUserId()));
		model.addAttribute("userDetails", user);
		model.addAttribute("userId", user.getUserId());
		return "Profile";
	}

	@GetMapping("/update")
	public String getStatusUpdate(Model model, @RequestParam(name = "statusId") int statusId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!auth.isAuthenticated()) return "Login";
		Status status = statusService.findById(statusId);		
		User user = userService.findById(auth.getName());
		if(!status.getUserId().equals(user.getUserId())) return "redirect:/user/profile";
		model.addAttribute("status", statusService.findById(statusId));
		model.addAttribute("userDetails", user);
		model.addAttribute("userId", user.getUserId());
		return "Update";
	}

	@PostMapping("/update")
	public String setStatusUpdate(Model model, @RequestParam(name = "statusId") int statusId,
			@ModelAttribute(name = "updateStatusForm") Status status) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!auth.isAuthenticated()) return "Login";
		Status upStatus = statusService.findById(statusId);
		upStatus.setStatusBody(status.getStatusBody());
		statusService.update(upStatus);
		return "redirect:/user/profile";
	}
}
