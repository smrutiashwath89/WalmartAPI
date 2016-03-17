//////////////////////////////////////////////////////////////////////
//Utility.java -  Calls the respective Walmart API based on         //
//			the request URL that is passed							//
//Version 1.0                                                       //
//Language:    Java SE-1.7 , Eclipse Mars 4.5.1		                //
//Platform:    HP Pavilion dv6, Core-i5, Windows 8                  //
//Author:      Smruti Ashwatha				      		            //
//(315) 395-8738, smrutiashwath89@gmail.com                         //
//////////////////////////////////////////////////////////////////////
/*
* 
* Package Operations:
* -------------------
* Calls the respective Walmart API based on the request URL that is passed
* 
* Public Interface:
* =================
* public static String callURL(String myURL) 
* - Calls the respective Walmart API based on the request URL that is passed as String input and
* 	 outputs the response in String format
* - Input  : URL as String request
* - Output : Output String as response based on which Walmart API is called
* 
* Required Files: Utility.java
* 
*/ 
package com.walmart.api.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class Utility {

	/**
	* Calls the particular Walmart API and sends the output response as string
	* 
	* @param myURL - String URL as input
	* @return String Response as output
	*/
	public static String callURL(String myURL) {
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
			in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:" + myURL, e);
		}

		return sb.toString();
	}
}
