package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzbe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbe> CREATOR = new f(4);
    private final zzbr zza;

    public zzbe(zzbr zzbrVar) {
        this.zza = zzbrVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        zzbr zzbrVar = this.zza;
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 1, zzbrVar, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
