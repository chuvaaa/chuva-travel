package com.travel.entity;

import jakarta.persistence.*;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tripId;
    private String date;          // 2026-04-17
    private String time;          // 17:00 (선택)
    private String title;
    private String subtitle;      // 간단 설명
    private String icon;          // 이모지
    private double sortOrder;     // 중간 삽입용 소수점 허용

    public Schedule() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTripId() { return tripId; }
    public void setTripId(String tripId) { this.tripId = tripId; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getSubtitle() { return subtitle; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }
    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
    public double getSortOrder() { return sortOrder; }
    public void setSortOrder(double sortOrder) { this.sortOrder = sortOrder; }
}
