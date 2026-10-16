package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzxq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxq> CREATOR = new b(17);
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;
    private final int zzf;
    private final boolean zzg;
    private final String zzh;

    public zzxq(int i3, int i10, int i11, int i12, int i13, int i14, boolean z5, String str) {
        this.zza = i3;
        this.zzb = i10;
        this.zzc = i11;
        this.zzd = i12;
        this.zze = i13;
        this.zzf = i14;
        this.zzg = z5;
        this.zzh = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        int i11 = this.zza;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 1, 4);
        parcel.writeInt(i11);
        int i12 = this.zzb;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 2, 4);
        parcel.writeInt(i12);
        int i13 = this.zzc;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 3, 4);
        parcel.writeInt(i13);
        int i14 = this.zzd;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 4, 4);
        parcel.writeInt(i14);
        int i15 = this.zze;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 5, 4);
        parcel.writeInt(i15);
        int i16 = this.zzf;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 6, 4);
        parcel.writeInt(i16);
        boolean z5 = this.zzg;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 7, 4);
        parcel.writeInt(z5 ? 1 : 0);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 8, this.zzh);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
