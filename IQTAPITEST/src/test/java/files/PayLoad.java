package files;

import TestIQT.LoginIQT;

public class PayLoad {
	
	 
	public static String loginPay() {
		return "{\r\n"
				+ " \"UserName\": \"Arihanttrip\",\r\n"
				+ " \"Password\": \"Arihanttrip@123\"\r\n"
				+ "}\r\n"
				+ "";
	}
	public static String onwWayPay(String SessionId) {
		
		return "{\r\n"
				+ " \"Trip\":1, \r\n"
				+ " \"TripType\": 1, \r\n"
				+ " \"Adult\": 1,\r\n"
				+ " \"RTF\": false,\r\n"
				+ " \"Child\": 0,\r\n"
				+ " \"Infant\": 0,\r\n"
				+ " \"NonStop\": \"false\",\r\n"
				+ " \"PreferredClass\": \"\", \r\n"
				+ " \"PreferredCarrier\": \"\",\r\n"
				+ " \"SessionID\": \""+SessionId+"\",\r\n"
				+ " \"Segments\": [\r\n"
				+ " {\r\n"
				+ " \"Origin\": \"AMD\",\r\n"
				+ " \"Destination\": \"DEL\",\r\n"
<<<<<<< Updated upstream
				+ " \"DepartDate\": \"12/09/2023\"\r\n"
=======
				+ " \"DepartDate\": \"15/08/2023\"\r\n"
>>>>>>> Stashed changes
				+ " }\r\n"
				+ " ]\r\n"
				+ "}";
	}
	public static String twoWayPay(String SessionId) {
		
		return "{\r\n"
				+ " \"Trip\":1, \r\n"
				+ " \"TripType\": 2, \r\n"
				+ " \"Adult\": 1,\r\n"
				+ " \"RTF\": true,\r\n"
				+ " \"Child\": 0,\r\n"
				+ " \"Infant\": 0,\r\n"
				+ " \"NonStop\": \"false\",\r\n"
				+ " \"PreferredClass\": \"\", \r\n"
				+ " \"PreferredCarrier\": \"\",\r\n"
				+ " \"SessionID\": \""+SessionId+"\",\r\n"
				+ " \"Segments\": [\r\n"
				+ " {\r\n"
				+ " \"Origin\": \"DEL\",\r\n"
				+ " \"Destination\": \"AMD\",\r\n"
				+ " \"DepartDate\": \"12/09/2023\"\r\n"
				+ " },\r\n"
				+ "{\r\n"
				+ " \"Origin\": \"AMD\",\r\n"
				+ " \"Destination\": \"DEL\",\r\n"
				+ " \"DepartDate\": \"13/09/2023\"\r\n"
				+ " }\r\n"
				+ " ]\r\n"
				+ "}";
	}

}
