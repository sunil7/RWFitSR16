package androidx.camera.core.impl;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class x0 extends d1 implements w0 {

    /* renamed from: d, reason: collision with root package name */
    public static final Config$OptionPriority f1517d = Config$OptionPriority.OPTIONAL;

    public static x0 f() {
        return new x0(new TreeMap(d1.f1372b));
    }

    public static x0 i(e0 e0Var) {
        TreeMap treeMap = new TreeMap(d1.f1372b);
        for (c cVar : e0Var.g()) {
            Set<Config$OptionPriority> h4 = e0Var.h(cVar);
            ArrayMap arrayMap = new ArrayMap();
            for (Config$OptionPriority config$OptionPriority : h4) {
                arrayMap.put(config$OptionPriority, e0Var.d(cVar, config$OptionPriority));
            }
            treeMap.put(cVar, arrayMap);
        }
        return new x0(treeMap);
    }

    public final void l(c cVar, Config$OptionPriority config$OptionPriority, Object obj) {
        Config$OptionPriority config$OptionPriority2;
        TreeMap treeMap = this.f1374a;
        Map map = (Map) treeMap.get(cVar);
        if (map == null) {
            ArrayMap arrayMap = new ArrayMap();
            treeMap.put(cVar, arrayMap);
            arrayMap.put(config$OptionPriority, obj);
            return;
        }
        Config$OptionPriority config$OptionPriority3 = (Config$OptionPriority) Collections.min(map.keySet());
        if (Objects.equals(map.get(config$OptionPriority3), obj) || config$OptionPriority3 != (config$OptionPriority2 = Config$OptionPriority.REQUIRED) || config$OptionPriority != config$OptionPriority2) {
            map.put(config$OptionPriority, obj);
            return;
        }
        throw new IllegalArgumentException("Option values conflicts: " + cVar.f1351a + ", existing value (" + config$OptionPriority3 + ")=" + map.get(config$OptionPriority3) + ", conflicting (" + config$OptionPriority + ")=" + obj);
    }

    public final void m(c cVar, Object obj) {
        l(cVar, f1517d, obj);
    }
}
