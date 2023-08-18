package endToEndCommTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pojo.OrderProd;
import pojo.OrderRequest;

public class OrderProduct extends Createproduct {

	@BeforeTest
	public void OderProducts() {
		String Tokens = tokens;
		String UserId = userid;
		String productid = ProductId;
		RequestSpecification OrderProduct = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com/api/ecom").setContentType(ContentType.JSON)
				.addHeader("Authorization", Tokens).build();
		
		OrderProd order = new OrderProd();
		order.setProductOrderedId(productid);
		order.setCountry("India");
		
		List<OrderProd> myList = new ArrayList<OrderProd>();
		myList.add(order);
		
		OrderRequest or = new OrderRequest();
		or.setOrders(myList);
		

		RequestSpecification orderItems = given().log().all().spec(OrderProduct).body(or);

		String ordered = orderItems.when().post("/order/create-order").then().log().all().extract().response()
				.asString();
		JsonPath js = new JsonPath(ordered);
		String orderesId = js.get("orders").toString();
		System.out.println(orderesId);

	}

}
