package maven.MOZmaven;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

import com.google.gson.Gson;

import com.seomoz.api.authentication.Authenticator;
import com.seomoz.api.service.URLMetricsService;
import com.seomoz.api.response.UrlResponse;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws Exception 
     */
    public void testApp() throws Exception
    {
    	   String objectURL = "www.pearsonschool.com";

           //Add your accessID here
           String accessID = "mozscape-e92f2ae771";

           //Add your secretKey here
           String secretKey = "fc3f2ac2e3e23f5b7000a6160c877627";
           //just to print da and pa
          BigInteger col = new BigInteger("103079215108");
          
           Authenticator authenticator = new Authenticator();
           authenticator.setAccessID(accessID);
           authenticator.setSecretKey(secretKey);

           URLMetricsService urlMetricsService = new URLMetricsService(authenticator);
           String response = urlMetricsService.getUrlMetrics(objectURL, col);
           
           
           Gson gson = new Gson();
           UrlResponse res = gson.fromJson(response, UrlResponse.class);
           
           
           
           Date date = new Date();
           System.out.print(date + " "); 
           
           
       
           System.out.print("DA: "+res.getPda() + " ");
           System.out.print("PA: "+res.getUpa()+ " ");
           System.out.println("URL: "+res.getUu()+ " ");
           
         String j = date + " " + "DA: "+res.getPda() + " " + "PA: "+res.getUpa()+ " "+"URL: "+res.getUu()+ System.lineSeparator();
        
         
         
     	try
		{
	
    	// location of txt file start with proj folder fuck :)))
    	Path filePath = Paths.get("./da.txt");
    	   	
    	System.out.println(filePath);
		
			if (!Files.exists(filePath)) {
			    Files.createFile(filePath);
			}
			
			Files.write(filePath, j.getBytes(), StandardOpenOption.APPEND);
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
         
         
         
         
         
           
    }
}
