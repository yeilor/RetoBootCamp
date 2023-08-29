package com.fakeStoreApi.stepDefinitions;

import com.fakeStoreApi.tasks.user.PostUserTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PostUserStepDef {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user = Actor.named("user");

    @Before
    public void setUpBaseUrl() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

    @When("I consume the service and I send the user information")
    public void iConsumeTheServiceAndISendTheUserInformation() {
        user.attemptsTo(
                PostUserTask.on()
        );
    }

    @Then("I can validate the code status")
    public void iCanValidateTheCodeStatus() {
        user.should(
                seeThat(
                        "The response code was: ",
                        res -> lastResponse().statusCode(),
                        CoreMatchers.equalTo(200)
                )
        );
    }

}
