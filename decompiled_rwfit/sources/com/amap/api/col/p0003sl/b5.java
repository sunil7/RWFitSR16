package com.amap.api.col.p0003sl;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class b5 implements z4 {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, a> f3775a = new ConcurrentHashMap();

    public class a {

        /* renamed from: a, reason: collision with root package name */
        String f3776a;

        /* renamed from: b, reason: collision with root package name */
        String f3777b;

        /* renamed from: c, reason: collision with root package name */
        int f3778c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicInteger f3779d = new AtomicInteger(0);

        public a(b5 b5Var, int i3, String str, String str2) {
            this.f3776a = str;
            this.f3777b = str2;
            this.f3778c = i3;
        }
    }

    @Override // com.amap.api.col.p0003sl.z4
    public void a(int i3, String str, String str2) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i3);
            String str3 = "";
            sb2.append(str == null ? "" : str);
            if (str2 != null) {
                str3 = str2;
            }
            sb2.append(str3);
            String sb3 = sb2.toString();
            a aVar = f3775a.get(sb3);
            if (aVar == null) {
                aVar = new a(this, i3, str, str2);
                f3775a.put(sb3, aVar);
            }
            if (aVar.f3779d.incrementAndGet() > 100) {
                a(aVar.f3778c, aVar.f3776a, aVar.f3777b, aVar.f3779d.get());
                f3775a.remove(sb3);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.p0003sl.z4
    public void flush() {
        try {
            Iterator<Map.Entry<String, a>> it = f3775a.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null) {
                    a(value.f3778c, value.f3776a, value.f3777b, value.f3779d.get());
                }
            }
            f3775a.clear();
            q9.a(v4.b()).e();
        } catch (Throwable unused) {
        }
    }

    private void a(int i3, String str, String str2, int i10) {
        if (i3 == 0) {
            q9.a(v4.b()).a(p9.b(str, str2 + " counter " + i10));
            return;
        }
        q9.a(v4.b()).a(p9.b(str, str2 + " counter " + i10));
    }
}
