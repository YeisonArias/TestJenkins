package co.com.colorlib.steps;

import co.com.colorlib.pageobject.LoginAutomationPage;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class LoginAutomationSteps {
    LoginAutomationPage loginAutomationPage;

    @Step
    public void abrirpagina() {
        loginAutomationPage.open();
    }

    @Step
    public void login(List<String> data) {
        loginAutomationPage.loginInApp(data);
    }

    @Step
    public void mensaje(List<String> data) {
        loginAutomationPage.validarMensaje(data);
    }
}
