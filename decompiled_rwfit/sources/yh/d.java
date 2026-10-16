package yh;

import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.EventBusException;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: q, reason: collision with root package name */
    public static volatile d f20139q;
    public static final e r;

    /* renamed from: s, reason: collision with root package name */
    public static final HashMap f20140s;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f20141a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f20142b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f20143c;

    /* renamed from: d, reason: collision with root package name */
    public final ca.h f20144d = new ca.h(6);
    public final h e;

    /* renamed from: f, reason: collision with root package name */
    public final f f20145f;

    /* renamed from: g, reason: collision with root package name */
    public final a f20146g;

    /* renamed from: h, reason: collision with root package name */
    public final ia.j f20147h;

    /* renamed from: i, reason: collision with root package name */
    public final n f20148i;

    /* renamed from: j, reason: collision with root package name */
    public final ExecutorService f20149j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f20150k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f20151l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f20152m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f20153n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f20154o;

    /* renamed from: p, reason: collision with root package name */
    public final g f20155p;

    static {
        e eVar = new e();
        eVar.f20157a = e.f20156b;
        r = eVar;
        f20140s = new HashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d() {
        /*
            r4 = this;
            r4.<init>()
            ca.h r0 = new ca.h
            r1 = 6
            r0.<init>(r1)
            r4.f20144d = r0
            yh.e r0 = yh.d.r
            r0.getClass()
            boolean r1 = zh.a.f20423a
            r2 = 0
            if (r1 == 0) goto L23
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch: java.lang.RuntimeException -> L1a
            goto L1b
        L1a:
            r1 = r2
        L1b:
            if (r1 == 0) goto L23
            zh.a r1 = new zh.a
            r1.<init>()
            goto L2a
        L23:
            gc.b r1 = new gc.b
            r3 = 25
            r1.<init>(r3)
        L2a:
            r4.f20155p = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r4.f20141a = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r4.f20142b = r1
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap
            r1.<init>()
            r4.f20143c = r1
            boolean r1 = zh.a.f20423a
            if (r1 == 0) goto L54
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch: java.lang.RuntimeException -> L4a
            goto L4b
        L4a:
            r1 = r2
        L4b:
            if (r1 != 0) goto L4e
            goto L54
        L4e:
            yh.h r3 = new yh.h
            r3.<init>(r1)
            goto L55
        L54:
            r3 = r2
        L55:
            r4.e = r3
            if (r3 == 0) goto L62
            yh.f r2 = new yh.f
            java.lang.Object r1 = r3.f20162a
            android.os.Looper r1 = (android.os.Looper) r1
            r2.<init>(r4, r1)
        L62:
            r4.f20145f = r2
            yh.a r1 = new yh.a
            r1.<init>(r4)
            r4.f20146g = r1
            ia.j r1 = new ia.j
            r1.<init>(r4)
            r4.f20147h = r1
            yh.n r1 = new yh.n
            r1.<init>()
            r4.f20148i = r1
            r1 = 1
            r4.f20150k = r1
            r4.f20151l = r1
            r4.f20152m = r1
            r4.f20153n = r1
            r4.f20154o = r1
            java.util.concurrent.ExecutorService r0 = r0.f20157a
            r4.f20149j = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: yh.d.<init>():void");
    }

    public static void a(ArrayList arrayList, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!arrayList.contains(cls)) {
                arrayList.add(cls);
                a(arrayList, cls.getInterfaces());
            }
        }
    }

    public static d b() {
        d dVar;
        d dVar2 = f20139q;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            try {
                dVar = f20139q;
                if (dVar == null) {
                    dVar = new d();
                    f20139q = dVar;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dVar;
    }

    public final void c(j jVar) {
        Object obj = jVar.f20165a;
        o oVar = jVar.f20166b;
        jVar.f20165a = null;
        jVar.f20166b = null;
        jVar.f20167c = null;
        ArrayList arrayList = j.f20164d;
        synchronized (arrayList) {
            if (arrayList.size() < 10000) {
                arrayList.add(jVar);
            }
        }
        if (oVar.f20180c) {
            d(oVar, obj);
        }
    }

    public final void d(o oVar, Object obj) {
        try {
            oVar.f20179b.f20171a.invoke(oVar.f20178a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            boolean z5 = obj instanceof l;
            boolean z6 = this.f20150k;
            g gVar = this.f20155p;
            if (!z5) {
                if (z6) {
                    gVar.l(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + oVar.f20178a.getClass(), cause);
                }
                if (this.f20152m) {
                    e(new l(cause, obj, oVar.f20178a));
                    return;
                }
                return;
            }
            if (z6) {
                Level level = Level.SEVERE;
                gVar.l(level, "SubscriberExceptionEvent subscriber " + oVar.f20178a.getClass() + " threw an exception", cause);
                l lVar = (l) obj;
                gVar.l(level, "Initial event " + lVar.f20169b + " caused exception in " + lVar.f20170c, lVar.f20168a);
            }
        }
    }

    public final void e(Object obj) {
        c cVar = (c) this.f20144d.get();
        ArrayList arrayList = cVar.f20135a;
        arrayList.add(obj);
        if (cVar.f20136b) {
            return;
        }
        h hVar = this.e;
        cVar.f20137c = hVar == null || ((Looper) hVar.f20162a) == Looper.myLooper();
        cVar.f20136b = true;
        while (!arrayList.isEmpty()) {
            try {
                f(arrayList.remove(0), cVar);
            } finally {
                cVar.f20136b = false;
                cVar.f20137c = false;
            }
        }
    }

    public final void f(Object obj, c cVar) {
        boolean g10;
        List list;
        Class<?> cls = obj.getClass();
        if (this.f20154o) {
            HashMap hashMap = f20140s;
            synchronized (hashMap) {
                try {
                    List list2 = (List) hashMap.get(cls);
                    list = list2;
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                            arrayList.add(cls2);
                            a(arrayList, cls2.getInterfaces());
                        }
                        f20140s.put(cls, arrayList);
                        list = arrayList;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            int size = list.size();
            g10 = false;
            for (int i3 = 0; i3 < size; i3++) {
                g10 |= g(obj, cVar, (Class) list.get(i3));
            }
        } else {
            g10 = g(obj, cVar, cls);
        }
        if (g10) {
            return;
        }
        if (this.f20151l) {
            this.f20155p.a(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.f20153n || cls == i.class || cls == l.class) {
            return;
        }
        e(new i(obj));
    }

    public final boolean g(Object obj, c cVar, Class cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.f20141a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            cVar.f20138d = obj;
            h(oVar, obj, cVar.f20137c);
        }
        return true;
    }

    public final void h(o oVar, Object obj, boolean z5) {
        int i3 = b.f20134a[oVar.f20179b.f20172b.ordinal()];
        if (i3 == 1) {
            d(oVar, obj);
            return;
        }
        f fVar = this.f20145f;
        if (i3 == 2) {
            if (z5) {
                d(oVar, obj);
                return;
            } else {
                fVar.a(oVar, obj);
                return;
            }
        }
        if (i3 == 3) {
            if (fVar != null) {
                fVar.a(oVar, obj);
                return;
            } else {
                d(oVar, obj);
                return;
            }
        }
        if (i3 != 4) {
            if (i3 != 5) {
                throw new IllegalStateException("Unknown thread mode: " + oVar.f20179b.f20172b);
            }
            ia.j jVar = this.f20147h;
            jVar.getClass();
            ((o4.e) jVar.f14390b).a(j.a(oVar, obj));
            ((d) jVar.f14391c).f20149j.execute(jVar);
            return;
        }
        if (!z5) {
            d(oVar, obj);
            return;
        }
        a aVar = this.f20146g;
        aVar.getClass();
        j a3 = j.a(oVar, obj);
        synchronized (aVar) {
            try {
                aVar.f20131a.a(a3);
                if (!aVar.f20133c) {
                    aVar.f20133c = true;
                    aVar.f20132b.f20149j.execute(aVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void i(Object obj, m mVar) {
        Object value;
        Class cls = mVar.f20173c;
        o oVar = new o(obj, mVar);
        HashMap hashMap = this.f20141a;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) hashMap.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            hashMap.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(oVar)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i3 = 0; i3 <= size; i3++) {
            if (i3 != size) {
                if (mVar.f20174d <= ((o) copyOnWriteArrayList.get(i3)).f20179b.f20174d) {
                }
            }
            copyOnWriteArrayList.add(i3, oVar);
            break;
        }
        HashMap hashMap2 = this.f20142b;
        List list = (List) hashMap2.get(obj);
        if (list == null) {
            list = new ArrayList();
            hashMap2.put(obj, list);
        }
        list.add(cls);
        if (mVar.e) {
            ConcurrentHashMap concurrentHashMap = this.f20143c;
            h hVar = this.e;
            if (!this.f20154o) {
                Object obj2 = concurrentHashMap.get(cls);
                if (obj2 != null) {
                    h(oVar, obj2, hVar == null || ((Looper) hVar.f20162a) == Looper.myLooper());
                    return;
                }
                return;
            }
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey()) && (value = entry.getValue()) != null) {
                    h(oVar, value, hVar == null || ((Looper) hVar.f20162a) == Looper.myLooper());
                }
            }
        }
    }

    public final String toString() {
        return "EventBus[indexCount=0, eventInheritance=" + this.f20154o + "]";
    }
}
