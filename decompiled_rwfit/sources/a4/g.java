package a4;

import android.util.Log;
import com.example.test.utils.y;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final y f88a = new y(1);

    /* renamed from: b, reason: collision with root package name */
    public final f f89b = new f(0);

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f90c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f91d = new HashMap();
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public int f92f;

    public g(int i3) {
        this.e = i3;
    }

    public final void a(Class cls, int i3) {
        NavigableMap f2 = f(cls);
        Integer num = (Integer) f2.get(Integer.valueOf(i3));
        if (num != null) {
            if (num.intValue() == 1) {
                f2.remove(Integer.valueOf(i3));
                return;
            } else {
                f2.put(Integer.valueOf(i3), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i3 + ", this: " + this);
    }

    public final void b(int i3) {
        while (this.f92f > i3) {
            Object H = this.f88a.H();
            t4.f.b(H);
            c d5 = d(H.getClass());
            this.f92f -= d5.b() * d5.a(H);
            a(H.getClass(), d5.a(H));
            if (Log.isLoggable(d5.c(), 2)) {
                Log.v(d5.c(), "evicted: " + d5.a(H));
            }
        }
    }

    public final synchronized Object c(Class cls, int i3) {
        e eVar;
        int i10;
        try {
            Integer num = (Integer) f(cls).ceilingKey(Integer.valueOf(i3));
            if (num == null || ((i10 = this.f92f) != 0 && this.e / i10 < 2 && num.intValue() > i3 * 8)) {
                f fVar = this.f89b;
                i iVar = (i) ((ArrayDeque) fVar.f78a).poll();
                if (iVar == null) {
                    iVar = fVar.j();
                }
                eVar = (e) iVar;
                eVar.f85b = i3;
                eVar.f86c = cls;
            }
            f fVar2 = this.f89b;
            int intValue = num.intValue();
            i iVar2 = (i) ((ArrayDeque) fVar2.f78a).poll();
            if (iVar2 == null) {
                iVar2 = fVar2.j();
            }
            eVar = (e) iVar2;
            eVar.f85b = intValue;
            eVar.f86c = cls;
        } catch (Throwable th2) {
            throw th2;
        }
        return e(eVar, cls);
    }

    public final c d(Class cls) {
        c cVar;
        HashMap hashMap = this.f91d;
        c cVar2 = (c) hashMap.get(cls);
        if (cVar2 != null) {
            return cVar2;
        }
        if (cls.equals(int[].class)) {
            cVar = new c(1);
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: ".concat(cls.getSimpleName()));
            }
            cVar = new c(0);
        }
        hashMap.put(cls, cVar);
        return cVar;
    }

    public final Object e(e eVar, Class cls) {
        c d5 = d(cls);
        Object n4 = this.f88a.n(eVar);
        if (n4 != null) {
            this.f92f -= d5.b() * d5.a(n4);
            a(cls, d5.a(n4));
        }
        if (n4 != null) {
            return n4;
        }
        if (Log.isLoggable(d5.c(), 2)) {
            Log.v(d5.c(), "Allocated " + eVar.f85b + " bytes");
        }
        int i3 = eVar.f85b;
        switch (d5.f79a) {
            case 0:
                return new byte[i3];
            default:
                return new int[i3];
        }
    }

    public final NavigableMap f(Class cls) {
        HashMap hashMap = this.f90c;
        NavigableMap navigableMap = (NavigableMap) hashMap.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        hashMap.put(cls, treeMap);
        return treeMap;
    }

    public final synchronized void g(Object obj) {
        Class<?> cls = obj.getClass();
        c d5 = d(cls);
        int a3 = d5.a(obj);
        int b3 = d5.b() * a3;
        if (b3 <= this.e / 2) {
            f fVar = this.f89b;
            i iVar = (i) ((ArrayDeque) fVar.f78a).poll();
            if (iVar == null) {
                iVar = fVar.j();
            }
            e eVar = (e) iVar;
            eVar.f85b = a3;
            eVar.f86c = cls;
            this.f88a.E(eVar, obj);
            NavigableMap f2 = f(cls);
            Integer num = (Integer) f2.get(Integer.valueOf(eVar.f85b));
            Integer valueOf = Integer.valueOf(eVar.f85b);
            int i3 = 1;
            if (num != null) {
                i3 = 1 + num.intValue();
            }
            f2.put(valueOf, Integer.valueOf(i3));
            this.f92f += b3;
            b(this.e);
        }
    }
}
