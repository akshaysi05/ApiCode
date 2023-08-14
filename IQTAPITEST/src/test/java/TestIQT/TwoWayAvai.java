package TestIQT;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class TwoWayAvai extends LoginIQT {
	@Test
		public void twoWayAvailibity() {
		SessionId=LoginIQT.SessionId;
		 System.out.println("TwoSeeionId:"+SessionId);
			String Avaitwo=given().header("Content-Type","application/json").body(PayLoad.twoWayPay(SessionId))
					.when().post("Availability")
					.then().log().all().assertThat().statusCode(200).extract().response().asString();
			 System.out.println(Avaitwo);
			 js= new JsonPath(Avaitwo);
				String keys=js.get("Availibilities[0].Availibility[0].FlightKey").toString();
				System.out.println(keys);
				
			 
		}

}
