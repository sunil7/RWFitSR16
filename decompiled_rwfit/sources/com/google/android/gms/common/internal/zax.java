package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;

/* loaded from: classes.dex */
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new d(28);

    /* renamed from: a, reason: collision with root package name */
    public final int f9137a;
    private final int zab;
    private final int zac;

    @Deprecated
    private final Scope[] zad;

    public zax(int i3, int i10, int i11, Scope[] scopeArr) {
        this.f9137a = i3;
        this.zab = i10;
        this.zac = i11;
        this.zad = scopeArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9137a);
        int i11 = this.zab;
        u.k(parcel, 2, 4);
        parcel.writeInt(i11);
        int i12 = this.zac;
        u.k(parcel, 3, 4);
        parcel.writeInt(i12);
        u.g(parcel, 4, this.zad, i3);
        u.j(parcel, i10);
    }
}
