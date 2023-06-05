package TestCase_pkg;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Get_testcase {

	@Test
	public static void main(String[] args) {
		//step 1 declare base URL
		
		RestAssured.baseURI = "https://reqres.in/";
		
		//step2 validate status code
		int statusCode = given().header("Content-Type","application/json").when().get("/api/users?page=2").then().extract().response().statusCode();
		System.out.println("status code is " + statusCode);
		
		// configure response body
		
		String responseBody = given().header("Content-Type","application/json").when().get("/api/users?page=2").then().extract().response().asString();
		System.out.println( "responsBody " +responseBody);
		JsonPath jsp = new JsonPath(responseBody);
		int datasize = jsp.getList("data").size();
		
		//assert the total count objects inside the data array
		
		Assert.assertEquals(datasize,6);
		
		//validate each object in data array
		 for(int i=0; i<datasize; i++) {
			 
			String id=jsp.getString("data ["+i+"].id");
			System.out.println(id);
			String email = jsp.getString("data ["+i+"].email");
			System.out.println(email);
			String fname = jsp.getString("data ["+i+"].first_name");
			System.out.println(fname);
			String lname = jsp.getString("data ["+i+"].last_name");
			System.out.println(lname);
			String avatar = jsp.getString("data ["+i+"].avatar");
			System.out.println(avatar);
			
			Assert.assertNotNull(id);
			Assert.assertNotNull(email);
			Assert.assertNotNull(fname);
			Assert.assertNotNull(lname);
			Assert.assertNotNull(avatar);
			
			Assert.assertTrue(Integer.parseInt(id)>=7 && Integer.parseInt(id)<=12);
			Assert.assertTrue(email.contains("@reqres.in"));
		 }
		
		 System.out.println("GET method");
		
		
	}

}
