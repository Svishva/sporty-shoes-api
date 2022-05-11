package com.sportyshoes.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Product;
import com.sportyshoes.models.User;
import com.sportyshoes.services.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	private static final Logger log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private UserService userService;

	@PatchMapping("/{adminId}/update/password")
	public String updateAdminPassword(@PathVariable String adminId, @RequestBody User user) {
		try {
			log.info("updateAdminPassword called \tAdmin ID =" + adminId + "\t Password =" + user.getPassword());

			this.userService.updateUserPassword(User.builder().userId(adminId).password(user.getPassword()).build());
			return "Admin Password updated Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@PostMapping("/signIn")
	public String signIn(@RequestBody User user) {
		try {
			this.userService.signIn(user);
			return "Sign in Successful";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
