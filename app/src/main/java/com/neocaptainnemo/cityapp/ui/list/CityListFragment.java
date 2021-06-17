package com.neocaptainnemo.cityapp.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.neocaptainnemo.cityapp.R;
import com.neocaptainnemo.cityapp.domain.City;
import com.neocaptainnemo.cityapp.domain.CityRepository;
import com.neocaptainnemo.cityapp.domain.CityRepositoryImpl;
import com.neocaptainnemo.cityapp.ui.Publisher;
import com.neocaptainnemo.cityapp.ui.PublisherHolder;

import java.util.List;

public class CityListFragment extends Fragment {

    public interface OnCityClicked {
        void onCityClicked(City city);
    }

    private CityRepository cityRepository;

    private OnCityClicked onCityClicked;

    private Publisher publisher;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnCityClicked) {
            onCityClicked = (OnCityClicked) context;
        }

        if (context instanceof PublisherHolder) {
            publisher = ((PublisherHolder) context).getPublisher();
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();

        onCityClicked = null;
        publisher = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cityRepository = new CityRepositoryImpl();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_city_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout citiesList = view.findViewById(R.id.city_list_container);

        List<City> cities = cityRepository.getCities();

        for (City city: cities) {

            View itemView = LayoutInflater.from(requireContext()).inflate(R.layout.item_city, citiesList, false);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onCityClicked != null) {
                        onCityClicked.onCityClicked(city);
                    }

                    if (publisher != null) {
                        publisher.notify(city);
                    }
                }
            });

            TextView cityName = itemView.findViewById(R.id.city_name);
            cityName.setText(city.getName());

            citiesList.addView(itemView);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
