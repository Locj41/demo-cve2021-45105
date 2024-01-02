package com.log4j.cve;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestMainController {

	private static final Logger logger = LogManager.getLogger(RestMainController.class);

	@GetMapping("/")
	public String echo(HttpServletRequest httpRequest) {
		String userAgent = httpRequest.getHeader("User-Agent");
		ThreadContext.put("user-agent", userAgent);
		logger.info("Received a request");
		return "Hello, API Controller!";
	}
	
	@PostMapping("/addrecord")
	public String addRecord(@RequestBody InputRequest request) {
		ThreadContext.put("clientRef", request.getClientRef());
		logger.info("Received a request");
		return "Hello, Input Request!";
	}
}
