package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new b(12);
    public String zza;
    public String zzb;
    public String zzc;
    public String zzd;
    public String zze;
    public zzj zzf;
    public zzj zzg;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 2, this.zza);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 3, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 4, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 5, this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 6, this.zze);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 7, this.zzf, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 8, this.zzg, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
