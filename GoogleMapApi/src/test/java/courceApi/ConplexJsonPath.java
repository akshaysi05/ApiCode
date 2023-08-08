package courceApi;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ConplexJsonPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js= new JsonPath(Payload.CoursePrice());
		
		//print Number Courses Return Bu The Api
		int countCource=js.getInt("courses.size()");
		System.out.println(countCource);
		
		//2.Print Purchase Amount
		int PurchaseAmount=js.getInt("dashboard.purchaseAmount");
		System.out.println(PurchaseAmount);
		
		//3. Print Title of the first course
		String FirstTitle=js.getString("courses[0].title");
		System.out.println(FirstTitle);
		
		//4. Print All course titles and their respective Prices
		for(int i=0;i<countCource;i++) {
			
			String titleall=js.get("courses["+i+"].title");
			System.out.println(titleall);
			int price=js.get("courses["+i+"].price");
			System.out.println(price);
		
		}

		//5. Print no of copies sold by RPA Course
            for(int i=0;i<countCource;i++) {
			String titleall=js.get("courses["+i+"].title");
			if(titleall.equalsIgnoreCase("RPA"))
			{
	     	int copies=js.get("courses["+i+"].copies");
		     System.out.println(copies);
		     break;
			}
            }
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		for(int i=0;i<countCource;i++) {
			int copiess=js.get("courses["+i+"].copies"); 
			int  prices=js.get("courses["+i+"].price");
			int toatlAmount=copiess*prices;
			System.out.println(toatlAmount);
		}
		 


	}

}
