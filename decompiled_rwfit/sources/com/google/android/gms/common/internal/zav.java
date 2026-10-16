package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;
import q9.c;
import q9.n;
import q9.y;

/* loaded from: classes.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new d(27);

    /* renamed from: a, reason: collision with root package name */
    public final int f9135a;

    /* renamed from: b, reason: collision with root package name */
    public final IBinder f9136b;
    private final ConnectionResult zac;
    private final boolean zad;
    private final boolean zae;

    public zav(int i3, IBinder iBinder, ConnectionResult connectionResult, boolean z5, boolean z6) {
        this.f9135a = i3;
        this.f9136b = iBinder;
        this.zac = connectionResult;
        this.zad = z5;
        this.zae = z6;
    }

    public final ConnectionResult b() {
        return this.zac;
    }

    public final boolean equals(Object obj) {
        Object yVar;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zavVar = (zav) obj;
        if (!this.zac.equals(zavVar.zac)) {
            return false;
        }
        Object obj2 = null;
        IBinder iBinder = this.f9136b;
        if (iBinder == null) {
            yVar = null;
        } else {
            int i3 = q9.a.f17807b;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            yVar = queryLocalInterface instanceof c ? (c) queryLocalInterface : new y(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 2);
        }
        IBinder iBinder2 = zavVar.f9136b;
        if (iBinder2 != null) {
            int i10 = q9.a.f17807b;
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            obj2 = queryLocalInterface2 instanceof c ? (c) queryLocalInterface2 : new y(iBinder2, "com.google.android.gms.common.internal.IAccountAccessor", 2);
        }
        return n.h(yVar, obj2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9135a);
        u.c(parcel, 2, this.f9136b);
        u.d(parcel, 3, this.zac, i3);
        boolean z5 = this.zad;
        u.k(parcel, 4, 4);
        parcel.writeInt(z5 ? 1 : 0);
        boolean z6 = this.zae;
        u.k(parcel, 5, 4);
        parcel.writeInt(z6 ? 1 : 0);
        u.j(parcel, i10);
    }
}
