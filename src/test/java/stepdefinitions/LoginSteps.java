package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("que el usuario está en la página de login")
    public void abrirPaginaLogin() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("ingresa su usuario {string} y contraseña {string}")
    public void ingresarCredenciales(String usuario, String contraseña) {
        loginPage.login(usuario, contraseña);
    }

    @Then("debería ver la página principal")
    public void validarLogin() {
        // Validación simple
        assert driver.getCurrentUrl().contains("inventory");
        driver.quit();
    }
}
