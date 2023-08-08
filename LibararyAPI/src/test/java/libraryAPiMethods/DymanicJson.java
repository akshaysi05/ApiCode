package libraryAPiMethods;


import org.testng.annotations.Test;

import files.Payload;
import files.ReUsebleMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static  io.restassured.RestAssured.*;
public class DymanicJson {
	@Test
	public void AddBook() {
		RestAssured.baseURI="http://216.10.245.166";
		
		String response=given().header("Content-Type","application/json")
		.body(Payload.addbook("log","321"))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=ReUsebleMethods.rowToJosn(response);
		String ID=js.get("ID").toString();
		System.out.println(ID);
		
	}

}
