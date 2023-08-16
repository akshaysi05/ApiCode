package serialization;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.ArrayList;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.AddPlacePaySeria;
import pojo.Location;

public class SerializationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AddPlacePaySeria p = new AddPlacePaySeria();
		p.setAccuracy(50);
		p.setLanguage("Hind");
		p.setAddress("Ahmedabad");
		p.setName("Akshay");
		p.setWebsite("Akshay.singh,.com");
		p.setPhone_number("900000002");
		List<String> myList = new ArrayList<String>();
		myList.add("ShoePark");
		myList.add("shop");
		p.setTypes(myList);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response response = given().queryParam("key", "qaclick123").headers("Content-Type", "application/json").body(p)
				.when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).extract()
				.response();

		String responseString = response.asString();
		System.out.println(responseString);

	}

}
