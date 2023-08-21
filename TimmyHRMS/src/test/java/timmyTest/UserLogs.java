package timmyTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloadTimmy.Payload;

import static io.restassured.RestAssured.*;
public class UserLogs extends Payload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="http://ams.naapbooks.com:7788";
		String Userlogs=given().log().all().header("Content-Type","application/json")
		.body(Payload.userLogsPay(31,"2023-08-01" , "2023-08-18"))
		.when().post("/Company/GetUserLog")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		 JsonPath js= new JsonPath(Userlogs);
		 System.out.println(Userlogs);
		System.out.println("Compnay Ststus: "+ js.getString("status"));

	}

}
