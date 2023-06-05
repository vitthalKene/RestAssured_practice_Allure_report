package TestCase_pkg;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_method.response_extractor;
import Request_repo.base_url;

public class get_tc {

	@Test
	public static void get_executor () {
		
		for (int i=0; i<5; i++){
			Response com_response=get_tc.Status_code_extractor();
			int status_code=com_response.statusCode();
			String responseBody=com_response.getBody().asString();
		
			if (status_code==200)
			{
				get_tc.get_response_validator(responseBody);
				System.out.println(responseBody);
			}
			else
			{
				System.out.println("Incorrect Status code");
			}
		}
	}
		
		public static Response Status_code_extractor () {
		RestAssured.baseURI=base_url.base_url();
		
		Response response=response_extractor.get_response(null);
		return response;
		}
	
	
	public static void get_response_validator (String responseBody) {	
		JsonPath jsp=new JsonPath (responseBody);
		
		String jsp_id=jsp.getString("id");
		String jsp_email=jsp.getString("email");
		String jsp_first_name=jsp.getString("first_name");
		String jsp_last_name=jsp.getString("last_name");
		String jsp_avatar=jsp.getString("avatar");
		
	}
	
}
	
