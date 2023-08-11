package TestIQT;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import javax.sql.rowset.serial.SQLOutputImpl;

public  class LoginIQT {
	 static String SessionId;
	 static JsonPath js;
	@Test
	public static  void LoginTest() {
		RestAssured.baseURI="https://ibe.itq.in/B2BAPI/Api/flight/";
		String res=given().header("Content-Type","application/json").body(PayLoad.loginPay())
		.when().post("Authenticate")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		 js= new JsonPath(res);
		System.out.println("Session Id ");
		 SessionId=	js.get("SessionID");
	   System.out.println(SessionId);	
	}
	@Test
	public void oneWayAvailibity() {
		System.out.println("AVALITY Check");
		String Avai=given().header("Content-Type","application/json").body(PayLoad.onwWayPay(SessionId))
		.when().post("Availability")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(Avai);
		js= new JsonPath(Avai);
		String keys=js.get("Availibilities[0].Availibility[0].FlightKey").toString();
		System.out.println(keys);
	}
	//@Test
	public void twoWayAvailibity() {
		String Avaitwo=given().header("Content-Type","application/json").body(PayLoad.twoWayPay(SessionId))
				.when().post("Availability")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		 System.out.println(Avaitwo);
	}
	 

}
