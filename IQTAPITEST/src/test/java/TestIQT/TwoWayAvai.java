package TestIQT;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import files.PayLoad;

public class TwoWayAvai extends LoginIQT {
	static String sessionId;
	@Test
		public void twoWayAvailibity() {
		 sessionId=LoginIQT.SessionId;
		 System.out.println("TwoSeeionId:"+sessionId);
			String Avaitwo=given().header("Content-Type","application/json").body(PayLoad.twoWayPay(sessionId))
					.when().post("Availability")
					.then().log().all().assertThat().statusCode(200).extract().response().asString();
			 System.out.println(Avaitwo);
			 
		}

}
