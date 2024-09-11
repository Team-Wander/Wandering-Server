package com.wandering.Do.domain.promise.repository;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;
import com.wandering.Do.domain.user.entity.Gender;
import com.wandering.Do.domain.user.entity.Grade;
import com.wandering.Do.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromiseRepository extends JpaRepository<Promise, Long> {
    List<Promise> findBySpot(String spot);
    List<Promise> findByTagsInAndGenderInAndGradeIn(
            List<Tag> tag, List<Gender> gender, List<Grade> grade);
    List<Promise> findByUser(User user);
    List<Promise> findByTitleContaining(String keyword);
}
