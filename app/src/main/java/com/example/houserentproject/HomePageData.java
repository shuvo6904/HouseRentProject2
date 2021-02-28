package com.example.houserentproject;

public class HomePageData {
    private String rentAmount;
    private String location;
    private int image;

    public HomePageData(String rentAmount, String location, int image) {
        this.rentAmount = rentAmount;
        this.location = location;

        this.image = image;
    }

    public String getRentAmount() {
        return rentAmount;
    }

    public String getLocation() {
        return location;
    }

    public int getImage() {
        return image;
    }
}
