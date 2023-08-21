package timmyTest;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetUserInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="http://ams.naapbooks.com:7788";
		String GetUserInfo=	given().log().all().queryParam("EnrollId", "31")
				.when().get("/Company/GetUserInfo")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		 JsonPath js= new JsonPath(GetUserInfo);
		 System.out.println(GetUserInfo);
		System.out.println( js.getString("status"));


	}

}
