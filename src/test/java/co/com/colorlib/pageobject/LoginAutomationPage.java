package co.com.colorlib.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static co.com.colorlib.utilidades.Constantes.*;

@DefaultUrl(URL)
public class LoginAutomationPage extends PageObject {
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElementFacade txtUsuario;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElementFacade txtPassword;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block']")
    WebElementFacade btnSignin;

    @FindBy(xpath = "/html/body/div/div[1]/img")
    WebElementFacade lblTitulo;

    @FindBy(xpath = "//a[@data-original-title='Logout']")
    WebElementFacade btnLogout;


    public void loginInApp(List<String> data) {
        txtUsuario.sendKeys(data.get(COLUMNA_USUARIO));
        txtPassword.sendKeys(data.get(COLUMNA_PASSWORD));
        btnSignin.click();
        btnLogout.click();
    }

    public void validarMensaje(List<String> data) {
        MatcherAssert.assertThat(data.get(0),containsText(lblTitulo.getText()));
    }
}
