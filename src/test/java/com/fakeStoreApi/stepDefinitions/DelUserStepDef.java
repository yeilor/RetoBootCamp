package com.fakeStoreApi.stepDefinitions;

import com.fakeStoreApi.questions.user.DeleteResponse;
import com.fakeStoreApi.tasks.user.DelUserTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class DelUserStepDef {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Actor user= Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        theRestApiBaseUrl= environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://www.postman.com/universal-escape-790589/workspace/fakestoreapi/collection/11239910-ca098a81-5688-41a6-834f-7a64ad92ec7b");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("I consume the endpoint {string} and I send the user information username {string}")
    public void iConsumeTheEndpoint(String endPoint, String username) {
        user.attemptsTo(
                DelUserTask.on(username, endPoint)
        );
    }
    @Then("I can validate the phone {string}")
    public void iCanValidateThePhone(String phone) {
        //String x = DeleteResponse.was().answeredBy(user).getUsername();
       /* user.should(
                seeThat(
                        "The phone number was",
                        res -> DeleteResponse.was().answeredBy(user).getPhone(),
                        equalTo(phone)
                )
        );*/

        user.should(
                seeThat(
                        "The response code is",
                        res -> lastResponse().statusCode(),
                        CoreMatchers.equalTo(200)
                )
        );



    }
}
