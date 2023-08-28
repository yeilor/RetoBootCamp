package com.fakeStoreApi.stepDefinitions;

import com.fakeStoreApi.questions.user.ServerResponse;
import com.fakeStoreApi.tasks.user.PostUserTask;
import com.fakeStoreApi.tasks.user.PutUserTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PutUserStepDef {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user = Actor.named("user");

    @Before
    public void setUpBaseUrl() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("I consume the endpoint and I send the User information")
    public void iConsumeTheEndpointAndISendTheUserInformation() {
        user.attemptsTo(
                PutUserTask.on()
        );
    }

    @Then("I can validate server response code")
    public void iCanValidateServerResponseCode() {
        user.should(
                seeThat(
                        "The response code is",
                        res -> lastResponse().statusCode(),
                        CoreMatchers.equalTo(200)
                )
        );
    }
}
