package goolesMaps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import files.Payload;
import files.ReusableMethods;
public class AddPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
		JsonPath js;
		//AddPlace
		String response=given().log().all().queryParam("key", "qaclick123").headers("Content-Type","application/json")
		.body(Payload.Addplace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", equalTo("Apache/2.4.52 (Ubuntu)")).extract().response().asString();
		
		 js= ReusableMethods.rowToJson(response);
		 String PlaceId=js.getString("place_id");
		 System.out.println(PlaceId);
		 
		 //Upadte Place
		 String NewAdd="Naurangpura police station Ahmedabad";
		 given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		 .body("{\r\n"
		 		+ "\"place_id\":\""+PlaceId+"\",\r\n"
		 		+ "\"address\":\""+NewAdd+"\",\r\n"
		 		+ "\"key\":\"qaclick123\"\r\n"
		 		+ "}\r\n"
		 		+ "")
		 .when().put("/maps/api/place/update/json")
		 .then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		 
		 //GetPlace
		String getPlaceResponse= given().log().all().queryParam("key", "qaclick123").queryParam("place_id", PlaceId)
		 .when().get("/maps/api/place/get/json")
		 .then().log().all().assertThat().statusCode(200).extract().response().asString();
	    js= ReusableMethods.rowToJson(getPlaceResponse);
		String ActualAdd=js.getString("address");
		System.out.println(ActualAdd);
		 assertEquals(NewAdd, ActualAdd);
		
		 

	}

}
