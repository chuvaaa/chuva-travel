package com.travel.controller;

import com.travel.entity.Favorite;
import com.travel.repository.FavoriteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteRepository favoriteRepository;

    public FavoriteController(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    // 특정 여행의 즐겨찾기 전체 조회
    @GetMapping("/{tripId}")
    public ResponseEntity<Map<String, Boolean>> getFavorites(@PathVariable String tripId) {
        Map<String, Boolean> result = new HashMap<>();
        favoriteRepository.findByIdStartingWithAndFavoritedTrue(tripId + ":")
                .forEach(f -> result.put(f.getId(), true));
        return ResponseEntity.ok(result);
    }

    // 즐겨찾기 토글
    @PostMapping("/{tripId}/{index}")
    public ResponseEntity<Map<String, Object>> toggleFavorite(
            @PathVariable String tripId,
            @PathVariable int index) {

        String id = tripId + ":" + index;
        Favorite fav = favoriteRepository.findById(id)
                .orElse(new Favorite(id, false));

        fav.setFavorited(!fav.isFavorited());
        favoriteRepository.save(fav);

        Map<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("favorited", fav.isFavorited());
        return ResponseEntity.ok(result);
    }
}
