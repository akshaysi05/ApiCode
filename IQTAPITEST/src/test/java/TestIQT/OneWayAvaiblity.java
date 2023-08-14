package TestIQT;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class OneWayAvaiblity extends LoginIQT{
	static String  sessionId;
	@Test
	public void oneWayAvailibity() {
		 sessionId=LoginIQT.SessionId;
		 System.out.println(sessionId);
		System.out.println("AVALITY Check");
		String Avai=given().header("Content-Type","application/json").body(PayLoad.onwWayPay(sessionId))
		.when().post("Availability")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(Avai);
		js= new JsonPath(Avai);
		String keys=js.get("Availibilities[0].Availibility[0].FlightKey").toString();
		System.out.println(keys);
	}

}
