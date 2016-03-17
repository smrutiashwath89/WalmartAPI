//////////////////////////////////////////////////////////////////////
//SearchProduct.java -  Search the product based on					//
//                   user specified string using Walmart Search API //
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
* Gets the first product id as search response using Walmart Search API
* 
* Public Interface:
* =================
* public static TreeSet<Product> productSearchString(String usersearchString)
* - Takes the user-specified search string as input and uses the Walmart Search API to
* 		 get the first result product and then send the item id to Walmart product recommendation API
* 		 to get the list of top 10 product recommendation based on user reviews using Walmart Review API
* - Input  : Product search string as input
* - Output : List of Recommended products based on user reviews.
* 
* Required Files: SearchProduct.java
* 				  ProductReviews.java
* 				  ProductRecommendation.java
* 				  Product.java
* 				  Utility.java
* 
*/ 
package com.walmart.product.search;

import java.util.TreeSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.walmart.api.utility.Utility;
import com.walmart.product.details.Product;
import com.walmart.product.recommendation.ProductRecommendation;
import com.walmart.product.reviews.ProductReviews;

public class SearchProduct {

	/**
	* Insert into TreeMap the top 10 product recommendations based on user reviews
	* 
	* @param usersearchString - Product search string as input
	* @return TreeSet<Product>
	*/
	public static TreeSet<Product> productSearchString(String usersearchString) {
		
		// Calls the Utility method to get the response from Walmart Search API
		String jsonOutput = Utility.callURL(
				"http://api.walmartlabs.com/v1/search?apiKey=n53dba2drazknwbyyavvmtkh&query=" + usersearchString);
		
		TreeSet<Product> prodComp = null;
		try {
			JSONObject obj = new JSONObject(jsonOutput);
			JSONArray jsonArray = obj.getJSONArray("items");
			//get the first result product id
			Integer itemId = jsonArray.getJSONObject(0).getInt("itemId");
			ProductReviews prodRev = new ProductReviews();
			// Based on user reviews get the top 10 product recommendations
			prodComp = prodRev.getProductReviews(ProductRecommendation.getProductRecommendation(itemId));

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return prodComp;
	}
}
