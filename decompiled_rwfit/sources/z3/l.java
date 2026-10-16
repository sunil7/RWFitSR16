package z3;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class l implements u4.b {

    /* renamed from: w, reason: collision with root package name */
    public static final hc.a f20248w = new hc.a(25);

    /* renamed from: a, reason: collision with root package name */
    public final k f20249a;

    /* renamed from: b, reason: collision with root package name */
    public final u4.e f20250b;

    /* renamed from: c, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.c f20251c;

    /* renamed from: d, reason: collision with root package name */
    public final n.l f20252d;
    public final hc.a e;

    /* renamed from: f, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.c f20253f;

    /* renamed from: g, reason: collision with root package name */
    public final c4.c f20254g;

    /* renamed from: h, reason: collision with root package name */
    public final c4.c f20255h;

    /* renamed from: i, reason: collision with root package name */
    public final c4.c f20256i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicInteger f20257j;

    /* renamed from: k, reason: collision with root package name */
    public m f20258k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20259l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20260m;

    /* renamed from: n, reason: collision with root package name */
    public s f20261n;

    /* renamed from: o, reason: collision with root package name */
    public DataSource f20262o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f20263p;

    /* renamed from: q, reason: collision with root package name */
    public GlideException f20264q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public n f20265s;

    /* renamed from: t, reason: collision with root package name */
    public com.bumptech.glide.load.engine.b f20266t;

    /* renamed from: u, reason: collision with root package name */
    public volatile boolean f20267u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f20268v;

    public l(c4.c cVar, c4.c cVar2, c4.c cVar3, c4.c cVar4, com.bumptech.glide.load.engine.c cVar5, com.bumptech.glide.load.engine.c cVar6, n.l lVar) {
        hc.a aVar = f20248w;
        this.f20249a = new k(new ArrayList(2));
        this.f20250b = new u4.e();
        this.f20257j = new AtomicInteger();
        this.f20254g = cVar;
        this.f20255h = cVar2;
        this.f20256i = cVar4;
        this.f20253f = cVar5;
        this.f20251c = cVar6;
        this.f20252d = lVar;
        this.e = aVar;
    }

    public final synchronized void a(com.bumptech.glide.request.a aVar, w.a aVar2) {
        try {
            this.f20250b.a();
            k kVar = this.f20249a;
            kVar.getClass();
            kVar.f20247a.add(new j(aVar, aVar2));
            if (this.f20263p) {
                e(1);
                com.bumptech.glide.load.engine.d dVar = new com.bumptech.glide.load.engine.d(this, aVar, 1);
                aVar2.getClass();
                t4.l.i(dVar);
            } else if (this.r) {
                e(1);
                com.bumptech.glide.load.engine.d dVar2 = new com.bumptech.glide.load.engine.d(this, aVar, 0);
                aVar2.getClass();
                t4.l.i(dVar2);
            } else {
                t4.f.a("Cannot add callbacks to a cancelled EngineJob", !this.f20267u);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // u4.b
    public final u4.e b() {
        return this.f20250b;
    }

    public final void c() {
        if (f()) {
            return;
        }
        this.f20267u = true;
        com.bumptech.glide.load.engine.b bVar = this.f20266t;
        bVar.D = true;
        e eVar = bVar.B;
        if (eVar != null) {
            eVar.cancel();
        }
        com.bumptech.glide.load.engine.c cVar = this.f20253f;
        m mVar = this.f20258k;
        synchronized (cVar) {
            fc.c cVar2 = cVar.f7011a;
            cVar2.getClass();
            HashMap hashMap = cVar2.f13558a;
            if (equals(hashMap.get(mVar))) {
                hashMap.remove(mVar);
            }
        }
    }

    public final void d() {
        n nVar;
        synchronized (this) {
            try {
                this.f20250b.a();
                t4.f.a("Not yet complete!", f());
                int decrementAndGet = this.f20257j.decrementAndGet();
                t4.f.a("Can't decrement below 0", decrementAndGet >= 0);
                if (decrementAndGet == 0) {
                    nVar = this.f20265s;
                    g();
                } else {
                    nVar = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (nVar != null) {
            nVar.b();
        }
    }

    public final synchronized void e(int i3) {
        n nVar;
        t4.f.a("Not yet complete!", f());
        if (this.f20257j.getAndAdd(i3) == 0 && (nVar = this.f20265s) != null) {
            nVar.a();
        }
    }

    public final boolean f() {
        return this.r || this.f20263p || this.f20267u;
    }

    public final synchronized void g() {
        boolean a3;
        if (this.f20258k == null) {
            throw new IllegalArgumentException();
        }
        this.f20249a.f20247a.clear();
        this.f20258k = null;
        this.f20265s = null;
        this.f20261n = null;
        this.r = false;
        this.f20267u = false;
        this.f20263p = false;
        this.f20268v = false;
        com.bumptech.glide.load.engine.b bVar = this.f20266t;
        q.b bVar2 = bVar.f6991g;
        synchronized (bVar2) {
            bVar2.f17606a = true;
            a3 = bVar2.a();
        }
        if (a3) {
            bVar.k();
        }
        this.f20266t = null;
        this.f20264q = null;
        this.f20262o = null;
        this.f20252d.q(this);
    }

    public final synchronized void h(com.bumptech.glide.request.a aVar) {
        try {
            this.f20250b.a();
            k kVar = this.f20249a;
            kVar.f20247a.remove(new j(aVar, t4.f.f18513b));
            if (this.f20249a.f20247a.isEmpty()) {
                c();
                if (!this.f20263p) {
                    if (this.r) {
                    }
                }
                if (this.f20257j.get() == 0) {
                    g();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
