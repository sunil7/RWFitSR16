package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.l7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
class m7 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4572a = true;

    /* renamed from: b, reason: collision with root package name */
    private long f4573b = 86400;

    /* renamed from: c, reason: collision with root package name */
    private int f4574c = 10;

    /* renamed from: d, reason: collision with root package name */
    private long f4575d = 0;
    private final LinkedHashMap<l7.b, Object> e = new LinkedHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private final Object f4576f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private final LinkedHashMap<l7.b, Object> f4577g = new LinkedHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final Object f4578h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<String> f4579i = new ArrayList<>();

    public m7(String... strArr) {
        a(strArr);
    }

    private void a(String... strArr) {
        this.f4575d = System.currentTimeMillis();
        this.e.clear();
        this.f4579i.clear();
        for (String str : strArr) {
            if (str != null) {
                this.f4579i.add(str);
            }
        }
    }

    public Object b(LinkedHashMap<l7.b, Object> linkedHashMap, l7.b bVar) {
        if (linkedHashMap != null) {
            return linkedHashMap.get(bVar);
        }
        return null;
    }

    public Object c(LinkedHashMap<l7.b, Object> linkedHashMap, l7.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.remove(bVar);
    }

    public boolean b(l7.b bVar) {
        if (bVar.f4475a == null) {
            return false;
        }
        ArrayList<String> arrayList = this.f4579i;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            String str = arrayList.get(i3);
            i3++;
            String str2 = str;
            if (str2 != null && bVar.f4475a.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(LinkedHashMap<l7.b, Object> linkedHashMap, l7.b bVar) {
        if (linkedHashMap != null) {
            return linkedHashMap.containsKey(bVar);
        }
        return false;
    }

    public l7.c a(l7.b bVar) {
        if (!this.f4572a || !b(bVar)) {
            return null;
        }
        a();
        synchronized (this.f4576f) {
            try {
                if (a(this.e, bVar)) {
                    return new l7.c(b(this.e, bVar), true);
                }
                synchronized (this.f4578h) {
                    if (a(this.f4577g, bVar)) {
                        while (!a(this.e, bVar) && a(this.f4577g, bVar)) {
                            try {
                                this.f4578h.wait(1000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        this.f4577g.put(bVar, null);
                    }
                }
                return new l7.c(b(this.e, bVar), false);
            } finally {
            }
        }
    }

    public void a(l7.b bVar, Object obj) {
        l7.b bVar2;
        if (this.f4572a && bVar != null && b(bVar)) {
            synchronized (this.f4576f) {
                try {
                    int size = this.e.size();
                    if (size > 0 && size >= this.f4574c) {
                        Iterator<l7.b> it = this.e.keySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                bVar2 = null;
                                break;
                            } else {
                                bVar2 = it.next();
                                if (bVar2 != null) {
                                    break;
                                }
                            }
                        }
                        c(this.e, bVar2);
                    }
                    a();
                    this.e.put(bVar, obj);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            synchronized (this.f4578h) {
                c(this.f4577g, bVar);
                this.f4578h.notify();
            }
        }
    }

    private void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if ((currentTimeMillis - this.f4575d) / 1000 > this.f4573b) {
            this.e.clear();
            this.f4575d = currentTimeMillis;
        }
    }

    public void a(l7.a aVar) {
        if (aVar != null) {
            this.f4572a = aVar.d();
            this.f4573b = aVar.c();
            this.f4574c = aVar.b();
        }
    }
}
