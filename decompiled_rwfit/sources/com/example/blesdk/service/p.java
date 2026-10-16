package com.example.blesdk.service;

import android.util.Log;
import com.example.test.service.s1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class p implements v5.y {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f7330a;

    public p(y yVar) {
        this.f7330a = yVar;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        y yVar = this.f7330a;
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "心率同步失败[" + i3 + ']');
        x5.b I0 = x5.b.I0();
        if (I0.J0(this)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == this) {
                    break;
                }
            }
            if (cVar != null) {
                linkedList.remove(cVar);
            }
        }
        yVar.f7340a = 40;
        y.b(yVar, 2);
        y.f(yVar);
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        List list = (List) obj;
        StringBuilder sb2 = new StringBuilder("onResult hr ");
        u5.c cVar = null;
        sb2.append(list != null ? Integer.valueOf(list.size()) : null);
        Log.e("qob", sb2.toString());
        y yVar = this.f7330a;
        yVar.f7340a = 40;
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -63, new byte[]{5, 3, 48}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) -63);
            }
            Iterator it = yVar.m().iterator();
            while (it.hasNext()) {
                ((s1) ((u5.h) it.next())).g(list);
            }
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -62, new byte[]{5, 3, 16}, new boolean[0]);
                return;
            } else {
                x5.b.I0().F0((byte) -62);
                return;
            }
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(this)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it2 = linkedList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                u5.c cVar2 = (u5.c) it2.next();
                if (cVar2 != null && cVar2.g() == this) {
                    cVar = cVar2;
                    break;
                }
            }
            if (cVar != null) {
                linkedList.remove(cVar);
            }
        }
        Iterator it3 = yVar.m().iterator();
        while (it3.hasNext()) {
            ((s1) ((u5.h) it3.next())).g(list);
        }
        y.f(yVar);
    }
}
