# WalmartAPI
This repository contains source files that uses three different walmart APIs
This document basically discusses about the Overall Workflow of the Assignment and also the assumptions that are considered while working on this Assignment.
1.	Assumptions
2.	Instructions for executing the solutions
3.	Workflow/ Overview of the Solution
4.	Screenshots of the Tests conducted

ASSUMPTIONS
•	This Assignment is programmed using Eclipse IDE for Java Developers, Version being Mars.1 Release (4.5.1).
•	As mentioned in the Assignment, the Ranked order of the recommended products based on the user reviews needs to be displayed back to the User. Hence I assumed based on the Average Product Rating of the product that is obtained from Product Reviews API, the ranked orders of Products are considered.
•	Also, Ranked orders of recommended products are in decreasing order of their Average Customer Product Rating.
•	If the product review doesn’t have Reviews of the product as response from the Product Reviews API, then the Average Rating of the Product is considered as 0.0 and the ranking is done for the products.
INSTRUCTIONS FOR EXECUTING THE SOLUTION
•	This Java project is run in Command Line using Runnable jar.
•	The Runnable jar needs to be extracted then following are the steps –
o	Export the java project into runnable jar using Eclipse IDE i.e. Right click on the project and click on Export.
o	Select the main or running class file under Launch configuration.
o	In Library handling - select the option [ Extract required libraries in to jar file ]
•	Steps to run the Java Project.
o	Open command prompt and go to the directory where runnable jar is available.
o	Type => java -jar walmart.jar ipod
Here Walmart.jar is the name of the runnable jar file that was exported.
ipod is the user specified search string which is taken as command line arguments.

For example, if the user wants to specify “tv” as the search string, then
Type => java –jar walmart.jar tv
If the user wants to specify “music” as the search string, then
Type => java –jar walmart.jar music
WORKFLOW/ OVERVIEW OF THE SOLUTION
Walmart API solution consists of the following java files –
	ProcessInputProductSearch.java – fetches the ranked recommendations of products to the user based on the user specified search string by using the Walmart API – Search API, Product Recommendation API, and Reviews API.
	SearchProduct.java – Search the product based on user specified string using Search API and passes the first result product to the Product Recommendation API to fetch the first ten recommendation products.
	ProductRecommendation.java – fetches the recommended products using the Product Recommendation API based on the item-id passed from Search API and sends the resultant string response to the ProductReview class to record the ratings of each product.
	ProductReviews.java – For each recommended product, fetch the item details and average rating using the Product Reviews API and add the item details into TreeMap based on the average rating of the item.
	Utility.java – utility class that requests the respective Walmart API and sends the response in string format which is later parsed using JSON.
	Product.java – Class where the item details are stored i.e itemid, item name, item description, item category path and rating.
	ReviewComp.java – Comparator class that compares the rating of the products and sorts in the decreasing order of the recommended products based on the rating.
