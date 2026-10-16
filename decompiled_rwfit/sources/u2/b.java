package u2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import o2.m;
import x2.h;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f18871a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public Object f18872b;

    /* renamed from: c, reason: collision with root package name */
    public final v2.d f18873c;

    /* renamed from: d, reason: collision with root package name */
    public t2.c f18874d;

    public b(v2.d dVar) {
        this.f18873c = dVar;
    }

    public abstract boolean a(h hVar);

    public abstract boolean b(Object obj);

    public final void c(Collection collection) {
        this.f18871a.clear();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (a(hVar)) {
                this.f18871a.add(hVar.f19749a);
            }
        }
        if (this.f18871a.isEmpty()) {
            this.f18873c.b(this);
        } else {
            v2.d dVar = this.f18873c;
            synchronized (dVar.f19137c) {
                try {
                    if (dVar.f19138d.add(this)) {
                        if (dVar.f19138d.size() == 1) {
                            dVar.e = dVar.a();
                            m.g().d(v2.d.f19134f, String.format("%s: initial state = %s", dVar.getClass().getSimpleName(), dVar.e), new Throwable[0]);
                            dVar.d();
                        }
                        Object obj = dVar.e;
                        this.f18872b = obj;
                        d(this.f18874d, obj);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        d(this.f18874d, this.f18872b);
    }

    public final void d(t2.c cVar, Object obj) {
        if (this.f18871a.isEmpty() || cVar == null) {
            return;
        }
        if (obj == null || b(obj)) {
            ArrayList arrayList = this.f18871a;
            synchronized (cVar.f18493c) {
                t2.b bVar = cVar.f18491a;
                if (bVar != null) {
                    bVar.c(arrayList);
                }
            }
            return;
        }
        ArrayList arrayList2 = this.f18871a;
        synchronized (cVar.f18493c) {
            try {
                ArrayList arrayList3 = new ArrayList();
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    String str = (String) obj2;
                    if (cVar.a(str)) {
                        m.g().d(t2.c.f18490d, "Constraints met for " + str, new Throwable[0]);
                        arrayList3.add(str);
                    }
                }
                t2.b bVar2 = cVar.f18491a;
                if (bVar2 != null) {
                    bVar2.e(arrayList3);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
