package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends BasePage{

	    protected By emailField = By.xpath("//input[@id='outlined-basic' and @type='text']");
	    protected By passwordField = By.xpath("(//input[@id='outlined-basic'])[2]");

	    public AuthenticationPage(WebDriver driver) {
	        super(driver);
	    }

	    public void enterEmail(String email) {
	    	driver.findElement(emailField).clear();
	        driver.findElement(emailField).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	    	driver.findElement(passwordField).clear();
	        driver.findElement(passwordField).sendKeys(password);
	    }
	}


