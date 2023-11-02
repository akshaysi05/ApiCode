package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlacePaySeria;
import pojo.Location;

public class TestDataBuild {
	public AddPlacePaySeria addPlacePayload(String name , String lang, String addres) {
		AddPlacePaySeria p = new AddPlacePaySeria();
		p.setAccuracy(50);
		p.setLanguage(lang);
		p.setAddress(addres);
		p.setName(name);
		p.setWebsite("Akshay.com");
		p.setPhone_number("900000001");
		List<String> myList = new ArrayList<String>();
		myList.add("Shoeark");
		myList.add("sho");
		p.setTypes(myList);
		Location l = new Location();
		l.setLat(-39.383494);
		l.setLng(34.427362);
		p.setLocation(l);
		return p;
	}
	public String deletePlacePayload(String place_id) {
		return "{\r\n"
				+ "    \"place_id\":\""+place_id+"\"\r\n"
				+ "}\r\n"
				+ "";
	}

}
