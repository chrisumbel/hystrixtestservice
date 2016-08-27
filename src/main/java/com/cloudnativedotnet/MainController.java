package com.cloudnativedotnet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {
	@RequestMapping("/")
	public String index(@RequestParam(value="sleep", defaultValue="0") int sleep) {
		HipsterCommand hipsterCommand = new HipsterCommand(sleep);
		return "Hello, world! " + hipsterCommand.execute();
	}
}
