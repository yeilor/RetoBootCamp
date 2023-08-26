package com.fakeStoreApi.questions.user;

import com.fakeStoreApi.models.user.Address;
import com.fakeStoreApi.models.user.Geolocation;
import com.fakeStoreApi.models.user.Name;
import com.fakeStoreApi.models.user.UserModel;
import com.fakeStoreApi.utils.user.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

public class BuildDataUser implements Question<UserModel> {

    @Override
    public UserModel answeredBy(Actor actor) {
        Map<String, String> data = Data.extractTo().get(0);
        Name name = Name.builder()
                .firstname(data.get("firstname"))
                .lastname(data.get("lastname"))
                .build();

        Geolocation geolocation = Geolocation.builder()
                .lat(data.get("lat"))
                .Long(data.get("long"))
                .build();

        Address address = Address.builder()
                .city(data.get("city"))
                .street(data.get("street"))
                .number(3)
                .zipcode(data.get("zipcode"))
                .build();

        UserModel userModel = UserModel.builder()
                .email(data.get("email"))
                .username(data.get("username"))
                .password(data.get("password"))
                .name(data.get("name"))
                .address(data.get("address"))
                .phone(data.get("phone"))
                .build();
        return userModel;
    }

    public static BuildDataUser was() {
        return new BuildDataUser();
    }
}
