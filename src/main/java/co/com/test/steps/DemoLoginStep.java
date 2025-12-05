package co.com.test.steps;

import co.com.test.pages.DemoPage;
import net.serenitybdd.annotations.Step;


public class DemoLoginStep {
    DemoPage demoPage;


    @Step
    public void ingresarCredenciales(String user, String password) {
        demoPage.realizarLoginconCredenciales(user,password);
    }
}
