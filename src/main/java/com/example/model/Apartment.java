package com.example.model;

public class Apartment {
    private String id;
    private Integer area;
    private String status;
    private Integer floor;
    private String type;
    private String description;
    private Integer price;
    private String startDay;
    private String endDay;

    public Apartment() {
    }

    public Apartment(Integer area, String status, Integer floor, String type, String description, Integer price, String startDay, String endDay) {
        this.area = area;
        this.status = status;
        this.floor = floor;
        this.type = type;
        this.description = description;
        this.price = price;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public Apartment(String id, Integer area, String status, Integer floor, String type, String description, Integer price, String startDay, String endDay) {
        this.id = id;
        this.area = area;
        this.status = status;
        this.floor = floor;
        this.type = type;
        this.description = description;
        this.price = price;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }
}
