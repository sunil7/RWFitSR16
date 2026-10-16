package com.google.mlkit.vision.common.internal;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.d0;
import androidx.lifecycle.r;
import com.example.test.ui.device.activity.f0;
import ia.g;
import ia.h;
import ia.m;
import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import mc.e;
import o4.c;
import oc.d;

/* loaded from: classes.dex */
public class MobileVisionBase<DetectionResultT> implements Closeable, r, AutoCloseable {
    public static final c e = new c("MobileVisionBase", "");

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f11205a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final e f11206b;

    /* renamed from: c, reason: collision with root package name */
    public final f0 f11207c;

    /* renamed from: d, reason: collision with root package name */
    public final Executor f11208d;

    public MobileVisionBase(e eVar, Executor executor) {
        this.f11206b = eVar;
        f0 f0Var = new f0(20);
        this.f11207c = f0Var;
        this.f11208d = executor;
        eVar.f16014b.incrementAndGet();
        m a3 = eVar.a(executor, d.f16916a, (f0) f0Var.f7859b);
        oc.c cVar = oc.c.f16914a;
        a3.getClass();
        a3.a(h.f14383a, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, ic.a
    @d0(Lifecycle$Event.ON_DESTROY)
    public synchronized void close() {
        if (this.f11205a.getAndSet(true)) {
            return;
        }
        this.f11207c.n();
        e eVar = this.f11206b;
        Executor executor = this.f11208d;
        if (eVar.f16014b.get() <= 0) {
            throw new IllegalStateException();
        }
        eVar.f16013a.j(new x.h(23, eVar, new g()), executor);
    }
}
