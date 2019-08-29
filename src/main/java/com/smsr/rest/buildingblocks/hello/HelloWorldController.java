package com.smsr.rest.buildingblocks.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author msatti
 *
 */
@RestController
public class HelloWorldController {

	/**
	 * 
	 * @return
	 */
	//@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
	@GetMapping("/helloworld")
	public String helloWorld() {
		return "Hello World1";
	}
	
	@GetMapping("/helloworld-bean")
	public UserDetails hellowWorldBean() {
		return new UserDetails("Madhu", "Satti", "Hyderabad");
	}
}
