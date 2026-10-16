package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.v4;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();

    /* renamed from: a, reason: collision with root package name */
    int f5725a;

    /* renamed from: b, reason: collision with root package name */
    int f5726b;

    @JBindingInclude
    protected Object mBitmap;

    @JBindingInclude
    private String mId;

    public BitmapDescriptor(Bitmap bitmap, String str) {
        this.f5725a = 0;
        this.f5726b = 0;
        if (bitmap != null) {
            try {
                this.f5725a = bitmap.getWidth();
                this.f5726b = bitmap.getHeight();
                if (bitmap.getConfig() == null) {
                    this.mBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                } else {
                    this.mBitmap = bitmap.copy(bitmap.getConfig(), true);
                }
            } catch (Throwable th2) {
                v4.a(th2);
                return;
            }
        }
        this.mId = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        BitmapDescriptor bitmapDescriptor;
        Object obj2;
        Object obj3 = this.mBitmap;
        if (obj3 == null || ((Bitmap) obj3).isRecycled() || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (BitmapDescriptor.class == obj.getClass() && (obj2 = (bitmapDescriptor = (BitmapDescriptor) obj).mBitmap) != null && !((Bitmap) obj2).isRecycled() && this.f5725a == bitmapDescriptor.getWidth() && this.f5726b == bitmapDescriptor.getHeight()) {
            try {
                return ((Bitmap) this.mBitmap).sameAs((Bitmap) bitmapDescriptor.mBitmap);
            } catch (Throwable th2) {
                v4.a(th2);
            }
        }
        return false;
    }

    public Bitmap getBitmap() {
        return (Bitmap) this.mBitmap;
    }

    public int getHeight() {
        return this.f5726b;
    }

    public String getId() {
        return this.mId;
    }

    public int getWidth() {
        return this.f5725a;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void recycle() {
        try {
            v4.a((Bitmap) this.mBitmap);
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mId);
        parcel.writeParcelable((Bitmap) this.mBitmap, i3);
        parcel.writeInt(this.f5725a);
        parcel.writeInt(this.f5726b);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitmapDescriptor m6clone() {
        try {
            Object obj = this.mBitmap;
            return new BitmapDescriptor(((Bitmap) obj).copy(((Bitmap) obj).getConfig(), true), this.f5725a, this.f5726b, this.mId);
        } catch (Throwable th2) {
            th2.printStackTrace();
            v4.a(th2);
            return null;
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i3, int i10, String str) {
        this.f5725a = i3;
        this.f5726b = i10;
        this.mBitmap = bitmap;
        this.mId = str;
    }
}
