package com.cloudnativedotnet;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class HipsterIpsumService {
	@HystrixCommand(fallbackMethod = "getHipsterIpsumFallback", commandKey="HipsterCommand", 
			threadPoolKey="HipsterThreadGroup", groupKey="HipsterGroup", commandProperties = {
				@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
	})
	public String getHipsterIpsum(int sleep) {	
		RestTemplate restTemplate = new RestTemplate();
		HipsterIpsum ipsum = restTemplate.getForObject("http://timeshipsteripsum.cfapps.pez.pivotal.io/api?sleep=" + String.valueOf(sleep), HipsterIpsum.class);
		
		return ipsum.getText();
	}	
	
	public String getHipsterIpsumFallback(int sleep) {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    }
}
