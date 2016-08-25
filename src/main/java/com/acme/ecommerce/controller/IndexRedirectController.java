package com.acme.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.acme.ecommerce.controller.WebConstants.REDIRECT_TO_BASE;

@Controller
public class IndexRedirectController {

	final Logger logger = LoggerFactory.getLogger(IndexRedirectController.class);
	
	@RequestMapping("/")
    public String root() {
		logger.debug("Redirecting from / to /product/");
		return REDIRECT_TO_BASE;
	}
	
	@RequestMapping("/index.*")
	public String index() {
		logger.debug("Redirecting from /index to /product/");
		return REDIRECT_TO_BASE;
	}
}
