package com.bumptech.glide.load.engine;

import android.os.SystemClock;
import android.util.Log;
import androidx.appcompat.widget.b0;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.example.test.utils.s0;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import de.i;
import java.util.HashMap;
import java.util.LinkedHashMap;
import n.l;
import n9.e;
import t4.g;
import y2.f;
import z3.h;
import z3.m;
import z3.n;
import z3.s;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f7010h = Log.isLoggable("Engine", 2);

    /* renamed from: a, reason: collision with root package name */
    public final fc.c f7011a;

    /* renamed from: b, reason: collision with root package name */
    public final e f7012b;

    /* renamed from: c, reason: collision with root package name */
    public final b4.e f7013c;

    /* renamed from: d, reason: collision with root package name */
    public final i f7014d;
    public final s0 e;

    /* renamed from: f, reason: collision with root package name */
    public final b0 f7015f;

    /* renamed from: g, reason: collision with root package name */
    public final l f7016g;

    public c(b4.e eVar, f fVar, c4.c cVar, c4.c cVar2, c4.c cVar3, c4.c cVar4) {
        this.f7013c = eVar;
        z3.i iVar = new z3.i(fVar);
        l lVar = new l();
        this.f7016g = lVar;
        synchronized (this) {
            try {
                try {
                    synchronized (lVar) {
                        try {
                            lVar.f16247d = this;
                        } catch (Throwable th2) {
                            th = th2;
                            while (true) {
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                        }
                    }
                    this.f7012b = new e(25);
                    this.f7011a = new fc.c(2);
                    this.f7014d = new i(cVar, cVar2, cVar3, cVar4, this, this);
                    b0 b0Var = new b0();
                    b0Var.f874c = u4.d.a(150, new xg.b(b0Var));
                    b0Var.f873b = iVar;
                    this.f7015f = b0Var;
                    this.e = new s0(8);
                    eVar.f3153d = this;
                } catch (Throwable th4) {
                    th = th4;
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                throw th;
            }
        }
    }

    public static void c(String str, long j4, m mVar) {
        StringBuilder u10 = l0.u(str, " in ");
        u10.append(g.a(j4));
        u10.append("ms, key: ");
        u10.append(mVar);
        Log.v("Engine", u10.toString());
    }

    public static void f(s sVar) {
        if (!(sVar instanceof n)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((n) sVar).b();
    }

    public final l a(com.bumptech.glide.f fVar, Object obj, x3.c cVar, int i3, int i10, Class cls, Class cls2, Priority priority, h hVar, t4.c cVar2, boolean z5, boolean z6, x3.f fVar2, boolean z8, boolean z10, com.bumptech.glide.request.a aVar, w.a aVar2) {
        long j4;
        if (f7010h) {
            int i11 = g.f18515b;
            j4 = SystemClock.elapsedRealtimeNanos();
        } else {
            j4 = 0;
        }
        this.f7012b.getClass();
        m mVar = new m(obj, cVar, i3, i10, cVar2, cls, cls2, fVar2);
        synchronized (this) {
            try {
                n b3 = b(mVar, z8, j4);
                if (b3 == null) {
                    return g(fVar, obj, cVar, i3, i10, cls, cls2, priority, hVar, cVar2, z5, z6, fVar2, z8, z10, aVar, aVar2, mVar, j4);
                }
                aVar.l(b3, DataSource.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    public final n b(m mVar, boolean z5, long j4) {
        Throwable th2;
        n nVar;
        Object obj;
        c cVar;
        m mVar2;
        n nVar2;
        if (z5) {
            l lVar = this.f7016g;
            synchronized (lVar) {
                try {
                    z3.a aVar = (z3.a) ((HashMap) lVar.f16245b).get(mVar);
                    if (aVar == null) {
                        nVar = null;
                    } else {
                        nVar = (n) aVar.get();
                        if (nVar == null) {
                            try {
                                lVar.f(aVar);
                            } catch (Throwable th3) {
                                th2 = th3;
                                while (true) {
                                    try {
                                        throw th2;
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                    }
                                    th2 = th4;
                                }
                            }
                        }
                    }
                    if (nVar != null) {
                        nVar.a();
                    }
                    if (nVar != null) {
                        if (f7010h) {
                            c("Loaded resource from active resources", j4, mVar);
                        }
                        return nVar;
                    }
                    b4.e eVar = this.f7013c;
                    synchronized (eVar) {
                        try {
                            t4.h hVar = (t4.h) ((LinkedHashMap) eVar.f16252c).remove(mVar);
                            if (hVar == null) {
                                obj = null;
                            } else {
                                eVar.f16251b -= hVar.f18517b;
                                obj = hVar.f18516a;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            while (true) {
                                try {
                                    throw th;
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            }
                        }
                    }
                    s sVar = (s) obj;
                    if (sVar == null) {
                        cVar = this;
                        mVar2 = mVar;
                        nVar2 = null;
                    } else if (sVar instanceof n) {
                        nVar2 = (n) sVar;
                        cVar = this;
                        mVar2 = mVar;
                    } else {
                        cVar = this;
                        mVar2 = mVar;
                        nVar2 = new n(sVar, true, true, mVar2, cVar);
                    }
                    if (nVar2 != null) {
                        nVar2.a();
                        cVar.f7016g.d(mVar2, nVar2);
                    }
                    if (nVar2 != null) {
                        if (f7010h) {
                            c("Loaded resource from cache", j4, mVar2);
                        }
                        return nVar2;
                    }
                } catch (Throwable th7) {
                    th2 = th7;
                }
            }
        }
        return null;
    }

    public final synchronized void d(z3.l lVar, m mVar, n nVar) {
        if (nVar != null) {
            try {
                if (nVar.f20277a) {
                    this.f7016g.d(mVar, nVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        fc.c cVar = this.f7011a;
        cVar.getClass();
        lVar.getClass();
        HashMap hashMap = cVar.f13558a;
        if (lVar.equals(hashMap.get(mVar))) {
            hashMap.remove(mVar);
        }
    }

    public final void e(m mVar, n nVar) {
        l lVar = this.f7016g;
        synchronized (lVar) {
            z3.a aVar = (z3.a) ((HashMap) lVar.f16245b).remove(mVar);
            if (aVar != null) {
                aVar.f20208c = null;
                aVar.clear();
            }
        }
        if (nVar.f20277a) {
        } else {
            this.e.g(nVar, false);
        }
    }

    public final l g(com.bumptech.glide.f fVar, Object obj, x3.c cVar, int i3, int i10, Class cls, Class cls2, Priority priority, h hVar, t4.c cVar2, boolean z5, boolean z6, x3.f fVar2, boolean z8, boolean z10, com.bumptech.glide.request.a aVar, w.a aVar2, m mVar, long j4) {
        c4.c cVar3;
        z3.l lVar = (z3.l) this.f7011a.f13558a.get(mVar);
        if (lVar != null) {
            lVar.a(aVar, aVar2);
            if (f7010h) {
                c("Added to existing load", j4, mVar);
            }
            return new l(this, aVar, lVar);
        }
        z3.l lVar2 = (z3.l) ((l) this.f7014d.f12362h).c();
        synchronized (lVar2) {
            lVar2.f20258k = mVar;
            lVar2.f20259l = z8;
            lVar2.f20260m = z10;
        }
        b0 b0Var = this.f7015f;
        b bVar = (b) ((l) b0Var.f874c).c();
        int i11 = b0Var.f872a;
        b0Var.f872a = i11 + 1;
        z3.f fVar3 = bVar.f6986a;
        fVar3.f20221c = fVar;
        fVar3.f20222d = obj;
        fVar3.f20231n = cVar;
        fVar3.e = i3;
        fVar3.f20223f = i10;
        fVar3.f20233p = hVar;
        fVar3.f20224g = cls;
        fVar3.f20225h = bVar.f6989d;
        fVar3.f20228k = cls2;
        fVar3.f20232o = priority;
        fVar3.f20226i = fVar2;
        fVar3.f20227j = cVar2;
        fVar3.f20234q = z5;
        fVar3.r = z6;
        bVar.f6992h = fVar;
        bVar.f6993i = cVar;
        bVar.f6994j = priority;
        bVar.f6995k = mVar;
        bVar.f6996l = i3;
        bVar.f6997m = i10;
        bVar.f6998n = hVar;
        bVar.f6999o = fVar2;
        bVar.f7000p = lVar2;
        bVar.f7001q = i11;
        bVar.f7002s = DecodeJob$RunReason.INITIALIZE;
        bVar.f7004u = obj;
        fc.c cVar4 = this.f7011a;
        cVar4.getClass();
        cVar4.f13558a.put(mVar, lVar2);
        lVar2.a(aVar, aVar2);
        synchronized (lVar2) {
            lVar2.f20266t = bVar;
            DecodeJob$Stage h4 = bVar.h(DecodeJob$Stage.INITIALIZE);
            if (h4 != DecodeJob$Stage.RESOURCE_CACHE && h4 != DecodeJob$Stage.DATA_CACHE) {
                cVar3 = lVar2.f20260m ? lVar2.f20256i : lVar2.f20255h;
                cVar3.execute(bVar);
            }
            cVar3 = lVar2.f20254g;
            cVar3.execute(bVar);
        }
        if (f7010h) {
            c("Started new load", j4, mVar);
        }
        return new l(this, aVar, lVar2);
    }
}
