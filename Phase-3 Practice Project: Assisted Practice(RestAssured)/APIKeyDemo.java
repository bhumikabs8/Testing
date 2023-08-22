package com.simplilearn.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class APIKeyDemo 
{
	@Test
	public void getWeatherInfo()
	{
		RestAssured
			.given()
				.param("q", "Bengaluru")
				.param("appid", "ebfcd9361a4388f3e22dc5134d0c49b2")
			.when()
				.get("https://api.openweathermap.org/data/2.5/weather")
			.then()
				.statusCode(200)
				.log().all();
	}
}
