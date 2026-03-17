package com.travel.repository;

import com.travel.entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    List<Accommodation> findByTripIdOrderBySortOrder(String tripId);
}
