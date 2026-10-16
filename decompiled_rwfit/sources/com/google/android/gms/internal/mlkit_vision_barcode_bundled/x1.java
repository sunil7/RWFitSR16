package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.security.AccessController;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class x1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f9841a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f9842b;

    /* renamed from: c, reason: collision with root package name */
    public static final w1 f9843c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f9844d;
    public static final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f9845f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f9846g;

    /* JADX WARN: Can't wrap try/catch for region: R(21:0|1|(18:(1:65)(1:(1:67))|4|(7:43|44|45|46|47|(4:51|52|(1:54)|57)|(14:50|8|(14:36|37|38|39|11|12|13|(3:26|27|(6:31|(1:19)|20|(1:22)|23|24))|15|(2:17|19)|20|(0)|23|24)|10|11|12|13|(0)|15|(0)|20|(0)|23|24))|6|7|8|(0)|10|11|12|13|(0)|15|(0)|20|(0)|23|24)|3|4|(0)|6|7|8|(0)|10|11|12|13|(0)|15|(0)|20|(0)|23|24) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0157, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0078, code lost:
    
        if (r0.getType() == r2) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0050  */
    static {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.x1.<clinit>():void");
    }

    public static void a(Class cls) {
        if (e) {
            f9843c.f9838a.arrayIndexScale(cls);
        }
    }

    public static void b(Object obj, long j4, byte b3) {
        w1 w1Var = f9843c;
        long j10 = (-4) & j4;
        int i3 = w1Var.f9838a.getInt(obj, j10);
        int i10 = ((~((int) j4)) & 3) << 3;
        w1Var.f9838a.putInt(obj, j10, ((255 & b3) << i10) | (i3 & (~(255 << i10))));
    }

    public static void c(Object obj, long j4, byte b3) {
        w1 w1Var = f9843c;
        long j10 = (-4) & j4;
        int i3 = (((int) j4) & 3) << 3;
        w1Var.f9838a.putInt(obj, j10, ((255 & b3) << i3) | (w1Var.f9838a.getInt(obj, j10) & (~(255 << i3))));
    }

    public static int d(long j4, Object obj) {
        return f9843c.f9838a.getInt(obj, j4);
    }

    public static long e(long j4, Object obj) {
        return f9843c.f9838a.getLong(obj, j4);
    }

    public static Object f(Class cls) {
        try {
            return f9841a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static Object g(long j4, Object obj) {
        return f9843c.f9838a.getObject(obj, j4);
    }

    public static Unsafe h() {
        try {
            return (Unsafe) AccessController.doPrivileged(new t1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void i(int i3, Object obj, long j4) {
        f9843c.f9838a.putInt(obj, j4, i3);
    }

    public static void j(Object obj, long j4, long j10) {
        f9843c.f9838a.putLong(obj, j4, j10);
    }

    public static void k(Object obj, long j4, Object obj2) {
        f9843c.f9838a.putObject(obj, j4, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean l(long j4, Object obj) {
        return ((byte) ((f9843c.f9838a.getInt(obj, (-4) & j4) >>> ((int) (((~j4) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean m(long j4, Object obj) {
        return ((byte) ((f9843c.f9838a.getInt(obj, (-4) & j4) >>> ((int) ((j4 & 3) << 3))) & 255)) != 0;
    }

    public static boolean n(Class cls) {
        int i3 = r.f9821a;
        try {
            Class cls2 = f9842b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int o(Class cls) {
        if (e) {
            return f9843c.f9838a.arrayBaseOffset(cls);
        }
        return -1;
    }
}
