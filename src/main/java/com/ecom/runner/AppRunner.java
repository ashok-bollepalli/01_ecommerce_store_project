package com.ecom.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ecom.model.UserDtls;
import com.ecom.service.UserService;

@Component
public class AppRunner implements ApplicationRunner {

	@Autowired
	private UserService userService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Boolean existsEmail = userService.existsEmail("admin@gmail.com");

		if (!existsEmail) {
			UserDtls user = new UserDtls();
			user.setEmail("admin@gmail.com");
			user.setPassword("admin");
			user.setAddress("Ameerpet");
			user.setCity("Hyd");
			user.setState("Telangana");
			user.setPincode("66868");
			user.setMobileNumber("9701787666");
			user.setName("Admin");
			userService.saveAdmin(user);
		}
	}
}
