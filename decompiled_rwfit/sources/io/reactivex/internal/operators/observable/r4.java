package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class r4 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f14864a;

    /* renamed from: b, reason: collision with root package name */
    public final s4 f14865b;

    public r4(long j4, s4 s4Var) {
        this.f14864a = j4;
        this.f14865b = s4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s4 s4Var = this.f14865b;
        if (s4Var.f14472d) {
            s4Var.r = true;
            s4Var.f();
        } else {
            s4Var.f14471c.offer(this);
        }
        if (s4Var.b()) {
            s4Var.g();
        }
    }
}
