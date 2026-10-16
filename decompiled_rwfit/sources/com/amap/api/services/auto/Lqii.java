package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Lqii implements Parcelable {
    public static final Parcelable.Creator<Lqii> CREATOR = new a();
    public String categoryBrandRecognitionResult;
    public String changeQueryTip;
    public String expandRangeTip;
    public String isCurrentCity;
    public String isUserCity;
    public String queryCateResult;
    public String suggestContent;
    public String targetViewCity;
    public String totalhits;
    public String viewRegion;

    public static class a implements Parcelable.Creator<Lqii> {
        @Override // android.os.Parcelable.Creator
        public Lqii createFromParcel(Parcel parcel) {
            return new Lqii(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Lqii[] newArray(int i3) {
            return new Lqii[i3];
        }
    }

    public Lqii() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.categoryBrandRecognitionResult);
        parcel.writeString(this.changeQueryTip);
        parcel.writeString(this.expandRangeTip);
        parcel.writeString(this.isCurrentCity);
        parcel.writeString(this.isUserCity);
        parcel.writeString(this.queryCateResult);
        parcel.writeString(this.suggestContent);
        parcel.writeString(this.targetViewCity);
        parcel.writeString(this.totalhits);
        parcel.writeString(this.viewRegion);
    }

    public Lqii(Parcel parcel) {
        this.categoryBrandRecognitionResult = parcel.readString();
        this.changeQueryTip = parcel.readString();
        this.expandRangeTip = parcel.readString();
        this.isCurrentCity = parcel.readString();
        this.isUserCity = parcel.readString();
        this.queryCateResult = parcel.readString();
        this.suggestContent = parcel.readString();
        this.targetViewCity = parcel.readString();
        this.totalhits = parcel.readString();
        this.viewRegion = parcel.readString();
    }
}
