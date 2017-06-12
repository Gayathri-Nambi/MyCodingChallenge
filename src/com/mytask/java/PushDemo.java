package com.mytask.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.jws.WebService;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import dtos.PushDTO;

@WebService
public class PushDemo {  
	
	static long userID=0;
	final String accessToken = "validTokenGoesHere";
    String content_type = "application/json"; 
	HashMap<Long,UserDTO> mapUsers =  new HashMap<Long,UserDTO>(); // user name,notification count,access token,creation time
	
	@RequestMapping(value = "/registeruser", produces = {"application/json"})
	public UserDTO registerUser( String userName)  throws Exception{
		long notificationCount=0;
		String jsonValue="Registration Failed";
		UserDTO userDTO = new UserDTO();
		try
		{		
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			String formattedDate = sdf.format(date);
			userDTO.setUserName(userName);
			userDTO.setNotificationCount(notificationCount);
			userDTO.setAccessToken(accessToken);
			userDTO.setCreationTime(formattedDate);
			mapUsers.put(++userID, userDTO);
			jsonValue = new Gson().toJson(userDTO);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("jsonValue:"+jsonValue);
		return userDTO;
	}
	
	
	@RequestMapping(value = "/getusers", produces = {"application/json"})
	public String getAllUsers() throws Exception
	{
		List<UserDTO> returnValue= new ArrayList<>();
		try {
			for(Long oKey: mapUsers.keySet()) {
				returnValue.add(mapUsers.get(oKey));
			}	
				
		} catch (Exception e) {	
			e.printStackTrace();
		}
		String json = new Gson().toJson(returnValue);
		System.out.println("jsonValue:"+json);
		return json;
	}
	
	@RequestMapping(value = "/sendmessage", produces = {"application/json"})
	public String sendMessage(String userName, String messageValue) throws Exception
	{
		String returnValue="User not found";
		try {
			for(Long oKey: mapUsers.keySet()) {
				UserDTO userDTO=mapUsers.get(oKey);
				if(userDTO.getUserName().equalsIgnoreCase(userName))
				{
					String uri = "https://api.pushbullet.com/v2/pushes";
					PushDTO push = new PushDTO();
					push.setBody(messageValue);
					push.setTitle("BBC poking");
					push.setType("note");
			        HashMap<String,String> headers  = new HashMap<>();
			        headers.put("Access-Token", accessToken);
			        headers.put("Content-Type", content_type);
					 
					String pbReturnValue = callCreatePushWebService(uri, "POST", new Gson().toJson(push), headers);
					Long oldNotificationCount=userDTO.getNotificationCount();
					userDTO.setNotificationCount(++oldNotificationCount);
					returnValue = new Gson().toJson(userDTO);
					System.out.println("From Push Bullet: "+pbReturnValue);
					break;					
				}				
			}	
				
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		return returnValue;
	}

	private String callCreatePushWebService(String uri, String requestMethod, String body, HashMap<String, String> headers) {
	        URL url;
	        StringBuilder retVal = new StringBuilder();
	        String line;
	        HttpURLConnection connection;
	        try {
	            url = new URL(uri);
	            connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod(requestMethod);
	            connection.setDoInput(true);
	            connection.setDoOutput(true);
	            if (headers != null) {
	                for (String header : headers.keySet()) {
	                    connection.setRequestProperty(header, headers.get(header));
	                }
	            }

	            OutputStream os = connection.getOutputStream();
	            BufferedWriter writer = new BufferedWriter(
	                    new OutputStreamWriter(os, "UTF-8"));
	            if (body != null)
	                writer.write(body);

	            writer.flush();
	            writer.close();
	            os.close();
	            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            while ((line = in.readLine()) != null) {
	                retVal.append(line);
	            }

	        }
	        catch (FileNotFoundException e){
	            //Entity not found
	            return null;
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        return retVal.toString();
	    }
	   
	
}