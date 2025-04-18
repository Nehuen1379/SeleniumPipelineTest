package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.IndexAutomationPracticePage;

public class IndexAutomationPracticeSteps {

    WebDriver driver;
    IndexAutomationPracticePage indexAutomationPracticePage;

    @Given("que estoy en la pagina principal")
    public void abrirIndex() {
        driver = new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        indexAutomationPracticePage = new IndexAutomationPracticePage(driver);
    }

    @And("hago click en sign in")
    public void clickEnSignIn() {
        indexAutomationPracticePage.signInClick();
    }

}
