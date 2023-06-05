package TestCase_pkg;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_method.evidence_file;
import Common_method.response_extractor;
import Request_repo.base_url;
import Request_repo.request_repo;


public class Post_Testcase {

	@Test
	public static void post_Executor() throws IOException {
		
		for (int i=0; i<3; i++) {
			Response com_response=Post_Testcase.response_status_code();
			int status_code=com_response.statusCode();
			String responseBody=com_response.getBody().asString();
			
			if (status_code==201) {
				Post_Testcase.post_response_validator(responseBody);
				System.out.println(responseBody);
				evidence_file.evidence_file("Post_TC", request_repo.post_req(), responseBody);
			}
			else
			{
				int k=i+1;
				if (k<3)
					System.out.println("incorrect Status_code");
			}
			
		}		
	}
		public static Response response_status_code () {
			
		RestAssured.baseURI=base_url.base_url();	
		Response response=response_extractor.post_response(request_repo.post_req());
		return response;
		
		}
		public static void post_response_validator (String responseBody) {

		JsonPath response_jsp=new JsonPath(responseBody);
		JsonPath request_jsp=new JsonPath (request_repo.post_req());
		
		String req_name=request_jsp.getString("name");
		String req_job=request_jsp.getString("job");
		
		String res_name=response_jsp.getString("name");
		String res_job=response_jsp.getString("job");
		String res_id=response_jsp.getString("id");
		String res_createdAt=response_jsp.getString("createdAt");
		
		Assert.assertEquals(req_name, res_name);
		Assert.assertEquals(req_job, res_job);
		Assert.assertNotNull(res_id);
		Assert.assertEquals(LocalDate.now(ZoneOffset.UTC).toString(), res_createdAt.substring(0,10));
		
		
		
	}

}   
