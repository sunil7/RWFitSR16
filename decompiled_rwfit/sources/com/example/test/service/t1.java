package com.example.test.service;

import android.util.Log;
import com.example.blesdk.bean.function.BrightVibrationBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.model.EventBusBeans;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class t1 implements v5.k0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1 f7808a;

    public t1(u1 u1Var) {
        this.f7808a = u1Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        this.f7808a.getClass();
        Log.e("SyncService", "SyncService vibrationCountCallback onFail " + i3);
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
        this.f7808a.getClass();
        Log.e("SyncService", "SyncService vibrationCountCallback onSuccess");
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
        BrightVibrationBean brightVibrationBean = (BrightVibrationBean) obj;
        if (brightVibrationBean != null) {
            this.f7808a.getClass();
            Log.e("SyncService", "SyncService vibrationCountCallback onResult");
            com.example.baselibrary.utils.b.x(brightVibrationBean, new oh.l() { // from class: com.example.test.service.SyncService$savebrightVibrationDB$1$1
                @Override // oh.l
                public final Long invoke(BrightVibrationBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(e.h().g().f18212c);
                    dataSetting.setDataKey("setting_vibration_level");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(it));
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                    User d5 = kVar != null ? kVar.d() : null;
                    if (d5 != null) {
                        dataSetting.setUserId(d5.getUserId());
                    }
                    return Long.valueOf(SettingImpl.INSTANCE.saveData(dataSetting));
                }
            }, new oh.l() { // from class: com.example.test.service.SyncService$savebrightVibrationDB$1$2
                public final void invoke(long j4) {
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke(((Number) obj2).longValue());
                    return eh.g.f12633a;
                }
            });
            yh.d.b().e(new EventBusBeans.DeviceFunEvent(91));
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
