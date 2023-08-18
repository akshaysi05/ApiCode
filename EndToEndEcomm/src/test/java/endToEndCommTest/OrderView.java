package endToEndCommTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class OrderView extends DeleteProduct {
	
	  @Test (priority = 5)
	public void orderView() {
		String Tokens = tokens;
		String orderID=orderesId;
		RequestSpecification ViewOrder = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com/api/ecom").setContentType(ContentType.JSON)
						.addHeader("Authorization", Tokens).build();
	RequestSpecification	ViewOrdDeta=given().spec(ViewOrder).queryParam("id",orderID );
	
	String GetDetails=ViewOrdDeta.when().get("/order/get-orders-details")
	.then().log().all().extract().response().asString();
	JsonPath js= new JsonPath(GetDetails);
	String Messages=js.get("message").toString();
	System.out.println("OrderViewMessages:"+Messages);
	
		
		
	}

}
