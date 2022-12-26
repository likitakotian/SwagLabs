package com.test.stepDefination;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.SwagLabs.BaseConfiguration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjetctModel.LoginPageObjectModel;
import pageObjetctModel.ProductPageObject;

public class Login extends BaseConfiguration {

	public WebDriver driver;
	public LoginPageObjectModel loginPageObjectModel;
	public ProductPageObject productPageObject;
	int addedItemCount = 0;

	@Given("^user launch the browser$")
	public void user_launch_the_browser() throws Throwable {
		initiateWebDriver();
		driver = getDriver();
		loginPageObjectModel = new LoginPageObjectModel(driver);
		productPageObject = new ProductPageObject(driver);
	}

	@When("^user enters the username as \"([^\"]*)\"$")
	public void user_enters_the_username_as_something(String username) throws Throwable {
		loginPageObjectModel.getUserName().sendKeys(username);
	}

	@When("^user enters the password as \"([^\"]*)\"$")
	public void user_enters_the_password_as_something(String password) throws Throwable {
		loginPageObjectModel.getpassword().sendKeys(password);
	}

	@Then("^naviagte to the page with title \"([^\"]*)\"$")
	public void naviagte_to_the_page_with_title_something(String title) throws Throwable {
		Assert.assertEquals(title, driver.getTitle());
	}

	@Then("^display \"([^\"]*)\"$")
	public void display_something(String error) throws Throwable {
		Assert.assertEquals(error, loginPageObjectModel.geterrorMessage().getText());
	}

	@And("^navigate to the \"([^\"]*)\"$")
	public void navigate_to_the_something(String strArg1) throws Throwable {
		driver.get("https://www.saucedemo.com/");
	}

	@And("^clicks on login button$")
	public void clicks_on_login_button() throws Throwable {
		loginPageObjectModel.getloginButton().click();
	}

	@And("^Quit browser$")
	public void quit_browser() throws Throwable {
		driver.quit();
	}

	@When("^user clicks on addtocart button on (.+)$")
	public void user_clicks_on_addtocart_button_on(String wantedProduct) throws Throwable {
		List<String> wantedItems = Arrays.asList(wantedProduct.split(";"));
		List<WebElement> allItems = productPageObject.getProductList();
		List<WebElement> addToCart = productPageObject.getAddTocart();
		for (int i = 0; i < allItems.size(); i++) {
			String allproduct = allItems.get(i).getText();
			if (wantedItems.contains(allproduct)) {
				addToCart.get(i).click();
				addedItemCount++;
			}
		}

	}

	@When("^user clicks on remove button on (.+)$")
	public void user_clicks_on_remove_button_on(String unwanted_product) throws Throwable {
		List<String> unwantedItems = Arrays.asList(unwanted_product.split(";"));
		List<WebElement> allItems = productPageObject.getProductList();
		List<WebElement> removeitem = productPageObject.getRemoveButton();
		for (int i = 0; i < allItems.size(); i++) {
			String allproduct = allItems.get(i).getText();
			if (unwantedItems.contains(allproduct)) {
				Thread.sleep(5);
				removeitem.get(i).click();
				addedItemCount--;
			}
		}
	}

	@Then("^varify the shopping cart count$")
	public void varify_the_shopping_cart_count() throws Throwable {
		String totaladdeditem = Integer.toString(addedItemCount);
		Assert.assertEquals(totaladdeditem, productPageObject.getshoppingcartcount().getText());
	}

	@When("^user click on shoping cart and checkout$")
	public void user_click_on_shoping_cart_and_checkout() throws Throwable {
		productPageObject.getShoppingCart().click();
		productPageObject.getCheckout().click();
	}

	@Then("^item total should be displayed wuth finish button$")
	public void item_total_should_be_displayed_wuth_finish_button() throws Throwable {
		productPageObject.getFinish().click();
	}

	@And("^enter (.+) , (.+) , (.+)  and click on continue$")
	public void enter_and_click_on_continue(String firstname, String lastname, String zipcode) throws Throwable {
		productPageObject.getFirstName().sendKeys(firstname);
		productPageObject.getLastName().sendKeys(lastname);
		productPageObject.getZipcode().sendKeys(zipcode);
		productPageObject.getContinue().click();
		Thread.sleep(5);
	}

	@Then("{string} page should be displayed")
	public void page_should_be_displayed(String string) throws InterruptedException {
		List<WebElement> cartItems = productPageObject.getcartItem();
		int sum = 0;
		for (int i = 0; i < cartItems.size(); i++) {
			WebElement totalprice = cartItems.get(i).findElement(By.xpath("//div[@class='inventory_item_price']"));
			String price = totalprice.toString().substring(1);
			sum += Integer.parseInt(price);
		}
		Thread.sleep(5);
		Assert.assertEquals(sum, productPageObject.getTotal());
		
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

}