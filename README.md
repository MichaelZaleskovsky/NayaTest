# Interview Task Application

Test for NAYA Technologies.


Created using **SpringBoot** framework.

Clone application as **Maven** project.

Run **DeliveryserviceApplication.java** to start server.

Test using **Junit** and **Rest-assured** library.

Run **DeliveryserviceApplicationTests.java** for test.


# API List

------------------------------------------------------------------
## 1. DDELIVERY MESSAGE  

### REQUEST

Type - POST

URL - http://localhost:8080/

Body
```
{
	messageBody: "message",
	messageType: "type"
}

Acceptable value for type: "sms", "email", "whatsapp"
```
### RESPONSE

Confirmation message;