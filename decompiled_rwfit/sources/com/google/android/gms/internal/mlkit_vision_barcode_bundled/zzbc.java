package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new f(3);
    private final zzbt zza;
    private final zzbv zzb;
    private final boolean zzc = true;
    private final boolean zzd;

    public zzbc(zzbt zzbtVar, zzbv zzbvVar, boolean z5) {
        this.zza = zzbtVar;
        this.zzb = zzbvVar;
        this.zzd = z5;
    }

    public final zzbt b() {
        return this.zza;
    }

    public final boolean h() {
        return this.zzd;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 1, this.zza, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 2, this.zzb, i3);
        boolean z5 = this.zzc;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 3, 4);
        parcel.writeInt(z5 ? 1 : 0);
        boolean z6 = this.zzd;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 4, 4);
        parcel.writeInt(z6 ? 1 : 0);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
