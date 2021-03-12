Feature: Login to the application
Scenario: Login to the application
Given Open the Url
When Click on Login button
Then Validate “Welcome, Please Sign In!” message
And Log in with given credentials 
And Validate the user account ID on top right
And Clear the shopping cart
And Select “Books” from Categories
And Select a book from the list displayed
And Get the price details and enter the quantity (more than one)
And Click on “Add to cart”
And Validate “The product has been added to shopping cart” message
And Click on “shopping cart” on top right and validate the “Sub-Total” Price for selected book
And Click on “Check-out”
And Select “New Address” From “Billing Address” drop down.
And Fill all mandatory fields in “Billing Address” and click “Continue”
And Select the “Shipping Address” as same as “Billing Address” from “Shipping Address” drop down and click on “Continue”
And Select the shipping method as “Next Day Air” and click on “Continue”
And Choose the payment method as COD (Cash on delivery) and click on “Continue”
And Validate the message “You will pay by COD” and click on “Continue”
And Click on “Confirm Order”
And Validate the message “Your order has been successfully processed!” and print the Order number
And Click on “Continue” and log out from the application 
And close browser


