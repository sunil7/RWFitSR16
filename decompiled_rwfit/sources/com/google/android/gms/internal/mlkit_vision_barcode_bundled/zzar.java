package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzar> CREATOR = new f(9);
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    public zzar(int i3, String str, String str2, String str3) {
        this.zza = i3;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = this.zza;
        int i11 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 1, 4);
        parcel.writeInt(i10);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 2, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 3, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 4, this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i11);
    }
}
