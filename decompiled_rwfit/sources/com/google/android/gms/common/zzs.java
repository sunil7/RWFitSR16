package com.google.android.gms.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import ba.a;
import ba.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;
import javax.annotation.Nullable;
import n9.i;
import n9.j;
import q9.l;
import q9.z;

/* loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new d(15);
    private final String zza;

    @Nullable
    private final i zzb;
    private final boolean zzc;
    private final boolean zzd;

    public zzs(String str, IBinder iBinder, boolean z5, boolean z6) {
        this.zza = str;
        j jVar = null;
        if (iBinder != null) {
            try {
                int i3 = i.f16452c;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
                a o3 = (queryLocalInterface instanceof l ? (l) queryLocalInterface : new z(iBinder, "com.google.android.gms.common.internal.ICertData", 2)).o();
                byte[] bArr = o3 == null ? null : (byte[]) b.B(o3);
                if (bArr != null) {
                    jVar = new j(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            }
        }
        this.zzb = jVar;
        this.zzc = z5;
        this.zzd = z6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.zza;
        int i10 = u.i(parcel, 20293);
        u.e(parcel, 1, str);
        i iVar = this.zzb;
        if (iVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            iVar = null;
        }
        u.c(parcel, 2, iVar);
        boolean z5 = this.zzc;
        u.k(parcel, 3, 4);
        parcel.writeInt(z5 ? 1 : 0);
        boolean z6 = this.zzd;
        u.k(parcel, 4, 4);
        parcel.writeInt(z6 ? 1 : 0);
        u.j(parcel, i10);
    }
}
