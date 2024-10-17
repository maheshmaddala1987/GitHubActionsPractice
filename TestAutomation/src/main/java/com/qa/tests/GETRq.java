package com.qa.tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GETRq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String res = given().
				baseUri("https://reqres.in/api/users/2")
				.when()
				.get()
				.then()
				.extract()
				.asPrettyString();

		System.out.println(res);

		JsonPath js = new JsonPath(res);
		System.out.println(js.getString("data.first_name"));
		System.out.println((Integer.parseInt(js.getString("data.id"))));
		System.out.println(js.getString("support.url"));
		
		
		//Create POST request
		
		String payload ="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		
	Response postResponse=	given().baseUri("https://reqres.in/api/users").log().all().contentType(ContentType.JSON).body(payload).when().post().then().extract().response();
    System.out.println(postResponse.asPrettyString());
    
    //Create Request with HashMap as payload
    
    HashMap<String,String> map = new HashMap<>();
    map.put("job", "software engineer");
    map.put("name", "mahesh");
    
   String mapResponse = given().log().all().baseUri("https://reqres.in/api/users").contentType(ContentType.JSON).body(map).when().post().then().extract().response().asPrettyString();
    System.out.println("map response :"+mapResponse);
    
    
    
    
    // Delete request
    
	Response deleteresponse = given().
			baseUri("https://reqres.in/api/users/2")
			.when()
			.delete()
			.then()
			.extract()
			.response();

	System.out.println(deleteresponse.getStatusCode());
    
    

	}

}
