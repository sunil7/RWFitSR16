package r1;

import ab.j;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: l, reason: collision with root package name */
    public static final c f17993l = new c();

    /* renamed from: m, reason: collision with root package name */
    public static final c f17994m = new c();

    /* renamed from: n, reason: collision with root package name */
    public static final c f17995n = new c();

    /* renamed from: o, reason: collision with root package name */
    public static final c f17996o = new c();

    /* renamed from: p, reason: collision with root package name */
    public static final c f17997p = new c();

    /* renamed from: q, reason: collision with root package name */
    public static final c f17998q = new c();

    /* renamed from: a, reason: collision with root package name */
    public float f17999a;

    /* renamed from: b, reason: collision with root package name */
    public float f18000b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18001c;

    /* renamed from: d, reason: collision with root package name */
    public final j f18002d;
    public final ab.i e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f18003f;

    /* renamed from: g, reason: collision with root package name */
    public final float f18004g;

    /* renamed from: h, reason: collision with root package name */
    public long f18005h;

    /* renamed from: i, reason: collision with root package name */
    public final float f18006i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f18007j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f18008k;

    public g(j jVar) {
        ab.i iVar = j.f174q;
        this.f17999a = 0.0f;
        this.f18000b = Float.MAX_VALUE;
        this.f18001c = false;
        this.f18003f = false;
        this.f18004g = -3.4028235E38f;
        this.f18005h = 0L;
        this.f18007j = new ArrayList();
        this.f18008k = new ArrayList();
        this.f18002d = jVar;
        this.e = iVar;
        if (iVar == f17995n || iVar == f17996o || iVar == f17997p) {
            this.f18006i = 0.1f;
            return;
        }
        if (iVar == f17998q) {
            this.f18006i = 0.00390625f;
        } else if (iVar == f17993l || iVar == f17994m) {
            this.f18006i = 0.00390625f;
        } else {
            this.f18006i = 1.0f;
        }
    }

    public final void a() {
        int i3 = 0;
        this.f18003f = false;
        ThreadLocal threadLocal = b.f17986f;
        if (threadLocal.get() == null) {
            threadLocal.set(new b());
        }
        b bVar = (b) threadLocal.get();
        bVar.f17987a.remove(this);
        ArrayList arrayList = bVar.f17988b;
        int indexOf = arrayList.indexOf(this);
        if (indexOf >= 0) {
            arrayList.set(indexOf, null);
            bVar.e = true;
        }
        this.f18005h = 0L;
        this.f18001c = false;
        while (true) {
            ArrayList arrayList2 = this.f18007j;
            if (i3 >= arrayList2.size()) {
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    if (arrayList2.get(size) == null) {
                        arrayList2.remove(size);
                    }
                }
                return;
            }
            if (arrayList2.get(i3) != null) {
                throw android.support.v4.media.session.e.c(i3, arrayList2);
            }
            i3++;
        }
    }

    public final void b(float f2) {
        this.e.getClass();
        j jVar = this.f18002d;
        jVar.f178o = f2 / 10000.0f;
        jVar.invalidateSelf();
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f18008k;
            if (i3 >= arrayList.size()) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (arrayList.get(size) == null) {
                        arrayList.remove(size);
                    }
                }
                return;
            }
            if (arrayList.get(i3) != null) {
                throw android.support.v4.media.session.e.c(i3, arrayList);
            }
            i3++;
        }
    }

    public void removeEndListener(e eVar) {
        ArrayList arrayList = this.f18007j;
        int indexOf = arrayList.indexOf(eVar);
        if (indexOf >= 0) {
            arrayList.set(indexOf, null);
        }
    }

    public void removeUpdateListener(f fVar) {
        ArrayList arrayList = this.f18008k;
        int indexOf = arrayList.indexOf(fVar);
        if (indexOf >= 0) {
            arrayList.set(indexOf, null);
        }
    }
}
