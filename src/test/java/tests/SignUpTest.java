package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SignUpPage;
import utils.TestDataUtil;

public class SignUpTest extends BaseTest {
    SignUpPage signUpPage;

    @BeforeMethod
    public void setUp() {
    	super.setUp();
        signUpPage = new SignUpPage(driver);
    }

    private boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @Test(dataProvider = "signUpData", dataProviderClass = TestDataUtil.class)
    public void testDuplicateEmail(String email, String password, String confirmPassword) {
        System.out.println("Testing Duplicate Email: " + email);
        signUpPage.signUp(email, password, confirmPassword);
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            Assert.assertEquals(alertText, "Provided E-Mail is already in use", "Duplicate email alert text mismatch!");
            alert.accept();
        } else {
            Assert.fail("No duplicate email alert present.");
        }
    }

    @Test(dataProvider = "signUpData", dataProviderClass = TestDataUtil.class)
    public void testWeakPassword(String email, String password, String confirmPassword) {
        System.out.println("Testing Weak Password: " + password);
        signUpPage.signUp(email, password, confirmPassword);
        if (isElementPresent(By.xpath("//p[contains(text(),'Password must contain at least one lowercase letter,')]"))) {
            Assert.assertTrue(true, "Weak password scenario passed");
        } else {
            Assert.fail("Weak password error not displayed.");
        }
    }

    @Test(dataProvider = "signUpData", dataProviderClass = TestDataUtil.class)
    public void testMismatchedPasswords(String email, String password, String confirmPassword) {
        System.out.println("Testing Mismatched Passwords: " + password + " and " + confirmPassword);
        signUpPage.signUp(email, password, confirmPassword);
        if (isElementPresent(By.xpath("//p[contains(text(),'Passwords do not match')]"))) {
            Assert.assertTrue(true, "Mismatched password scenario passed");
        } else {
            Assert.fail("Mismatched password error not displayed.");
        }
    }

    @Test(dataProvider = "signUpData", dataProviderClass = TestDataUtil.class)
    public void testSuccessfulSignUp(String email, String password, String confirmPassword) {
        System.out.println("Testing Successful Sign-Up: " + email);
        signUpPage.signUp(email, password, confirmPassword);
        if (isElementPresent(By.xpath("//h1[contains(text(),'Open Capital Network')]"))) {
            Assert.assertTrue(true, "Successful signup scenario passed");
        } else {
            Assert.fail("Success message not displayed.");
        }
    }
}
