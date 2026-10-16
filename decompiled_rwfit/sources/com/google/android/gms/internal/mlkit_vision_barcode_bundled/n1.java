package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class n1 {

    /* renamed from: a, reason: collision with root package name */
    public static final g0 f9806a;

    static {
        g1 g1Var = g1.f9786c;
        f9806a = new g0(6);
    }

    public static void A(int i3, List list, x0 x0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0Var.getClass();
        if (list instanceof w0) {
            throw new ClassCastException();
        }
        z zVar = (z) x0Var.f9840a;
        int i10 = 0;
        if (!z5) {
            while (i10 < list.size()) {
                zVar.h(i3, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        zVar.m(i3, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Long) list.get(i12)).getClass();
            i11 += 8;
        }
        zVar.o(i11);
        while (i10 < list.size()) {
            zVar.i(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void a(int i3, List list, x0 x0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0Var.getClass();
        boolean z6 = list instanceof m0;
        int i10 = 0;
        z zVar = (z) x0Var.f9840a;
        if (!z6) {
            if (!z5) {
                while (i10 < list.size()) {
                    int intValue = ((Integer) list.get(i10)).intValue();
                    zVar.n(i3, (intValue >> 31) ^ (intValue + intValue));
                    i10++;
                }
                return;
            }
            zVar.m(i3, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                int intValue2 = ((Integer) list.get(i12)).intValue();
                i11 += z.a((intValue2 >> 31) ^ (intValue2 + intValue2));
            }
            zVar.o(i11);
            while (i10 < list.size()) {
                int intValue3 = ((Integer) list.get(i10)).intValue();
                zVar.o((intValue3 >> 31) ^ (intValue3 + intValue3));
                i10++;
            }
            return;
        }
        m0 m0Var = (m0) list;
        if (!z5) {
            while (i10 < m0Var.f9805c) {
                int c9 = m0Var.c(i10);
                zVar.n(i3, (c9 >> 31) ^ (c9 + c9));
                i10++;
            }
            return;
        }
        zVar.m(i3, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < m0Var.f9805c; i14++) {
            int c10 = m0Var.c(i14);
            i13 += z.a((c10 >> 31) ^ (c10 + c10));
        }
        zVar.o(i13);
        while (i10 < m0Var.f9805c) {
            int c11 = m0Var.c(i10);
            zVar.o((c11 >> 31) ^ (c11 + c11));
            i10++;
        }
    }

    public static void b(int i3, List list, x0 x0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0Var.getClass();
        if (list instanceof w0) {
            throw new ClassCastException();
        }
        z zVar = (z) x0Var.f9840a;
        int i10 = 0;
        if (!z5) {
            while (i10 < list.size()) {
                long longValue = ((Long) list.get(i10)).longValue();
                zVar.p(i3, (longValue >> 63) ^ (longValue + longValue));
                i10++;
            }
            return;
        }
        zVar.m(i3, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            long longValue2 = ((Long) list.get(i12)).longValue();
            i11 += z.b((longValue2 >> 63) ^ (longValue2 + longValue2));
        }
        zVar.o(i11);
        while (i10 < list.size()) {
            long longValue3 = ((Long) list.get(i10)).longValue();
            zVar.q((longValue3 >> 63) ^ (longValue3 + longValue3));
            i10++;
        }
    }

    public static void c(int i3, List list, x0 x0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0Var.getClass();
        boolean z6 = list instanceof m0;
        int i10 = 0;
        z zVar = (z) x0Var.f9840a;
        if (!z6) {
            if (!z5) {
                while (i10 < list.size()) {
                    zVar.n(i3, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            zVar.m(i3, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                i11 += z.a(((Integer) list.get(i12)).intValue());
            }
            zVar.o(i11);
            while (i10 < list.size()) {
                zVar.o(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        m0 m0Var = (m0) list;
        if (!z5) {
            while (i10 < m0Var.f9805c) {
                zVar.n(i3, m0Var.c(i10));
                i10++;
            }
            return;
        }
        zVar.m(i3, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < m0Var.f9805c; i14++) {
            i13 += z.a(m0Var.c(i14));
        }
        zVar.o(i13);
        while (i10 < m0Var.f9805c) {
            zVar.o(m0Var.c(i10));
            i10++;
        }
    }

    public static void d(int i3, List list, x0 x0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0Var.getClass();
        if (list instanceof w0) {
            throw new ClassCastException();
        }
        z zVar = (z) x0Var.f9840a;
        int i10 = 0;
        if (!z5) {
            while (i10 < list.size()) {
                zVar.p(i3, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        zVar.m(i3, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            i11 += z.b(((Long) list.get(i12)).longValue());
        }
        zVar.o(i11);
        while (i10 < list.size()) {
            zVar.q(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static boolean e(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int f(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof m0)) {
            int i10 = 0;
            while (i3 < size) {
                i10 += z.b(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return i10;
        }
        m0 m0Var = (m0) list;
        int i11 = 0;
        while (i3 < size) {
            i11 += z.b(m0Var.c(i3));
            i3++;
        }
        return i11;
    }

    public static int g(int i3, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (z.a(i3 << 3) + 4) * size;
    }

    public static int h(int i3, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (z.a(i3 << 3) + 8) * size;
    }

    public static int i(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof m0)) {
            int i10 = 0;
            while (i3 < size) {
                i10 += z.b(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return i10;
        }
        m0 m0Var = (m0) list;
        int i11 = 0;
        while (i3 < size) {
            i11 += z.b(m0Var.c(i3));
            i3++;
        }
        return i11;
    }

    public static int j(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof w0) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int i3 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i3 += z.b(((Long) list.get(i10)).longValue());
        }
        return i3;
    }

    public static int k(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof m0)) {
            int i10 = 0;
            while (i3 < size) {
                int intValue = ((Integer) list.get(i3)).intValue();
                i10 += z.a((intValue >> 31) ^ (intValue + intValue));
                i3++;
            }
            return i10;
        }
        m0 m0Var = (m0) list;
        int i11 = 0;
        while (i3 < size) {
            int c9 = m0Var.c(i3);
            i11 += z.a((c9 >> 31) ^ (c9 + c9));
            i3++;
        }
        return i11;
    }

    public static int l(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof w0) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int i3 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            long longValue = ((Long) list.get(i10)).longValue();
            i3 += z.b((longValue >> 63) ^ (longValue + longValue));
        }
        return i3;
    }

    public static int m(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof m0)) {
            int i10 = 0;
            while (i3 < size) {
                i10 += z.a(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return i10;
        }
        m0 m0Var = (m0) list;
        int i11 = 0;
        while (i3 < size) {
            i11 += z.a(m0Var.c(i3));
            i3++;
        }
        return i11;
    }

    public static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof w0) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int i3 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i3 += z.b(((Long) list.get(i10)).longValue());
        }
        return i3;
    }

    public static Object o(int i3, Object obj, Object obj2, int i10) {
        Object obj3 = obj2;
        if (obj2 == null) {
            l0 l0Var = (l0) obj;
            s1 s1Var = l0Var.zzc;
            obj3 = s1Var;
            if (s1Var == s1.f9829f) {
                s1 b3 = s1.b();
                l0Var.zzc = b3;
                obj3 = b3;
            }
        }
        ((s1) obj3).c(i3 << 3, Long.valueOf(i10));
        return obj3;
    }

    public static void p(Object obj, Object obj2) {
        e0 e0Var = ((i0) obj2).zzb;
        if (e0Var.f9774a.isEmpty()) {
            return;
        }
        i0 i0Var = (i0) obj;
        e0 e0Var2 = i0Var.zzb;
        if (e0Var2.f9775b) {
            i0Var.zzb = e0Var2.clone();
        }
        e0 e0Var3 = i0Var.zzb;
        e0Var3.getClass();
        o1 o1Var = e0Var.f9774a;
        int i3 = o1Var.f9809b;
        for (int i10 = 0; i10 < i3; i10++) {
            e0Var3.g(o1Var.c(i10));
        }
        Iterator it = o1Var.a().iterator();
        while (it.hasNext()) {
            e0Var3.g((Map.Entry) it.next());
        }
    }

    public static void q(Object obj, Object obj2) {
        l0 l0Var = (l0) obj;
        s1 s1Var = l0Var.zzc;
        s1 s1Var2 = ((l0) obj2).zzc;
        s1 s1Var3 = s1.f9829f;
        if (!s1Var3.equals(s1Var2)) {
            if (s1Var3.equals(s1Var)) {
                int i3 = s1Var.f9830a + s1Var2.f9830a;
                int[] copyOf = Arrays.copyOf(s1Var.f9831b, i3);
                System.arraycopy(s1Var2.f9831b, 0, copyOf, s1Var.f9830a, s1Var2.f9830a);
                Object[] copyOf2 = Arrays.copyOf(s1Var.f9832c, i3);
                System.arraycopy(s1Var2.f9832c, 0, copyOf2, s1Var.f9830a, s1Var2.f9830a);
                s1Var = new s1(i3, copyOf, copyOf2, true);
            } else {
                s1Var.getClass();
                if (!s1Var2.equals(s1Var3)) {
                    if (!s1Var.e) {
                        throw new UnsupportedOperationException();
                    }
                    int i10 = s1Var.f9830a + s1Var2.f9830a;
                    s1Var.e(i10);
                    System.arraycopy(s1Var2.f9831b, 0, s1Var.f9831b, s1Var.f9830a, s1Var2.f9830a);
                    System.arraycopy(s1Var2.f9832c, 0, s1Var.f9832c, s1Var.f9830a, s1Var2.f9830a);
                    s1Var.f9830a = i10;
                }
            }
        }
        l0Var.zzc = s1Var;
    }

    public static void r(int i3, List list, x0 x0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0Var.getClass();
        if (list instanceof t) {
            throw new ClassCastException();
        }
        z zVar = (z) x0Var.f9840a;
        int i10 = 0;
        if (!z5) {
            while (i10 < list.size()) {
                boolean booleanValue = ((Boolean) list.get(i10)).booleanValue();
                zVar.o(i3 << 3);
                zVar.c(booleanValue ? (byte) 1 : (byte) 0);
                i10++;
            }
            return;
        }
        zVar.m(i3, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Boolean) list.get(i12)).getClass();
            i11++;
        }
        zVar.o(i11);
        while (i10 < list.size()) {
            zVar.c(((Boolean) list.get(i10)).booleanValue() ? (byte) 1 : (byte) 0);
            i10++;
        }
    }

    public static void s(int i3, List list, x0 x0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0Var.getClass();
        if (list instanceof a0) {
            throw new ClassCastException();
        }
        z zVar = (z) x0Var.f9840a;
        int i10 = 0;
        if (!z5) {
            while (i10 < list.size()) {
                zVar.h(i3, Double.doubleToRawLongBits(((Double) list.get(i10)).doubleValue()));
                i10++;
            }
            return;
        }
        zVar.m(i3, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Double) list.get(i12)).getClass();
            i11 += 8;
        }
        zVar.o(i11);
        while (i10 < list.size()) {
            zVar.i(Double.doubleToRawLongBits(((Double) list.get(i10)).doubleValue()));
            i10++;
        }
    }

    public static void t(int i3, List list, x0 x0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0Var.getClass();
        boolean z6 = list instanceof m0;
        int i10 = 0;
        z zVar = (z) x0Var.f9840a;
        if (!z6) {
            if (!z5) {
                while (i10 < list.size()) {
                    zVar.j(i3, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            zVar.m(i3, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                i11 += z.b(((Integer) list.get(i12)).intValue());
            }
            zVar.o(i11);
            while (i10 < list.size()) {
                zVar.k(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        m0 m0Var = (m0) list;
        if (!z5) {
            while (i10 < m0Var.f9805c) {
                zVar.j(i3, m0Var.c(i10));
                i10++;
            }
            return;
        }
        zVar.m(i3, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < m0Var.f9805c; i14++) {
            i13 += z.b(m0Var.c(i14));
        }
        zVar.o(i13);
        while (i10 < m0Var.f9805c) {
            zVar.k(m0Var.c(i10));
            i10++;
        }
    }

    public static void u(int i3, List list, x0 x0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0Var.getClass();
        boolean z6 = list instanceof m0;
        int i10 = 0;
        z zVar = (z) x0Var.f9840a;
        if (!z6) {
            if (!z5) {
                while (i10 < list.size()) {
                    zVar.f(i3, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            zVar.m(i3, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Integer) list.get(i12)).getClass();
                i11 += 4;
            }
            zVar.o(i11);
            while (i10 < list.size()) {
                zVar.g(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        m0 m0Var = (m0) list;
        if (!z5) {
            while (i10 < m0Var.f9805c) {
                zVar.f(i3, m0Var.c(i10));
                i10++;
            }
            return;
        }
        zVar.m(i3, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < m0Var.f9805c; i14++) {
            m0Var.c(i14);
            i13 += 4;
        }
        zVar.o(i13);
        while (i10 < m0Var.f9805c) {
            zVar.g(m0Var.c(i10));
            i10++;
        }
    }

    public static void v(int i3, List list, x0 x0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0Var.getClass();
        if (list instanceof w0) {
            throw new ClassCastException();
        }
        z zVar = (z) x0Var.f9840a;
        int i10 = 0;
        if (!z5) {
            while (i10 < list.size()) {
                zVar.h(i3, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        zVar.m(i3, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Long) list.get(i12)).getClass();
            i11 += 8;
        }
        zVar.o(i11);
        while (i10 < list.size()) {
            zVar.i(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void w(int i3, List list, x0 x0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0Var.getClass();
        boolean z6 = list instanceof f0;
        int i10 = 0;
        z zVar = (z) x0Var.f9840a;
        if (!z6) {
            if (!z5) {
                while (i10 < list.size()) {
                    zVar.f(i3, Float.floatToRawIntBits(((Float) list.get(i10)).floatValue()));
                    i10++;
                }
                return;
            }
            zVar.m(i3, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Float) list.get(i12)).getClass();
                i11 += 4;
            }
            zVar.o(i11);
            while (i10 < list.size()) {
                zVar.g(Float.floatToRawIntBits(((Float) list.get(i10)).floatValue()));
                i10++;
            }
            return;
        }
        f0 f0Var = (f0) list;
        if (!z5) {
            while (i10 < f0Var.f9782c) {
                f0Var.d(i10);
                zVar.f(i3, Float.floatToRawIntBits(f0Var.f9781b[i10]));
                i10++;
            }
            return;
        }
        zVar.m(i3, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < f0Var.f9782c; i14++) {
            f0Var.d(i14);
            float f2 = f0Var.f9781b[i14];
            i13 += 4;
        }
        zVar.o(i13);
        while (i10 < f0Var.f9782c) {
            f0Var.d(i10);
            zVar.g(Float.floatToRawIntBits(f0Var.f9781b[i10]));
            i10++;
        }
    }

    public static void x(int i3, List list, x0 x0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0Var.getClass();
        boolean z6 = list instanceof m0;
        int i10 = 0;
        z zVar = (z) x0Var.f9840a;
        if (!z6) {
            if (!z5) {
                while (i10 < list.size()) {
                    zVar.j(i3, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            zVar.m(i3, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                i11 += z.b(((Integer) list.get(i12)).intValue());
            }
            zVar.o(i11);
            while (i10 < list.size()) {
                zVar.k(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        m0 m0Var = (m0) list;
        if (!z5) {
            while (i10 < m0Var.f9805c) {
                zVar.j(i3, m0Var.c(i10));
                i10++;
            }
            return;
        }
        zVar.m(i3, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < m0Var.f9805c; i14++) {
            i13 += z.b(m0Var.c(i14));
        }
        zVar.o(i13);
        while (i10 < m0Var.f9805c) {
            zVar.k(m0Var.c(i10));
            i10++;
        }
    }

    public static void y(int i3, List list, x0 x0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0Var.getClass();
        if (list instanceof w0) {
            throw new ClassCastException();
        }
        z zVar = (z) x0Var.f9840a;
        int i10 = 0;
        if (!z5) {
            while (i10 < list.size()) {
                zVar.p(i3, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        zVar.m(i3, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            i11 += z.b(((Long) list.get(i12)).longValue());
        }
        zVar.o(i11);
        while (i10 < list.size()) {
            zVar.q(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void z(int i3, List list, x0 x0Var, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x0Var.getClass();
        boolean z6 = list instanceof m0;
        int i10 = 0;
        z zVar = (z) x0Var.f9840a;
        if (!z6) {
            if (!z5) {
                while (i10 < list.size()) {
                    zVar.f(i3, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            zVar.m(i3, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Integer) list.get(i12)).getClass();
                i11 += 4;
            }
            zVar.o(i11);
            while (i10 < list.size()) {
                zVar.g(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        m0 m0Var = (m0) list;
        if (!z5) {
            while (i10 < m0Var.f9805c) {
                zVar.f(i3, m0Var.c(i10));
                i10++;
            }
            return;
        }
        zVar.m(i3, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < m0Var.f9805c; i14++) {
            m0Var.c(i14);
            i13 += 4;
        }
        zVar.o(i13);
        while (i10 < m0Var.f9805c) {
            zVar.g(m0Var.c(i10));
            i10++;
        }
    }
}
