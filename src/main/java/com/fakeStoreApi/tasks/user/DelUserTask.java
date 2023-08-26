package com.fakeStoreApi.tasks.user;

import com.fakeStoreApi.models.user.UserModel;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DelUserTask implements Task {

    private final String endPoint;
    private final String username;

    public DelUserTask(String endPoint, String username) {
        this.endPoint = endPoint;
        this.username = username;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Delete.from(endPoint)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .log().all()  // Agregar esta línea para imprimir la solicitud
                        )
        );

    }

    public static DelUserTask on(String endPoint, String username) {
        return instrumented(DelUserTask.class,endPoint, username);
    }
}
