package yb;

import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g extends com.google.gson.k {

    /* renamed from: b, reason: collision with root package name */
    public static final a f20056b = new a(2);

    /* renamed from: a, reason: collision with root package name */
    public final com.google.gson.e f20057a;

    public g(com.google.gson.e eVar) {
        this.f20057a = eVar;
    }

    @Override // com.google.gson.k
    public final Object a(cc.a aVar) {
        switch (f.f20055a[aVar.b0().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.b();
                while (aVar.j()) {
                    arrayList.add(a(aVar));
                }
                aVar.g();
                return arrayList;
            case 2:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                aVar.c();
                while (aVar.j()) {
                    linkedTreeMap.put(aVar.O(), a(aVar));
                }
                aVar.h();
                return linkedTreeMap;
            case 3:
                return aVar.Z();
            case 4:
                return Double.valueOf(aVar.A());
            case 5:
                return Boolean.valueOf(aVar.y());
            case 6:
                aVar.X();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.k
    public final void b(cc.b bVar, Object obj) {
        if (obj == null) {
            bVar.k();
            return;
        }
        Class<?> cls = obj.getClass();
        com.google.gson.e eVar = this.f20057a;
        eVar.getClass();
        com.google.gson.k c9 = eVar.c(new bc.a(cls));
        if (!(c9 instanceof g)) {
            c9.b(bVar, obj);
        } else {
            bVar.e();
            bVar.h();
        }
    }
}
