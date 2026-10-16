package com.bumptech.glide.load.engine;

import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.f;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.e;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import g4.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import n.l;
import t4.g;
import z3.h;
import z3.i;
import z3.j;
import z3.k;
import z3.m;
import z3.n;
import z3.p;
import z3.q;
import z3.r;
import z3.s;
import z3.t;
import z3.v;

/* loaded from: classes.dex */
public final class b implements z3.d, Runnable, Comparable, u4.b {
    public e A;
    public volatile z3.e B;
    public volatile boolean C;
    public volatile boolean D;
    public boolean E;

    /* renamed from: d, reason: collision with root package name */
    public final i f6989d;
    public final l e;

    /* renamed from: h, reason: collision with root package name */
    public f f6992h;

    /* renamed from: i, reason: collision with root package name */
    public x3.c f6993i;

    /* renamed from: j, reason: collision with root package name */
    public Priority f6994j;

    /* renamed from: k, reason: collision with root package name */
    public m f6995k;

    /* renamed from: l, reason: collision with root package name */
    public int f6996l;

    /* renamed from: m, reason: collision with root package name */
    public int f6997m;

    /* renamed from: n, reason: collision with root package name */
    public h f6998n;

    /* renamed from: o, reason: collision with root package name */
    public x3.f f6999o;

    /* renamed from: p, reason: collision with root package name */
    public z3.l f7000p;

    /* renamed from: q, reason: collision with root package name */
    public int f7001q;
    public DecodeJob$Stage r;

    /* renamed from: s, reason: collision with root package name */
    public DecodeJob$RunReason f7002s;

    /* renamed from: t, reason: collision with root package name */
    public long f7003t;

    /* renamed from: u, reason: collision with root package name */
    public Object f7004u;

    /* renamed from: v, reason: collision with root package name */
    public Thread f7005v;

    /* renamed from: w, reason: collision with root package name */
    public x3.c f7006w;

    /* renamed from: x, reason: collision with root package name */
    public x3.c f7007x;

    /* renamed from: y, reason: collision with root package name */
    public Object f7008y;

    /* renamed from: z, reason: collision with root package name */
    public DataSource f7009z;

    /* renamed from: a, reason: collision with root package name */
    public final z3.f f6986a = new z3.f();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f6987b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final u4.e f6988c = new u4.e();

    /* renamed from: f, reason: collision with root package name */
    public final l f6990f = new l(19);

    /* renamed from: g, reason: collision with root package name */
    public final q.b f6991g = new q.b();

    public b(i iVar, l lVar) {
        this.f6989d = iVar;
        this.e = lVar;
    }

    @Override // z3.d
    public final void a(x3.c cVar, Exception exc, e eVar, DataSource dataSource) {
        eVar.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(cVar, dataSource, eVar.a());
        this.f6987b.add(glideException);
        if (Thread.currentThread() == this.f7005v) {
            m();
            return;
        }
        this.f7002s = DecodeJob$RunReason.SWITCH_TO_SOURCE_SERVICE;
        z3.l lVar = this.f7000p;
        (lVar.f20260m ? lVar.f20256i : lVar.f20255h).execute(this);
    }

    @Override // u4.b
    public final u4.e b() {
        return this.f6988c;
    }

    @Override // z3.d
    public final void c(x3.c cVar, Object obj, e eVar, DataSource dataSource, x3.c cVar2) {
        this.f7006w = cVar;
        this.f7008y = obj;
        this.A = eVar;
        this.f7009z = dataSource;
        this.f7007x = cVar2;
        this.E = cVar != this.f6986a.a().get(0);
        if (Thread.currentThread() == this.f7005v) {
            f();
            return;
        }
        this.f7002s = DecodeJob$RunReason.DECODE_DATA;
        z3.l lVar = this.f7000p;
        (lVar.f20260m ? lVar.f20256i : lVar.f20255h).execute(this);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        b bVar = (b) obj;
        int ordinal = this.f6994j.ordinal() - bVar.f6994j.ordinal();
        return ordinal == 0 ? this.f7001q - bVar.f7001q : ordinal;
    }

    public final s d(e eVar, Object obj, DataSource dataSource) {
        if (obj == null) {
            return null;
        }
        try {
            int i3 = g.f18515b;
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            s e = e(obj, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                i(elapsedRealtimeNanos, "Decoded result " + e, null);
            }
            return e;
        } finally {
            eVar.b();
        }
    }

    public final s e(Object obj, DataSource dataSource) {
        com.bumptech.glide.load.data.g b3;
        q c9 = this.f6986a.c(obj.getClass());
        x3.f fVar = this.f6999o;
        boolean z5 = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f6986a.r;
        x3.e eVar = o.f13838i;
        Boolean bool = (Boolean) fVar.c(eVar);
        if (bool == null || (bool.booleanValue() && !z5)) {
            fVar = new x3.f();
            fVar.f19776b.i(this.f6999o.f19776b);
            fVar.f19776b.put(eVar, Boolean.valueOf(z5));
        }
        x3.f fVar2 = fVar;
        com.bumptech.glide.load.data.i iVar = this.f6992h.f6917b.e;
        synchronized (iVar) {
            try {
                com.bumptech.glide.load.data.f fVar3 = (com.bumptech.glide.load.data.f) ((HashMap) iVar.f6970b).get(obj.getClass());
                if (fVar3 == null) {
                    Iterator it = ((HashMap) iVar.f6970b).values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.bumptech.glide.load.data.f fVar4 = (com.bumptech.glide.load.data.f) it.next();
                        if (fVar4.a().isAssignableFrom(obj.getClass())) {
                            fVar3 = fVar4;
                            break;
                        }
                    }
                }
                if (fVar3 == null) {
                    fVar3 = com.bumptech.glide.load.data.i.f6968c;
                }
                b3 = fVar3.b(obj);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        try {
            int i3 = this.f6996l;
            int i10 = this.f6997m;
            o4.c cVar = new o4.c();
            cVar.f16733b = this;
            cVar.f16732a = dataSource;
            return c9.a(i3, i10, b3, cVar, fVar2);
        } finally {
            b3.b();
        }
    }

    public final void f() {
        s sVar;
        boolean a3;
        if (Log.isLoggable("DecodeJob", 2)) {
            i(this.f7003t, "Retrieved data", "data: " + this.f7008y + ", cache key: " + this.f7006w + ", fetcher: " + this.A);
        }
        r rVar = null;
        try {
            sVar = d(this.A, this.f7008y, this.f7009z);
        } catch (GlideException e) {
            e.setLoggingDetails(this.f7007x, this.f7009z);
            this.f6987b.add(e);
            sVar = null;
        }
        if (sVar == null) {
            m();
            return;
        }
        DataSource dataSource = this.f7009z;
        boolean z5 = this.E;
        if (sVar instanceof p) {
            ((p) sVar).a();
        }
        if (((r) this.f6990f.f16247d) != null) {
            rVar = (r) r.e.c();
            rVar.f20291d = false;
            rVar.f20290c = true;
            rVar.f20289b = sVar;
            sVar = rVar;
        }
        o();
        z3.l lVar = this.f7000p;
        synchronized (lVar) {
            lVar.f20261n = sVar;
            lVar.f20262o = dataSource;
            lVar.f20268v = z5;
        }
        synchronized (lVar) {
            try {
                lVar.f20250b.a();
                if (lVar.f20267u) {
                    lVar.f20261n.recycle();
                    lVar.g();
                } else {
                    if (lVar.f20249a.f20247a.isEmpty()) {
                        throw new IllegalStateException("Received a resource without any callbacks to notify");
                    }
                    if (lVar.f20263p) {
                        throw new IllegalStateException("Already have resource");
                    }
                    hc.a aVar = lVar.e;
                    s sVar2 = lVar.f20261n;
                    boolean z6 = lVar.f20259l;
                    m mVar = lVar.f20258k;
                    c cVar = lVar.f20251c;
                    aVar.getClass();
                    lVar.f20265s = new n(sVar2, z6, true, mVar, cVar);
                    lVar.f20263p = true;
                    k kVar = lVar.f20249a;
                    kVar.getClass();
                    ArrayList arrayList = new ArrayList(kVar.f20247a);
                    lVar.e(arrayList.size() + 1);
                    lVar.f20253f.d(lVar, lVar.f20258k, lVar.f20265s);
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        j jVar = (j) obj;
                        jVar.f20246b.execute(new d(lVar, jVar.f20245a, 1));
                    }
                    lVar.d();
                }
            } finally {
            }
        }
        this.r = DecodeJob$Stage.ENCODE;
        try {
            l lVar2 = this.f6990f;
            if (((r) lVar2.f16247d) != null) {
                i iVar = this.f6989d;
                x3.f fVar = this.f6999o;
                lVar2.getClass();
                try {
                    iVar.a().a((x3.c) lVar2.f16245b, new l((x3.h) lVar2.f16246c, (r) lVar2.f16247d, fVar, 18, false));
                    ((r) lVar2.f16247d).a();
                } catch (Throwable th2) {
                    ((r) lVar2.f16247d).a();
                    throw th2;
                }
            }
            q.b bVar = this.f6991g;
            synchronized (bVar) {
                bVar.f17607b = true;
                a3 = bVar.a();
            }
            if (a3) {
                k();
            }
        } finally {
            if (rVar != null) {
                rVar.a();
            }
        }
    }

    public final z3.e g() {
        int i3 = a.f6984b[this.r.ordinal()];
        z3.f fVar = this.f6986a;
        if (i3 == 1) {
            return new t(fVar, this);
        }
        if (i3 == 2) {
            return new z3.b(fVar.a(), fVar, this);
        }
        if (i3 == 3) {
            return new v(fVar, this);
        }
        if (i3 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.r);
    }

    public final DecodeJob$Stage h(DecodeJob$Stage decodeJob$Stage) {
        boolean z5;
        boolean z6;
        int i3 = a.f6984b[decodeJob$Stage.ordinal()];
        if (i3 == 1) {
            switch (this.f6998n.f20242a) {
                case 0:
                    z5 = false;
                    break;
                case 1:
                default:
                    z5 = true;
                    break;
            }
            return z5 ? DecodeJob$Stage.DATA_CACHE : h(DecodeJob$Stage.DATA_CACHE);
        }
        if (i3 == 2) {
            return DecodeJob$Stage.SOURCE;
        }
        if (i3 == 3 || i3 == 4) {
            return DecodeJob$Stage.FINISHED;
        }
        if (i3 != 5) {
            throw new IllegalArgumentException("Unrecognized stage: " + decodeJob$Stage);
        }
        switch (this.f6998n.f20242a) {
            case 0:
            case 1:
                z6 = false;
                break;
            default:
                z6 = true;
                break;
        }
        return z6 ? DecodeJob$Stage.RESOURCE_CACHE : h(DecodeJob$Stage.RESOURCE_CACHE);
    }

    public final void i(long j4, String str, String str2) {
        StringBuilder u10 = l0.u(str, " in ");
        u10.append(g.a(j4));
        u10.append(", load key: ");
        u10.append(this.f6995k);
        u10.append(str2 != null ? ", ".concat(str2) : "");
        u10.append(", thread: ");
        u10.append(Thread.currentThread().getName());
        Log.v("DecodeJob", u10.toString());
    }

    public final void j() {
        boolean a3;
        o();
        GlideException glideException = new GlideException("Failed to load resource", new ArrayList(this.f6987b));
        z3.l lVar = this.f7000p;
        synchronized (lVar) {
            lVar.f20264q = glideException;
        }
        synchronized (lVar) {
            try {
                lVar.f20250b.a();
                if (lVar.f20267u) {
                    lVar.g();
                } else {
                    if (lVar.f20249a.f20247a.isEmpty()) {
                        throw new IllegalStateException("Received an exception without any callbacks to notify");
                    }
                    if (lVar.r) {
                        throw new IllegalStateException("Already failed once");
                    }
                    lVar.r = true;
                    m mVar = lVar.f20258k;
                    k kVar = lVar.f20249a;
                    kVar.getClass();
                    ArrayList arrayList = new ArrayList(kVar.f20247a);
                    lVar.e(arrayList.size() + 1);
                    lVar.f20253f.d(lVar, mVar, null);
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        j jVar = (j) obj;
                        jVar.f20246b.execute(new d(lVar, jVar.f20245a, 0));
                    }
                    lVar.d();
                }
            } finally {
            }
        }
        q.b bVar = this.f6991g;
        synchronized (bVar) {
            bVar.f17608c = true;
            a3 = bVar.a();
        }
        if (a3) {
            k();
        }
    }

    public final void k() {
        q.b bVar = this.f6991g;
        synchronized (bVar) {
            bVar.f17607b = false;
            bVar.f17606a = false;
            bVar.f17608c = false;
        }
        l lVar = this.f6990f;
        lVar.f16245b = null;
        lVar.f16246c = null;
        lVar.f16247d = null;
        z3.f fVar = this.f6986a;
        fVar.f20221c = null;
        fVar.f20222d = null;
        fVar.f20231n = null;
        fVar.f20224g = null;
        fVar.f20228k = null;
        fVar.f20226i = null;
        fVar.f20232o = null;
        fVar.f20227j = null;
        fVar.f20233p = null;
        fVar.f20219a.clear();
        fVar.f20229l = false;
        fVar.f20220b.clear();
        fVar.f20230m = false;
        this.C = false;
        this.f6992h = null;
        this.f6993i = null;
        this.f6999o = null;
        this.f6994j = null;
        this.f6995k = null;
        this.f7000p = null;
        this.r = null;
        this.B = null;
        this.f7005v = null;
        this.f7006w = null;
        this.f7008y = null;
        this.f7009z = null;
        this.A = null;
        this.f7003t = 0L;
        this.D = false;
        this.f7004u = null;
        this.f6987b.clear();
        this.e.q(this);
    }

    public final void l() {
        this.f7002s = DecodeJob$RunReason.SWITCH_TO_SOURCE_SERVICE;
        z3.l lVar = this.f7000p;
        (lVar.f20260m ? lVar.f20256i : lVar.f20255h).execute(this);
    }

    public final void m() {
        this.f7005v = Thread.currentThread();
        int i3 = g.f18515b;
        this.f7003t = SystemClock.elapsedRealtimeNanos();
        boolean z5 = false;
        while (!this.D && this.B != null && !(z5 = this.B.b())) {
            this.r = h(this.r);
            this.B = g();
            if (this.r == DecodeJob$Stage.SOURCE) {
                l();
                return;
            }
        }
        if ((this.r == DecodeJob$Stage.FINISHED || this.D) && !z5) {
            j();
        }
    }

    public final void n() {
        int i3 = a.f6983a[this.f7002s.ordinal()];
        if (i3 == 1) {
            this.r = h(DecodeJob$Stage.INITIALIZE);
            this.B = g();
            m();
        } else if (i3 == 2) {
            m();
        } else if (i3 == 3) {
            f();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.f7002s);
        }
    }

    public final void o() {
        this.f6988c.a();
        if (this.C) {
            throw new IllegalStateException("Already notified", this.f6987b.isEmpty() ? null : (Throwable) l0.h(1, this.f6987b));
        }
        this.C = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = this.A;
        try {
            try {
                try {
                    if (this.D) {
                        j();
                        if (eVar != null) {
                            eVar.b();
                            return;
                        }
                        return;
                    }
                    n();
                    if (eVar != null) {
                        eVar.b();
                    }
                } catch (Throwable th2) {
                    if (Log.isLoggable("DecodeJob", 3)) {
                        Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.D + ", stage: " + this.r, th2);
                    }
                    if (this.r != DecodeJob$Stage.ENCODE) {
                        this.f6987b.add(th2);
                        j();
                    }
                    if (!this.D) {
                        throw th2;
                    }
                    throw th2;
                }
            } catch (CallbackException e) {
                throw e;
            }
        } catch (Throwable th3) {
            if (eVar != null) {
                eVar.b();
            }
            throw th3;
        }
    }
}
