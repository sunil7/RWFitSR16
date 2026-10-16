package org.joda.time.format;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f17190a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f17191b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17192c;

    /* renamed from: d, reason: collision with root package name */
    public d0[] f17193d;

    static {
        new ConcurrentHashMap();
    }

    public static Object[] d(List list) {
        int size = list.size();
        if (size == 0) {
            f0 f0Var = f0.f17176b;
            return new Object[]{f0Var, f0Var};
        }
        if (size == 1) {
            return new Object[]{list.get(0), list.get(1)};
        }
        b0 b0Var = new b0(list);
        return new Object[]{b0Var, b0Var};
    }

    public static a0 e(List list, boolean z5, boolean z6) {
        if (z5 && z6) {
            throw new IllegalStateException("Builder has created neither a printer nor a parser");
        }
        int size = list.size();
        if (size >= 2 && (list.get(0) instanceof g0)) {
            g0 g0Var = (g0) list.get(0);
            if (g0Var.f17184f == null && g0Var.f17183d == null) {
                a0 e = e(list.subList(2, size), z5, z6);
                k0 k0Var = e.f17149a;
                j0 j0Var = e.f17150b;
                g0Var.f17183d = k0Var;
                g0Var.f17184f = j0Var;
                return new a0(g0Var, g0Var);
            }
        }
        Object[] d5 = d(list);
        return z5 ? new a0(null, (j0) d5[1]) : z6 ? new a0((k0) d5[0], null) : new a0((k0) d5[0], (j0) d5[1]);
    }

    public final void a(k0 k0Var, j0 j0Var) {
        this.f17190a.add(k0Var);
        this.f17190a.add(j0Var);
        this.f17191b = this.f17191b;
        this.f17192c = this.f17192c;
    }

    public final void b(int i3) {
        d0 d0Var = new d0(i3, this.f17193d);
        a(d0Var, d0Var);
        this.f17193d[i3] = d0Var;
    }

    public final void c(String str) {
        Object obj;
        Object obj2;
        h0 h0Var = new h0(str);
        if (this.f17190a.size() > 0) {
            obj = l0.h(2, this.f17190a);
            obj2 = l0.h(1, this.f17190a);
        } else {
            obj = null;
            obj2 = null;
        }
        if (obj == null || obj2 == null || obj != obj2 || !(obj instanceof d0)) {
            throw new IllegalStateException("No field to apply suffix to");
        }
        d0 d0Var = new d0((d0) obj, h0Var);
        ArrayList arrayList = this.f17190a;
        arrayList.set(arrayList.size() - 2, d0Var);
        ArrayList arrayList2 = this.f17190a;
        arrayList2.set(arrayList2.size() - 1, d0Var);
        this.f17193d[d0Var.f17170d] = d0Var;
    }
}
