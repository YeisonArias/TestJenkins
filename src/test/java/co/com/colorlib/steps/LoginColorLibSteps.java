package co.com.colorlib.steps;

import co.com.colorlib.pageobject.LoginColorLibPage;
import net.thucydides.core.annotations.Step;

public class LoginColorLibSteps {
    LoginColorLibPage loginColorLibPage;

    @Step
    public void abrirPagina() {
        loginColorLibPage.open();
    }

    @Step
    public void autenticar(String usuario, String password) {
        loginColorLibPage.logueoEnLaApp(usuario, password);
    }

    @Step
    public void verificar(String titulo) {
        loginColorLibPage.verificarTitulo(titulo);
    }
}
