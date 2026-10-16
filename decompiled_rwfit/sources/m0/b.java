package m0;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class b extends k implements Map {

    /* renamed from: h, reason: collision with root package name */
    public a f15883h;

    public b(b bVar) {
        i(bVar);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        if (this.f15883h == null) {
            this.f15883h = new a(this, 0);
        }
        a aVar = this.f15883h;
        if (((h) aVar.f194a) == null) {
            aVar.f194a = new h(aVar, 0);
        }
        return (h) aVar.f194a;
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.f15883h == null) {
            this.f15883h = new a(this, 0);
        }
        a aVar = this.f15883h;
        if (((h) aVar.f195b) == null) {
            aVar.f195b = new h(aVar, 1);
        }
        return (h) aVar.f195b;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.f15919c);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        if (this.f15883h == null) {
            this.f15883h = new a(this, 0);
        }
        a aVar = this.f15883h;
        if (((j) aVar.f196c) == null) {
            aVar.f196c = new j(aVar);
        }
        return (j) aVar.f196c;
    }
}
