package com.cloudnativedotnet;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// @FeignClient("http://timeshipsteripsum.cfapps.pez.pivotal.io")
public interface HipsterIpsumClient {
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	HipsterIpsum get(@RequestParam("sleep") int sleep);
}
