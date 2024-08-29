package com.wandering.Do.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    // token
    EXPIRED_TOKEN(401, "토큰이 만료되었습니다."),
    INVALID_TOKEN_TYPE(401, "유효하지 않은 토큰 타입입니다."),
    INVALID_TOKEN(401, "유효하지 않은 토큰입니다."),
    EXPIRED_REFRESH_TOKEN(401, "만료된 리프레쉬 토큰입니다."),

    //user
    USER_NOT_FOUND(404, "해당 유저를 찾을 수 없습니다"),

    //promise
//    TooManyTagsException
    INVALID_TAG_COUNT(400, "최대 2개 까지 선택 가능합니다"),
    BOARD_NOT_FOUND(404, "해당 글을 찾을 수 없습니다"),
    INVALID_DATE(400, "날짜는 현재보다 이전일 수 없습니다.");

    private final int httpStatus;
    private final String message;
}
