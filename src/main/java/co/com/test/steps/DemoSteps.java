package co.com.test.steps;


import co.com.test.pages.DemoPage;
import net.serenitybdd.annotations.Step;


import java.net.URL;



public class DemoSteps {
    DemoPage demoPage;
    @Step
    public void OpenTheWebSite() {
        demoPage.open();
    }

    @Step
    public void realizarLogue() {
        demoPage.ingresarCredenciales();
    }
    @Step
    public void verificarAcceso() {
        demoPage.mensajeBienvenida();
    }
}
