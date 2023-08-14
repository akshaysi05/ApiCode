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
				+ " \"Origin\": \"DEL\",\r\n"
				+ " \"Destination\": \"BOM\",\r\n"
				+ " \"DepartDate\": \"15/08/2023\"\r\n"
				+ " }\r\n"
				+ " ]\r\n"
				+ "}\r\n"
				+ "";
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
				+ " \"Destination\": \"BOM\",\r\n"
				+ " \"DepartDate\": \"15/08/2023\"\r\n"
				+ " },\r\n"
				+ "{\r\n"
				+ " \"Origin\": \"BOM\",\r\n"
				+ " \"Destination\": \"DEL\",\r\n"
				+ " \"DepartDate\": \"16/08/2023\"\r\n"
				+ " }\r\n"
				+ " ]\r\n"
				+ "}";
	}
	public static String pricingPay(String SessionID, String Key,String PriceKey, String Provider, String ItemNo) {
		
		return "{\r\n"
				+ " \"SessionID\": \""+SessionID+"\",\r\n"
				+ " \"Key\": \""+Key+"\",\r\n"
				+ " \"Pricingkey\": \""+PriceKey+"\",\r\n"
				+ " \"Provider\": \""+Provider+"\",\r\n"
				+ " \"ResultIndex\": \""+ItemNo+"\"\r\n"
				+ "}";
	}
	public static String AddPassenser(String SessionId,String Key,String ResfrenceNo) {
		
		return "{\r\n"
				+ "\"SessionID\": \""+SessionId+"\",\r\n"
				+ " \"Key\": \""+Key+"\",\r\n"
				+ " \"ReferenceNo\": \""+ResfrenceNo+"\",\r\n"
				+ " \"CustomerInfo\": {\r\n"
				+ " \"Email\": \"akshay.s@naapbooks.in\",\r\n"
				+ " \"Mobile\": \"7903707611\",\r\n"
				+ " \"Address\": \"law Garden\",\r\n"
				+ " \"City\": \"Ahmedabad\",\r\n"
				+ " \"State\": \"Gujrat\",\r\n"
				+ " \"CountryCode\": \"IN\",\r\n"
				+ " \"CountryName\": \"India\",\r\n"
				+ " \"ZipCode\": \"380009\",\r\n"
				+ " \"PassengerDetails\": [\r\n"
				+ " \r\n"
				+ " {\r\n"
				+ " \"Title\": \"MR\",\r\n"
				+ " \"Gender\": \"Male\",\r\n"
				+ " \"FirstName\": \"Akshay\",\r\n"
				+ " \"MiddleName\": \"\",\r\n"
				+ " \"LastName\": \"Singh\",\r\n"
				+ " \"DateOfBirth\": \"02/07/2000\",\r\n"
				+ " \"PaxType\": \"ADT\",\r\n"
				+ " \"PassportNumber\": \"136889D1\",\r\n"
				+ " \"IssuingCountry\": \"IN\",\r\n"
				+ " \"ExpiryDate\": \"13/08/2028\"\r\n"
				+ " }\r\n"
				+ " ],\r\n"
				+ " \"PassengerTicketDetails\": [\r\n"
				+ " ],\r\n"
				+ " \"Payment\": {\r\n"
				+ " }\r\n"
				+ " },\r\n"
				+ " \"SSRInfo\": [\r\n"
				+ " \r\n"
				+ " ],\r\n"
				+ " \"TotalAmount\": \"0\",\r\n"
				+ " \"SSRAmount\": 0,\r\n"
				+ " \"Discount\": 0,\r\n"
				+ " \"GrandTotalFare\": \"0\",\r\n"
				+ " \"IsGSTProvided\": false\r\n"
				+ "}";
		
	}
	public static String Bookingpay(String SessionId,String Key,String ResfrenceNo,String Provider) {
		
		return "{\r\n"
				+ " \"SessionID\": \""+SessionId+"\",\r\n"
				+ " \"Key\": \""+Key+"\",\r\n"
				+ " \"ReferenceNo\": \""+ResfrenceNo+"\",\r\n"
				+ "\"Provider\":\""+Provider+"\"\r\n"
				+ "}\r\n"
				+ "";
	}

}
