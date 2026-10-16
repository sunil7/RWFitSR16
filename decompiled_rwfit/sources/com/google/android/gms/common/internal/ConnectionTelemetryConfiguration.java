package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import q9.o;

/* loaded from: classes.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new o(3);
    private final RootTelemetryConfiguration zza;
    private final boolean zzb;
    private final boolean zzc;
    private final int[] zzd;
    private final int zze;
    private final int[] zzf;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z5, boolean z6, int[] iArr, int i3, int[] iArr2) {
        this.zza = rootTelemetryConfiguration;
        this.zzb = z5;
        this.zzc = z6;
        this.zzd = iArr;
        this.zze = i3;
        this.zzf = iArr2;
    }

    public final int b() {
        return this.zze;
    }

    public final int[] h() {
        return this.zzd;
    }

    public final int[] i() {
        return this.zzf;
    }

    public final boolean j() {
        return this.zzb;
    }

    public final boolean k() {
        return this.zzc;
    }

    public final RootTelemetryConfiguration l() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.d(parcel, 1, this.zza, i3);
        boolean z5 = this.zzb;
        u.k(parcel, 2, 4);
        parcel.writeInt(z5 ? 1 : 0);
        boolean z6 = this.zzc;
        u.k(parcel, 3, 4);
        parcel.writeInt(z6 ? 1 : 0);
        int[] iArr = this.zzd;
        if (iArr != null) {
            int i11 = u.i(parcel, 4);
            parcel.writeIntArray(iArr);
            u.j(parcel, i11);
        }
        int i12 = this.zze;
        u.k(parcel, 5, 4);
        parcel.writeInt(i12);
        int[] iArr2 = this.zzf;
        if (iArr2 != null) {
            int i13 = u.i(parcel, 6);
            parcel.writeIntArray(iArr2);
            u.j(parcel, i13);
        }
        u.j(parcel, i10);
    }
}
