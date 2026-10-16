package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import q9.c;
import q9.o;
import q9.y;

/* loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new o(4);

    /* renamed from: n, reason: collision with root package name */
    public static final Scope[] f9098n = new Scope[0];

    /* renamed from: o, reason: collision with root package name */
    public static final Feature[] f9099o = new Feature[0];

    /* renamed from: a, reason: collision with root package name */
    public final int f9100a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9101b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9102c;

    /* renamed from: d, reason: collision with root package name */
    public String f9103d;
    public IBinder e;

    /* renamed from: f, reason: collision with root package name */
    public Scope[] f9104f;

    /* renamed from: g, reason: collision with root package name */
    public Bundle f9105g;

    /* renamed from: h, reason: collision with root package name */
    public Account f9106h;

    /* renamed from: i, reason: collision with root package name */
    public Feature[] f9107i;

    /* renamed from: j, reason: collision with root package name */
    public Feature[] f9108j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f9109k;

    /* renamed from: l, reason: collision with root package name */
    public final int f9110l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9111m;
    private final String zzp;

    public GetServiceRequest(int i3, int i10, int i11, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z5, int i12, boolean z6, String str2) {
        Scope[] scopeArr2 = scopeArr == null ? f9098n : scopeArr;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        Feature[] featureArr3 = f9099o;
        Feature[] featureArr4 = featureArr == null ? featureArr3 : featureArr;
        featureArr3 = featureArr2 != null ? featureArr2 : featureArr3;
        this.f9100a = i3;
        this.f9101b = i10;
        this.f9102c = i11;
        if ("com.google.android.gms".equals(str)) {
            this.f9103d = "com.google.android.gms";
        } else {
            this.f9103d = str;
        }
        if (i3 < 2) {
            Account account2 = null;
            if (iBinder != null) {
                int i13 = q9.a.f17807b;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                IInterface yVar = queryLocalInterface instanceof c ? (c) queryLocalInterface : new y(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 2);
                if (yVar != null) {
                    long clearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        try {
                            y yVar2 = (y) yVar;
                            Parcel m10 = yVar2.m(yVar2.y(), 2);
                            Account account3 = (Account) ea.a.a(m10, Account.CREATOR);
                            m10.recycle();
                            Binder.restoreCallingIdentity(clearCallingIdentity);
                            account2 = account3;
                        } catch (RemoteException unused) {
                            Log.w("AccountAccessor", "Remote account accessor probably died");
                            Binder.restoreCallingIdentity(clearCallingIdentity);
                        }
                    } catch (Throwable th2) {
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        throw th2;
                    }
                }
            }
            this.f9106h = account2;
        } else {
            this.e = iBinder;
            this.f9106h = account;
        }
        this.f9104f = scopeArr2;
        this.f9105g = bundle2;
        this.f9107i = featureArr4;
        this.f9108j = featureArr3;
        this.f9109k = z5;
        this.f9110l = i12;
        this.f9111m = z6;
        this.zzp = str2;
    }

    public final String b() {
        return this.zzp;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        o.a(this, parcel, i3);
    }
}
