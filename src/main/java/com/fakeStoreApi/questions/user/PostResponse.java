package com.fakeStoreApi.questions.user;

import com.fakeStoreApi.models.user.UserModel;
import com.fakeStoreApi.models.user.responsePost.UserModelPost;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PostResponse implements Question<UserModelPost> {

    @Override
    public UserModelPost answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UserModelPost.class);
    }

    public static PostResponse was() {
        return new PostResponse();
    }
}
