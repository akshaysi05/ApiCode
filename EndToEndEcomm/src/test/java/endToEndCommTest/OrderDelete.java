package endToEndCommTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class OrderDelete extends OrderView {
	
	  @Test (priority = 6)
	public void deleteOrder() {
		String Tokens = tokens;
		String orderID=orderesId;
		RequestSpecification deleteorder = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com/api/ecom").setContentType(ContentType.JSON)
						.addHeader("Authorization", Tokens).build();
	 RequestSpecification	DeleteOrd=given().spec(deleteorder).pathParam("orderID",orderID );
	String DeletedOrdered= DeleteOrd.delete("/order/delete-order/{orderID}")
	 .then().log().all().extract().response().asString();
	JsonPath js= new JsonPath(DeletedOrdered);
	String Messages=js.getString("message");
	System.out.println("DeletedMessagesPrint:"+Messages);
	}

}
