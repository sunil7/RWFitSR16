package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.slider.BaseSlider;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        BaseSlider.SliderState sliderState = new BaseSlider.SliderState(parcel);
        sliderState.f10752a = parcel.readFloat();
        sliderState.f10753b = parcel.readFloat();
        ArrayList arrayList = new ArrayList();
        sliderState.f10754c = arrayList;
        parcel.readList(arrayList, Float.class.getClassLoader());
        sliderState.f10755d = parcel.readFloat();
        sliderState.e = parcel.createBooleanArray()[0];
        return sliderState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        return new BaseSlider.SliderState[i3];
    }
}
