package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Contact;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.entity.Stats;
import com.wandering.Do.domain.promise.exception.InvalidDateException;
import com.wandering.Do.domain.promise.presentation.dto.req.PromiseWriteReqDto;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.WriteBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class WriteBoardServiceImpl implements WriteBoardService {

    private final PromiseRepository promiseRepository;


    @Override
    public void execute(PromiseWriteReqDto writeReqDto) {

        LocalDate now = LocalDate.now();
        LocalDate requestDate = writeReqDto.getDate();

        if (requestDate.isBefore(now)) {
            throw new InvalidDateException();
        }

        Stats stats;

        // 작성된 날짜와 현재 날짜를 비교하여 상태를 결정
        if (requestDate.isAfter(now)) {
            stats = Stats.PENDING;
        } else if (requestDate.isEqual(now)) {
            stats = Stats.NOW;
        } else {
            stats = Stats.PAST;
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
                .contact(contact)  // Dto에서 받은 Contact 사용
                .date(writeReqDto.getDate())  // 작성된 약속 시간 사용
                .spot(writeReqDto.getSpot())
                .maximum(writeReqDto.getMaximum())
                .tags(writeReqDto.getTags())  // Dto에서 받은 Tags 사용
                .stats(stats)
                .build();

        promiseRepository.save(promise);
    }
}
