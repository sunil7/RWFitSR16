package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;

/* loaded from: classes.dex */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new d(26);

    /* renamed from: a, reason: collision with root package name */
    public final int f9134a;
    private final Account zab;
    private final int zac;
    private final GoogleSignInAccount zad;

    public zat(int i3, Account account, int i10, GoogleSignInAccount googleSignInAccount) {
        this.f9134a = i3;
        this.zab = account;
        this.zac = i10;
        this.zad = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9134a);
        u.d(parcel, 2, this.zab, i3);
        int i11 = this.zac;
        u.k(parcel, 3, 4);
        parcel.writeInt(i11);
        u.d(parcel, 4, this.zad, i3);
        u.j(parcel, i10);
    }
}
