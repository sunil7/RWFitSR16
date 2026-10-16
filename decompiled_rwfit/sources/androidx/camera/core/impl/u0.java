package androidx.camera.core.impl;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class u0 implements androidx.lifecycle.c0 {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f1494a = new AtomicBoolean(true);

    /* renamed from: b, reason: collision with root package name */
    public final androidx.camera.view.a f1495b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f1496c;

    public u0(Executor executor, androidx.camera.view.a aVar) {
        this.f1496c = executor;
        this.f1495b = aVar;
    }

    @Override // androidx.lifecycle.c0
    public final void i(Object obj) {
        this.f1496c.execute(new androidx.appcompat.app.i0(3, this, (v0) obj));
    }
}
