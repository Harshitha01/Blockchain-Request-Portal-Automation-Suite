package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SignInPage;
import utils.TestDataUtil;

public class SignInTest extends BaseTest{
	
	SignInPage signInPage;
	
	@BeforeClass
    public void setUp() {
		super.setUp();
        signInPage = new SignInPage(driver);
    }
	 private boolean isAlertPresent() {
	        try {
	            driver.switchTo().alert();
	            return true;
	        } catch (NoAlertPresentException e) {
	            return false;
	        }
	    }

	    private String getAlertTextAndAccept() {
	        if (isAlertPresent()) {
	            Alert alert = driver.switchTo().alert();
	            String alertText = alert.getText();
	            System.out.println("Alert Text: " + alertText);
	            alert.accept();
	            return alertText;
	        }
	        return null;
	    }

    @Test(dataProvider = "signInData", dataProviderClass = TestDataUtil.class)
    public void testValidSignIn(String email, String password) {
        System.out.println("Testing valid credentials: " + email);
        signInPage.signIn(email, password);

        WebElement welcomeMessage = driver.findElement(By.xpath("//h1[contains(text(),'Open Capital Network')]"));
        Assert.assertTrue(welcomeMessage.isDisplayed(), "Open Capital Network message not displayed.");
    }

    @Test(dataProvider = "signInData", dataProviderClass = TestDataUtil.class)
    public void testInvalidEmailFormatSignIn(String email, String password) {
        System.out.println("Testing invalid email format: " + email);
        signInPage.signIn(email, password);

        String alertText = getAlertTextAndAccept();

        // Verify alert text
        Assert.assertTrue(alertText != null && alertText.contains("User not found"), "Expected alert for user not found was not displayed.");
    }

    @Test(dataProvider = "signInData", dataProviderClass = TestDataUtil.class)
    public void testInvalidPasswordSignIn(String email, String password) {
        System.out.println("Testing invalid password: " + password);
        signInPage.signIn(email, password);

        String alertText = getAlertTextAndAccept();

        // Verify the alert text for Incorrect email or password
        Assert.assertTrue(alertText != null && alertText.contains("Incorrect E-Mail or Password"), 
                          "Expected alert for incorrect email or password was not displayed.");
    }

}
