package codeStudio;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGetRequest {
	Response res;
	
	@Test
	public void singleUser(){
		
		 res=RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.asString());
		System.out.println(" Status Code: "+res.getStatusCode());
		System.out.println("Response Time :"+res.getTime());
	}
	@Test
	public void ListUser() {
	Response req=RestAssured.get("https://reqres.in/api/users?page=2");
	 System.out.println(req.getBody().asString());
	}

}
