package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import q9.o;

/* loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new o(2);

    /* renamed from: a, reason: collision with root package name */
    public Bundle f9139a;

    /* renamed from: b, reason: collision with root package name */
    public Feature[] f9140b;

    /* renamed from: c, reason: collision with root package name */
    public int f9141c;

    /* renamed from: d, reason: collision with root package name */
    public ConnectionTelemetryConfiguration f9142d;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.a(parcel, 1, this.f9139a);
        u.g(parcel, 2, this.f9140b, i3);
        u.k(parcel, 3, 4);
        parcel.writeInt(this.f9141c);
        u.d(parcel, 4, this.f9142d, i3);
        u.j(parcel, i10);
    }
}
