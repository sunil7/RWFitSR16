package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzau extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzau> CREATOR = new f(15);
    private final int zza;
    private final String zzb;

    public zzau(int i3, String str) {
        this.zza = i3;
        this.zzb = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = this.zza;
        int i11 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 1, 4);
        parcel.writeInt(i10);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 2, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i11);
    }
}
