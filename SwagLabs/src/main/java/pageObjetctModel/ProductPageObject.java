package pageObjetctModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPageObject {

	public WebDriver driver;
	
	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	private By productList = By.xpath("//div[@class='inventory_item_name']");
	private By addToCart = By.xpath("//button[starts-with(text(),'Add to cart')]");
	private By costs = By.xpath("//div[@class='inventory_item_price']");
	private By removeButton = By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory']");
	private By shoppingCart = By.xpath("//a[@class='shopping_cart_link']");
	private By shoppingcartcount = By.xpath("//span[@class='shopping_cart_badge']");
	private By continueShopping = By.xpath("//button[@id='continue-shopping']");
	private By checkOut = By.xpath("//button[@id='checkout']");
	private By firstname = By.xpath("//input[@id='first-name']");
	private By lastname = By.xpath("//input[@id='last-name']");
	private By zipcode = By.xpath("//input[@id='postal-code']");
	private By continuee = By.xpath("//input[@id='continue']");
	private By total = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]/text()[2]");
	private By finish = By.xpath("//button[@id='finish']");
	private By itemprice = By.xpath("//div[@class='inventory_item_price']");
	private By cartItem = By.xpath("/div[@class='cart_item']");
	
	public List<WebElement> getProductList(){
		return driver.findElements(productList);
	}
	
	public List<WebElement> getAddTocart(){
		return driver.findElements(addToCart);
	}
	
	public List<WebElement> getCosts(){
		return driver.findElements(costs);
	}
	
	public List<WebElement> getRemoveButton(){
		return driver.findElements(removeButton);
	}
	
	public WebElement getShoppingCart() {
		return driver.findElement(shoppingCart);
	}
	
	public WebElement getContinueShopping() {
		return driver.findElement(continueShopping);
	}
	
	public WebElement getCheckout() {
		return driver.findElement(checkOut);
	}
	
	public WebElement getFirstName() {
		return driver.findElement(firstname);
	}
	
	public WebElement getLastName() {
		return driver.findElement(lastname);
	}
	
	public WebElement getZipcode() {
		return driver.findElement(zipcode);
	}
	
	public WebElement getContinue() {
		return driver.findElement(continuee);
	}
	
	public WebElement getTotal() {
		return driver.findElement(total);
	}
	
	public WebElement getFinish() {
		return driver.findElement(finish);
	}
	
	public WebElement getshoppingcartcount() {
		return driver.findElement(shoppingcartcount);
	}
	
	public List<WebElement> getItemPrice(){
		return driver.findElements(itemprice);
	}
	
	public List<WebElement> getcartItem(){
		return driver.findElements(cartItem);
	}
}
