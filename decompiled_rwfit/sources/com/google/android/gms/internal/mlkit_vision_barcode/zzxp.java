package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzxp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxp> CREATOR = new b(13);
    private final int zza;
    private final String[] zzb;

    public zzxp(String[] strArr, int i3) {
        this.zza = i3;
        this.zzb = strArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        int i11 = this.zza;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 1, 4);
        parcel.writeInt(i11);
        com.google.android.gms.internal.mlkit_vision_common.u.f(parcel, 2, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
