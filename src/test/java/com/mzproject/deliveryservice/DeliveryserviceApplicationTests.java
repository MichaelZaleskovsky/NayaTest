package com.mzproject.deliveryservice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import com.mzproject.deliveryservice.models.Message;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DeliveryserviceApplicationTests {

	@LocalServerPort
	private int port;
	
	private String host = "http://localhost:";
	private String testString = "test string";
	private Message message = new Message();
	{
		message.setMessageBody(testString);
	}
	
	@Test
	void smsMessageDelivery() {
		
		String expectedRecord = "Message have sent by SMS: " + testString;
		message.setMessageType("sms");
		
		given().contentType("application/json").body(message) 								
		.when().post(host + port + "/messages")
		.then() 
		.assertThat().body(equalTo(expectedRecord));

	}

	@Test
	void emailMessageDelivery() {
		
		String expectedRecord = "Message have sent by email: " + testString;
		message.setMessageType("email");
		
		given().contentType("application/json").body(message) 								
		.when().post(host + port + "/messages")
		.then() 
		.assertThat().body(equalTo(expectedRecord));

	}

	@Test
	void whatsappMessageDelivery() {
		
		String expectedRecord = "Message have sent by WhatsApp: " + testString;
		message.setMessageType("whatsapp");
		
		given().contentType("application/json").body(message) 								
		.when().post(host + port + "/messages")
		.then() 
		.assertThat().body(equalTo(expectedRecord));

	}

	@Test
	void wrongMessageDelivery() {
		
		String expectedRecord = "This type of message not supported: pigeon";
		message.setMessageType("pigeon");
		
		given().contentType("application/json").body(message) 								
		.when().post(host + port + "/messages")
		.then() 
		.assertThat().body(equalTo(expectedRecord));

	}

}
