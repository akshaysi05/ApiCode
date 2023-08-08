package libraryAPiMethods;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.ReUsebleMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;
public class DymanicJson {

	@Test(dataProvider="BooksData")
	public void AddBook(String isbn,String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		
		String response=given().header("Content-Type","application/json")
		.body(Payload.addbook(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=ReUsebleMethods.rowToJosn(response);
		String ID=js.get("ID");
		System.out.println(ID);
	}
	@DataProvider(name="BooksData")
	public Object[][] BookProvid() {
		return new Object[][] {{"pol","9878"},{"uop","9632"},{"loi","8458"}};
		
	}

}
