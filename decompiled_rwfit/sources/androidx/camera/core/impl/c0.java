package androidx.camera.core.impl;

import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f1354a;

    /* renamed from: b, reason: collision with root package name */
    public x0 f1355b;

    /* renamed from: c, reason: collision with root package name */
    public int f1356c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1357d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final z0 f1358f;

    /* renamed from: g, reason: collision with root package name */
    public n f1359g;

    public c0() {
        this.f1354a = new HashSet();
        this.f1355b = x0.f();
        this.f1356c = -1;
        this.f1357d = new ArrayList();
        this.e = false;
        this.f1358f = z0.a();
    }

    public final void a(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            b((k) it.next());
        }
    }

    public final void b(k kVar) {
        ArrayList arrayList = this.f1357d;
        if (arrayList.contains(kVar)) {
            return;
        }
        arrayList.add(kVar);
    }

    public final void c(e0 e0Var) {
        for (c cVar : e0Var.g()) {
            x0 x0Var = this.f1355b;
            x0Var.getClass();
            try {
                x0Var.e(cVar);
            } catch (IllegalArgumentException unused) {
            }
            this.f1355b.l(cVar, e0Var.j(cVar), e0Var.e(cVar));
        }
    }

    public final d0 d() {
        ArrayList arrayList = new ArrayList(this.f1354a);
        d1 a3 = d1.a(this.f1355b);
        int i3 = this.f1356c;
        ArrayList arrayList2 = new ArrayList(this.f1357d);
        boolean z5 = this.e;
        w1 w1Var = w1.f1513b;
        ArrayMap arrayMap = new ArrayMap();
        z0 z0Var = this.f1358f;
        for (String str : z0Var.f1514a.keySet()) {
            arrayMap.put(str, z0Var.f1514a.get(str));
        }
        return new d0(arrayList, a3, i3, arrayList2, z5, new w1(arrayMap), this.f1359g);
    }

    public c0(d0 d0Var) {
        HashSet hashSet = new HashSet();
        this.f1354a = hashSet;
        this.f1355b = x0.f();
        this.f1356c = -1;
        ArrayList arrayList = new ArrayList();
        this.f1357d = arrayList;
        this.e = false;
        this.f1358f = z0.a();
        hashSet.addAll(d0Var.f1366a);
        this.f1355b = x0.i(d0Var.f1367b);
        this.f1356c = d0Var.f1368c;
        arrayList.addAll(d0Var.f1369d);
        this.e = d0Var.e;
        ArrayMap arrayMap = new ArrayMap();
        w1 w1Var = d0Var.f1370f;
        for (String str : w1Var.f1514a.keySet()) {
            arrayMap.put(str, w1Var.f1514a.get(str));
        }
        this.f1358f = new z0(arrayMap);
    }
}
