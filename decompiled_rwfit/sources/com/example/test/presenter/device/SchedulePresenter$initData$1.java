package com.example.test.presenter.device;

import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
final class SchedulePresenter$initData$1 extends Lambda implements oh.l {
    public static final SchedulePresenter$initData$1 INSTANCE = new SchedulePresenter$initData$1();

    public SchedulePresenter$initData$1() {
        super(1);
    }

    @Override // oh.l
    public final DataSetting invoke(String it) {
        kotlin.jvm.internal.e.f(it, "it");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        User d5 = kVar != null ? kVar.d() : null;
        if (d5 == null) {
            return null;
        }
        SettingImpl settingImpl = SettingImpl.INSTANCE;
        String userId = d5.getUserId();
        String str = android.support.v4.media.session.e.y(userId, "getUserId(...)").f18212c;
        kotlin.jvm.internal.e.e(str, "getBleMac(...)");
        return settingImpl.getData(userId, str, "setting_schedule");
    }
}
