package com.travel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Favorite {

    @Id
    private String id;  // "tripId:restaurantIndex" (e.g. "202604:3")

    private boolean favorited;

    public Favorite() {}

    public Favorite(String id, boolean favorited) {
        this.id = id;
        this.favorited = favorited;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public boolean isFavorited() { return favorited; }
    public void setFavorited(boolean favorited) { this.favorited = favorited; }
}
