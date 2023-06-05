package Common_method;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterTest;

public class evidence_file {
	
	@AfterTest
	public static void evidence_file (String file, String requestBody, String responseBody) throws IOException
	{
		File newFile=new File("C:\\Users\\Vitthal\\OneDrive\\Desktop\\aaa\\" +file);
	    if (newFile.createNewFile())
	    {
	    	location_file.location(file, requestBody, responseBody);
	    }
	    else
	    {
	    	 System.out.println("this file already exists,hence deleting and recreating:" +newFile.getName());
			 newFile.delete();
			 
		   location_file.location(file, requestBody, responseBody);			 
	    }
	}

}

