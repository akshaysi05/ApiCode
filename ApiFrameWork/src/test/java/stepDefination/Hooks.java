package stepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeletePlace")
	public void beforeRunScenario() throws IOException {
		//execute this code only when place_id is null
		//write a code that will give you place_id
		StepDefination sd= new StepDefination();
		if(StepDefination.place_id==null) {
		sd.add_place_pay_load_with("Ram", "Hindi", "LawGarden");
		sd.user_calls_with_http_request("AddPlaceAPI", "POST");
		sd.verify_place_id_created_maps_to_using("Golu", "getPlaceApi");
		}
		
		
	}

}
