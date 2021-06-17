package com.neocaptainnemo.cityapp.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class City implements Parcelable {

    @StringRes
    private final int name;

    @DrawableRes
    private final int coat;

    public City(int name, int coat) {
        this.name = name;
        this.coat = coat;
    }

    protected City(Parcel in) {
        name = in.readInt();
        coat = in.readInt();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public int getName() {
        return name;
    }

    public int getCoat() {
        return coat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(name);
        dest.writeInt(coat);
    }
}
