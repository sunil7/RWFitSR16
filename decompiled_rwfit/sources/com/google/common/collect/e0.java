package com.google.common.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final Map f11061a = CompactHashMap.create();

    public Collection a() {
        return new ArrayList();
    }

    public e0 b(Object obj, Object obj2) {
        h.c(obj, obj2);
        Map map = this.f11061a;
        Collection collection = (Collection) map.get(obj);
        if (collection == null) {
            collection = a();
            map.put(obj, collection);
        }
        collection.add(obj2);
        return this;
    }

    public void c(Map.Entry entry) {
        b(entry.getKey(), entry.getValue());
    }
}
