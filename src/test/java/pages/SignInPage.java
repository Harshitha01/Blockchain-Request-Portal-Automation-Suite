package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends AuthenticationPage {
	
	private By initialSignInLink = By.xpath("//button[contains(text(),'Sign In')]");
	private By signupPageGoToSignInLink = By.xpath("//button[contains(text(),'Already have an account? Click here to sign in.')]");
	private By submitSignInButton = By.xpath("(//span[@class='MuiTouchRipple-root css-w0pj6f'])[2]");
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	public void clickOnInitialSignInLinkButton() {
        driver.findElement(initialSignInLink).click();
    }
	public void clickOnSignupPageGoToSignInLinkButton() {
        driver.findElement(signupPageGoToSignInLink).click();
    }
	public void clickOnSubmitSignInButton() {
        driver.findElement(submitSignInButton).click();
    }
	 public void signIn(String email, String password) {
		 clickOnInitialSignInLinkButton();
		 clickOnSignupPageGoToSignInLinkButton();
	     enterEmail(email);
	     enterPassword(password);
	     clickOnSubmitSignInButton();
	    }

}
