package co.com.test.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.junit.Assert.assertEquals;


@DefaultUrl("https://parabank.parasoft.com/parabank/index.htm")
public class DemoPage extends PageObject {
    @FindBy(name = "username")
    WebElementFacade USERNAME;

    @FindBy(name = "password")
    WebElementFacade PASSWORD;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElementFacade BTN_LOGIN;

    @FindBy(xpath = "//*[@id='leftPanel']/p")
    WebElementFacade MENSAJE_BIENVENIDA;

    @FindBy(linkText = "Log Out")
    WebElementFacade LOG_OUT;

    public void ingresarCredenciales() {
        USERNAME.sendKeys("john");
        PASSWORD.sendKeys("demo");
        BTN_LOGIN.click();
    }

    public void mensajeBienvenida() {
        String mensaje="Welcome John Smith";
        assertEquals(mensaje, MENSAJE_BIENVENIDA.getText());
        LOG_OUT.click();
    }

    public void realizarLoginconCredenciales(String user, String password) {
        USERNAME.sendKeys(user);
        PASSWORD.sendKeys(password);
        BTN_LOGIN.click();
    }
}
