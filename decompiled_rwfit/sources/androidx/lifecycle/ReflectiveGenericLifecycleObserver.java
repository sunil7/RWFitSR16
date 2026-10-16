package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements q {

    /* renamed from: a, reason: collision with root package name */
    public final r f2334a;

    /* renamed from: b, reason: collision with root package name */
    public final b f2335b;

    public ReflectiveGenericLifecycleObserver(r rVar) {
        this.f2334a = rVar;
        d dVar = d.f2345c;
        Class<?> cls = rVar.getClass();
        b bVar = (b) dVar.f2346a.get(cls);
        this.f2335b = bVar == null ? dVar.a(cls, null) : bVar;
    }

    @Override // androidx.lifecycle.q
    public final void c(s sVar, Lifecycle$Event lifecycle$Event) {
        HashMap hashMap = this.f2335b.f2341a;
        List list = (List) hashMap.get(lifecycle$Event);
        r rVar = this.f2334a;
        b.a(list, sVar, lifecycle$Event, rVar);
        b.a((List) hashMap.get(Lifecycle$Event.ON_ANY), sVar, lifecycle$Event, rVar);
    }
}
