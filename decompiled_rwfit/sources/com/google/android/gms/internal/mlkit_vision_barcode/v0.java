package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    public final zzrb f9553a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f9554b;

    /* renamed from: c, reason: collision with root package name */
    public final rf f9555c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcs f9556d;
    public final zzcs e;

    public /* synthetic */ v0(u0 u0Var) {
        this.f9553a = (zzrb) u0Var.f9537a;
        this.f9554b = (Boolean) u0Var.f9538b;
        this.f9555c = (rf) u0Var.f9539c;
        this.f9556d = (zzcs) u0Var.f9540d;
        this.e = (zzcs) u0Var.e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return q9.n.h(this.f9553a, v0Var.f9553a) && q9.n.h(null, null) && q9.n.h(this.f9554b, v0Var.f9554b) && q9.n.h(null, null) && q9.n.h(this.f9555c, v0Var.f9555c) && q9.n.h(this.f9556d, v0Var.f9556d) && q9.n.h(this.e, v0Var.e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9553a, null, this.f9554b, null, this.f9555c, this.f9556d, this.e});
    }
}
