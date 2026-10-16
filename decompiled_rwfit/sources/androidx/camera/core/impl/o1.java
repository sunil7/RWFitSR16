package androidx.camera.core.impl;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class o1 implements p1 {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f1464a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final p1 f1465b;

    public o1(p1 p1Var) {
        this.f1465b = p1Var;
    }

    @Override // androidx.camera.core.impl.p1
    public final void a(s1 s1Var, SessionConfig$SessionError sessionConfig$SessionError) {
        if (this.f1464a.get()) {
            return;
        }
        this.f1465b.a(s1Var, sessionConfig$SessionError);
    }

    public final void b() {
        this.f1464a.set(true);
    }
}
