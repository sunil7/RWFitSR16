package androidx.camera.core.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class y0 implements b1 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1524a;

    /* renamed from: b, reason: collision with root package name */
    public int f1525b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1526c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1527d;
    public Object e;

    /* renamed from: f, reason: collision with root package name */
    public Serializable f1528f;

    public x.k a() {
        Object obj = ((AtomicReference) this.f1527d).get();
        if (!(obj instanceof g)) {
            return x.i.c(obj);
        }
        ((g) obj).getClass();
        return new x.k(null, 1);
    }

    @Override // androidx.camera.core.impl.b1
    public void d(a1 a1Var) {
        synchronized (this.f1526c) {
            u1 u1Var = (u1) ((HashMap) this.e).remove(a1Var);
            if (u1Var != null) {
                u1Var.f1500c.set(false);
                ((CopyOnWriteArraySet) this.f1528f).remove(u1Var);
            }
        }
    }

    @Override // androidx.camera.core.impl.b1
    public void e(Executor executor, a1 a1Var) {
        u1 u1Var;
        synchronized (this.f1526c) {
            u1 u1Var2 = (u1) ((HashMap) this.e).remove(a1Var);
            if (u1Var2 != null) {
                u1Var2.f1500c.set(false);
                ((CopyOnWriteArraySet) this.f1528f).remove(u1Var2);
            }
            u1Var = new u1((AtomicReference) this.f1527d, executor, a1Var);
            ((HashMap) this.e).put(a1Var, u1Var);
            ((CopyOnWriteArraySet) this.f1528f).add(u1Var);
        }
        u1Var.a(0);
    }
}
