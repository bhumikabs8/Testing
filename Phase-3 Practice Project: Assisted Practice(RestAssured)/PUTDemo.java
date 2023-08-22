package com.simplilearn.RestAssured;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PUTDemo 
{
	HashMap<String, String> map = new HashMap<String, String>();
	
	@BeforeMethod
	public void createPayload()
	{
		map.put("name", "morpheus");
		map.put("job", "programmer");
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users/255";
	}
	
	@Test
	public void updateResource()
	{
		RestAssured
			.given()
				.contentType("application/json")
				.body(map)
			.when()
				.put()
			.then()
				.statusCode(200)
				.log().all();
	}
}
