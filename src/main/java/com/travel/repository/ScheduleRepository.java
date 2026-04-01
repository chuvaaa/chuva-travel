package com.travel.repository;

import com.travel.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByTripIdOrderByDateAscSortOrderAsc(String tripId);
}
