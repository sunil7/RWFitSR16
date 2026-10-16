package j;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class a extends f {
    public final HashMap e = new HashMap();

    @Override // j.f
    public final c a(Object obj) {
        return (c) this.e.get(obj);
    }

    @Override // j.f
    public final Object c(Object obj, Object obj2) {
        c a3 = a(obj);
        if (a3 != null) {
            return a3.f15152b;
        }
        HashMap hashMap = this.e;
        c cVar = new c(obj, obj2);
        this.f15161d++;
        c cVar2 = this.f15159b;
        if (cVar2 == null) {
            this.f15158a = cVar;
            this.f15159b = cVar;
        } else {
            cVar2.f15153c = cVar;
            cVar.f15154d = cVar2;
            this.f15159b = cVar;
        }
        hashMap.put(obj, cVar);
        return null;
    }

    @Override // j.f
    public final Object d(Object obj) {
        Object d5 = super.d(obj);
        this.e.remove(obj);
        return d5;
    }
}
