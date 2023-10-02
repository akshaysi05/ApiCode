package TestIQT;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

public  class LoginIQT {
	 static String SessionId;
	 static JsonPath js;
	@BeforeTest
	public static  void LoginTest() {
		RestAssured.baseURI="https://ibe.itq.in/B2BAPI/Api/flight/";
		String res=given().header("Content-Type","application/json").body(PayLoad.loginPay())
		.when().post("Authenticate")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		 js= new JsonPath(res);
		 SessionId=	js.get("SessionID");	
	}

	
	 
	
}
