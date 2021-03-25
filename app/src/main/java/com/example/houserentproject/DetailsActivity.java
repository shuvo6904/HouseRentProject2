package com.example.houserentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    TextView rentedAmount , homeLocation, buildingName, floorNumber, detailsAddress;
    ImageView homeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        rentedAmount = (TextView) findViewById(R.id.rentedAmountId);
        homeLocation = (TextView) findViewById(R.id.homeLocationId);
        homeImage = (ImageView) findViewById(R.id.ivImage2Id);


        buildingName = (TextView) findViewById(R.id.buildingNameId);
        floorNumber = (TextView) findViewById(R.id.floorNumberId);
        detailsAddress = (TextView) findViewById(R.id.detailsAddressId);


        Bundle mBundle = getIntent().getExtras();

        if (mBundle != null){
            rentedAmount.setText("Rented Amount : " + mBundle.getString("RentedAmount"));
            homeLocation.setText("Location : "+ mBundle.getString("Location"));
            //homeImage.setImageResource(mBundle.getInt("Image"));

            buildingName.setText("Building Name : " + mBundle.getString("BuildingName"));
            floorNumber.setText("Floor Number : " + mBundle.getString("FloorNumber"));
            detailsAddress.setText("Details Address : " + mBundle.getString("DetailsAddress"));

            Glide.with(this)
                    .load(mBundle.getString("Image"))
                    .into(homeImage);
        }
    }
}