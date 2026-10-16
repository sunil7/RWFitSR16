package androidx.camera.core.impl;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class h1 {

    /* renamed from: b, reason: collision with root package name */
    public static final g1 f1413b = new g1(true, null, null);

    /* renamed from: c, reason: collision with root package name */
    public static final h1 f1414c = new h1();

    /* renamed from: a, reason: collision with root package name */
    public final y0 f1415a;

    public h1() {
        g1 g1Var = f1413b;
        y0 y0Var = new y0();
        y0Var.f1526c = new Object();
        y0Var.f1525b = 0;
        y0Var.f1524a = false;
        y0Var.e = new HashMap();
        y0Var.f1528f = new CopyOnWriteArraySet();
        y0Var.f1527d = new AtomicReference(g1Var);
        this.f1415a = y0Var;
    }
}
