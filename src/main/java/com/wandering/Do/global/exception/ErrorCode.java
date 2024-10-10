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
    PERMISSION_NOT_ACCESSIBLE(401, "접근할 수 없는 권한 입니다."),
    USER_NOT_MATCH(403, "이 글에 대한 접근 권한이 없습니다."),
    NOT_INCLUDED_APPLICATION(403, "해당 유저는 약속을 신청하지 않았습니다"),


    //promise
    PROMISE_NOT_FOUND(404, "해당 글을 찾을 수 없습니다"),
    INVALID_TAG_COUNT(400, "최대 2개 까지 선택 가능합니다"),
    INVALID_GRADE_SELECTION(400, "ANY가 선택된 경우 다른 학년을 선택할 수 없습니다."),
    INVALID_GRADES_SELECTION(400, "ONE부터 SIX까지의 학년이 선택된 경우 'ANY'를 선택할 수 없습니다."),
    INVALID_DATE(400, "날짜는 현재보다 이전일 수 없습니다."),
    ILLEGAL_ARGUMENT(400, "자신의 약속에 신청할 수 없습니다"),
    ALREADY_APPLIED(400, "이미 신청한 약속 입니다"),

    // report
    NOT_EMPTY_REASON(400, "신고사유는 공란일 수 없습니다."),
    PROMISE_ALREADY_REPORT(400, "이미 신고된 글입니다."),
    NOT_FOUND_REPORT(404, "해당 신고글을 찾을 수 없습니다.");

    private final int httpStatus;
    private final String message;
}
