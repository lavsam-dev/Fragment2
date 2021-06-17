package com.neocaptainnemo.cityapp.ui.details;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.neocaptainnemo.cityapp.R;
import com.neocaptainnemo.cityapp.domain.City;
import com.neocaptainnemo.cityapp.ui.Observer;
import com.neocaptainnemo.cityapp.ui.Publisher;
import com.neocaptainnemo.cityapp.ui.PublisherHolder;

public class CityDetailsFragment extends Fragment implements Observer {

    private static final String ARG_CITY = "ARG_CITY";

    public static CityDetailsFragment newInstance(City city) {
        CityDetailsFragment fragment = new CityDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_CITY, city);
        fragment.setArguments(bundle);
        return fragment;
    }

    private Publisher publisher;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof PublisherHolder) {
            publisher = ((PublisherHolder) context).getPublisher();

            publisher.subscribe(this);
        }
    }

    @Override
    public void onDetach() {
        if (publisher != null) {
            publisher.unsubscribe(this);
        }
        super.onDetach();
    }

    public CityDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_city_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView cityName = view.findViewById(R.id.city_name);
        ImageView cityCoat = view.findViewById(R.id.city_coat);

        City city = getArguments().getParcelable(ARG_CITY);

        cityName.setText(city.getName());
        cityCoat.setImageResource(city.getCoat());
    }

    @Override
    public void updateCity(City city) {
        Toast.makeText(requireContext(), city.getName(), Toast.LENGTH_LONG).show();
    }
}