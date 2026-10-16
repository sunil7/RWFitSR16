package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new h();
    public static final String NUMBER_FORMAT = "%d";
    public static final String ZERO_LEADING_NUMBER_FORMAT = "%02d";

    /* renamed from: a, reason: collision with root package name */
    public final int f10971a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10972b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10973c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10974d;
    private final f hourInputValidator;
    private final f minuteInputValidator;

    public TimeModel(Parcel parcel) {
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        this.f10972b = readInt;
        this.f10973c = readInt2;
        this.f10974d = readInt3;
        this.f10971a = readInt4;
        this.minuteInputValidator = new f(59);
        this.hourInputValidator = new f(readInt4 == 1 ? 24 : 12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f10972b == timeModel.f10972b && this.f10973c == timeModel.f10973c && this.f10971a == timeModel.f10971a && this.f10974d == timeModel.f10974d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10971a), Integer.valueOf(this.f10972b), Integer.valueOf(this.f10973c), Integer.valueOf(this.f10974d)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f10972b);
        parcel.writeInt(this.f10973c);
        parcel.writeInt(this.f10974d);
        parcel.writeInt(this.f10971a);
    }
}
