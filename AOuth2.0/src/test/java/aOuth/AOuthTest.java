package aOuth;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.Arrays;

import groovyjarjarantlr4.v4.parse.ANTLRParser.parserRule_return;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.GetCourse;
import pojo.WebAutomation;

public class AOuthTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//InvokeChromeDriver
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver= new ChromeDriver();
//		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
//		driver.findElement(By.cssSelector("#identifierId")).sendKeys("akshay.s@naapbooks.in");
//		driver.findElement(By.cssSelector("#identifierId")).sendKeys(Keys.ENTER);
//		driver.findElement(By.cssSelector("input[name='Passwd']")).sendKeys("nbl_proex");
//		driver.findElement(By.cssSelector("input[name='Passwd']")).sendKeys(Keys.ENTER);
//		Thread.sleep(4000);
		String[] courcesTitle= {"Selenium Webdriver Java","Cypress","Protractor"};
		String url="https://rahulshettyacademy.com/getCourse.php?state=jhar&code=4%2F0Adeu5BUdl5KLRZHh6bIKHUqB_2qVzKE2ObXRN8j7tlrhtgy5FZMrHkQqyEX4MxOloZ_tDg&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String Code=url.split("code=")[1].split("&scope")[0];
		System.out.println(Code);
		
		//GetAccessToken 
		String AccessTokenResponse = given().urlEncodingEnabled(false).queryParams("code", Code)
				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParams("grant_type", "authorization_code").when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js = new JsonPath(AccessTokenResponse);
		String AccessToken = js.getString("access_token");
		
        //GetActualResults
		GetCourse gc = given().queryParam("access_token", AccessToken).expect().defaultParser(Parser.JSON)
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		  System.out.println(gc.getLinkedIn());
		  System.out.println(gc.getInstructor());
		  
		  //Print Api Course Price According To Title 
		  
		 List<Api> apicouce= gc.getCourses().getApi();
		 for(int i=0;i<apicouce.size();i++) {
			 if(apicouce.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")){
				System.out.println( apicouce.get(i).getPrice());
			 }
			 
		 }
		 //And Compare Your Array With Find Array
		 ArrayList<String> a= new ArrayList<String>();
		 //print all the title of WebAutomation courses along with price
		 List<WebAutomation> webAutomationcourse= gc.getCourses().getWebAutomation();
		 for(int i=0;i<webAutomationcourse.size();i++) {
			 a.add(webAutomationcourse.get(i).getCourseTitle());
			System.out.println( webAutomationcourse.get(i).getCourseTitle());
			System.out.println( webAutomationcourse.get(i).getPrice());
		 }
		List<String> ExpectedCouses= Arrays.asList(courcesTitle);
		 assertTrue(a.equals(ExpectedCouses));

	}

}
