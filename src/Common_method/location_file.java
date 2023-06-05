package Common_method;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class location_file {
	
	public static void location(String file,String requestBody, String responseBody) throws IOException
	{
		File newFile=new File("C:\\Users\\Vitthal\\OneDrive\\Desktop\\aaa\\" +file);
	    if (newFile.createNewFile())
	    {
	    	System.out.println("New blank file is created:" +newFile.getName()); 
	    	FileWriter datawriter=new FileWriter("C:\\Users\\Vitthal\\OneDrive\\Desktop\\aaa\\" +file);
	    	datawriter.write("Request Body :" +"\n" +requestBody+"\n\n");
			datawriter.write("Response Body :" +"\n" +responseBody+"\n\n");
			datawriter.close();
			System.out.println("Request and Response Body written into text file named :" +newFile.getName());
	    }
	}

}
