package specBuilderTest;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.ArrayList;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlacePaySeria;
import pojo.Location;

public class SpecBilderTest {

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
		//Request Specifinaction
		 RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				 .addQueryParam("key", "qaclick123")
		         .setContentType(ContentType.JSON).build();
		 //Response Specification
		 ResponseSpecification	ResponseSpec=  new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		 RequestSpecification response = given().spec(req).body(p);
				
		Response res= response.when().post("/maps/api/place/add/json")
				.then().spec(ResponseSpec).extract()
				.response();

		
		String responseString = res.asString();
		System.out.println(responseString);

	}

}
