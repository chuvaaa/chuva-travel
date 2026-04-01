package com.travel.controller;

import com.travel.entity.Schedule;
import com.travel.repository.ScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleRepository repository;

    public ScheduleController(ScheduleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{tripId}")
    public List<Schedule> list(@PathVariable String tripId) {
        return repository.findByTripIdOrderByDateAscSortOrderAsc(tripId);
    }

    @PostMapping("/{tripId}")
    public Schedule create(@PathVariable String tripId, @RequestBody Schedule schedule) {
        schedule.setTripId(tripId);
        return repository.save(schedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> update(@PathVariable Long id, @RequestBody Schedule schedule) {
        return repository.findById(id)
                .map(existing -> {
                    schedule.setId(id);
                    schedule.setTripId(existing.getTripId());
                    return ResponseEntity.ok(repository.save(schedule));
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
