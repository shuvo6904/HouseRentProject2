package com.example.houserentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView rentedAmount ,homeLocation;
    ImageView homeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        rentedAmount = (TextView) findViewById(R.id.rentedAmountId);
        homeLocation = (TextView) findViewById(R.id.homeLocationId);
        homeImage = (ImageView) findViewById(R.id.ivImage2Id);

        Bundle mBundle = getIntent().getExtras();

        if (mBundle != null){
            rentedAmount.setText(mBundle.getString("RentedAmount"));
            homeLocation.setText(mBundle.getString("Location"));
            homeImage.setImageResource(mBundle.getInt("Image"));
        }
    }
}