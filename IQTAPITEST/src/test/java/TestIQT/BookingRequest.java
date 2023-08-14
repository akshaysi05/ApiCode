package TestIQT;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class BookingRequest extends AddPassenser {

	@Test
	public void bookingRequest() {
		System.out.println("Add Booking Request");
		String SessionId = AddPassenser.SessionId;
		String RefrenceNo = AddPassenser.ReferenaceNo;
		String Key = AddPassenser.Key;
		String provider = AddPassenser.Provider;
		String Booking = given().header("Content-Type", "application/json").body(PayLoad.Bookingpay(SessionId, Key, RefrenceNo, provider))
				.when().post("Booking").then()
				.log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(Booking);
		js= new JsonPath(Booking);
		String pnr=js.getString("AirBookingResponse[0].PNR");
		System.out.println("New PNRNo:"+pnr);

	}
}
