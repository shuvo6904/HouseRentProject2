package com.example.houserentproject;

public class HomePageData {
    private String rentAmount;
    private String location;
    private String image;
    private String buildingName;
    private String floorNumber;
    private String detailsAddress;


    public HomePageData() {

    }

    public HomePageData(String rentAmount, String location, String image, String buildingName, String floorNumber, String detailsAddress) {
        this.rentAmount = rentAmount;
        this.location = location;
        this.image = image;
        this.buildingName = buildingName;
        this.floorNumber = floorNumber;
        this.detailsAddress = detailsAddress;
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

    public String getBuildingName(){return buildingName;}

    public String getFloorNumber() {
        return floorNumber;
    }

    public String getDetailsAddress() {
        return detailsAddress;
    }
}
