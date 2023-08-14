package TestIQT;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Pricing extends OneWayAvaiblity {
	static String ReferenaceNo;
	@BeforeTest
	public void pricing() {
		String fligthkey=OneWayAvaiblity.flightkeys;
		String Key=OneWayAvaiblity.Key;
		String ItemNo=OneWayAvaiblity.ItemNo;
		String PriceKey=OneWayAvaiblity.pricingKey;
		String Provider=OneWayAvaiblity.Provider;
		String SessionId=OneWayAvaiblity.SessionId;
		String price=given().header("Content-Type","application/json").body(PayLoad.pricingPay(SessionId, Key, PriceKey, Provider, ItemNo))
		.when().post("Pricing")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		js= new JsonPath(price);
		ReferenaceNo=js.getString("ReferenceNo");
		System.out.println("RefrenceNo:"+ReferenaceNo);
		
	}

}
