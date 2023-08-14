package TestIQT;

import org.testng.annotations.Test;

import files.PayLoad;

import static io.restassured.RestAssured.*;
public class Ticketing extends AddPassenser {
	@Test
	public void ticket() {
		System.out.println("Ticketing Check");
		String SessionId = AddPassenser.SessionId;
		String RefrenceNo = AddPassenser.ReferenaceNo;
		String Key = AddPassenser.Key;
		String provider = AddPassenser.Provider;
		String Ticket=given().header("Content-Type", "application/json").body(PayLoad.Bookingpay(SessionId, Key, RefrenceNo, provider))
		.when().post("Ticketing").then()
		.log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(Ticket);
		
	}

}
