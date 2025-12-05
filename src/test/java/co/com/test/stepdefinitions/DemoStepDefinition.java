package co.com.test.stepdefinitions;

import co.com.test.steps.DemoSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;


public class DemoStepDefinition {
    @Steps
    DemoSteps demoSteps;

    @Given("Test")
    public void test() {
        // Write code here that turns the phrase above into concrete actions
        demoSteps.OpenTheWebSite();

    }
    @When("Test1")
    public void test1() {
        demoSteps.realizarLogue();

    }
    @Then("Test2")
    public void test2() {
        demoSteps.verificarAcceso();
    }
}
