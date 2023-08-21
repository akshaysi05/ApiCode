package payloadTimmy;

public   class Payload {

	public static String  userLogsPay(int id, String fromDate ,String ToDate) {
		
//		return "{\r\n"
//				+ "    \"enrollId\" : "+id+",\r\n"
//				+ "    \"fromDate\" : \""+fromDate+",\r\n"
//				+ "    \"toDate\" : \""+ToDate+"\r\n"
//				+ "}";
		return "{\"enrollId\":"+id+",\"fromDate\":\""+fromDate+"\",\"toDate\":\""+ToDate+"\"}";
	}

}
