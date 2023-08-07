package goolesMaps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payload;
public class AddPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").headers("Content-Type","application/json")
		.body(Payload.Addplace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", equalTo("Apache/2.4.52 (Ubuntu)")).extract().response().asString();
		
		 JsonPath js= new JsonPath(response);
		 String PlaceId=js.getString("place_id");
		 System.out.println(PlaceId);

	}

}
