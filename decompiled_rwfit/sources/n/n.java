package n;

/* loaded from: classes.dex */
public final class n extends androidx.lifecycle.a0 {

    /* renamed from: m, reason: collision with root package name */
    public androidx.lifecycle.b0 f16255m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f16256n;

    public n(Object obj) {
        this.f16256n = obj;
    }

    @Override // androidx.lifecycle.y
    public final Object d() {
        androidx.lifecycle.b0 b0Var = this.f16255m;
        return b0Var == null ? this.f16256n : b0Var.d();
    }

    @Override // androidx.lifecycle.a0
    public final void l(androidx.lifecycle.y yVar, androidx.lifecycle.c0 c0Var) {
        throw null;
    }

    public final void m(androidx.lifecycle.b0 b0Var) {
        androidx.lifecycle.z zVar;
        androidx.lifecycle.b0 b0Var2 = this.f16255m;
        if (b0Var2 != null && (zVar = (androidx.lifecycle.z) this.f2340l.d(b0Var2)) != null) {
            zVar.f2412a.j(zVar);
        }
        this.f16255m = b0Var;
        super.l(b0Var, new af.a(this, 20));
    }
}
