package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import ia.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import t4.l;

/* loaded from: classes.dex */
public final class i extends p4.a {
    public final boolean A = true;
    public boolean B;
    public boolean C;
    public final Context r;

    /* renamed from: s, reason: collision with root package name */
    public final j f6936s;

    /* renamed from: t, reason: collision with root package name */
    public final Class f6937t;

    /* renamed from: u, reason: collision with root package name */
    public final f f6938u;

    /* renamed from: v, reason: collision with root package name */
    public a f6939v;

    /* renamed from: w, reason: collision with root package name */
    public Object f6940w;

    /* renamed from: x, reason: collision with root package name */
    public ArrayList f6941x;

    /* renamed from: y, reason: collision with root package name */
    public i f6942y;

    /* renamed from: z, reason: collision with root package name */
    public i f6943z;

    static {
    }

    public i(b bVar, j jVar, Class cls, Context context) {
        p4.e eVar;
        this.f6936s = jVar;
        this.f6937t = cls;
        this.r = context;
        m0.b bVar2 = jVar.f6945a.f6910c.f6920f;
        a aVar = (a) bVar2.getOrDefault(cls, null);
        if (aVar == null) {
            Iterator it = ((m0.h) bVar2.entrySet()).iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    aVar = (a) entry.getValue();
                }
            }
        }
        this.f6939v = aVar == null ? f.f6915k : aVar;
        this.f6938u = bVar.f6910c;
        Iterator it2 = jVar.f6952i.iterator();
        while (it2.hasNext()) {
            if (it2.next() != null) {
                throw new ClassCastException();
            }
            t();
        }
        synchronized (jVar) {
            eVar = jVar.f6953j;
        }
        a(eVar);
    }

    public final i t() {
        if (this.f17464o) {
            return b().t();
        }
        l();
        return this;
    }

    @Override // p4.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public final i a(p4.a aVar) {
        t4.f.b(aVar);
        return (i) super.a(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p4.c v(Object obj, q4.g gVar, p4.d dVar, a aVar, Priority priority, int i3, int i10, p4.a aVar2) {
        p4.d dVar2;
        p4.d dVar3;
        p4.a aVar3;
        com.bumptech.glide.request.a aVar4;
        Priority priority2;
        if (this.f6943z != null) {
            dVar3 = new p4.b(obj, dVar);
            dVar2 = dVar3;
        } else {
            dVar2 = null;
            dVar3 = dVar;
        }
        i iVar = this.f6942y;
        if (iVar == null) {
            Object obj2 = this.f6940w;
            ArrayList arrayList = this.f6941x;
            f fVar = this.f6938u;
            aVar3 = aVar2;
            aVar4 = new com.bumptech.glide.request.a(this.r, fVar, obj, obj2, this.f6937t, aVar3, i3, i10, priority, gVar, arrayList, dVar3, fVar.f6921g, aVar.f6905a);
        } else {
            if (this.C) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            a aVar5 = iVar.A ? aVar : iVar.f6939v;
            if (p4.a.f(iVar.f17451a, 8)) {
                priority2 = this.f6942y.f17453c;
            } else {
                int i11 = h.f6935b[priority.ordinal()];
                if (i11 == 1) {
                    priority2 = Priority.NORMAL;
                } else if (i11 == 2) {
                    priority2 = Priority.HIGH;
                } else {
                    if (i11 != 3 && i11 != 4) {
                        throw new IllegalArgumentException("unknown priority: " + this.f17453c);
                    }
                    priority2 = Priority.IMMEDIATE;
                }
            }
            Priority priority3 = priority2;
            i iVar2 = this.f6942y;
            int i12 = iVar2.f17457h;
            int i13 = iVar2.f17456g;
            if (l.h(i3, i10)) {
                i iVar3 = this.f6942y;
                if (!l.h(iVar3.f17457h, iVar3.f17456g)) {
                    i12 = aVar2.f17457h;
                    i13 = aVar2.f17456g;
                }
            }
            int i14 = i13;
            int i15 = i12;
            p4.f fVar2 = new p4.f(obj, dVar3);
            Object obj3 = this.f6940w;
            ArrayList arrayList2 = this.f6941x;
            p4.f fVar3 = fVar2;
            f fVar4 = this.f6938u;
            com.bumptech.glide.request.a aVar6 = new com.bumptech.glide.request.a(this.r, fVar4, obj, obj3, this.f6937t, aVar2, i3, i10, priority, gVar, arrayList2, fVar3, fVar4.f6921g, aVar.f6905a);
            this.C = true;
            i iVar4 = this.f6942y;
            p4.c v6 = iVar4.v(obj, gVar, fVar3, aVar5, priority3, i15, i14, iVar4);
            this.C = false;
            fVar3.f17474c = aVar6;
            fVar3.f17475d = v6;
            aVar3 = aVar2;
            aVar4 = fVar3;
        }
        if (dVar2 == null) {
            return aVar4;
        }
        i iVar5 = this.f6943z;
        int i16 = iVar5.f17457h;
        int i17 = iVar5.f17456g;
        if (l.h(i3, i10)) {
            i iVar6 = this.f6943z;
            if (!l.h(iVar6.f17457h, iVar6.f17456g)) {
                i16 = aVar3.f17457h;
                i17 = aVar3.f17456g;
            }
        }
        int i18 = i17;
        i iVar7 = this.f6943z;
        p4.b bVar = dVar2;
        p4.c v9 = iVar7.v(obj, gVar, bVar, iVar7.f6939v, iVar7.f17453c, i16, i18, iVar7);
        bVar.f17469c = aVar4;
        bVar.f17470d = v9;
        return bVar;
    }

    @Override // p4.a
    /* renamed from: w, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final i clone() {
        i iVar = (i) super.clone();
        iVar.f6939v = iVar.f6939v.clone();
        if (iVar.f6941x != null) {
            iVar.f6941x = new ArrayList(iVar.f6941x);
        }
        i iVar2 = iVar.f6942y;
        if (iVar2 != null) {
            iVar.f6942y = iVar2.b();
        }
        i iVar3 = iVar.f6943z;
        if (iVar3 != null) {
            iVar.f6943z = iVar3.b();
        }
        return iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(android.widget.ImageView r5) {
        /*
            r4 = this;
            r0 = 0
            char[] r1 = t4.l.f18523a
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            if (r1 != r2) goto Lb3
            t4.f.b(r5)
            int r1 = r4.f17451a
            r2 = 2048(0x800, float:2.87E-42)
            boolean r1 = p4.a.f(r1, r2)
            if (r1 != 0) goto L70
            android.widget.ImageView$ScaleType r1 = r5.getScaleType()
            if (r1 == 0) goto L70
            int[] r1 = com.bumptech.glide.h.f6934a
            android.widget.ImageView$ScaleType r2 = r5.getScaleType()
            int r2 = r2.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L60;
                case 2: goto L50;
                case 3: goto L40;
                case 4: goto L40;
                case 5: goto L40;
                case 6: goto L30;
                default: goto L2f;
            }
        L2f:
            goto L70
        L30:
            com.bumptech.glide.i r1 = r4.b()
            g4.m r2 = g4.m.f13829c
            g4.h r3 = new g4.h
            r3.<init>()
            p4.a r1 = r1.k(r2, r3, r0)
            goto L71
        L40:
            com.bumptech.glide.i r1 = r4.b()
            g4.m r2 = g4.m.f13828b
            g4.t r3 = new g4.t
            r3.<init>()
            p4.a r1 = r1.k(r2, r3, r0)
            goto L71
        L50:
            com.bumptech.glide.i r1 = r4.b()
            g4.m r2 = g4.m.f13829c
            g4.h r3 = new g4.h
            r3.<init>()
            p4.a r1 = r1.k(r2, r3, r0)
            goto L71
        L60:
            com.bumptech.glide.i r1 = r4.b()
            g4.m r2 = g4.m.f13830d
            g4.g r3 = new g4.g
            r3.<init>()
            p4.a r1 = r1.g(r2, r3)
            goto L71
        L70:
            r1 = r4
        L71:
            com.bumptech.glide.f r2 = r4.f6938u
            hc.a r2 = r2.f6918c
            r2.getClass()
            java.lang.Class<android.graphics.Bitmap> r2 = android.graphics.Bitmap.class
            java.lang.Class r3 = r4.f6937t
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L88
            q4.b r2 = new q4.b
            r2.<init>(r5, r0)
            goto L96
        L88:
            java.lang.Class<android.graphics.drawable.Drawable> r0 = android.graphics.drawable.Drawable.class
            boolean r0 = r0.isAssignableFrom(r3)
            if (r0 == 0) goto L9a
            q4.b r2 = new q4.b
            r0 = 1
            r2.<init>(r5, r0)
        L96:
            r4.y(r2, r1)
            return
        L9a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unhandled class: "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r1 = ", try .as*(Class).transcode(ResourceTranscoder)"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        Lb3:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "You must call this method on the main thread"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.i.x(android.widget.ImageView):void");
    }

    public final void y(q4.g gVar, p4.a aVar) {
        t4.f.b(gVar);
        if (!this.B) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        p4.c v6 = v(new Object(), gVar, null, this.f6939v, aVar.f17453c, aVar.f17457h, aVar.f17456g, aVar);
        p4.c f2 = gVar.f();
        if (v6.c(f2) && (aVar.f17455f || !f2.i())) {
            t4.f.c(f2, "Argument must not be null");
            if (f2.isRunning()) {
                return;
            }
            f2.g();
            return;
        }
        this.f6936s.k(gVar);
        gVar.d(v6);
        j jVar = this.f6936s;
        synchronized (jVar) {
            jVar.f6949f.f15967a.add(gVar);
            k kVar = jVar.f6948d;
            ((Set) kVar.f14394c).add(v6);
            if (kVar.f14393b) {
                v6.clear();
                if (Log.isLoggable("RequestTracker", 2)) {
                    Log.v("RequestTracker", "Paused, delaying request");
                }
                ((ArrayList) kVar.f14395d).add(v6);
            } else {
                v6.g();
            }
        }
    }

    public final i z(Object obj) {
        if (this.f17464o) {
            return b().z(obj);
        }
        this.f6940w = obj;
        this.B = true;
        l();
        return this;
    }
}
