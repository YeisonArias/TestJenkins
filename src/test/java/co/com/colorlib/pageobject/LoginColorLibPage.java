package co.com.colorlib.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.FindBy;
import static co.com.colorlib.utilidades.Constantes.URL;


@DefaultUrl(URL)
public class LoginColorLibPage extends PageObject {
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElementFacade txtUsuario;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElementFacade txtPassword;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block']")
    WebElementFacade btnSignin;

    @FindBy(xpath = "//*[@id='top']/header/div[2]/h3")
    WebElementFacade lblTitulo;

    public void logueoEnLaApp(String usuario, String password) {
        txtUsuario.sendKeys(usuario);
        txtPassword.sendKeys(password);
        btnSignin.click();
    }

    public void verificarTitulo(String titulo) {
        MatcherAssert.assertThat(lblTitulo.getText(),containsText(titulo));
    }
}
