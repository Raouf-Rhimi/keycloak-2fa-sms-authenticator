package Eca.legitimation.service.gateway;

import org.jboss.logging.Logger;
import java.util.Map;


public class SuisseComSmsService implements SmsService {

	private static final Logger LOG = Logger.getLogger(SuisseComSmsService.class);

	private final String senderId;

	SuisseComSmsService(Map<String, String> config) {
		senderId = config.get("senderId");
	}

	@Override
	public void send(String phoneNumber, String message) {
		//here we should call Suiss Com service API to send the API
		LOG.warn(String.format("***** SENDING SMS VIA SUISS OPERATOR ***** Would send SMS to %s with text: %s", phoneNumber, message));
	}

}
