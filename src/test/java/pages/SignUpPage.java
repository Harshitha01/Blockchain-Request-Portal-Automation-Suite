package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends AuthenticationPage {
	
	

	private By getStartedButton = By.xpath("//button[contains(text(),'Get Started')]");
	private By confirmPasswordField = By.xpath("(//input[@id='outlined-basic'])[3]");
	private By signUpButton = By.xpath("//button[contains(text(),'Sign Up')]");

	public SignUpPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnGetStartedButton() {
		driver.findElement(getStartedButton).click();
	}

	public void enterConfirmPassword(String confirmPassword) {
		driver.findElement(confirmPasswordField).clear();
		driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
	}

	public void clickSignUp() {
		driver.findElement(signUpButton).click();
	}

	public void signUp(String email, String password, String confirmPassword) {
		clickOnGetStartedButton();
		enterEmail(email);
		enterPassword(password);
		enterConfirmPassword(confirmPassword);
		clickSignUp();
	}

}
