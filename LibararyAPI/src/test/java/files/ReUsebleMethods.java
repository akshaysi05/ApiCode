package files;

import io.restassured.path.json.JsonPath;

public class ReUsebleMethods {
	public static JsonPath rowToJosn(String response) {
		JsonPath js= new JsonPath(response);
		return js;
	}
	}


