package com.neocaptainnemo.cityapp.ui;

import com.neocaptainnemo.cityapp.domain.City;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private final List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notify(City city) {
        for (Observer observer: observers) {
            observer.updateCity(city);
        }
    }
}
