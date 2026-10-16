package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;

/* loaded from: classes.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new d(29);
    private final int zza;
    private final boolean zzb;
    private final boolean zzc;
    private final int zzd;
    private final int zze;

    public RootTelemetryConfiguration(int i3, boolean z5, boolean z6, int i10, int i11) {
        this.zza = i3;
        this.zzb = z5;
        this.zzc = z6;
        this.zzd = i10;
        this.zze = i11;
    }

    public final int b() {
        return this.zzd;
    }

    public final int getVersion() {
        return this.zza;
    }

    public final int h() {
        return this.zze;
    }

    public final boolean i() {
        return this.zzb;
    }

    public final boolean j() {
        return this.zzc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        int i11 = this.zza;
        u.k(parcel, 1, 4);
        parcel.writeInt(i11);
        boolean z5 = this.zzb;
        u.k(parcel, 2, 4);
        parcel.writeInt(z5 ? 1 : 0);
        boolean z6 = this.zzc;
        u.k(parcel, 3, 4);
        parcel.writeInt(z6 ? 1 : 0);
        int i12 = this.zzd;
        u.k(parcel, 4, 4);
        parcel.writeInt(i12);
        int i13 = this.zze;
        u.k(parcel, 5, 4);
        parcel.writeInt(i13);
        u.j(parcel, i10);
    }
}
