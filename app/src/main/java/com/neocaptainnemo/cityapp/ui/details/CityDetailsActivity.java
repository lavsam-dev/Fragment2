package com.neocaptainnemo.cityapp.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.neocaptainnemo.cityapp.R;
import com.neocaptainnemo.cityapp.domain.City;

public class CityDetailsActivity extends AppCompatActivity {

    public static final String ARG_CITY = "ARG_CITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details);

        if (savedInstanceState == null) {

            City city = getIntent().getParcelableExtra(ARG_CITY);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, CityDetailsFragment.newInstance(city))
                    .commit();

        }
    }
}