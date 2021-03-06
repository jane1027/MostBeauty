package com.m520it.mostbeautiful.fragment.paint;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.picasso.Target;

/**
 * Simple model class
 * One important requirement for DeckView to function
 * is that all items in the dataset *must be* uniquely
 * identifiable. No two items can be such
 * that `item1.equals(item2)` returns `true`.
 * See equals() implementation below.
 * `id` is generated using `DeckViewSampleActivity#generateuniqueKey()`
 * Implementing `Parcelable` serves only one purpose - to persist data
 * on configuration change.
 */
public class Datum implements Parcelable {

    public int id;
    public String headerTitle, link,iconLink,subTitle,authorName;
    public Target target;

    public Datum() {
        // Nothing
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Datum(Parcel in) {
        readFromParcel(in);
    }

    public void readFromParcel(Parcel in) {
        id = in.readInt();
        headerTitle = in.readString();
        subTitle = in.readString();
        authorName = in.readString();
        link = in.readString();
        iconLink = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(headerTitle);
        dest.writeString(subTitle);
        dest.writeString(authorName);
        dest.writeString(link);
        dest.writeString(iconLink);
    }

    public static final Creator<Datum> CREATOR = new Creator<Datum>() {
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        public Datum[] newArray(int size) {
            return new Datum[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        return ((Datum) o).id == this.id;
    }
}