package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import ba.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;

/* loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new d(13);
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;
    private final Context zzd;
    private final boolean zze;
    private final boolean zzf;

    public zzo(String str, boolean z5, boolean z6, IBinder iBinder, boolean z8, boolean z10) {
        this.zza = str;
        this.zzb = z5;
        this.zzc = z6;
        this.zzd = (Context) b.B(b.A(iBinder));
        this.zze = z8;
        this.zzf = z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.zza;
        int i10 = u.i(parcel, 20293);
        u.e(parcel, 1, str);
        boolean z5 = this.zzb;
        u.k(parcel, 2, 4);
        parcel.writeInt(z5 ? 1 : 0);
        boolean z6 = this.zzc;
        u.k(parcel, 3, 4);
        parcel.writeInt(z6 ? 1 : 0);
        u.c(parcel, 4, new b(this.zzd));
        boolean z8 = this.zze;
        u.k(parcel, 5, 4);
        parcel.writeInt(z8 ? 1 : 0);
        boolean z10 = this.zzf;
        u.k(parcel, 6, 4);
        parcel.writeInt(z10 ? 1 : 0);
        u.j(parcel, i10);
    }
}
