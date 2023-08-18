package endToEndCommTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class DeleteProduct extends OrderProduct{
	@Test
	public void deleteProduct() {
		String Tokens = tokens;
		String productid = ProductId;
		RequestSpecification DeleteReq = new RequestSpecBuilder()
		.setBaseUri("https://rahulshettyacademy.com/api/ecom").setContentType(ContentType.JSON)
				.addHeader("Authorization", Tokens).build();
		
	RequestSpecification	DeleteProdbase=given().spec(DeleteReq).pathParam("productId", productid);
	String deleteResponse=DeleteProdbase.when().delete("/product/delete-product/{productId}")
	.then().log().all().extract().response().asString();
	JsonPath js= new JsonPath(deleteResponse);
	String Message=js.get("message");
	System.out.println(Message );
	}

}
