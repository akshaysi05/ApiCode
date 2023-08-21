package timmyTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class GetCompanyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="http://ams.naapbooks.com:7788";
	String GetCompnay=	given().log().all().queryParam("companyId", "1")
		.when().get("/Company/GetCompanyDevices")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
	 System.out.println(GetCompnay);
	 JsonPath js= new JsonPath(GetCompnay);
	 System.out.println("Compnay Ststus: "+ js.getString("status"));
	 System.out.println("Data Under sn Number: "+js.getString("data[0].sn"));

	}

}
