package TestIQT;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.PayLoad;


public class AddPassenser extends Pricing {
	@BeforeTest
	public void addPassenser() {
		System.out.println("Add New passenser");
		String ReferenaceNo= Pricing.ReferenaceNo;
		String SessionId=Pricing.SessionId;
		String Key=Pricing.Key;
		String AddNewPassenser=given().header("Content-Type","application/json").body(PayLoad.AddPassenser(SessionId, Key, ReferenaceNo))
		.when().post("AddPassengerDetails")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
	}
	
	
}
