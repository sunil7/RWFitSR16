package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import okhttp3.internal.http2.Settings;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final a1 f9733a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9734b;

    public b0(a1 a1Var, int i3) {
        this.f9733a = a1Var;
        this.f9734b = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f9733a == b0Var.f9733a && this.f9734b == b0Var.f9734b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f9733a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.f9734b;
    }
}
