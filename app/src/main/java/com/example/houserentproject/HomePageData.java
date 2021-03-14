package com.example.houserentproject;

public class HomePageData {
    private String rentAmount;
    private String location;
    private String image;

    public HomePageData(String rentAmount, String location, String image) {
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

    public String getImage() {
        return image;
    }
}
