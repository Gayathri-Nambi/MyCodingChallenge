package com.mytask.java;

import javax.xml.ws.Endpoint;
public class PushService {
	
	public static void main(String[] args) {
		  System.out.println("PushDemo Web Service started....");
		  Endpoint.publish("http://localhost:8080/PushDemo", new PushDemo());
	}

}
