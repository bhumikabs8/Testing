package com.simplilearn.RestAssured;

import java.util.HashMap;
import java.util.UUID;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UUIDDemo 
{
	HashMap<String, String> map = new HashMap<String, String>();
	UUID uuid = UUID.randomUUID();
	
	@BeforeMethod
	public void createPayLoad()
	{
		map.put("name", "Superman");
		map.put("email", uuid+"@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users";
	}
	
	@Test
	public void createResource()
	{
		RestAssured
			.given()
				.contentType("application/json")
				.body(map)
				.header("Authorization", "Bearer 13089a6b1d2efae40a1ae956dd438c1670d29e2ffdf0c67afb8dbe28e2aa1a5a")
			.when()
				.post()
			.then()
				.statusCode(201)
				.log().all();
	}
}


