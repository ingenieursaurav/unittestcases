/**
 * 
 */
package com.orion.orionlauncher;



import java.util.HashMap;
import java.util.Map;

/**
 * @author sauravsharma
 *
 */
public class AuthenticationController extends CommunicationController {

	/***
	 * 
	 * @param subscriber
	 * @return subscriber
	 */
	public Subscriber Authenticate(Subscriber subscriber) {
		try {
			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put("email", subscriber.getEmail());
			parameters.put("password", subscriber.getPassword());
			CommunicationController communicationcontroller = new CommunicationController();
			String response = communicationcontroller.Communicate(parameters, "sign_in_service","POST");
			org.json.JSONObject result = new org.json.JSONObject(response);
			if (result.getString("message").trim().compareTo(SUCCESS) == 0) {
				subscriber.setToken(result.getString("auth_token").trim());
				result = result.getJSONObject("data");
			}

		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return subscriber;
	}

}
