package com.agileinfoways.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Json_Parsing  {
 
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
    static JSONArray jArray=null;
 
    // constructor
    public Json_Parsing() {
 
    }
 
    
 //   JSONObject :::::
   /* {
        "data": [
            {
                    "id": "1",
                    "name": "John",
                    "email": "John@gmail.com",
                    "address": india",
                    "gender" : "male",
                    "phone": {
                        "mobile": "+91 15455151",
                        "home": "51 49848",
                        "office": "001 444854"
                    }
            },
            {
                    "id": "2",
                    "name": "Johnny",
                    "email": "johnny@gmail.com",
                    "address": "USA",
                    "gender" : "male",
                    "phone": {
                        "mobile": "+91 145415",
                        "home": "00 8481",
                        "office": "00 4874"
                    }
            }
      ]
    } */
    
    public JSONObject getJSONFromUrl_JsonObject(String url) {
 
        // Making HTTP request
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
 
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();           
 
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) 
            {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
 
        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
 
        // return JSON String
        return jObj;
 
    }
    
    
//  JSONArray :::::
  /*  [
           {
                   "id": "1",
                   "name": "John",
                   "email": "John@gmail.com",
                   "address": india",
                   "gender" : "male",
                   "phone": {
                       "mobile": "+91 15455151",
                       "home": "51 49848",
                       "office": "001 444854"
                   }
           },
           {
                   "id": "2",
                   "name": "Johnny",
                   "email": "johnny@gmail.com",
                   "address": "USA",
                   "gender" : "male",
                   "phone": {
                       "mobile": "+91 145415",
                       "home": "00 8481",
                       "office": "00 4874"
                   }
           }
     ]
    */
    
    public JSONArray getJSONFromUrl_JsonArray(String url) {
    	 
        // Making HTTP request
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
 
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();           
 
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
 
        // try parse the string to a JSON object
        try {
        	jArray = new JSONArray(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
 
        // return JSON String
        return jArray;
 
    }
}