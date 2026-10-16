package com.example.test.presenter.device;

import com.example.blesdk.bean.function.AlarmRemainderBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import java.util.List;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
final class AlarmJLPresenter$saveDB$2 extends Lambda implements oh.l {
    public static final AlarmJLPresenter$saveDB$2 INSTANCE = new AlarmJLPresenter$saveDB$2();

    public AlarmJLPresenter$saveDB$2() {
        super(1);
    }

    @Override // oh.l
    public final Long invoke(List<AlarmRemainderBean> it) {
        kotlin.jvm.internal.e.f(it, "it");
        DataSetting dataSetting = new DataSetting();
        dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
        dataSetting.setDataKey("setting_alarm");
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
}
