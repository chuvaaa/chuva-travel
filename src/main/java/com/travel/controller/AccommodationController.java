package com.travel.controller;

import com.travel.entity.Accommodation;
import com.travel.repository.AccommodationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {

    private final AccommodationRepository repository;

    public AccommodationController(AccommodationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{tripId}")
    public List<Accommodation> list(@PathVariable String tripId) {
        return repository.findByTripIdOrderBySortOrder(tripId);
    }

    @PostMapping("/{tripId}")
    public Accommodation create(@PathVariable String tripId, @RequestBody Accommodation accom) {
        accom.setTripId(tripId);
        return repository.save(accom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accommodation> update(@PathVariable Long id, @RequestBody Accommodation accom) {
        return repository.findById(id)
                .map(existing -> {
                    accom.setId(id);
                    accom.setTripId(existing.getTripId());
                    return ResponseEntity.ok(repository.save(accom));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
