package com.tencent.open.log;

import com.tencent.open.log.d;

/* loaded from: classes2.dex */
public abstract class Tracer {

    /* renamed from: a, reason: collision with root package name */
    private volatile int f12029a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f12030b;

    /* renamed from: c, reason: collision with root package name */
    private g f12031c;

    public Tracer() {
        this(c.f12053a, true, g.f12073a);
    }

    public void a(int i3, Thread thread, long j4, String str, String str2, Throwable th2) {
        if (d() && d.a.a(this.f12029a, i3)) {
            doTrace(i3, thread, j4, str, str2, th2);
        }
    }

    public boolean d() {
        return this.f12030b;
    }

    public abstract void doTrace(int i3, Thread thread, long j4, String str, String str2, Throwable th2);

    public g e() {
        return this.f12031c;
    }

    public Tracer(int i3, boolean z5, g gVar) {
        this.f12029a = c.f12053a;
        this.f12030b = true;
        this.f12031c = g.f12073a;
        a(i3);
        a(z5);
        a(gVar);
    }

    public void a(int i3) {
        this.f12029a = i3;
    }

    public void a(boolean z5) {
        this.f12030b = z5;
    }

    public void a(g gVar) {
        this.f12031c = gVar;
    }
}
