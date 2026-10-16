package com.github.mikephil.charting.data;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import ha.d;
import o7.e;

/* loaded from: classes.dex */
public class Entry extends e implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new d(16);

    /* renamed from: x, reason: collision with root package name */
    private float f8829x;

    public Entry() {
        this.f8829x = 0.0f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public float j() {
        return this.f8829x;
    }

    public void k(float f2) {
        this.f8829x = f2;
    }

    public final String toString() {
        return "Entry, x: " + this.f8829x + " y: " + d();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloat(this.f8829x);
        parcel.writeFloat(d());
        if (a() == null) {
            parcel.writeInt(0);
        } else {
            if (!(a() instanceof Parcelable)) {
                throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
            }
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) a(), i3);
        }
    }

    public Entry(float f2, float f10) {
        super(f10);
        this.f8829x = f2;
    }

    public Entry(Parcel parcel) {
        this.f8829x = 0.0f;
        this.f8829x = parcel.readFloat();
        i(parcel.readFloat());
        if (parcel.readInt() == 1) {
            h(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }
}
