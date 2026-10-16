package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzas> CREATOR = new f(10);
    private final double zza;
    private final double zzb;

    public zzas(double d5, double d8) {
        this.zza = d5;
        this.zzb = d8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        double d5 = this.zza;
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 1, 8);
        parcel.writeDouble(d5);
        double d8 = this.zzb;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 2, 8);
        parcel.writeDouble(d8);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
