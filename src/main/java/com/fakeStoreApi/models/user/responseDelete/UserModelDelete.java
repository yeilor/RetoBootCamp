package com.fakeStoreApi.models.user.responseDelete;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserModelDelete {
    @JsonProperty("city")
    public Integer id;

    @JsonProperty("email")
    public String email;

    @JsonProperty("username")
    public String username;

    @JsonProperty("password")
    public String password;

    @JsonProperty("phone")
    public String phone;

    @JsonProperty("v")
    public Integer v;
}
