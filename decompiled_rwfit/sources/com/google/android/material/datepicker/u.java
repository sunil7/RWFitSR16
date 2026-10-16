package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class u implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10470a;

    public /* synthetic */ u(int i3) {
        this.f10470a = i3;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f10470a) {
            case 0:
                return Month.b(parcel.readInt(), parcel.readInt());
            case 1:
                return new DateValidatorPointBackward(parcel.readLong());
            case 2:
                return new DateValidatorPointForward(parcel.readLong());
            case 3:
                RangeDateSelector rangeDateSelector = new RangeDateSelector();
                rangeDateSelector.selectedStartItem = (Long) parcel.readValue(Long.class.getClassLoader());
                rangeDateSelector.selectedEndItem = (Long) parcel.readValue(Long.class.getClassLoader());
                return rangeDateSelector;
            default:
                SingleDateSelector singleDateSelector = new SingleDateSelector();
                singleDateSelector.selectedItem = (Long) parcel.readValue(Long.class.getClassLoader());
                return singleDateSelector;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        switch (this.f10470a) {
            case 0:
                return new Month[i3];
            case 1:
                return new DateValidatorPointBackward[i3];
            case 2:
                return new DateValidatorPointForward[i3];
            case 3:
                return new RangeDateSelector[i3];
            default:
                return new SingleDateSelector[i3];
        }
    }
}
