package com.neocaptainnemo.cityapp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.neocaptainnemo.cityapp.R;
import com.neocaptainnemo.cityapp.domain.City;
import com.neocaptainnemo.cityapp.ui.details.CityDetailsActivity;
import com.neocaptainnemo.cityapp.ui.details.CityDetailsFragment;
import com.neocaptainnemo.cityapp.ui.list.CityListFragment;

public class MainActivity extends AppCompatActivity implements CityListFragment.OnCityClicked, PublisherHolder {

    private final Publisher publisher = new Publisher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onCityClicked(City city) {

        boolean isLandscape = getResources().getBoolean(R.bool.isLandscape);

        if (isLandscape) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.cities_details_fragment, CityDetailsFragment.newInstance(city))
                    .commit();

        } else {
            Intent intent = new Intent(this, CityDetailsActivity.class);
            intent.putExtra(CityDetailsActivity.ARG_CITY, city);
            startActivity(intent);
        }
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }
}