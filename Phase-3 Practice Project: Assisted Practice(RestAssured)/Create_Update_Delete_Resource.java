package com.simplilearn.RestAssured;

import java.util.HashMap;
import java.util.UUID;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.is;

public class Create_Update_Delete_Resource extends TestBase
{
	HashMap<String, String> map = new HashMap<String, String>();
	
	UUID uuid = UUID.randomUUID();
	int id;
	Response response;
	JsonPath jsonPath;
	
	@Test(priority=0)
	public void createPayload()
	{
		map.put("name", "Captain Planet");
		map.put("email", uuid + "@gmail.com");
		map.put("gender", "male");
		map.put("status", "Active");
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "public/v2/users";
		logger.info("Payload created");
	}
	
	@Test(priority=1)
	public void createResource()
	{
		response = RestAssured
				.given()
					.contentType("application/json")
					.body(map)
					.header("Authorization", "Bearer 13089a6b1d2efae40a1ae956dd438c1670d29e2ffdf0c67afb8dbe28e2aa1a5a")
				.when()
					.post()
				.then()
					.log().all()
					.extract().response();
		
		logger.info("ResourceCreated Successfully");
		jsonPath = response.jsonPath();
		id = jsonPath.get("id");
		System.out.println(id);
	}
	
	@Test(priority=2)
	public void verifyResource()
	{
		System.out.println("Id = " + id);
		RestAssured
		.given()
			.contentType("application/json")
			.header("Authorization", "Bearer 13089a6b1d2efae40a1ae956dd438c1670d29e2ffdf0c67afb8dbe28e2aa1a5a")
		.when()
			.get("https://gorest.co.in/public/v2/users/"+id)
		.then()
			.statusCode(200)
			.log().all();
		
		logger.info("Resource verify sucefully");
		Assert.assertTrue(jsonPath.get("name").equals("Captain Planet"));
		
	}
	
	@Test(priority=3)
	public void updateResource()
	{
		map.put("name", "Captainn Planett");
		map.put("email", uuid + "@gmail.com");
		map.put("gender", "male");
		map.put("status", "Active");
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "public/v2/users/" + id;
		
		RestAssured
		.given()
			.contentType("application/json")
			.header("Authorization", "Bearer 13089a6b1d2efae40a1ae956dd438c1670d29e2ffdf0c67afb8dbe28e2aa1a5a")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all()
			.assertThat()
			.body("name", is("Captainn Planett"));
		
		logger.info("Resources Updated Sucessfully");
	}
	
	@Test(priority=4)
	public void deleteResource()
	{
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "public/v2/users/" + id;
		
		RestAssured
			.given()
				.contentType("application/json")
				.header("Authorization", "Bearer 13089a6b1d2efae40a1ae956dd438c1670d29e2ffdf0c67afb8dbe28e2aa1a5a")
			.when()
				.delete()
			.then()
				.statusCode(204);
		logger.info("Resource deleted");
				
	}
}
