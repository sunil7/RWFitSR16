package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzay extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzay> CREATOR = new f(1);
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final byte[] zzd;
    private final Point[] zze;
    private final int zzf;
    private final zzar zzg;
    private final zzau zzh;
    private final zzav zzi;
    private final zzax zzj;
    private final zzaw zzk;
    private final zzas zzl;
    private final zzao zzm;
    private final zzap zzn;
    private final zzaq zzo;

    public zzay(int i3, String str, String str2, byte[] bArr, Point[] pointArr, int i10, zzar zzarVar, zzau zzauVar, zzav zzavVar, zzax zzaxVar, zzaw zzawVar, zzas zzasVar, zzao zzaoVar, zzap zzapVar, zzaq zzaqVar) {
        this.zza = i3;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i10;
        this.zzg = zzarVar;
        this.zzh = zzauVar;
        this.zzi = zzavVar;
        this.zzj = zzaxVar;
        this.zzk = zzawVar;
        this.zzl = zzasVar;
        this.zzm = zzaoVar;
        this.zzn = zzapVar;
        this.zzo = zzaqVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = this.zza;
        int i11 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 1, 4);
        parcel.writeInt(i10);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 2, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 3, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.u.b(parcel, 4, this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 5, this.zze, i3);
        int i12 = this.zzf;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 6, 4);
        parcel.writeInt(i12);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 7, this.zzg, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 8, this.zzh, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 9, this.zzi, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 10, this.zzj, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 11, this.zzk, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 12, this.zzl, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 13, this.zzm, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 14, this.zzn, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 15, this.zzo, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i11);
    }
}
