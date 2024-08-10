package com.wandering.Do.global.oauth2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverInfoRes {

    @JsonProperty("response")
    private Response response;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Response {
        private String email;
        private String nickname;
        private String gender;
        private String birthyear;
        private String mobile;
    }

    public String getEmail() {
        return response.email;
    }

    public String getNickname() {
        return response.nickname;
    }

    public String getGender() {
        return response.gender;
    }

    public String getBirthyear() {
        return response.birthyear;
    }

    public String getMobile() {
        return response.mobile;
    }
}
