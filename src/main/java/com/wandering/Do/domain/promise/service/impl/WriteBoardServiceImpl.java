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

        Stats stats = Stats.PENDING;

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
                .date(writeReqDto.getDate())
                .spot(writeReqDto.getSpot())
                .maximum(writeReqDto.getMaximum())
                .tags(writeReqDto.getTags())
                .stats(stats)
                .build();

        promiseRepository.save(promise);
    }
}
