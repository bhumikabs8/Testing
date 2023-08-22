package com.simplilearn.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GETDemoBearerToken 
{
	@Test
	public void verifyResource()
	{
		RestAssured
			.given()
				.given()
					.contentType("application/json")
					.header("Authorization", "Bearer 13089a6b1d2efae40a1ae956dd438c1670d29e2ffdf0c67afb8dbe28e2aa1a5a")
				.when()
					.get("https://gorest.co.in/public/v2/users/4495014")
				.then()
					.statusCode(200)
					.log().all();		
	}
}
