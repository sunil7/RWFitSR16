package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2341a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f2342b;

    public b(HashMap hashMap) {
        this.f2342b = hashMap;
        for (Map.Entry entry : hashMap.entrySet()) {
            Lifecycle$Event lifecycle$Event = (Lifecycle$Event) entry.getValue();
            List list = (List) this.f2341a.get(lifecycle$Event);
            if (list == null) {
                list = new ArrayList();
                this.f2341a.put(lifecycle$Event, list);
            }
            list.add((c) entry.getKey());
        }
    }

    public static void a(List list, s sVar, Lifecycle$Event lifecycle$Event, r rVar) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                c cVar = (c) list.get(size);
                cVar.getClass();
                try {
                    int i3 = cVar.f2343a;
                    Method method = cVar.f2344b;
                    if (i3 == 0) {
                        method.invoke(rVar, null);
                    } else if (i3 == 1) {
                        method.invoke(rVar, sVar);
                    } else if (i3 == 2) {
                        method.invoke(rVar, sVar, lifecycle$Event);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e10) {
                    throw new RuntimeException("Failed to call observer method", e10.getCause());
                }
            }
        }
    }
}
