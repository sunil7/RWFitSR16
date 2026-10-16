package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new b(14);
    public zzp zza;
    public String zzb;
    public String zzc;
    public zzq[] zzd;
    public zzn[] zze;
    public String[] zzf;
    public zzi[] zzg;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 2, this.zza, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 3, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 4, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 5, this.zzd, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 6, this.zze, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.f(parcel, 7, this.zzf);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 8, this.zzg, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
