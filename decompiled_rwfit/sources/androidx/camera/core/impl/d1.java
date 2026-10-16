package androidx.camera.core.impl;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class d1 implements e0 {

    /* renamed from: b, reason: collision with root package name */
    public static final c1 f1372b;

    /* renamed from: c, reason: collision with root package name */
    public static final d1 f1373c;

    /* renamed from: a, reason: collision with root package name */
    public final TreeMap f1374a;

    static {
        c1 c1Var = new c1(0);
        f1372b = c1Var;
        f1373c = new d1(new TreeMap(c1Var));
    }

    public d1(TreeMap treeMap) {
        this.f1374a = treeMap;
    }

    public static d1 a(e0 e0Var) {
        if (d1.class.equals(e0Var.getClass())) {
            return (d1) e0Var;
        }
        TreeMap treeMap = new TreeMap(f1372b);
        for (c cVar : e0Var.g()) {
            Set<Config$OptionPriority> h4 = e0Var.h(cVar);
            ArrayMap arrayMap = new ArrayMap();
            for (Config$OptionPriority config$OptionPriority : h4) {
                arrayMap.put(config$OptionPriority, e0Var.d(cVar, config$OptionPriority));
            }
            treeMap.put(cVar, arrayMap);
        }
        return new d1(treeMap);
    }

    @Override // androidx.camera.core.impl.e0
    public final boolean b(c cVar) {
        return this.f1374a.containsKey(cVar);
    }

    @Override // androidx.camera.core.impl.e0
    public final void c(c0.b bVar) {
        for (Map.Entry entry : this.f1374a.tailMap(new c("camera2.captureRequest.option.", Void.class, null)).entrySet()) {
            if (!((c) entry.getKey()).f1351a.startsWith("camera2.captureRequest.option.")) {
                return;
            }
            c cVar = (c) entry.getKey();
            g0.d dVar = (g0.d) bVar.f3280b;
            e0 e0Var = (e0) bVar.f3281c;
            dVar.f13764b.l(cVar, e0Var.j(cVar), e0Var.e(cVar));
        }
    }

    @Override // androidx.camera.core.impl.e0
    public final Object d(c cVar, Config$OptionPriority config$OptionPriority) {
        Map map = (Map) this.f1374a.get(cVar);
        if (map == null) {
            throw new IllegalArgumentException("Option does not exist: " + cVar);
        }
        if (map.containsKey(config$OptionPriority)) {
            return map.get(config$OptionPriority);
        }
        throw new IllegalArgumentException("Option does not exist: " + cVar + " with priority=" + config$OptionPriority);
    }

    @Override // androidx.camera.core.impl.e0
    public final Object e(c cVar) {
        Map map = (Map) this.f1374a.get(cVar);
        if (map != null) {
            return map.get((Config$OptionPriority) Collections.min(map.keySet()));
        }
        throw new IllegalArgumentException("Option does not exist: " + cVar);
    }

    @Override // androidx.camera.core.impl.e0
    public final Set g() {
        return Collections.unmodifiableSet(this.f1374a.keySet());
    }

    @Override // androidx.camera.core.impl.e0
    public final Set h(c cVar) {
        Map map = (Map) this.f1374a.get(cVar);
        return map == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(map.keySet());
    }

    @Override // androidx.camera.core.impl.e0
    public final Config$OptionPriority j(c cVar) {
        Map map = (Map) this.f1374a.get(cVar);
        if (map != null) {
            return (Config$OptionPriority) Collections.min(map.keySet());
        }
        throw new IllegalArgumentException("Option does not exist: " + cVar);
    }

    @Override // androidx.camera.core.impl.e0
    public final Object k(c cVar, Object obj) {
        try {
            return e(cVar);
        } catch (IllegalArgumentException unused) {
            return obj;
        }
    }
}
