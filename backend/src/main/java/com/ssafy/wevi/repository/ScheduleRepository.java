package com.ssafy.wevi.repository;

import com.ssafy.wevi.domain.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query("SELECT s FROM Schedule s WHERE s.customer.userId = :customerId")
    List<Schedule> findAllScheduleByCustomerId(@Param("customerId") Integer customerId);

    List<Schedule> findAllByCustomer_UserId(Integer UserId);

}
