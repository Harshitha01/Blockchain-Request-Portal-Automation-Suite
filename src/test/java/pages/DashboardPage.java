package pages;

import org.openqa.selenium.*;

public class DashboardPage extends BasePage {

    private By signoutButton = By.xpath("//button[contains(text(),'Sign Out')]");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignout() {
        driver.findElement(signoutButton).click();
    }
}
