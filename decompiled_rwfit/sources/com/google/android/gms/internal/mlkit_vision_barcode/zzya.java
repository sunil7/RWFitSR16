package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzya extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzya> CREATOR = new b(27);
    private final String zza;
    private final String zzb;
    private final int zzc;

    public zzya(String str, String str2, int i3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.zza;
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 1, str);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 2, this.zzb);
        int i11 = this.zzc;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 3, 4);
        parcel.writeInt(i11);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
