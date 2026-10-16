package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import androidx.customview.view.a;
import m0.k;

/* loaded from: classes.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new a(2);
    public final k extendableStates;

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.extendableStates = new k();
    }

    public final String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.extendableStates + "}";
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        int i10 = this.extendableStates.f15919c;
        parcel.writeInt(i10);
        String[] strArr = new String[i10];
        Bundle[] bundleArr = new Bundle[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            strArr[i11] = (String) this.extendableStates.h(i11);
            bundleArr[i11] = (Bundle) this.extendableStates.l(i11);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public ExtendableSavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.extendableStates = new k(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            this.extendableStates.put(strArr[i3], bundleArr[i3]);
        }
    }
}
