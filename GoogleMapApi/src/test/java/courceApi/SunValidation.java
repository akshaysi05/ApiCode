package courceApi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SunValidation {
	
	@Test
	public void getSumPrice() {
		int sum=0;
		JsonPath js= new JsonPath(Payload.CoursePrice());
		int countCource=js.getInt("courses.size()");
		for(int i=0;i<countCource;i++) {
			int price=js.get("courses["+i+"].price");
			int copies=js.get("courses["+i+"].copies");
			int amount=price*copies;
			//System.out.println(amount);
			sum=sum+amount;
			
		}
		System.out.println(sum);
		int PurchaseAmount=js.getInt("dashboard.purchaseAmount");
		assertEquals(PurchaseAmount, sum);
	}

}
