package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.slider.RangeSlider;

/* loaded from: classes.dex */
public final class j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new RangeSlider.RangeSliderState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        return new RangeSlider.RangeSliderState[i3];
    }
}
