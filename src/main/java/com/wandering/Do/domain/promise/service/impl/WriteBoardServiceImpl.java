package com.wandering.Do.domain.promise.service.impl;
import com.wandering.Do.domain.promise.entity.*;
import com.wandering.Do.domain.promise.exception.InvalidDateException;
import com.wandering.Do.domain.promise.exception.InvalidTagCountException;
import com.wandering.Do.domain.promise.presentation.dto.req.PromiseWriteReq;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.WriteBoardService;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WriteBoardServiceImpl implements WriteBoardService {

    private final PromiseRepository promiseRepository;
    private final UserUtil userUtil;


    @Override
    public void execute(PromiseWriteReq writeReqDto) {

        User user = userUtil.getCurrentUser();

        LocalDate now = LocalDate.now();

        List<Tag> tags = writeReqDto.getTags();
        if (tags.size() > 2) {
            throw new InvalidTagCountException();
        }

        Contact contact = new Contact(
                writeReqDto.getContact().getInstagram(),
                writeReqDto.getContact().getDiscord(),
                writeReqDto.getContact().getKakao(),
                writeReqDto.getContact().getEmail()
        );

        Promise promise = Promise.builder()
                .title(writeReqDto.getTitle())
                .content(writeReqDto.getContent())
                .contact(contact)
                .date(now)
                .spot(writeReqDto.getSpot())
                .maximum(writeReqDto.getMaximum())
                .tags(tags)
                .user(user)
                .gender(SelGender.ANY)
                .stats(Stats.PENDING)
                .grade(writeReqDto.getGrade())
                .build();
        promiseRepository.save(promise);
    }
}
