package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
	public RequestSpecification requestSpecifinationData() throws IOException {
		
		// Request Specifinaction
		if(req==null) {
		PrintStream log= new PrintStream(new FileOutputStream("logging.txt"));
				 req = new RequestSpecBuilder().setBaseUri(getGlobalData("baseUrl"))
						.addQueryParam("key", "qaclick123")
						.addFilter(RequestLoggingFilter.logRequestTo(log))
						.addFilter(ResponseLoggingFilter.logResponseTo(log))
						.setContentType(ContentType.JSON).build();
				 return req;
		}
		return req;	 
	}
	public static String getGlobalData(String key) throws IOException {
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream("E:\\Gitcode\\ApiCode\\ApiFrameWork\\src\\test\\java\\resources\\golbal.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}

}
