package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexAutomationPracticePage {
    private WebDriver driver;

    private By signInButton = By.xpath("//a[@class='login']");

    public IndexAutomationPracticePage(WebDriver driver) {
        this.driver = driver;
    }

    public void signInClick() {
        driver.findElement(signInButton).click();
    }
}
