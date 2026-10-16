package com.example.test.service;

import com.example.blesdk.bean.function.BaseAnswerBean;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class d implements u5.g {
    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        e h4 = e.h();
        h4.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "登录设备失败 " + i3);
        if (i3 != 7) {
            h4.f7686f.sendEmptyMessage(8);
        }
        d dVar = h4.f7696p;
        if (dVar != null) {
            x5.b I0 = x5.b.I0();
            if (I0.J0(dVar)) {
                LinkedList linkedList = I0.f19795a;
                Iterator it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        cVar = null;
                        break;
                    }
                    cVar = (u5.c) it.next();
                    if (cVar != null && cVar.g() == dVar) {
                        break;
                    }
                }
                if (cVar == null) {
                    return;
                }
                linkedList.remove(cVar);
            }
        }
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        u5.c cVar;
        if (((BaseAnswerBean) obj).getStatusCode() != 0) {
            e.h().a();
            return;
        }
        e.h().f7689i = true;
        e h4 = e.h();
        h4.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "登录设备成功，设备已绑定");
        h4.f7686f.sendEmptyMessage(1);
        d dVar = h4.f7696p;
        if (dVar != null) {
            x5.b I0 = x5.b.I0();
            if (I0.J0(dVar)) {
                LinkedList linkedList = I0.f19795a;
                Iterator it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        cVar = null;
                        break;
                    }
                    cVar = (u5.c) it.next();
                    if (cVar != null && cVar.g() == dVar) {
                        break;
                    }
                }
                if (cVar == null) {
                    return;
                }
                linkedList.remove(cVar);
            }
        }
    }
}
