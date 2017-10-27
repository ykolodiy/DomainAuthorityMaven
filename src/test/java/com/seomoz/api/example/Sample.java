package com.seomoz.api.example;

import java.math.BigInteger;

import com.google.gson.Gson;

import com.seomoz.api.authentication.Authenticator;
import com.seomoz.api.service.URLMetricsService;
import com.sun.jna.platform.win32.OaIdl.DATE;
import com.seomoz.api.response.UrlResponse;


public class Sample
{
    public static void main(String args[])
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
        
        System.out.println("DomainAutority: "+res.getPda());
        System.out.println("PageAutority: "+res.getUpa());
        System.out.println("URL: "+res.getUu());
      
       
        

       
    }
}
