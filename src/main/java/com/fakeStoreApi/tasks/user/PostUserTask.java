package com.fakeStoreApi.tasks.user;

import com.fakeStoreApi.models.user.UserModel;
import com.fakeStoreApi.questions.user.BuildDataUser;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostUserTask implements Task {

    private final String endPoint;

    public PostUserTask(String endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        UserModel userInfo = actor.asksFor(BuildDataUser.was());
        actor.attemptsTo(
                Post.to(endPoint).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );

    }

    public static PostUserTask on(String endPoint) {
        return instrumented(PostUserTask.class,endPoint);
    }
}
