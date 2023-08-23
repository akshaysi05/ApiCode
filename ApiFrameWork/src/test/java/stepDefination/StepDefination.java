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

	@When("user calls {string} with Post http request")
	public void user_calls_with_post_http_request(String string) {
		 res = response.when().post("/maps/api/place/add/json").then().spec(ResponseSpec).extract().response();

	}

	@Then("the API call got Success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(res.getStatusCode(), 200);
		
	}
	

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String ActualValue, String ExpectedValue) {
		String resp=res.asString();
		JsonPath js= new JsonPath(resp);
	  assertEquals(js.getString(ActualValue), ExpectedValue);	
		
	}
	
}
