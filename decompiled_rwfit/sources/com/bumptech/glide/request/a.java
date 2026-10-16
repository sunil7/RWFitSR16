package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.nc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import n.l;
import p4.c;
import p4.d;
import q4.f;
import q4.g;
import u4.e;
import z3.h;
import z3.s;

/* loaded from: classes.dex */
public final class a implements c, f {
    public static final boolean C = Log.isLoggable("Request", 2);
    public boolean A;
    public final RuntimeException B;

    /* renamed from: a, reason: collision with root package name */
    public final String f7033a;

    /* renamed from: b, reason: collision with root package name */
    public final e f7034b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f7035c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f7036d;
    public final Context e;

    /* renamed from: f, reason: collision with root package name */
    public final com.bumptech.glide.f f7037f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f7038g;

    /* renamed from: h, reason: collision with root package name */
    public final Class f7039h;

    /* renamed from: i, reason: collision with root package name */
    public final p4.a f7040i;

    /* renamed from: j, reason: collision with root package name */
    public final int f7041j;

    /* renamed from: k, reason: collision with root package name */
    public final int f7042k;

    /* renamed from: l, reason: collision with root package name */
    public final Priority f7043l;

    /* renamed from: m, reason: collision with root package name */
    public final g f7044m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f7045n;

    /* renamed from: o, reason: collision with root package name */
    public final r4.a f7046o;

    /* renamed from: p, reason: collision with root package name */
    public final w.a f7047p;

    /* renamed from: q, reason: collision with root package name */
    public s f7048q;
    public l r;

    /* renamed from: s, reason: collision with root package name */
    public long f7049s;

    /* renamed from: t, reason: collision with root package name */
    public volatile com.bumptech.glide.load.engine.c f7050t;

    /* renamed from: u, reason: collision with root package name */
    public SingleRequest$Status f7051u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f7052v;

    /* renamed from: w, reason: collision with root package name */
    public Drawable f7053w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f7054x;

    /* renamed from: y, reason: collision with root package name */
    public int f7055y;

    /* renamed from: z, reason: collision with root package name */
    public int f7056z;

    public a(Context context, com.bumptech.glide.f fVar, Object obj, Object obj2, Class cls, p4.a aVar, int i3, int i10, Priority priority, g gVar, ArrayList arrayList, d dVar, com.bumptech.glide.load.engine.c cVar, r4.a aVar2) {
        w.a aVar3 = t4.f.f18512a;
        this.f7033a = C ? String.valueOf(hashCode()) : null;
        this.f7034b = new e();
        this.f7035c = obj;
        this.e = context;
        this.f7037f = fVar;
        this.f7038g = obj2;
        this.f7039h = cls;
        this.f7040i = aVar;
        this.f7041j = i3;
        this.f7042k = i10;
        this.f7043l = priority;
        this.f7044m = gVar;
        this.f7045n = arrayList;
        this.f7036d = dVar;
        this.f7050t = cVar;
        this.f7046o = aVar2;
        this.f7047p = aVar3;
        this.f7051u = SingleRequest$Status.PENDING;
        if (this.B == null && ((Map) fVar.f6922h.f568b).containsKey(com.bumptech.glide.d.class)) {
            this.B = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // p4.c
    public final boolean a() {
        boolean z5;
        synchronized (this.f7035c) {
            z5 = this.f7051u == SingleRequest$Status.COMPLETE;
        }
        return z5;
    }

    public final void b() {
        if (this.A) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
        this.f7034b.a();
        this.f7044m.c(this);
        l lVar = this.r;
        if (lVar != null) {
            synchronized (((com.bumptech.glide.load.engine.c) lVar.f16247d)) {
                ((z3.l) lVar.f16245b).h((a) lVar.f16246c);
            }
            this.r = null;
        }
    }

    @Override // p4.c
    public final boolean c(c cVar) {
        int i3;
        int i10;
        Object obj;
        Class cls;
        p4.a aVar;
        Priority priority;
        int size;
        int i11;
        int i12;
        Object obj2;
        Class cls2;
        p4.a aVar2;
        Priority priority2;
        int size2;
        if (!(cVar instanceof a)) {
            return false;
        }
        synchronized (this.f7035c) {
            try {
                i3 = this.f7041j;
                i10 = this.f7042k;
                obj = this.f7038g;
                cls = this.f7039h;
                aVar = this.f7040i;
                priority = this.f7043l;
                ArrayList arrayList = this.f7045n;
                size = arrayList != null ? arrayList.size() : 0;
            } finally {
            }
        }
        a aVar3 = (a) cVar;
        synchronized (aVar3.f7035c) {
            try {
                i11 = aVar3.f7041j;
                i12 = aVar3.f7042k;
                obj2 = aVar3.f7038g;
                cls2 = aVar3.f7039h;
                aVar2 = aVar3.f7040i;
                priority2 = aVar3.f7043l;
                ArrayList arrayList2 = aVar3.f7045n;
                size2 = arrayList2 != null ? arrayList2.size() : 0;
            } finally {
            }
        }
        if (i3 != i11 || i10 != i12) {
            return false;
        }
        char[] cArr = t4.l.f18523a;
        return (obj == null ? obj2 == null : obj.equals(obj2)) && cls.equals(cls2) && aVar.equals(aVar2) && priority == priority2 && size == size2;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, p4.d] */
    @Override // p4.c
    public final void clear() {
        synchronized (this.f7035c) {
            try {
                if (this.A) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f7034b.a();
                SingleRequest$Status singleRequest$Status = this.f7051u;
                SingleRequest$Status singleRequest$Status2 = SingleRequest$Status.CLEARED;
                if (singleRequest$Status == singleRequest$Status2) {
                    return;
                }
                b();
                s sVar = this.f7048q;
                if (sVar != null) {
                    this.f7048q = null;
                } else {
                    sVar = null;
                }
                ?? r32 = this.f7036d;
                if (r32 == 0 || r32.l(this)) {
                    this.f7044m.g(d());
                }
                this.f7051u = singleRequest$Status2;
                if (sVar != null) {
                    this.f7050t.getClass();
                    com.bumptech.glide.load.engine.c.f(sVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final Drawable d() {
        if (this.f7053w == null) {
            p4.a aVar = this.f7040i;
            aVar.getClass();
            this.f7053w = null;
            int i3 = aVar.e;
            if (i3 > 0) {
                this.f7053w = h(i3);
            }
        }
        return this.f7053w;
    }

    @Override // p4.c
    public final boolean e() {
        boolean z5;
        synchronized (this.f7035c) {
            z5 = this.f7051u == SingleRequest$Status.CLEARED;
        }
        return z5;
    }

    @Override // p4.c
    public final void f() {
        synchronized (this.f7035c) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, p4.d] */
    @Override // p4.c
    public final void g() {
        synchronized (this.f7035c) {
            try {
                if (this.A) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f7034b.a();
                int i3 = t4.g.f18515b;
                this.f7049s = SystemClock.elapsedRealtimeNanos();
                if (this.f7038g == null) {
                    if (t4.l.h(this.f7041j, this.f7042k)) {
                        this.f7055y = this.f7041j;
                        this.f7056z = this.f7042k;
                    }
                    if (this.f7054x == null) {
                        this.f7040i.getClass();
                        this.f7054x = null;
                    }
                    k(new GlideException("Received null model"), this.f7054x == null ? 5 : 3);
                    return;
                }
                SingleRequest$Status singleRequest$Status = this.f7051u;
                SingleRequest$Status singleRequest$Status2 = SingleRequest$Status.RUNNING;
                if (singleRequest$Status == singleRequest$Status2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (singleRequest$Status == SingleRequest$Status.COMPLETE) {
                    l(this.f7048q, DataSource.MEMORY_CACHE, false);
                    return;
                }
                SingleRequest$Status singleRequest$Status3 = SingleRequest$Status.WAITING_FOR_SIZE;
                this.f7051u = singleRequest$Status3;
                if (t4.l.h(this.f7041j, this.f7042k)) {
                    n(this.f7041j, this.f7042k);
                } else {
                    this.f7044m.a(this);
                }
                SingleRequest$Status singleRequest$Status4 = this.f7051u;
                if (singleRequest$Status4 == singleRequest$Status2 || singleRequest$Status4 == singleRequest$Status3) {
                    ?? r22 = this.f7036d;
                    if (r22 == 0 || r22.d(this)) {
                        this.f7044m.e(d());
                    }
                }
                if (C) {
                    j("finished run method in " + t4.g.a(this.f7049s));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final Drawable h(int i3) {
        this.f7040i.getClass();
        Resources.Theme theme = this.e.getTheme();
        com.bumptech.glide.f fVar = this.f7037f;
        return nc.a(fVar, fVar, i3, theme);
    }

    @Override // p4.c
    public final boolean i() {
        boolean z5;
        synchronized (this.f7035c) {
            z5 = this.f7051u == SingleRequest$Status.COMPLETE;
        }
        return z5;
    }

    @Override // p4.c
    public final boolean isRunning() {
        boolean z5;
        synchronized (this.f7035c) {
            try {
                SingleRequest$Status singleRequest$Status = this.f7051u;
                z5 = singleRequest$Status == SingleRequest$Status.RUNNING || singleRequest$Status == SingleRequest$Status.WAITING_FOR_SIZE;
            } finally {
            }
        }
        return z5;
    }

    public final void j(String str) {
        StringBuilder u10 = l0.u(str, " this: ");
        u10.append(this.f7033a);
        Log.v("Request", u10.toString());
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, p4.d] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object, p4.d] */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.lang.Object, p4.d] */
    public final void k(GlideException glideException, int i3) {
        Drawable drawable;
        this.f7034b.a();
        synchronized (this.f7035c) {
            try {
                glideException.setOrigin(this.B);
                int i10 = this.f7037f.f6923i;
                if (i10 <= i3) {
                    Log.w("Glide", "Load failed for " + this.f7038g + " with size [" + this.f7055y + "x" + this.f7056z + "]", glideException);
                    if (i10 <= 4) {
                        glideException.logRootCauses("Glide");
                    }
                }
                this.r = null;
                this.f7051u = SingleRequest$Status.FAILED;
                boolean z5 = true;
                this.A = true;
                try {
                    ArrayList arrayList = this.f7045n;
                    if (arrayList != null) {
                        Iterator it = arrayList.iterator();
                        if (it.hasNext()) {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            ?? r62 = this.f7036d;
                            if (r62 == 0) {
                                throw null;
                            }
                            r62.b().a();
                            throw null;
                        }
                    }
                    ?? r22 = this.f7036d;
                    if (r22 != 0 && !r22.d(this)) {
                        z5 = false;
                    }
                    if (this.f7038g == null) {
                        if (this.f7054x == null) {
                            this.f7040i.getClass();
                            this.f7054x = null;
                        }
                        drawable = this.f7054x;
                    } else {
                        drawable = null;
                    }
                    if (drawable == null) {
                        if (this.f7052v == null) {
                            p4.a aVar = this.f7040i;
                            aVar.getClass();
                            this.f7052v = null;
                            int i11 = aVar.f17454d;
                            if (i11 > 0) {
                                this.f7052v = h(i11);
                            }
                        }
                        drawable = this.f7052v;
                    }
                    if (drawable == null) {
                        drawable = d();
                    }
                    this.f7044m.b(drawable);
                    this.A = false;
                    ?? r52 = this.f7036d;
                    if (r52 != 0) {
                        r52.j(this);
                    }
                } catch (Throwable th2) {
                    this.A = false;
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r9v14, types: [java.lang.Object, p4.d] */
    public final void l(s sVar, DataSource dataSource, boolean z5) {
        this.f7034b.a();
        s sVar2 = null;
        try {
            synchronized (this.f7035c) {
                try {
                    this.r = null;
                    if (sVar == null) {
                        k(new GlideException("Expected to receive a Resource<R> with an object of " + this.f7039h + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = sVar.get();
                    try {
                        if (obj != null && this.f7039h.isAssignableFrom(obj.getClass())) {
                            ?? r9 = this.f7036d;
                            if (r9 == 0 || r9.k(this)) {
                                m(sVar, obj, dataSource);
                                return;
                            }
                            this.f7048q = null;
                            this.f7051u = SingleRequest$Status.COMPLETE;
                            this.f7050t.getClass();
                            com.bumptech.glide.load.engine.c.f(sVar);
                        }
                        this.f7048q = null;
                        StringBuilder sb2 = new StringBuilder("Expected to receive an object of ");
                        sb2.append(this.f7039h);
                        sb2.append(" but instead got ");
                        sb2.append(obj != null ? obj.getClass() : "");
                        sb2.append(Const.STR_MART_JSON_BEGIN);
                        sb2.append(obj);
                        sb2.append("} inside Resource{");
                        sb2.append(sVar);
                        sb2.append("}.");
                        sb2.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        k(new GlideException(sb2.toString()), 5);
                        this.f7050t.getClass();
                        com.bumptech.glide.load.engine.c.f(sVar);
                    } catch (Throwable th2) {
                        sVar2 = sVar;
                        th = th2;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            if (sVar2 != null) {
                this.f7050t.getClass();
                com.bumptech.glide.load.engine.c.f(sVar2);
            }
            throw th4;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, p4.d] */
    public final void m(s sVar, Object obj, DataSource dataSource) {
        ?? r02 = this.f7036d;
        if (r02 != 0) {
            r02.b().a();
        }
        this.f7051u = SingleRequest$Status.COMPLETE;
        this.f7048q = sVar;
        if (this.f7037f.f6923i <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + dataSource + " for " + this.f7038g + " with size [" + this.f7055y + "x" + this.f7056z + "] in " + t4.g.a(this.f7049s) + " ms");
        }
        this.A = true;
        try {
            ArrayList arrayList = this.f7045n;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
            this.f7046o.getClass();
            this.f7044m.h(obj);
            this.A = false;
            if (r02 != 0) {
                r02.h(this);
            }
        } catch (Throwable th2) {
            this.A = false;
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(int i3, int i10) {
        a aVar = this;
        int i11 = i3;
        aVar.f7034b.a();
        Object obj = aVar.f7035c;
        synchronized (obj) {
            try {
                try {
                    boolean z5 = C;
                    if (z5) {
                        aVar.j("Got onSizeReady in " + t4.g.a(aVar.f7049s));
                    }
                    if (aVar.f7051u == SingleRequest$Status.WAITING_FOR_SIZE) {
                        SingleRequest$Status singleRequest$Status = SingleRequest$Status.RUNNING;
                        aVar.f7051u = singleRequest$Status;
                        aVar.f7040i.getClass();
                        if (i11 != Integer.MIN_VALUE) {
                            i11 = Math.round(i11 * 1.0f);
                        }
                        aVar.f7055y = i11;
                        aVar.f7056z = i10 == Integer.MIN_VALUE ? i10 : Math.round(1.0f * i10);
                        if (z5) {
                            aVar.j("finished setup for calling load in " + t4.g.a(aVar.f7049s));
                        }
                        com.bumptech.glide.load.engine.c cVar = aVar.f7050t;
                        com.bumptech.glide.f fVar = aVar.f7037f;
                        Object obj2 = aVar.f7038g;
                        p4.a aVar2 = aVar.f7040i;
                        x3.c cVar2 = aVar2.f17458i;
                        try {
                            int i12 = aVar.f7055y;
                            int i13 = aVar.f7056z;
                            Class cls = aVar2.f17462m;
                            try {
                                Class cls2 = aVar.f7039h;
                                Priority priority = aVar.f7043l;
                                h hVar = aVar2.f17452b;
                                try {
                                    t4.c cVar3 = aVar2.f17461l;
                                    boolean z6 = aVar2.f17459j;
                                    boolean z8 = aVar2.f17465p;
                                    try {
                                        x3.f fVar2 = aVar2.f17460k;
                                        boolean z10 = aVar2.f17455f;
                                        boolean z11 = aVar2.f17466q;
                                        w.a aVar3 = aVar.f7047p;
                                        aVar = obj;
                                        try {
                                            aVar.r = cVar.a(fVar, obj2, cVar2, i12, i13, cls, cls2, priority, hVar, cVar3, z6, z8, fVar2, z10, z11, aVar, aVar3);
                                            if (aVar.f7051u != singleRequest$Status) {
                                                aVar.r = null;
                                            }
                                            if (z5) {
                                                aVar.j("finished onSizeReady in " + t4.g.a(aVar.f7049s));
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        aVar = obj;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    aVar = obj;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                aVar = obj;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            aVar = obj;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Throwable th8) {
                th = th8;
                aVar = obj;
            }
        }
    }
}
