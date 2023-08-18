package endToEndCommTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.ProdductResponse;

public class Createproduct extends EcomApiTest {
	static String  ProductId;
	  @Test (priority = 2)
	public  void CreateItems () {
		String Tokens= tokens;
		String UserId=userid;
		System.out.println(Tokens);
		RequestSpecification Createprod = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/api/ecom")
				.addHeader("Authorization", Tokens).build();
				
		RequestSpecification createProdData= given().log().all().spec(Createprod)
		.param("productName", "LapTop")
		.param("productAddedBy", userid)
		.param("productCategory", "fashion")
		.param("productSubCategory", "LapTop")
		.param("productPrice", "35000")
		.param("productDescription", "Assus")
		.param("productFor", "Male")
		.multiPart("productImage", new File("E:\\Downloads//Coffee.png"));
		
		ProdductResponse resProdt= createProdData.when().post("/product/add-product")
		.then().log().all().extract().response().as(ProdductResponse.class);
		ProductId = resProdt.getProductId();
		System.out.println("productID:"+ProductId);
         
		
	}

}
