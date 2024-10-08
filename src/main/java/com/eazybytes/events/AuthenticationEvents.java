package com.eazybytes.events;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthenticationEvents {
	
	@EventListener
	public void onSuccess(AuthenticationSuccessEvent successEvent) {
		
		System.out.println("now we are in the onsuccess method.....");
		
		log.info("Login successful for the user:{}", successEvent.getAuthentication().getName());
		
	}
	
	@EventListener
	public void onFailure(AbstractAuthenticationFailureEvent failureEvent) {
		
		System.out.println("now we are in the onfailure method.....");
		
		log.error("Login failed for the user: {} due to:{}", failureEvent.getAuthentication().getName(),
				failureEvent.getException().getMessage());
	}
	/*
	Whenever I mention this annotation,

	it is going to provide me a log variable

	which I can directly use to log the info messages,

	error messages, or any other type

	of messages based upon my business requirements.
	
	*/

}
