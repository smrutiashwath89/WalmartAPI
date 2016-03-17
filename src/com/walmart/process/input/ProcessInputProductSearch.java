//////////////////////////////////////////////////////////////////////
//ProcessInputProductSearch.java -  Gets the ranked	recommendations //
// based on the user-provided product search string          	    //
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
* Gets the ranked recommendations based on the user-provided product search string
* 
* Public Interface:
* =================
* public static void main(String[] args) 
* - Gets the ranked recommendations based on the user-provided product search string, insert into TreeMap 
* 	and sorts the product recommendations 
* - Input  : Product search string as input
* 
* 
* Required Files: ProcessInputProductSearch.java
* 				  Product.java
* 				  SearchProduct.java
* 
*/ 
package com.walmart.process.input;

import java.util.TreeSet;

import com.walmart.product.details.Product;
import com.walmart.product.search.SearchProduct;

/**
* Reads input as the product search string and gets the ranked recommendations of products
* @param args - User Specified search string
*/

public class ProcessInputProductSearch {

	public static void main(String[] args) {
		// get the user search string from the command-line
		String usersearchString = args[0];

		// Insert the ranked recommended products in TreeMap
		TreeSet<Product> prodComp = SearchProduct.productSearchString(usersearchString);

		System.out.println("Recommended products based on reviews are");
		for (Product p : prodComp) {
			System.out.println(p);
		}

	}

}
