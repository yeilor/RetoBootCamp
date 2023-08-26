package com.fakeStoreApi.stepDefinitions;

import com.fakeStoreApi.questions.user.ServerResponse;
import com.fakeStoreApi.tasks.user.PostUserTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PostUserStepDef {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user = Actor.named("user");

    @Before
    public void setUpBaseUrl() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://www.postman.com/universal-escape-790589/workspace/fakestoreapi/collection/11239910-ca098a81-5688-41a6-834f-7a64ad92ec7b");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

    @When("I consume the endpoint {string} and I send the user information")
    public void setInfoUser(String endpoint) {
        user.attemptsTo(
                PostUserTask.on(endpoint)
        );
    }

    @Then("I can validate the code status {int}")
    public void iCanValidateTheCodeStatus(Integer resServer) {
        user.should(
                seeThat(
                        "The response code was: ",
                        ServerResponse.was(),
                        equalTo(resServer)
                )
        );
    }
}
