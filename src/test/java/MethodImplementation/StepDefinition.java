package MethodImplementation;

import org.junit.Assert;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import shoppingcart.BaseClass;

public class StepDefinition extends BaseClass {

	LoginPage lp;

	// Enter valid Url in the browser

	@Given("Open the Url")
	public void open_the_url() {

		initializer();
		lp = new LoginPage(driver);
		driver.get(prop.getProperty("Url"));
	}

	// Click on Login link

	@When("Click on Login button")
	public void click_on_login_button() {
		lp.logIn();
	}

	// Validate the page title

	@Then("Validate “Welcome, Please Sign In!” message")
	public void validate_welcome_please_sign_in_message() {

		String title = lp.getTitle();
		Assert.assertEquals(prop.getProperty("PageTitle"), title);
		System.out.println("Added Success Message: " + title);
	}

	// Enter valid credentials and Click on Login button
	@Then("Log in with given credentials")
	public void log_in_with_given_credentials() {
		lp.getEmail();
		lp.getPwd();
		lp.loginButton();
	}

	// Validate User account ID

	@Then("Validate the user account ID on top right")
	public void validate_the_user_account_id_on_top_right() {
		String email = lp.getEmailText();
		Assert.assertEquals(prop.getProperty("Email"), email);
		System.out.println("Added Success Message: " + email);
	}

	// Clear the Shopping Cart

	@Then("Clear the shopping cart")
	public void clear_the_shopping_cart() throws InterruptedException {
		lp.clearShoppingCart();
		Thread.sleep(5000);
	}

	// Select Books Category

	@Then("Select “Books” from Categories")
	public void select_books_from_categories() {
		lp.clickBookCategory();
	}

	// Select book from list

	@Then("Select a book from the list displayed")
	public void select_a_book_from_the_list_displayed() {
		lp.selectBookFromList();
	}

	// Get the price details and enter the quantity

	@Then("Get the price details and enter the quantity \\(more than one)")
	public void get_the_price_details_and_enter_the_quantity_more_than_one() {
		lp.getpriceQuantity();
	}

	// Click on Add to Cart

	@Then("Click on “Add to cart”")
	public void click_on_add_to_cart() {
		lp.clickOnAddCart();
	}

	// Validate Add to Cart Success message

	@Then("Validate “The product has been added to shopping cart” message")
	public void validate_the_product_has_been_added_to_shopping_cart_message() {

		String addMsg = lp.getProductAddMsg();
		Assert.assertEquals(prop.getProperty("ProductAddMessage"), addMsg);
		System.out.println("Added Success Message: " + addMsg);
	}

	// Click on Shopping Cart

	@Then("Click on “shopping cart” on top right and validate the “Sub-Total” Price for selected book")
	public void click_on_shopping_cart_on_top_right_and_validate_the_sub_total_price_for_selected_book() {
		lp.clickShoppingCart();
		String total = lp.validateSubTotal();
		Assert.assertEquals(prop.getProperty("SubTotal"), total);
		System.out.println("Added Success Message: " + total);

	}

	// Click on Agree checkbox and Checkout

	@Then("Click on “Check-out”")
	public void click_on_check_out() {
		lp.clickCheckout();
	}

	// Select New Address from billing Address

	@Then("Select “New Address” From “Billing Address” drop down.")
	public void select_new_address_from_billing_address_drop_down() {
		lp.selectNewAddress();

	}

	// Clcik on Continue button

	@Then("Fill all mandatory fields in “Billing Address” and click “Continue”")
	public void fill_all_mandatory_fields_in_billing_address_and_click_continue() {
		lp.billingContinue();
	}

	// Click on Continue button in shipping adress

	@Then("Select the “Shipping Address” as same as “Billing Address” from “Shipping Address” drop down and click on “Continue”")
	public void select_the_shipping_address_as_same_as_billing_address_from_shipping_address_drop_down_and_click_on_continue() {
		lp.shippingContinue();
	}

	// Clcik on Next Day Air radio button

	@Then("Select the shipping method as “Next Day Air” and click on “Continue”")
	public void select_the_shipping_method_as_next_day_air_and_click_on_continue() {
		lp.selectShippingMethod();
	}

	// Select Cash On Delivery

	@Then("Choose the payment method as COD \\(Cash on delivery) and click on “Continue”")
	public void choose_the_payment_method_as_cod_cash_on_delivery_and_click_on_continue() throws InterruptedException {
		lp.paymentContinue();
		Thread.sleep(5000);
	}

	// Validate You will pay by COD message

	@Then("Validate the message “You will pay by COD” and click on “Continue”")
	public void validate_the_message_you_will_pay_by_cod_and_click_on_continue() {

		String cod = lp.getPayByCODMsg();
		Assert.assertEquals(prop.getProperty("PayCod"), cod);
		System.out.println("Payment Method: " + cod);

	}

	// Click on Continue button

	@Then("Click on “Confirm Order”")
	public void click_on_confirm_order() {

		lp.confirmOrder();

	}

	// Validate Your order has been successfully processed! message

	@Then("Validate the message “Your order has been successfully processed!” and print the Order number")
	public void validate_the_message_your_order_has_been_successfully_processed_and_print_the_order_number() {

		String yourOrderSuccess = lp.getSuccessMsg();
		Assert.assertEquals(prop.getProperty("SuccessMsg"), yourOrderSuccess);
		System.out.println("Order Details " + yourOrderSuccess);

	}

	// Click on Continue and Logout

	@Then("Click on “Continue” and log out from the application")
	public void click_on_continue_and_log_out_from_the_application() {

		lp.orderCompleted();
	}

	// Close the browser
	@Then("close browser")
	public void close_browser() {

		driver.close();
	}
}
