package Request_repo;

import org.testng.annotations.BeforeTest;

public class base_url {
	
	@BeforeTest
public static String base_url () {
		
		String url="https://reqres.in/";
		return url;

}
}