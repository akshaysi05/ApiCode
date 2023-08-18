package endToEndCommTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;

public class EcomApiTest {
	  static  String tokens;
	  static String userid;
	 @BeforeTest
	public  void Login() {
		// TODO Auto-generated method stub
		RequestSpecification reqEcomm = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/api/ecom")
				.setContentType(ContentType.JSON).build();
		
		LoginRequest login = new LoginRequest();
		login.setUserEmail("akshay.s@gmail.com");
		login.setUserPassword("ProEx@2013");
		
		RequestSpecification relogin = given().log().all().spec(reqEcomm).body(login);
		
		LoginResponse loginRes = relogin.when().post("/auth/login").then().log().all().extract().response().as(LoginResponse.class);
		
		  tokens = loginRes.getToken();
		  userid = loginRes.getUserId();
		System.out.println(tokens);
		System.out.println(userid);

	}

}
