package files;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReUsebleMethods {
	public static JsonPath rowToJosn(String response) {
		JsonPath js= new JsonPath(response);
		return js;
	}
	}


