package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes.dex */
public abstract class h0 implements Cloneable, b1 {

    /* renamed from: a, reason: collision with root package name */
    public final l0 f9789a;

    /* renamed from: b, reason: collision with root package name */
    public l0 f9790b;

    public h0(l0 l0Var) {
        this.f9789a = l0Var;
        if (l0Var.k()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f9790b = (l0) l0Var.m(4, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1
    public final boolean a() {
        return l0.j(this.f9790b, false);
    }

    public final l0 b() {
        l0 c9 = c();
        if (l0.j(c9, true)) {
            return c9;
        }
        throw new zzgr(c9);
    }

    public l0 c() {
        if (!this.f9790b.k()) {
            return this.f9790b;
        }
        l0 l0Var = this.f9790b;
        l0Var.getClass();
        g1.f9786c.a(l0Var.getClass()).a(l0Var);
        l0Var.g();
        return this.f9790b;
    }

    public final Object clone() {
        h0 h0Var = (h0) this.f9789a.m(5, null);
        h0Var.f9790b = c();
        return h0Var;
    }

    public /* bridge */ a1 d() {
        return c();
    }

    public final void e() {
        if (this.f9790b.k()) {
            return;
        }
        f();
    }

    public void f() {
        l0 l0Var = (l0) this.f9789a.m(4, null);
        g1.f9786c.a(l0Var.getClass()).c(l0Var, this.f9790b);
        this.f9790b = l0Var;
    }
}
