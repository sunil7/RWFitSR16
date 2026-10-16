package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ArrayList readArrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
        int readInt = parcel.readInt();
        g gVar = readInt == 2 ? CompositeDateValidator.ALL_OPERATOR : readInt == 1 ? CompositeDateValidator.ANY_OPERATOR : CompositeDateValidator.ALL_OPERATOR;
        readArrayList.getClass();
        return new CompositeDateValidator(readArrayList, gVar);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        return new CompositeDateValidator[i3];
    }
}
