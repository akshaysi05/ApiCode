package timmyTest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetAllUserList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="http://ams.naapbooks.com:7788";
		String GetUSerList=	given().log().all().queryParam("companyId", "1")
				.when().get("/Company/GetUsers")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		 JsonPath js= new JsonPath(GetUSerList);
		 System.out.println(GetUSerList);
		System.out.println( js.getString("status"));

	}

}
