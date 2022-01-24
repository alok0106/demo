Feature: Feature to test demoblaze website by purchasing laptop

@test1
Scenario: Customer navigates through product categories
	Given  Customer is on demoblaze homepage  
	Then   customer navigates to Phones category
	Then   customer navigates to Laptops category
	Then   customer navigates to Monitors category
	
@test2	
Scenario Outline: Customer adds laptop to the cart and places the order
	Given Customer is on demoblaze homepage
	And   customer navigates to Laptops category
	Then  clicks on <laptop1> laptop 
	Then  clicks on Add to cart
	Then  accepts pop up confirmation
	Then  customer clicks on Home
	Then  customer navigates to Laptops category
	Then  clicks on <laptop2> laptop
	Then  clicks on Add to cart
	Then  accepts pop up confirmation
	Then  customer clicks on Cart
	Then  customer deletes <laptop2> laptop
	Then  customer clicks on Place order button
	Then  customer fills the place order form with values <name> <country> <city> <creditcard> <month> <year>
	Then  customer clicks on purchase button
	Then  capture purchase id and purchase amount
	Then  log purchase id and purchase amount
	Then  Verify the purchase amount with expected amount
	Then  customer clicks ok button

	 Examples:
		 | laptop1			 | laptop2	   | name | country | city | creditcard | month | year |
		 | Sony vaio i5  | Dell i7 8gb | apap | esp 	  | bcn  | 1234567    | jan   | 1765 |
		 	 
		 	 