package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzcc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcc> CREATOR = new f(19);
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final long zze;

    public zzcc(long j4, int i3, int i10, int i11, int i12) {
        this.zza = i3;
        this.zzb = i10;
        this.zzc = i11;
        this.zzd = i12;
        this.zze = j4;
    }

    public final int b() {
        return this.zzc;
    }

    public final int h() {
        return this.zza;
    }

    public final int i() {
        return this.zzd;
    }

    public final int j() {
        return this.zzb;
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
        long j4 = this.zze;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 5, 8);
        parcel.writeLong(j4);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
