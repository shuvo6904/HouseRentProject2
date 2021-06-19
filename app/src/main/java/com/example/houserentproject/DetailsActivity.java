package com.example.houserentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    TextView rentedAmount , homeLocation, buildingName, floorNumber, detailsAddress , genderValue, rentTypeValue, rentDate, postedBy;
    ImageView homeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        rentedAmount = findViewById(R.id.rentedAmountId);
        homeLocation = (TextView) findViewById(R.id.homeLocationId);
        homeImage = (ImageView) findViewById(R.id.ivImage2Id);


        buildingName = (TextView) findViewById(R.id.buildingNameId);
        floorNumber = (TextView) findViewById(R.id.floorNumberId);
        detailsAddress = (TextView) findViewById(R.id.detailsAddressId);
        genderValue = (TextView) findViewById(R.id.genderValueId);
        rentTypeValue = (TextView) findViewById(R.id.rentTypeValueId);
        rentDate = (TextView) findViewById(R.id.datePickerId);
        postedBy = (TextView) findViewById(R.id.postedById);

        //Bundle mBundle = getIntent().getExtras();

        HomePageData model = (HomePageData) getIntent().getSerializableExtra("model");

        if (model != null){

            rentedAmount.setText("Rented Amount : " + model.getRentAmount());
            homeLocation.setText("Location : "+ model.getLocation());
            //homeImage.setImageResource(mBundle.getInt("Image"));

            buildingName.setText("Building Name : " + model.getBuildingName());
            floorNumber.setText("Floor Number : " + model.getFloorNumber());
            detailsAddress.setText("Details Address : " + model.getDetailsAddress());
            genderValue.setText("Gender Type : " + model.getValueOfGender());
            rentTypeValue.setText("Rent Type : " + model.getValueOfRentType());
            rentDate.setText("Rent Date : " + model.getDatePick());
            postedBy.setText("Posted By : " + model.getNameOfUser() + "\n\n" + "Phone Number : " + model.getPhnNumOfUser());

            Glide.with(this)
                    .load(model.getImage())
                    .into(homeImage);

//            rentedAmount.setText("Rented Amount : " + mBundle.getString("RentedAmount"));
//            homeLocation.setText("Location : "+ mBundle.getString("Location"));
//            //homeImage.setImageResource(mBundle.getInt("Image"));
//
//            buildingName.setText("Building Name : " + mBundle.getString("BuildingName"));
//            floorNumber.setText("Floor Number : " + mBundle.getString("FloorNumber"));
//            detailsAddress.setText("Details Address : " + mBundle.getString("DetailsAddress"));
//            genderValue.setText("Gender Type : " + mBundle.getString("GenderType"));
//            rentTypeValue.setText("Rent Type : " + mBundle.getString("RentType"));
//            rentDate.setText("Rent Date : " + mBundle.getString("DatePicker"));
//            postedBy.setText("Posted By : " + mBundle.getString("NameOfUser") + "\n\n" + "Phone Number : " + mBundle.getString("UserPhnNumber"));
//
//            Glide.with(this)
//                    .load(mBundle.getString("Image"))
//                    .into(homeImage);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}