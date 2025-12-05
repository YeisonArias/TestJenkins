package co.com.test.stepdefinitions;

import co.com.test.steps.DemoLoginStep;
import co.com.test.steps.DemoSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.annotations.Steps;


public class DemoLoginStepDefinition {
    @Steps
    DemoLoginStep demoLoginStep;
    @Steps
    DemoSteps demoSteps;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Given("que el usuario ingresa a la PARABANK")
    public void queElUsuarioIngresaALaPARABANK() {
        demoSteps.OpenTheWebSite();
    }
    @When("el escribe el usuario {string} y la clave {string}")
    public void elEscribeElUsuarioYLaClave(String user, String password ) {
        demoLoginStep.ingresarCredenciales(user,password);
    }
    @Then("el ve el mensaje de bienvenida {string}")
    public void elVeElMensajeDeBienvenida(String string) {
        demoSteps.verificarAcceso();
    }
}
