package com.cloudnativedotnet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@RestController
public class MainController {
	@Autowired
	private HipsterIpsumService hipsterIpsumService;
	
	@RequestMapping("/")
	public String index(@RequestParam(value="sleep", defaultValue="0") int sleep) {		
		return "Hello, world! " + hipsterIpsumService.getHipsterIpsum(sleep);
	}
}
