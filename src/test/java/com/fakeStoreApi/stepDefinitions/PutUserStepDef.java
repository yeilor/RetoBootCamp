package com.fakeStoreApi.stepDefinitions;

import com.fakeStoreApi.questions.user.ServerResponse;
import com.fakeStoreApi.tasks.user.PutUserTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PutUserStepDef {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user = Actor.named("user");

    @Before
    public void setUpBaseUrl() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://www.postman.com/universal-escape-790589/workspace/fakestoreapi/collection/11239910-ca098a81-5688-41a6-834f-7a64ad92ec7b");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("I consume the endpoint {string} and I send the User information")
    public void iConsumeTheEndpointAndISendTheUserInformation(String endpoint) {
        user.attemptsTo(
                PutUserTask.on(endpoint)
        );
    }

    @Then("I can validate server response code {int}")
    public void iCanValidateServerResponseCode(Integer statusUser) {
        user.should(
                seeThat(
                        "The server response was: ",
                        ServerResponse.was(),
                        equalTo(statusUser)
                )
        );
    }
}
