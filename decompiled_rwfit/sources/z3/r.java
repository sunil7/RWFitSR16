package z3;

/* loaded from: classes.dex */
public final class r implements s, u4.b {
    public static final n.l e = u4.d.a(20, new com.google.android.gms.internal.mlkit_common.o(26));

    /* renamed from: a, reason: collision with root package name */
    public final u4.e f20288a = new u4.e();

    /* renamed from: b, reason: collision with root package name */
    public s f20289b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20290c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f20291d;

    public final synchronized void a() {
        this.f20288a.a();
        if (!this.f20290c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f20290c = false;
        if (this.f20291d) {
            recycle();
        }
    }

    @Override // u4.b
    public final u4.e b() {
        return this.f20288a;
    }

    @Override // z3.s
    public final int c() {
        return this.f20289b.c();
    }

    @Override // z3.s
    public final Class d() {
        return this.f20289b.d();
    }

    @Override // z3.s
    public final Object get() {
        return this.f20289b.get();
    }

    @Override // z3.s
    public final synchronized void recycle() {
        this.f20288a.a();
        this.f20291d = true;
        if (!this.f20290c) {
            this.f20289b.recycle();
            this.f20289b = null;
            e.q(this);
        }
    }
}
