package com.cognizant.banking.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@PropertySource("classpath:application.properties")
public class UserDataDao {
	@Autowired
	private RestClient restClient;
	//private ResourceBundle resourceBundle;
	@Value("${userUrl}")
	private String userDataUrl;
	private Map<String,String> userDataMap;
	
	public Map<String,String> getUserData() {
		//resourceBundle = ResourceBundle.getBundle("application");
		// Logic to fetch user data using restClient
		//return resourceBundle.getString("userUrl");
		userDataMap=new HashMap<>();
		String response= restClient.get().uri(userDataUrl).retrieve().body(String.class);
		//parse the response and populate the map
		JSONArray usersArray=new JSONArray(response);
		for(int i=0;i<usersArray.length();i++) {
			String username=usersArray.getJSONObject(i).getString("name");
			String email=usersArray.getJSONObject(i).getString("email");
			userDataMap.put(username, email);
		}
		
		return userDataMap;
	}

}
