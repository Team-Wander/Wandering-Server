package com.wandering.Do.domain.promise.service.impl;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.presentation.dto.res.GetPromiseListResDto;
import com.wandering.Do.domain.promise.repository.PromiseRepository;
import com.wandering.Do.domain.promise.service.GetBoardListService;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GetBoardListServiceImpl implements GetBoardListService {
    private final PromiseRepository promiseRepository;
    private final UserUtil userUtil;
    @Override
    public List<GetPromiseListResDto> execute(String spot) {
        User user = userUtil.getCurrentUser();
        List<Promise> promises = promiseRepository.findBySpot(spot);

        return promises.stream()
                .map(promise -> GetPromiseListResDto.toDto(promise, user.getName()))
                .collect(Collectors.toList());
    }
}
