package com.wandering.Do.domain.promise.repository;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.user.entity.Gender;
import com.wandering.Do.domain.user.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromiseRepository extends JpaRepository<Promise, Long> {
    List<Promise> findBySpot(String spot);
    List<Promise> findByTagsInAndGenderInAndGradeIn(
            List<Tag> tag, List<Gender> gender, List<Grade> grade);
}
