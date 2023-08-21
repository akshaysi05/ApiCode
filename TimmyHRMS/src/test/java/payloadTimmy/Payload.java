package payloadTimmy;

public   class Payload {
//	int id=31;
//	String Fromdate="2023-08-01";
//	String ToDate="2023-08-18";
	public static String  userLogsPay(int id, String fromDate ,String ToDate) {
		
//		return "{\r\n"
//				+ "    \"enrollId\" : "+id+",\r\n"
//				+ "    \"fromDate\" : \""+fromDate+",\r\n"
//				+ "    \"toDate\" : \""+ToDate+"\r\n"
//				+ "}";
		return "{\"enrollId\":"+id+",\"fromDate\":\""+fromDate+"\",\"toDate\":\""+ToDate+"\"}";
	}

}
