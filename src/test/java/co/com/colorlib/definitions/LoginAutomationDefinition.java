package co.com.colorlib.definitions;

import co.com.colorlib.steps.LoginAutomationSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

import static co.com.colorlib.utilidades.Constantes.NUMERO_UNO;

public class LoginAutomationDefinition {
    @Steps
    LoginAutomationSteps loginAutomationSteps;

    @Given("^que quiero ingresar a la APP$")
    public void queQuieroIngresarALaAPP() {
        loginAutomationSteps.abrirpagina();
    }

    @When("^ingreso el usuario y la clave$")
    public void ingresoElUsuarioYLaClave(DataTable LoginAutomationData) {
        List<List<String>> data = LoginAutomationData.asLists(String.class);
        for (int i = NUMERO_UNO; i < data.size(); i++) {
            loginAutomationSteps.login(data.get(i));
        }
    }

    @Then("^verifico el mensaje de Bienvenida$")
    public void veriricoElMensajeDeBienvenida(DataTable LoginAutomationData) {
        List<List<String>> data = LoginAutomationData.asLists(String.class);
        loginAutomationSteps.mensaje(data.get(NUMERO_UNO));
    }

}
