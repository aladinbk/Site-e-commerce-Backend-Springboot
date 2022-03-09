package org.sid.lightecom.web;

import org.sid.lightecom.entities.Users;
import org.sid.lightecom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public Users authenticate(@RequestBody Users user) {
		return userService.authenticate(user);
	}
}
