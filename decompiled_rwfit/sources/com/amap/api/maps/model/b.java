package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
class b implements Parcelable.Creator<Tile> {
    @Override // android.os.Parcelable.Creator
    public Tile createFromParcel(Parcel parcel) {
        return new Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.readInt() == 1);
    }

    @Override // android.os.Parcelable.Creator
    public Tile[] newArray(int i3) {
        return new Tile[i3];
    }
}
