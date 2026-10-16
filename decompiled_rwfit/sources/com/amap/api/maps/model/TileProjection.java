package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TileProjection implements Parcelable {
    public static final TileProjection CREATOR = new TileProjection(0, 0, 0, 0, 0, 0);
    public final int maxX;
    public final int maxY;
    public final int minX;
    public final int minY;
    public final int offsetX;
    public final int offsetY;

    public TileProjection(int i3, int i10, int i11, int i12, int i13, int i14) {
        this.offsetX = i3;
        this.offsetY = i10;
        this.minX = i11;
        this.maxX = i12;
        this.minY = i13;
        this.maxY = i14;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.offsetX);
        parcel.writeInt(this.offsetY);
        parcel.writeInt(this.minX);
        parcel.writeInt(this.maxX);
        parcel.writeInt(this.minY);
        parcel.writeInt(this.maxY);
    }
}
