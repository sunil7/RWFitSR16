package com.amap.api.col.p0003sl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class n0 {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Integer, a> f4670a = new ConcurrentHashMap<>();

    public class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public List<T> f4671a = Collections.synchronizedList(new ArrayList());

        /* renamed from: b, reason: collision with root package name */
        public T f4672b = null;

        public a(n0 n0Var) {
        }
    }

    public <T> void a(Integer num, T t8) {
        ConcurrentHashMap<Integer, a> concurrentHashMap;
        if (t8 == null || (concurrentHashMap = this.f4670a) == null) {
            return;
        }
        try {
            a aVar = concurrentHashMap.get(num);
            if (aVar == null) {
                aVar = new a(this);
                this.f4670a.putIfAbsent(num, aVar);
            }
            List<T> list = aVar.f4671a;
            if (list == null || list.contains(t8)) {
                return;
            }
            aVar.f4671a.add(t8);
        } catch (Throwable unused) {
        }
    }

    public <T> void b(Integer num, T t8) {
        ConcurrentHashMap<Integer, a> concurrentHashMap;
        a aVar;
        List<T> list;
        if (t8 == null || (concurrentHashMap = this.f4670a) == null) {
            return;
        }
        try {
            if (!concurrentHashMap.containsKey(num) || (aVar = this.f4670a.get(num)) == null || (list = aVar.f4671a) == null || !list.contains(t8)) {
                return;
            }
            aVar.f4671a.remove(t8);
        } catch (Throwable unused) {
        }
    }

    public <T> void a(Integer num) {
        a aVar;
        List<T> list;
        try {
            if (!this.f4670a.containsKey(num) || (aVar = this.f4670a.get(num)) == null || (list = aVar.f4671a) == null) {
                return;
            }
            list.clear();
        } catch (Throwable unused) {
        }
    }

    public <T> List<T> a(int i3) {
        try {
            a aVar = this.f4670a.get(Integer.valueOf(i3));
            if (aVar != null) {
                return aVar.f4671a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public <T> void a(int i3, T t8) {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f4670a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            a aVar = concurrentHashMap.get(Integer.valueOf(i3));
            if (aVar == null) {
                aVar = new a(this);
                this.f4670a.putIfAbsent(Integer.valueOf(i3), aVar);
            }
            if (aVar.f4672b == t8) {
                return;
            }
            b(Integer.valueOf(i3), aVar.f4672b);
            aVar.f4672b = t8;
            a(Integer.valueOf(i3), (Integer) t8);
        } catch (Throwable unused) {
        }
    }

    public <T> void a() {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f4670a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            Iterator<Map.Entry<Integer, a>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                value.f4671a.clear();
                value.f4672b = null;
            }
            this.f4670a.clear();
        } catch (Throwable unused) {
        }
    }
}
