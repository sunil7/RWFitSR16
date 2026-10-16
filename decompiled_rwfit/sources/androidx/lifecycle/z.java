package androidx.lifecycle;

/* loaded from: classes.dex */
public final class z implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f2412a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f2413b;

    /* renamed from: c, reason: collision with root package name */
    public int f2414c = -1;

    public z(b0 b0Var, c0 c0Var) {
        this.f2412a = b0Var;
        this.f2413b = c0Var;
    }

    @Override // androidx.lifecycle.c0
    public final void i(Object obj) {
        int i3 = this.f2414c;
        int i10 = this.f2412a.f2408g;
        if (i3 != i10) {
            this.f2414c = i10;
            this.f2413b.i(obj);
        }
    }
}
