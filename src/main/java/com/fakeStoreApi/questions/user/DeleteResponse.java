package com.fakeStoreApi.questions.user;

import com.fakeStoreApi.models.user.UserModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DeleteResponse implements Question<UserModel> {

    @Override
    public UserModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UserModel.class);
    }

    public static DeleteResponse was() {
        return new DeleteResponse();
    }
}
