package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9167a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9168b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f9169c;

    public b(Object obj, Object obj2, Object obj3) {
        this.f9167a = obj;
        this.f9168b = obj2;
        this.f9169c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.f9167a;
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(this.f9168b);
        String valueOf3 = String.valueOf(obj);
        String valueOf4 = String.valueOf(this.f9169c);
        StringBuilder v6 = l0.v("Multiple entries with same key: ", valueOf, "=", valueOf2, " and ");
        v6.append(valueOf3);
        v6.append("=");
        v6.append(valueOf4);
        return new IllegalArgumentException(v6.toString());
    }
}
