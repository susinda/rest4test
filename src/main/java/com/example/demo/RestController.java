package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/app")
class ConfigController {

	@GetMapping("/hello/{name}")
	public String getHello(@PathVariable String name) {
         return "Hello " + name + " " + System.currentTimeMillis();
    }
	
	@PostMapping("/postHello")
	public String postHello(@RequestBody String body) {
         return "Payload you send " + body;
    }
	
}