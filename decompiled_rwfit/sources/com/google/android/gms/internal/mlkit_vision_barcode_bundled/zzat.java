package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzat> CREATOR = new f(14);
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    public zzat(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.zza;
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 1, str);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 2, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 3, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 4, this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 5, this.zze);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 6, this.zzf);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 7, this.zzg);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
