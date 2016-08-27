package com.cloudnativedotnet;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HipsterCommand extends HystrixCommand<String> {
	private int sleep;
	
	public HipsterCommand(int sleep) {
		super(HystrixCommandGroupKey.Factory.asKey("HipsterGroup"));
		this.sleep = sleep;
	}

	@Override
	protected String run() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		// The API will sleep the response thread for the duration specified by "sleep" in seconds. The API is programmed to return "Hipster ipsum" text. It
		// kind of looks like Lorem ipsum except is filled with hipster terms.
		HipsterIpsum ipsum = restTemplate.getForObject("http://timeshipsteripsum.cfapps.pez.pivotal.io/api?sleep=" + String.valueOf(this.sleep), HipsterIpsum.class);
		
		return ipsum.getText();
	}
	
    @Override
    protected String getFallback() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    }	
}
