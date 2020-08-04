package az.maqa.keycloak.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {

	@RolesAllowed("admin")
	@GetMapping(value = "/welcome-admin")
	public String welcomeAdmin(@RequestHeader String authorization) {
		return "Hello, Admin.";
	}

	@RolesAllowed("user")
	@GetMapping(value = "/welcome-user")
	public String welcomeUser(@RequestHeader String authorization) {
		return "Hello, User.";
	}

	@RolesAllowed({ "user", "admin" })
	@GetMapping(value = "/welcome")
	public String welcomeAll(@RequestHeader String authorization) {
		return "Hello, All.";
	}

}
