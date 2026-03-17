package com.travel.entity;

import jakarta.persistence.*;

@Entity
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tripId;
    private String name;
    private String nameKr;
    private String area;
    private String checkIn;
    private String checkOut;
    private int nights;
    private String bookingSite;
    private String bookingAccount;
    private String bookingRef;
    private String pinCode;
    private String mapUrl;
    private String memo;

    @Column(name = "sort_order")
    private int sortOrder;

    public Accommodation() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTripId() { return tripId; }
    public void setTripId(String tripId) { this.tripId = tripId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getNameKr() { return nameKr; }
    public void setNameKr(String nameKr) { this.nameKr = nameKr; }
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
    public String getCheckIn() { return checkIn; }
    public void setCheckIn(String checkIn) { this.checkIn = checkIn; }
    public String getCheckOut() { return checkOut; }
    public void setCheckOut(String checkOut) { this.checkOut = checkOut; }
    public int getNights() { return nights; }
    public void setNights(int nights) { this.nights = nights; }
    public String getBookingSite() { return bookingSite; }
    public void setBookingSite(String bookingSite) { this.bookingSite = bookingSite; }
    public String getBookingAccount() { return bookingAccount; }
    public void setBookingAccount(String bookingAccount) { this.bookingAccount = bookingAccount; }
    public String getBookingRef() { return bookingRef; }
    public void setBookingRef(String bookingRef) { this.bookingRef = bookingRef; }
    public String getPinCode() { return pinCode; }
    public void setPinCode(String pinCode) { this.pinCode = pinCode; }
    public String getMapUrl() { return mapUrl; }
    public void setMapUrl(String mapUrl) { this.mapUrl = mapUrl; }
    public String getMemo() { return memo; }
    public void setMemo(String memo) { this.memo = memo; }
    public int getSortOrder() { return sortOrder; }
    public void setSortOrder(int sortOrder) { this.sortOrder = sortOrder; }
}
