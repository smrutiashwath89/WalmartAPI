//////////////////////////////////////////////////////////////////////
//ReviewComp.java -  Class that compares the rating of two products	//
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
* Class that compares the rating of two products
* 
* Required Files: ReviewComp.java
* 				  Product.java
* 
*/ 
package com.walmart.product.details;

import java.util.Comparator;

public class ReviewComp implements Comparator<Product> {
	public ReviewComp() {
	}

	@Override
	public int compare(Product e1, Product e2) {
		if (e1.getOverallReviewRating() < e2.getOverallReviewRating()) {
			return 1;
		} else {
			return -1;
		}
	}
}
