package aOuth;

import static io.restassured.RestAssured.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;

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
		
		String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0Adeu5BU2at-W-nL5AHGq23uu8umSXxiXBmc6_y6EtOn-1_R7v5Lnszpr_gf6CLlA6LD9kw&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";
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
		String ActualRest = given().queryParam("access_token", AccessToken).when().log().all()
				.post("https://rahulshettyacademy.com/getCourse.php").asString();
		System.out.println(ActualRest);

	}

}
