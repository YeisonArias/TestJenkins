package co.com.colorlib.definitions;

import co.com.colorlib.steps.LoginColorLibSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginColorLibDefinition {
    @Steps
    LoginColorLibSteps loginColorLibSteps;

    @Given("^que el Usuario quiere acceder a la APP$")
    public void queElUsuarioQuiereAccederALaAPP() {
        loginColorLibSteps.abrirPagina();
    }


    @When("^el escribe el usuario (.*) y la clave (.*)$")
    public void elEscribeElUsuarioDemoYLaClaveDemo(String usuario, String password) {
        loginColorLibSteps.autenticar(usuario, password);
    }

    @Then("^el ve el titulo (.*)$")
    public void elVeElTituloMetis(String titulo) {
        loginColorLibSteps.verificar(titulo);
    }


}
