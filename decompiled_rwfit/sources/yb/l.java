package yb;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: classes.dex */
public final class l extends com.google.gson.k {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.gson.e f20076a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.gson.k f20077b;

    /* renamed from: c, reason: collision with root package name */
    public final Type f20078c;

    public l(com.google.gson.e eVar, com.google.gson.k kVar, Type type) {
        this.f20076a = eVar;
        this.f20077b = kVar;
        this.f20078c = type;
    }

    @Override // com.google.gson.k
    public final Object a(cc.a aVar) {
        return this.f20077b.a(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.reflect.Type] */
    @Override // com.google.gson.k
    public final void b(cc.b bVar, Object obj) {
        ?? r02 = this.f20078c;
        Class<?> cls = (obj == null || !(r02 == Object.class || (r02 instanceof TypeVariable) || (r02 instanceof Class))) ? r02 : obj.getClass();
        com.google.gson.k kVar = this.f20077b;
        if (cls != r02) {
            com.google.gson.k c9 = this.f20076a.c(new bc.a(cls));
            if (!(c9 instanceof i) || (kVar instanceof i)) {
                kVar = c9;
            }
        }
        kVar.b(bVar, obj);
    }
}
