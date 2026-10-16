package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PoiItemExtension implements Parcelable {
    public static final Parcelable.Creator<PoiItemExtension> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6102a;

    /* renamed from: b, reason: collision with root package name */
    private String f6103b;

    public static class a implements Parcelable.Creator<PoiItemExtension> {
        @Override // android.os.Parcelable.Creator
        public PoiItemExtension createFromParcel(Parcel parcel) {
            return new PoiItemExtension(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PoiItemExtension[] newArray(int i3) {
            return new PoiItemExtension[i3];
        }
    }

    public PoiItemExtension(String str, String str2) {
        this.f6102a = str;
        this.f6103b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getOpentime() {
        return this.f6102a;
    }

    public String getmRating() {
        return this.f6103b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6102a);
        parcel.writeString(this.f6103b);
    }

    public PoiItemExtension(Parcel parcel) {
        this.f6102a = parcel.readString();
        this.f6103b = parcel.readString();
    }
}
