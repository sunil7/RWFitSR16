package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new b(2);
    public String zza;
    public String zzb;
    public String zzc;
    public String zzd;
    public String zze;
    public String zzf;
    public String zzg;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 2, this.zza);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 3, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 4, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 5, this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 6, this.zze);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 7, this.zzf);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 8, this.zzg);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
