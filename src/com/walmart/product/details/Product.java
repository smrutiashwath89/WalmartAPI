//////////////////////////////////////////////////////////////////////
//Product.java -  Class that contains the product details			//
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
* Class that contains the product details
* 
* Required Files: Product.java
* 
*/ 
package com.walmart.product.details;

public class Product {
	private int itemId;
	private double overallReviewRating;
	private String itemName;
	private String itemCategoryPath;
	private String itemDesc;

	public Product(int itemid, double rating, String itemName, String itemCategoryPath, String itemDesc) {
		this.setItemId(itemid);
		this.setOverallReviewRating(rating);
		this.setItemName(itemName);
		this.setItemCategoryPath(itemCategoryPath);
		this.setItemDesc(itemDesc);
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public double getOverallReviewRating() {
		return overallReviewRating;
	}

	public void setOverallReviewRating(double overallReviewRating) {
		this.overallReviewRating = overallReviewRating;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCategoryPath() {
		return itemCategoryPath;
	}

	public void setItemCategoryPath(String itemCategoryPath) {
		this.itemCategoryPath = itemCategoryPath;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String toString() {
		System.out.println("--------------------------------------------------------------------------------");
		return "Item id: " + this.itemId + "\nItemName: " + this.itemName + "\nRating: " + this.overallReviewRating
				+ "\nItemCategoryPath: " + this.itemCategoryPath + "\nItemDescription: " + this.itemDesc;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;

		Product prod = (Product) obj;
		return itemId == prod.itemId && overallReviewRating == prod.overallReviewRating
				&& (itemName == prod.itemName || (itemName != null && prod.equals(prod.itemName)))
				&& (itemCategoryPath == prod.itemCategoryPath
						|| (itemCategoryPath != null && prod.equals(prod.itemCategoryPath)))
				&& (itemDesc == prod.itemDesc || (itemDesc != null && prod.equals(prod.itemDesc)));
	}

	public int hashCode() {
		return (int) itemId * (int) overallReviewRating * itemName.hashCode() * itemCategoryPath.hashCode()
				* itemDesc.hashCode();
	}

}
