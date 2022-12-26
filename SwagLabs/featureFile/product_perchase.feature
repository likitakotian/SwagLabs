

Feature: Product perchase
 
  Scenario Outline: Add and remove products to the cart
	Given user launch the browser
    And navigate to the "https://www.saucedemo.com/"
    When user enters the username as "standard_user"
    When user enters the password as "secret_sauce"
    And clicks on login button
    Then naviagte to the page with title "Swag Labs"
    When user clicks on addtocart button on <wantedProduct>
    Then varify the shopping cart count
    When user clicks on remove button on <unwanted_product>
    Then varify the shopping cart count
    And close browser 
   	
             
    
      Examples:
    |wantedProduct|unwanted_product|
    |Sauce Labs Backpack;Sauce Labs Bolt T-Shirt;Sauce Labs Onesie|Sauce Labs Bolt T-Shirt|
    
    
     
  Scenario Outline: validate the total and finish
	Given user launch the browser
    And navigate to the "https://www.saucedemo.com/"
    When user enters the username as "standard_user"
    When user enters the password as "secret_sauce"
    And clicks on login button
    Then naviagte to the page with title "Swag Labs"
    When user clicks on addtocart button on <wantedProduct>
    Then varify the shopping cart count
    When user click on shoping cart and checkout
    And enter <firstName> , <lastName> , <zipCode>  and click on continue
    Then item total should be displayed wuth finish button
    And "THANK YOU FOR YOUR ORDER" page should be displayed 
    And close browser 
   
Examples:
    |wantedProduct|firstName|lastName|zipCode|
    |Sauce Labs Backpack;Sauce Labs Bolt T-Shirt;Sauce Labs Onesie|Niyati|sharma|A-19389|
    