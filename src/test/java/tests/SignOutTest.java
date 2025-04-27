package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DashboardPage;
import pages.SignInPage;
import utils.TestDataUtil;

public class SignOutTest extends BaseTest{

    SignInPage signInPage;
    DashboardPage dashboardPage;
    

    @BeforeClass
    public void setUp() {
    	super.setUp();
        signInPage = new SignInPage(driver);
        dashboardPage = new DashboardPage(driver);
    }
    
    

    @Test(dataProvider="credentials",dataProviderClass = TestDataUtil.class)
    public void verifySignOutFunctionality(String email, String password) {
        // Perform SignIn first
        signInPage.signIn(email, password); 

        // Click on Signout button
        dashboardPage.clickOnSignout();
        
        WebElement successMessage = driver.findElement(By.xpath("//h1[contains(text(),'Open Capital Network')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Sign-up failed, user not redirected to the dashboard.");

    }

}
