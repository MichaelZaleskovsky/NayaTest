package com.mzproject.deliveryservice.services.implementations;

import org.springframework.stereotype.Component;

import com.mzproject.deliveryservice.services.SenderService;

@Component("email")
public class EmailSender implements SenderService {

	@Override
	public String send(String messageText) {
		
		return "Message have sent by email: " + messageText;
	}

}
