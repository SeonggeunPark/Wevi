package com.ssafy.wevi.repository;

import com.ssafy.wevi.domain.Sigungu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SigunguRepository extends JpaRepository<Sigungu, Integer> {

}