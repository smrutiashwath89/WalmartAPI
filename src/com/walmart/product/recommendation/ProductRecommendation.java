//////////////////////////////////////////////////////////////////////
//ProductRecommendation.java -  Calls the Product Recommendation    //
//		Walmart API based on item id fetched from Search API	    //
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
* Calls the the Product Recommendation Walmart API based on item id fetched from Search API
* 
* Public Interface:
* =================
* public static String getProductRecommendation(Integer itemId) 
* - Calls the Product Recommendation Walmart API based on item id fetched from Search API
* - Input  : Item-id as input
* - Output : Output String as response based on Product Recommendation Walmart API 
* 
* Required Files: ProductRecommendation.java
* 				  Utility.java
* 
*/ 
package com.walmart.product.recommendation;

import com.walmart.api.utility.Utility;

public class ProductRecommendation {
	
	/**
	* Calls the Walmart Product Recommendation API based on Itemid passed from Search API and sends the output response as string
	* 
	* @param myURL - Itemid as input
	* @return String Response as output
	*/
	public static String getProductRecommendation(Integer itemId) {
		String prodRecommendation = Utility
				.callURL("http://api.walmartlabs.com/v1/nbp?apiKey=n53dba2drazknwbyyavvmtkh&itemId=" + itemId);
		return prodRecommendation;
	}
}
