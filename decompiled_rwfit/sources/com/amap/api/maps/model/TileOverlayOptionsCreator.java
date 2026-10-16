package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TileOverlayOptionsCreator implements Parcelable.Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TileOverlayOptions createFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        TileProvider tileProvider = (TileProvider) parcel.readValue(TileProvider.class.getClassLoader());
        boolean z5 = parcel.readByte() != 0;
        float readFloat = parcel.readFloat();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        String readString = parcel.readString();
        boolean z6 = parcel.readByte() != 0;
        boolean z8 = parcel.readByte() != 0;
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions(readInt, z5, readFloat);
        if (tileProvider != null) {
            tileOverlayOptions.tileProvider(tileProvider);
        }
        tileOverlayOptions.memCacheSize(readInt2);
        tileOverlayOptions.diskCacheSize(readInt3);
        tileOverlayOptions.diskCacheDir(readString);
        tileOverlayOptions.memoryCacheEnabled(z6);
        tileOverlayOptions.diskCacheEnabled(z8);
        return tileOverlayOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TileOverlayOptions[] newArray(int i3) {
        return new TileOverlayOptions[i3];
    }
}
