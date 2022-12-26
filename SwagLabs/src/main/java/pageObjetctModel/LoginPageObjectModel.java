package pageObjetctModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjectModel {

	public WebDriver driver;
	
	public LoginPageObjectModel(WebDriver driver) {
		this.driver = driver;
	}
	
	private By userName = By.xpath("//input[@id='user-name']");
	private By password = By.xpath("//input[@id='password']");
	private By loginButton = By.xpath("//input[@id='login-button']");
	private By error = By.xpath("//h3[.='Epic sadface: Username and password do not match any user in this service']");
	
	public WebElement getUserName() {
		return driver.findElement(userName);
	}
	
	public WebElement getpassword() {
		return driver.findElement(password);
	}
	
	public WebElement getloginButton() {
		return driver.findElement(loginButton);
	}
	
	public WebElement geterrorMessage() {
		return driver.findElement(error);
	}
}
