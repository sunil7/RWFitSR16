package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.v4;
import com.autonavi.base.ae.gmap.maploader.Pools;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public final class Tile implements Parcelable {
    public static final b CREATOR = new b();
    private static final Pools.SynchronizedPool<Tile> M_POOL = new Pools.SynchronizedPool<>(18);

    @JBindingInclude
    private BitmapDescriptor bitmapDescriptor;

    @JBindingInclude
    public final byte[] data;

    @JBindingInclude
    public final int height;

    @JBindingInclude
    private final boolean isBitmap;

    @JBindingInclude
    private final int mVersionCode;

    @JBindingInclude
    public final int width;

    public Tile(int i3, int i10, int i11, byte[] bArr, boolean z5) {
        this.mVersionCode = i3;
        this.width = i10;
        this.height = i11;
        this.data = bArr;
        if (bArr != null) {
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(decodeByteArray);
                v4.a(decodeByteArray);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        this.isBitmap = z5;
    }

    public static Tile obtain(int i3, int i10, byte[] bArr) {
        Tile acquire = M_POOL.acquire();
        return acquire != null ? acquire : new Tile(i3, i10, bArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeByteArray(this.data);
        parcel.writeInt(this.isBitmap ? 1 : 0);
    }

    public Tile(int i3, int i10, byte[] bArr) {
        this(1, i3, i10, bArr, true);
    }

    public Tile(int i3, int i10, byte[] bArr, boolean z5) {
        this(1, i3, i10, bArr, z5);
    }
}
