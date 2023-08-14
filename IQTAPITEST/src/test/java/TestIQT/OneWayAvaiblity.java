package TestIQT;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public   class  OneWayAvaiblity extends LoginIQT{
	static String flightkeys;
	static String Key;
	static  String Provider;
	static  String ItemNo;
	static String pricingKey;
	@BeforeTest
	public static void oneWayAvailibity() {
		 sessionId=LoginIQT.SessionId;
		 System.out.println(sessionId);
		System.out.println("AVALITY Check");
		String Avai=given().header("Content-Type","application/json").body(PayLoad.onwWayPay(sessionId))
		.when().post("Availability")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(Avai);
		js= new JsonPath(Avai);
		 flightkeys=js.get("Availibilities[0].Availibility[0].FlightKey").toString();
		System.out.println("FlightKey:"+flightkeys);
		 Key=js.getString("Key");
		System.out.println("Keys:"+Key);
	  Provider=js.getString("Availibilities[0].Availibility[0].Provider");
	 System.out.println("Provider:"+Provider);
	 ItemNo= js.getString("Availibilities[0].Availibility[0].ItemNo");
	System.out.println("ItemNo:"+ItemNo);
	 pricingKey=js.getString("Availibilities[0].Availibility[0].PricingInfos.PricingInfo[0].Pricingkey");
	System.out.println("PricingKey:"+pricingKey);
	}

}
