package com.fakeStoreApi.tasks.user;

import com.fakeStoreApi.models.user.UserModel;
import com.fakeStoreApi.questions.user.BuildDataUser;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUserTask implements Task {

    private final String endPoint;

    public PutUserTask(String endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        UserModel userInfo = actor.asksFor(BuildDataUser.was());

        actor.attemptsTo(
                Put.to(endPoint)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .body(userInfo)
                        )
        );
    }

    public static Performable on (String endPoint) {
        return instrumented(PutUserTask.class,endPoint);
    }
}
