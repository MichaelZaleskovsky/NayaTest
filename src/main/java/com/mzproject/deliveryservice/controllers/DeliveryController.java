package com.mzproject.deliveryservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mzproject.deliveryservice.models.Message;
import com.mzproject.deliveryservice.services.DeliveryService;

@RestController
public class DeliveryController {
	
	@Autowired
	DeliveryService deliveryService;
	
	@PostMapping("/messages")
	ResponseEntity<String> sendMessage(@RequestBody Message message) {
		
		String result = deliveryService.send(message);
		return ResponseEntity.ok(result);
	}
	

}
