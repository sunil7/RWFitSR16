package com.bumptech.glide;

import androidx.camera.core.impl.i1;
import d4.q;
import d4.r;
import d4.s;
import d4.u;
import d4.w;
import d4.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import n.l;
import n.m0;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final u f6925a;

    /* renamed from: b, reason: collision with root package name */
    public final m0 f6926b;

    /* renamed from: c, reason: collision with root package name */
    public final o4.e f6927c;

    /* renamed from: d, reason: collision with root package name */
    public final i1 f6928d;
    public final com.bumptech.glide.load.data.i e;

    /* renamed from: f, reason: collision with root package name */
    public final l4.c f6929f;

    /* renamed from: g, reason: collision with root package name */
    public final l4.c f6930g;

    /* renamed from: h, reason: collision with root package name */
    public final o4.c f6931h = new o4.c(0);

    /* renamed from: i, reason: collision with root package name */
    public final o4.b f6932i = new o4.b();

    /* renamed from: j, reason: collision with root package name */
    public final l f6933j;

    public g() {
        l lVar = new l(new k1.e(20), 8, new gc.b(21), new hc.a(21));
        this.f6933j = lVar;
        this.f6925a = new u(lVar);
        this.f6926b = new m0(4);
        this.f6927c = new o4.e(0);
        this.f6928d = new i1(1);
        this.e = new com.bumptech.glide.load.data.i();
        this.f6929f = new l4.c(0);
        this.f6930g = new l4.c(1);
        List asList = Arrays.asList("Gif", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(asList.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = asList.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        o4.e eVar = this.f6927c;
        synchronized (eVar) {
            try {
                ArrayList arrayList2 = new ArrayList((ArrayList) eVar.f16737a);
                ((ArrayList) eVar.f16737a).clear();
                int size = arrayList.size();
                int i3 = 0;
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((ArrayList) eVar.f16737a).add((String) obj);
                }
                int size2 = arrayList2.size();
                while (i3 < size2) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    String str = (String) obj2;
                    if (!arrayList.contains(str)) {
                        ((ArrayList) eVar.f16737a).add(str);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void a(Class cls, Class cls2, r rVar) {
        u uVar = this.f6925a;
        synchronized (uVar) {
            x xVar = uVar.f12285a;
            synchronized (xVar) {
                try {
                    w wVar = new w(cls, cls2, rVar);
                    ArrayList arrayList = xVar.f12297a;
                    arrayList.add(arrayList.size(), wVar);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            uVar.f12286b.f12284a.clear();
        }
    }

    public final void b(Class cls, x3.a aVar) {
        m0 m0Var = this.f6926b;
        synchronized (m0Var) {
            ((ArrayList) m0Var.f16254b).add(new o4.a(cls, aVar));
        }
    }

    public final void c(Class cls, x3.h hVar) {
        i1 i1Var = this.f6928d;
        synchronized (i1Var) {
            i1Var.f1421a.add(new o4.f(cls, hVar));
        }
    }

    public final void d(String str, Class cls, Class cls2, x3.g gVar) {
        o4.e eVar = this.f6927c;
        synchronized (eVar) {
            eVar.e(str).add(new o4.d(cls, cls2, gVar));
        }
    }

    public final ArrayList e() {
        ArrayList arrayList;
        l4.c cVar = this.f6930g;
        synchronized (cVar) {
            arrayList = cVar.f15766a;
        }
        if (arrayList.isEmpty()) {
            throw new Registry$MissingComponentException() { // from class: com.bumptech.glide.Registry$NoImageHeaderParserException
            };
        }
        return arrayList;
    }

    public final List f(Object obj) {
        List list;
        u uVar = this.f6925a;
        uVar.getClass();
        Class<?> cls = obj.getClass();
        synchronized (uVar) {
            s sVar = (s) uVar.f12286b.f12284a.get(cls);
            list = sVar == null ? null : sVar.f12283a;
            if (list == null) {
                list = Collections.unmodifiableList(uVar.f12285a.b(cls));
                if (((s) uVar.f12286b.f12284a.put(cls, new s(list))) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (list.isEmpty()) {
            throw new Registry$NoModelLoaderAvailableException(obj);
        }
        int size = list.size();
        List list2 = Collections.EMPTY_LIST;
        boolean z5 = true;
        for (int i3 = 0; i3 < size; i3++) {
            q qVar = (q) list.get(i3);
            if (qVar.b(obj)) {
                if (z5) {
                    list2 = new ArrayList(size - i3);
                    z5 = false;
                }
                list2.add(qVar);
            }
        }
        if (list2.isEmpty()) {
            throw new Registry$NoModelLoaderAvailableException(obj, (List<q>) list);
        }
        return list2;
    }

    public final void g(com.bumptech.glide.load.data.f fVar) {
        com.bumptech.glide.load.data.i iVar = this.e;
        synchronized (iVar) {
            ((HashMap) iVar.f6970b).put(fVar.a(), fVar);
        }
    }

    public final void h(Class cls, Class cls2, l4.a aVar) {
        l4.c cVar = this.f6929f;
        synchronized (cVar) {
            cVar.f15766a.add(new l4.b(cls, cls2, aVar));
        }
    }
}
