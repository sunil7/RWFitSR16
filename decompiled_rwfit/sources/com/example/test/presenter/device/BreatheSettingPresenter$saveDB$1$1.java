package com.example.test.presenter.device;

import com.example.blesdk.bean.function.BreatheBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.Devices;
import com.example.database.table.User;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
final class BreatheSettingPresenter$saveDB$1$1 extends Lambda implements oh.l {
    public static final BreatheSettingPresenter$saveDB$1$1 INSTANCE = new BreatheSettingPresenter$saveDB$1$1();

    public BreatheSettingPresenter$saveDB$1$1() {
        super(1);
    }

    @Override // oh.l
    public final Long invoke(BreatheBean it) {
        Devices c9;
        kotlin.jvm.internal.e.f(it, "it");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        User d5 = kVar != null ? kVar.d() : null;
        if (d5 != null) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            if (kVar2 != null && (c9 = kVar2.c()) != null) {
                DataSetting dataSetting = new DataSetting();
                dataSetting.setUserId(d5.getUserId());
                dataSetting.setMac(c9.getMacAddress());
                dataSetting.setDataKey("setting_breathe");
                dataSetting.setDataValue(com.example.baselibrary.utils.b.z(it));
                return Long.valueOf(SettingImpl.INSTANCE.saveData(dataSetting));
            }
        }
        return null;
    }
}
