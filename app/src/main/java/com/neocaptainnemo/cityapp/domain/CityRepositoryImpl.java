package com.neocaptainnemo.cityapp.domain;

import com.neocaptainnemo.cityapp.R;

import java.util.ArrayList;
import java.util.List;

public class CityRepositoryImpl implements CityRepository {

    @Override
    public List<City> getCities() {
        ArrayList<City> result = new ArrayList<>();

        result.add(new City(R.string.msc, R.drawable.msc));
        result.add(new City(R.string.nsk, R.drawable.nsk));
        result.add(new City(R.string.spb, R.drawable.spb));
        result.add(new City(R.string.ebrg, R.drawable.ebrg));
        result.add(new City(R.string.sam, R.drawable.sam));
        return result;
    }
}
