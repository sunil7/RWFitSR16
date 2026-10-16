package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import yb.m;
import yb.n;
import yb.p;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal f11161a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f11162b;

    /* renamed from: c, reason: collision with root package name */
    public final ef.i f11163c;

    /* renamed from: d, reason: collision with root package name */
    public final yb.c f11164d;
    public final List e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11165f;

    static {
        new bc.a(Object.class);
    }

    public e() {
        int i3 = 1;
        int i10 = 0;
        com.google.gson.internal.c cVar = com.google.gson.internal.c.f11176c;
        FieldNamingPolicy fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        Map map = Collections.EMPTY_MAP;
        LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        List list = Collections.EMPTY_LIST;
        this.f11161a = new ThreadLocal();
        this.f11162b = new ConcurrentHashMap();
        ef.i iVar = new ef.i(15);
        this.f11163c = iVar;
        this.f11165f = true;
        ArrayList arrayList = new ArrayList();
        arrayList.add(p.A);
        arrayList.add(yb.g.f20056b);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(p.f20100p);
        arrayList.add(p.f20091g);
        arrayList.add(p.f20089d);
        arrayList.add(p.e);
        arrayList.add(p.f20090f);
        b bVar = p.f20095k;
        arrayList.add(new n(Long.TYPE, Long.class, bVar));
        arrayList.add(new n(Double.TYPE, Double.class, new b(i10)));
        arrayList.add(new n(Float.TYPE, Float.class, new b(i3)));
        arrayList.add(p.f20096l);
        arrayList.add(p.f20092h);
        arrayList.add(p.f20093i);
        arrayList.add(new m(AtomicLong.class, new c(new c(bVar, 0), 2), i10));
        arrayList.add(new m(AtomicLongArray.class, new c(new c(bVar, 1), 2), i10));
        arrayList.add(p.f20094j);
        arrayList.add(p.f20097m);
        arrayList.add(p.f20101q);
        arrayList.add(p.r);
        arrayList.add(new m(BigDecimal.class, p.f20098n, i10));
        arrayList.add(new m(BigInteger.class, p.f20099o, i10));
        arrayList.add(p.f20102s);
        arrayList.add(p.f20103t);
        arrayList.add(p.f20105v);
        arrayList.add(p.f20106w);
        arrayList.add(p.f20109z);
        arrayList.add(p.f20104u);
        arrayList.add(p.f20087b);
        arrayList.add(yb.d.f20048c);
        arrayList.add(p.f20108y);
        arrayList.add(yb.k.f20073d);
        arrayList.add(yb.k.f20072c);
        arrayList.add(p.f20107x);
        arrayList.add(yb.b.f20042d);
        arrayList.add(p.f20086a);
        arrayList.add(new yb.c(iVar, i10));
        arrayList.add(new yb.c(iVar, 2));
        yb.c cVar2 = new yb.c(iVar, i3);
        this.f11164d = cVar2;
        arrayList.add(cVar2);
        arrayList.add(p.B);
        arrayList.add(new yb.j(iVar, fieldNamingPolicy, cVar, cVar2));
        this.e = Collections.unmodifiableList(arrayList);
    }

    public static void a(double d5) {
        if (Double.isNaN(d5) || Double.isInfinite(d5)) {
            throw new IllegalArgumentException(d5 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r5, java.lang.reflect.Type r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            java.io.StringReader r1 = new java.io.StringReader
            r1.<init>(r5)
            cc.a r5 = new cc.a
            r5.<init>(r1)
            java.lang.String r1 = "AssertionError (GSON 2.8.6): "
            r2 = 1
            r5.f3428b = r2
            r3 = 0
            r5.b0()     // Catch: java.lang.Throwable -> L27 java.lang.AssertionError -> L29 java.io.IOException -> L2b java.lang.IllegalStateException -> L2d java.io.EOFException -> L57
            bc.a r2 = new bc.a     // Catch: java.lang.Throwable -> L27 java.lang.AssertionError -> L29 java.io.IOException -> L2b java.lang.IllegalStateException -> L2d java.io.EOFException -> L2f
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L27 java.lang.AssertionError -> L29 java.io.IOException -> L2b java.lang.IllegalStateException -> L2d java.io.EOFException -> L2f
            com.google.gson.k r6 = r4.c(r2)     // Catch: java.lang.Throwable -> L27 java.lang.AssertionError -> L29 java.io.IOException -> L2b java.lang.IllegalStateException -> L2d java.io.EOFException -> L2f
            java.lang.Object r0 = r6.a(r5)     // Catch: java.lang.Throwable -> L27 java.lang.AssertionError -> L29 java.io.IOException -> L2b java.lang.IllegalStateException -> L2d java.io.EOFException -> L2f
        L24:
            r5.f3428b = r3
            goto L5b
        L27:
            r6 = move-exception
            goto L85
        L29:
            r6 = move-exception
            goto L32
        L2b:
            r6 = move-exception
            goto L4b
        L2d:
            r6 = move-exception
            goto L51
        L2f:
            r6 = move-exception
            r2 = r3
            goto L58
        L32:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L27
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L27
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L27
            java.lang.String r1 = r6.getMessage()     // Catch: java.lang.Throwable -> L27
            r2.append(r1)     // Catch: java.lang.Throwable -> L27
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L27
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L27
            r0.initCause(r6)     // Catch: java.lang.Throwable -> L27
            throw r0     // Catch: java.lang.Throwable -> L27
        L4b:
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException     // Catch: java.lang.Throwable -> L27
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L27
            throw r0     // Catch: java.lang.Throwable -> L27
        L51:
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException     // Catch: java.lang.Throwable -> L27
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L27
            throw r0     // Catch: java.lang.Throwable -> L27
        L57:
            r6 = move-exception
        L58:
            if (r2 == 0) goto L7f
            goto L24
        L5b:
            if (r0 == 0) goto L7e
            com.google.gson.stream.JsonToken r5 = r5.b0()     // Catch: java.io.IOException -> L6e com.google.gson.stream.MalformedJsonException -> L70
            com.google.gson.stream.JsonToken r6 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch: java.io.IOException -> L6e com.google.gson.stream.MalformedJsonException -> L70
            if (r5 != r6) goto L66
            goto L7e
        L66:
            com.google.gson.JsonIOException r5 = new com.google.gson.JsonIOException     // Catch: java.io.IOException -> L6e com.google.gson.stream.MalformedJsonException -> L70
            java.lang.String r6 = "JSON document was not fully consumed."
            r5.<init>(r6)     // Catch: java.io.IOException -> L6e com.google.gson.stream.MalformedJsonException -> L70
            throw r5     // Catch: java.io.IOException -> L6e com.google.gson.stream.MalformedJsonException -> L70
        L6e:
            r5 = move-exception
            goto L72
        L70:
            r5 = move-exception
            goto L78
        L72:
            com.google.gson.JsonIOException r6 = new com.google.gson.JsonIOException
            r6.<init>(r5)
            throw r6
        L78:
            com.google.gson.JsonSyntaxException r6 = new com.google.gson.JsonSyntaxException
            r6.<init>(r5)
            throw r6
        L7e:
            return r0
        L7f:
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException     // Catch: java.lang.Throwable -> L27
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L27
            throw r0     // Catch: java.lang.Throwable -> L27
        L85:
            r5.f3428b = r3
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.e.b(java.lang.String, java.lang.reflect.Type):java.lang.Object");
    }

    public final k c(bc.a aVar) {
        boolean z5;
        ConcurrentHashMap concurrentHashMap = this.f11162b;
        k kVar = (k) concurrentHashMap.get(aVar);
        if (kVar != null) {
            return kVar;
        }
        ThreadLocal threadLocal = this.f11161a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z5 = true;
        } else {
            z5 = false;
        }
        d dVar = (d) map.get(aVar);
        if (dVar != null) {
            return dVar;
        }
        try {
            d dVar2 = new d();
            map.put(aVar, dVar2);
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                k a3 = ((l) it.next()).a(this, aVar);
                if (a3 != null) {
                    if (dVar2.f11160a != null) {
                        throw new AssertionError();
                    }
                    dVar2.f11160a = a3;
                    concurrentHashMap.put(aVar, a3);
                    map.remove(aVar);
                    if (z5) {
                        threadLocal.remove();
                    }
                    return a3;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.6) cannot handle " + aVar);
        } catch (Throwable th2) {
            map.remove(aVar);
            if (z5) {
                threadLocal.remove();
            }
            throw th2;
        }
    }

    public final cc.b d(Writer writer) {
        cc.b bVar = new cc.b(writer);
        bVar.f3449h = false;
        return bVar;
    }

    public final String e(Object obj) {
        if (obj == null) {
            StringWriter stringWriter = new StringWriter();
            try {
                f(d(stringWriter));
                return stringWriter.toString();
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        }
        Class cls = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            g(obj, cls, d(stringWriter2));
            return stringWriter2.toString();
        } catch (IOException e10) {
            throw new JsonIOException(e10);
        }
    }

    public final void f(cc.b bVar) {
        h hVar = h.f11167a;
        boolean z5 = bVar.e;
        bVar.e = true;
        boolean z6 = bVar.f3447f;
        bVar.f3447f = this.f11165f;
        boolean z8 = bVar.f3449h;
        bVar.f3449h = false;
        try {
            try {
                com.google.gson.internal.a.k(bVar, hVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            } catch (AssertionError e10) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e10.getMessage());
                assertionError.initCause(e10);
                throw assertionError;
            }
        } finally {
            bVar.e = z5;
            bVar.f3447f = z6;
            bVar.f3449h = z8;
        }
    }

    public final void g(Object obj, Class cls, cc.b bVar) {
        k c9 = c(new bc.a(cls));
        boolean z5 = bVar.e;
        bVar.e = true;
        boolean z6 = bVar.f3447f;
        bVar.f3447f = this.f11165f;
        boolean z8 = bVar.f3449h;
        bVar.f3449h = false;
        try {
            try {
                try {
                    c9.b(bVar, obj);
                } catch (IOException e) {
                    throw new JsonIOException(e);
                }
            } catch (AssertionError e10) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e10.getMessage());
                assertionError.initCause(e10);
                throw assertionError;
            }
        } finally {
            bVar.e = z5;
            bVar.f3447f = z6;
            bVar.f3449h = z8;
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.e + ",instanceCreators:" + this.f11163c + "}";
    }
}
