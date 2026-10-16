package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new b(1);
    public double zza;
    public double zzb;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        double d5 = this.zza;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 2, 8);
        parcel.writeDouble(d5);
        double d8 = this.zzb;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 3, 8);
        parcel.writeDouble(d8);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
