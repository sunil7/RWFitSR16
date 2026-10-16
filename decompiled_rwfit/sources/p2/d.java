package p2;

import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f17401a = o2.m.i("Schedulers");

    public static void a(o2.b bVar, WorkDatabase workDatabase, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        p0.f n4 = workDatabase.n();
        workDatabase.c();
        try {
            ArrayList c9 = n4.c(bVar.f16697h);
            ArrayList b3 = n4.b();
            if (c9.size() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                int size = c9.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = c9.get(i3);
                    i3++;
                    n4.j(currentTimeMillis, ((x2.h) obj).f19749a);
                }
            }
            workDatabase.h();
            workDatabase.f();
            if (c9.size() > 0) {
                x2.h[] hVarArr = (x2.h[]) c9.toArray(new x2.h[c9.size()]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.f()) {
                        cVar.d(hVarArr);
                    }
                }
            }
            if (b3.size() > 0) {
                x2.h[] hVarArr2 = (x2.h[]) b3.toArray(new x2.h[b3.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    c cVar2 = (c) it2.next();
                    if (!cVar2.f()) {
                        cVar2.d(hVarArr2);
                    }
                }
            }
        } catch (Throwable th2) {
            workDatabase.f();
            throw th2;
        }
    }
}
