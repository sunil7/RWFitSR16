package androidx.lifecycle;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class u extends n {

    /* renamed from: a, reason: collision with root package name */
    public j.a f2389a;

    /* renamed from: b, reason: collision with root package name */
    public Lifecycle$State f2390b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakReference f2391c;

    /* renamed from: d, reason: collision with root package name */
    public int f2392d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2393f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f2394g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f2395h;

    public u(s sVar) {
        new AtomicReference();
        this.f2389a = new j.a();
        this.f2392d = 0;
        this.e = false;
        this.f2393f = false;
        this.f2394g = new ArrayList();
        this.f2391c = new WeakReference(sVar);
        this.f2390b = Lifecycle$State.INITIALIZED;
        this.f2395h = true;
    }

    @Override // androidx.lifecycle.n
    public final void a(r rVar) {
        q reflectiveGenericLifecycleObserver;
        s sVar;
        ArrayList arrayList = this.f2394g;
        d("addObserver");
        Lifecycle$State lifecycle$State = this.f2390b;
        Lifecycle$State lifecycle$State2 = Lifecycle$State.DESTROYED;
        if (lifecycle$State != lifecycle$State2) {
            lifecycle$State2 = Lifecycle$State.INITIALIZED;
        }
        t tVar = new t();
        HashMap hashMap = v.f2396a;
        boolean z5 = rVar instanceof q;
        boolean z6 = rVar instanceof f;
        if (z5 && z6) {
            reflectiveGenericLifecycleObserver = new FullLifecycleObserverAdapter((f) rVar, (q) rVar);
        } else if (z6) {
            reflectiveGenericLifecycleObserver = new FullLifecycleObserverAdapter((f) rVar, null);
        } else if (z5) {
            reflectiveGenericLifecycleObserver = (q) rVar;
        } else {
            Class<?> cls = rVar.getClass();
            if (v.c(cls) == 2) {
                List list = (List) v.f2397b.get(cls);
                if (list.size() == 1) {
                    v.a((Constructor) list.get(0), rVar);
                    reflectiveGenericLifecycleObserver = new SingleGeneratedAdapterObserver();
                } else {
                    i[] iVarArr = new i[list.size()];
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        v.a((Constructor) list.get(i3), rVar);
                        iVarArr[i3] = null;
                    }
                    reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(iVarArr);
                }
            } else {
                reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(rVar);
            }
        }
        tVar.f2388b = reflectiveGenericLifecycleObserver;
        tVar.f2387a = lifecycle$State2;
        if (((t) this.f2389a.c(rVar, tVar)) == null && (sVar = (s) this.f2391c.get()) != null) {
            boolean z8 = this.f2392d != 0 || this.e;
            Lifecycle$State c9 = c(rVar);
            this.f2392d++;
            while (tVar.f2387a.compareTo(c9) < 0 && this.f2389a.e.containsKey(rVar)) {
                arrayList.add(tVar.f2387a);
                Lifecycle$Event upFrom = Lifecycle$Event.upFrom(tVar.f2387a);
                if (upFrom == null) {
                    throw new IllegalStateException("no event up from " + tVar.f2387a);
                }
                tVar.a(sVar, upFrom);
                arrayList.remove(arrayList.size() - 1);
                c9 = c(rVar);
            }
            if (!z8) {
                g();
            }
            this.f2392d--;
        }
    }

    @Override // androidx.lifecycle.n
    public final void b(r rVar) {
        d("removeObserver");
        this.f2389a.d(rVar);
    }

    public final Lifecycle$State c(r rVar) {
        HashMap hashMap = this.f2389a.e;
        j.c cVar = hashMap.containsKey(rVar) ? ((j.c) hashMap.get(rVar)).f15154d : null;
        Lifecycle$State lifecycle$State = cVar != null ? ((t) cVar.f15152b).f2387a : null;
        ArrayList arrayList = this.f2394g;
        Lifecycle$State lifecycle$State2 = arrayList.isEmpty() ? null : (Lifecycle$State) com.google.android.gms.internal.mlkit_vision_barcode.l0.h(1, arrayList);
        Lifecycle$State lifecycle$State3 = this.f2390b;
        if (lifecycle$State == null || lifecycle$State.compareTo(lifecycle$State3) >= 0) {
            lifecycle$State = lifecycle$State3;
        }
        return (lifecycle$State2 == null || lifecycle$State2.compareTo(lifecycle$State) >= 0) ? lifecycle$State : lifecycle$State2;
    }

    public final void d(String str) {
        if (this.f2395h) {
            i.a.a().f14329a.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(com.google.android.gms.internal.mlkit_vision_barcode.l0.o("Method ", str, " must be called on the main thread"));
            }
        }
    }

    public final void e(Lifecycle$Event lifecycle$Event) {
        d("handleLifecycleEvent");
        f(lifecycle$Event.getTargetState());
    }

    public final void f(Lifecycle$State lifecycle$State) {
        Lifecycle$State lifecycle$State2 = this.f2390b;
        if (lifecycle$State2 == lifecycle$State) {
            return;
        }
        if (lifecycle$State2 == Lifecycle$State.INITIALIZED && lifecycle$State == Lifecycle$State.DESTROYED) {
            throw new IllegalStateException("no event down from " + this.f2390b);
        }
        this.f2390b = lifecycle$State;
        if (this.e || this.f2392d != 0) {
            this.f2393f = true;
            return;
        }
        this.e = true;
        g();
        this.e = false;
        if (this.f2390b == Lifecycle$State.DESTROYED) {
            this.f2389a = new j.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e0, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.u.g():void");
    }
}
