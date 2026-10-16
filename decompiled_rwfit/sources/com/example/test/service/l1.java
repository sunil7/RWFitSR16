package com.example.test.service;

import android.util.Log;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class l1 implements v5.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1 f7730a;

    public l1(u1 u1Var) {
        this.f7730a = u1Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        this.f7730a.getClass();
        Log.e("SyncService", "SyncService muslimCountSwitchCallback onFail " + i3);
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
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }

    @Override // u5.g
    public final void c() {
        u5.c cVar;
        this.f7730a.getClass();
        Log.e("SyncService", "SyncService muslimCountSwitchCallback onSuccess");
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
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        u5.c cVar;
        Integer num = (Integer) obj;
        if (num != null) {
            this.f7730a.getClass();
            Log.e("SyncService", "SyncService muslimCountSwitchCallback onResult " + num);
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                kVar.Z(num.intValue());
            }
            yh.d.b().e(new EventBusBeans.DeviceFunEvent(92));
            Object obj2 = com.example.test.utils.m.f8734b;
            yh.d.b().e(new EventBusBeans.DeviceSupportEvent(d2.a().f8735a));
        }
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
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }
}
