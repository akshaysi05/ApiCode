package stepDefination;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlacePaySeria;
import pojo.Location;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils{
	ResponseSpecification ResponseSpec;
	RequestSpecification response;
	Response res;

	TestDataBuild data= new TestDataBuild();
	@Given("Add Place PayLoad with {string} {string} {string}")
	public void add_place_pay_load_with(String name, String lang, String addres)  throws IOException {
			ResponseSpec=  new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			
			
			response = given().spec(requestSpecifinationData()).body(data.addPlacePayload(name ,lang, addres));
		
			// TODO Auto-generated catch block
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String methods) {
		ApiResources resourceAPI=ApiResources.valueOf(resource);
		System.out.println( resourceAPI.getResource());
		if(methods.equalsIgnoreCase("POST"))
		 res = response.when().post(resourceAPI.getResource());
		else if(methods.equalsIgnoreCase("GET"))
			 res = response.when().get(resourceAPI.getResource());

	}

	@Then("the API call got Success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(res.getStatusCode(), 200);
		
	}
	

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String ActualValue, String ExpectedValue) {
		
	  assertEquals(getJosnPath(res,ActualValue), ExpectedValue);	
		
	}
	@Then("Verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resourceName) throws IOException {
		String place_id=getJosnPath(res, "place_id");
		
		response = given().spec(requestSpecifinationData()).queryParam("place_id", place_id);
		user_calls_with_http_request(resourceName,"GET");
		String name=getJosnPath(res, "name");
		assertEquals(name, expectedName);
	    
	}

	
}
