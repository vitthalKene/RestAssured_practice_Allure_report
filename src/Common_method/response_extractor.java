package Common_method;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class response_extractor {
	
	public static Response post_response (String requestBody) {
		
		Response response=given().header("Content-Type", "application/json").body(requestBody).when().post("/api/users").
		           then().extract().response();
		 return response;
		
		
	}
	
	public static Response get_response (String requestBody) {
		Response response=given().header("Content-Type", "application/json").when().get("/api/users/2").then().extract().response();
		
		return response;
	}

}
