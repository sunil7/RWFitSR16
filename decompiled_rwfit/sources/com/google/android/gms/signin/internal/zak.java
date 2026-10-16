package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;

/* loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new d(0);

    /* renamed from: a, reason: collision with root package name */
    public final int f10163a;
    private final ConnectionResult zab;
    private final zav zac;

    public zak(int i3, ConnectionResult connectionResult, zav zavVar) {
        this.f10163a = i3;
        this.zab = connectionResult;
        this.zac = zavVar;
    }

    public final ConnectionResult b() {
        return this.zab;
    }

    public final zav h() {
        return this.zac;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f10163a);
        u.d(parcel, 2, this.zab, i3);
        u.d(parcel, 3, this.zac, i3);
        u.j(parcel, i10);
    }
}
