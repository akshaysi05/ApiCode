package files;

public class Payload {
	public static String addbook(String isbn, String aisle) {
      String payloadbook  =  "{\r\n"
      		+ "\r\n"
      		+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
      		+ "\"isbn\":\""+isbn+"\",\r\n"
      		+ "\"aisle\":\""+aisle+"\",\r\n"
      		+ "\"author\":\"Akshay singh\"\r\n"
      		+ "}\r\n"
      		+ " ";
      return payloadbook;
	}

}
