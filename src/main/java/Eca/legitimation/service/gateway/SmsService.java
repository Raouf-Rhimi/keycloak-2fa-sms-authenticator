package Eca.legitimation.service.gateway;

import java.util.Map;


public interface SmsService {

	void send(String phoneNumber, String message);

}
