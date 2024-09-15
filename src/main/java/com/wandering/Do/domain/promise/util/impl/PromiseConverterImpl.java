package com.wandering.Do.domain.promise.util.impl;

import com.wandering.Do.domain.promise.entity.Contact;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.entity.State;
import com.wandering.Do.domain.promise.presentation.dto.req.PromiseWriteReq;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetRes;
import com.wandering.Do.domain.promise.util.PromiseConverter;
import com.wandering.Do.domain.user.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PromiseConverterImpl implements PromiseConverter {

    public Promise toEntity(PromiseWriteReq promiseWriteReq, User user) {
        return Promise.builder()
                .title(promiseWriteReq.getTitle())
                .content(promiseWriteReq.getContent())
                .contact(saveContact(promiseWriteReq.getContact()))
                .date(LocalDate.now())
                .spot(promiseWriteReq.getSpot())
                .maximum(promiseWriteReq.getMaximum())
                .user(user)
                .gender(promiseWriteReq.getGender())
                .tags(promiseWriteReq.getTags())
                .state(State.PENDING)
                .grade(promiseWriteReq.getGrade())
                .build();
    }

    private Contact saveContact(Contact contact) {
        return Contact.builder()
                .email(contact.getEmail())
                .kakao(contact.getKakao())
                .discord(contact.getDiscord())
                .instagram(contact.getInstagram())
                .build();
    }

    public PromiseGetListRes toListDto(Promise promise) {
        return PromiseGetListRes.builder()
                .author(promise.getUser().getName())
                .author_school(promise.getUser().getSchool())
                .author_grade(promise.getUser().getGrade())
                .author_gender(promise.getUser().getGender())
                .id(promise.getId())
                .title(promise.getTitle())
                .grade(promise.getGrade())
                .gender(promise.getGender())
                .date(promise.getDate())
                .maximum(promise.getMaximum())
                .tag(promise.getTags())
                .build();
    }

    public PromiseGetRes toDto(Promise promise) {
        return PromiseGetRes.builder()
                .author(promise.getUser().getName())
                .author_school(promise.getUser().getSchool())
                .author_grade(promise.getUser().getGrade())
                .author_gender(promise.getUser().getGender())
                .author_profile(promise.getUser().getImage())
                .id(promise.getId())
                .title(promise.getTitle())
                .content(promise.getContent())
                .grade(promise.getGrade())
                .gender(promise.getGender())
                .date(promise.getDate())
                .maximum(promise.getMaximum())
                .spot(promise.getSpot())
                .tag(promise.getTags())
                .build();
    }
}
