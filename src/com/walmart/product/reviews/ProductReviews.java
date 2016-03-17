//////////////////////////////////////////////////////////////////////
//ProductReviews.java -  Calls the Product Reviews API for each     //
//	recommended product obtained from Product recommendation API	//
//  and ranks the recommended products based on user rating         //
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
*  Calls the Product Reviews API for each recommended product obtained from Product recommendation API
*  and ranks the recommended products based on user rating 
* 
* Public Interface:
* =================
* public static double getProductOverallRating(Integer itemId)
* - Calls the Product Reviews Walmart API based on item id and fetches the reviewStatistics and returns the Average product rating
* - Input  : Item-id as input
* - Output : Output Average Rating as response based on Product Reviews Walmart API 
* 
* public TreeSet<Product> getProductReviews(String prodRecommendation)
* - Takes as input the String response obtained from product recommendation and based on User average rating
* 	of each product ranks the order of the products and stores it in TreeMap
* - Input  : String response from Product Recommendation API as input
* - Output : Output TreeMap with item details stored as response based on Product Reviews Walmart API 
* 
* Required Files: ProductReviews.java
* 				  Utility.java
* 				  Product.java
* 				  ReviewComp.java
* 
*/ 
package com.walmart.product.reviews;

import java.util.TreeSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.walmart.api.utility.Utility;
import com.walmart.product.details.Product;
import com.walmart.product.details.ReviewComp;

public class ProductReviews {
	
	/**
	* Calls the Walmart Product Review API based on Itemid passed from Recommendation API and sends the Average rating as response
	* 
	* @param itemId - Itemid as input
	* @return Double Average Rating as output
	*/
	public static double getProductOverallRating(Integer itemId) {
		// Product Reviews API for the itemId
		String prodRating = Utility.callURL(
				"http://api.walmartlabs.com/v1/reviews/" + itemId + "?apiKey=n53dba2drazknwbyyavvmtkh&format=json");

		String avgProdRating = null;

		try {
			JSONObject obj = new JSONObject(prodRating);
			// get the average rating of each item
			avgProdRating = (obj.has("reviewStatistics")
					? obj.getJSONObject("reviewStatistics").getString("averageOverallRating") : null);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return (avgProdRating != null ? Double.parseDouble(avgProdRating) : 0.0);

	}

	/**
	* Takes the Walmart Product Recommendation API response and sends the output as TreeMap that has ranked order of
	*  recommended products based on user revies - average rating
	* 
	* @param prodRecommendation - String as input
	* @return TreeMap of Products as output
	*/
	public TreeSet<Product> getProductReviews(String prodRecommendation) {
		TreeSet<Product> prodComp = new TreeSet<Product>(new ReviewComp());
		try {
			JSONArray jsonArray = new JSONArray(prodRecommendation);

			for (int i = 0; i < 10; i++) {
				JSONObject jsonobject = jsonArray.getJSONObject(i);
				int itemId = jsonobject.getInt("itemId");
				String itemName = jsonobject.getString("name");
				String itemCategoryPath = jsonobject.getString("categoryPath");
				String itemDesc = jsonobject.getString("shortDescription");
				// get the Average rating of the product which is used for ranking the products
				double itemRating = getProductOverallRating(itemId);
				prodComp.add(new Product(itemId, itemRating, itemName, itemCategoryPath, itemDesc));
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return prodComp;
	}
}
