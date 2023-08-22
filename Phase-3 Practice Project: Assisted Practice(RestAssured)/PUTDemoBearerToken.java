package com.simplilearn.RestAssured;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PUTDemoBearerToken 
{
	HashMap<String, String> map = new HashMap<String, String>();
	
	@BeforeTest
	public void createPayLoad()
	{
		map.put("name", "Supermann");
		map.put("email", "superman554462@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users/4495014";
	}
	
	@Test
	public void updateResource()
	{
		RestAssured
			.given()
				.contentType("application/json")
				.header("Authorization", "Bearer 13089a6b1d2efae40a1ae956dd438c1670d29e2ffdf0c67afb8dbe28e2aa1a5a")
				.body(map)
			.when()
				.put()
			.then()
				.statusCode(200)
				.log().all();
	}
}
