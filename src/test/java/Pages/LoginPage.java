package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import shoppingcart.BaseClass;

public class LoginPage extends BaseClass {

	// Webelements

	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy(xpath = "//div[@class='page-title']/h1")
	WebElement pageTitle;

	@FindBy(id = "Email")
	WebElement userInd;

	@FindBy(id = "Password")
	WebElement pwd;

	@FindBy(xpath = "//input[@value='Log in']")
	WebElement login;

	@FindBy(xpath = "//div[@class='header-links']//a[@class='account']")
	WebElement loginUserAccount;

	@FindBy(xpath = "//input[@name='removefromcart']")
	List<WebElement> checkboxes;

	@FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
	WebElement shoppingCart;

	@FindBy(xpath = "//input[@name='updatecart']")
	WebElement updateShoppingCart;

	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Books')]")
	WebElement bookCategory;

	@FindBy(xpath = "(//h2[@class='product-title']/a)[1]")
	WebElement selectBook;

	@FindBy(xpath = "//span[@itemprop='price']")
	WebElement priceDetails;

	@FindBy(id = "addtocart_13_EnteredQuantity")
	WebElement quantity;

	@FindBy(id = "add-to-cart-button-13")
	WebElement addCartButton;

	@FindBy(xpath = "//p[@class='content']")
	WebElement productAddMsg;

	@FindBy(xpath = "//span[contains(text(),'Sub-Total:')]/parent::td//following-sibling::td//span[@class='product-price']")
	WebElement getSubTotalPrice;

	@FindBy(id = "checkout")
	WebElement checkoutButton;

	@FindBy(id = "termsofservice")
	WebElement termsOfService;

	@FindBy(xpath = "//select[@name='billing_address_id']")
	WebElement billingAddress;

	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	WebElement billingSave;

	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	WebElement shippingSave;

	@FindBy(xpath = "//label[text()='Next Day Air (0.00)']")
	WebElement shippingMethod;

	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	WebElement shippingMethodSave;

	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
	WebElement paymentMethodSave;

	@FindBy(xpath = "//p[text()='You will pay by COD']")
	WebElement validatePayByCOD;

	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
	WebElement paymentInfoSave;

	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")
	WebElement confirmOrderSave;

	@FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
	WebElement yourOrderSuccess;

	@FindBy(xpath = "//input[@class='button-2 order-completed-continue-button']")
	WebElement ContinueComplete;

	@FindBy(linkText = "Log out")
	WebElement logOut;

	// Action Methods starts here

	public void logIn() {
		loginLink.click();
	}

	public String getTitle() {

		return pageTitle.getText();

	}

	public void getEmail() {
		userInd.sendKeys(prop.getProperty("Email"));
	}

	public void getPwd() {
		pwd.sendKeys(prop.getProperty("Password"));
	}

	public void loginButton() {

		login.click();

	}

	public String getEmailText() {
		return loginUserAccount.getText();
	}

	public void clearShoppingCart() {
		shoppingCart.click();

		int checkbx = checkboxes.size();

		for (int i = 0; i < checkbx; i++) {
			checkboxes.get(i).click();
		}

		updateShoppingCart.click();
	}

	public void clickBookCategory() {

		bookCategory.click();

	}

	public void selectBookFromList() {

		selectBook.click();

	}

	public void getpriceQuantity() {

		priceDetails.getText();

		quantity.clear();
		quantity.sendKeys(prop.getProperty("Qty"));
	}

	public void clickOnAddCart() {

		addCartButton.click();
	}

	public String getProductAddMsg() {

		return productAddMsg.getText();

	}

	public void clickShoppingCart() {

		shoppingCart.click();
	}

	public String validateSubTotal() {

		return getSubTotalPrice.getText();

	}

	public void clickCheckout() {

		termsOfService.click();
		checkoutButton.click();

	}

	public void selectNewAddress() {

		billingAddress.click();

		Select s = new Select(billingAddress);
		s.selectByValue("839319");

	}

	public void billingContinue() {

		billingSave.click();
	}

	public void shippingContinue() {

		shippingSave.click();
	}

	public void selectShippingMethod() {

		shippingMethod.click();
		shippingMethodSave.click();

	}

	public void paymentContinue() {

		paymentMethodSave.click();
	}

	public String getPayByCODMsg() {

		return validatePayByCOD.getText();

	}

	public void confirmOrder() {

		paymentInfoSave.click();
		confirmOrderSave.click();
	}

	public String getSuccessMsg() {

		return yourOrderSuccess.getText();

	}

	public void orderCompleted() {

		ContinueComplete.click();
		logOut.click();

	}

	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

}
