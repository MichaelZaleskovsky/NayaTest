package com.mzproject.deliveryservice.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzproject.deliveryservice.models.Message;

@Service
public class DeliveryService {
	
	private final String errMessage = "This type of message not supported: ";
	
	@Autowired
	Map<String, SenderService> senders;

	public String send(Message message) {
		
		String type = message.getMessageType();
		SenderService sender = senders.get(type);
		String result = sender == null ? 
				errMessage + type : sender.send(message.getMessageBody());
		
		return result;
	}

}
