package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class g1 {

    /* renamed from: c, reason: collision with root package name */
    public static final g1 f9786c = new g1();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f9788b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final x0 f9787a = new x0(0);

    public final m1 a(Class cls) {
        m1 v6;
        Charset charset = s0.f9827a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.f9788b;
        m1 m1Var = (m1) concurrentHashMap.get(cls);
        if (m1Var != null) {
            return m1Var;
        }
        x0 x0Var = this.f9787a;
        x0Var.getClass();
        g0 g0Var = n1.f9806a;
        l0.class.isAssignableFrom(cls);
        i1 a3 = ((x0) x0Var.f9840a).a(cls);
        if ((a3.f9798d & 2) == 2) {
            g0 g0Var2 = n1.f9806a;
            g0 g0Var3 = d0.f9760a;
            v6 = new e1(g0Var2, a3.f9795a);
        } else {
            int i3 = f1.f9783a;
            int i10 = v0.f9837a;
            g0 g0Var4 = n1.f9806a;
            g0 g0Var5 = a3.a() + (-1) != 1 ? d0.f9760a : null;
            int i11 = y0.f9848a;
            v6 = d1.v(a3, g0Var4, g0Var5);
        }
        m1 m1Var2 = (m1) concurrentHashMap.putIfAbsent(cls, v6);
        return m1Var2 == null ? v6 : m1Var2;
    }
}
