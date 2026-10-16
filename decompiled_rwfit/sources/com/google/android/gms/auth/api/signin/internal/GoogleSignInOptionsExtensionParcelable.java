package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;

/* loaded from: classes.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new d(7);

    /* renamed from: a, reason: collision with root package name */
    public final int f9069a;
    private int zab;
    private Bundle zac;

    public GoogleSignInOptionsExtensionParcelable(int i3, int i10, Bundle bundle) {
        this.f9069a = i3;
        this.zab = i10;
        this.zac = bundle;
    }

    public final int b() {
        return this.zab;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9069a);
        int i11 = this.zab;
        u.k(parcel, 2, 4);
        parcel.writeInt(i11);
        u.a(parcel, 3, this.zac);
        u.j(parcel, i10);
    }
}
