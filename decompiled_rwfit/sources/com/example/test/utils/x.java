package com.example.test.utils;

import android.app.Application;
import com.autonavi.aps.amapapi.config.Const;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.ui.device.model.MsgDataModel;
import com.example.test.ui.device.model.NotificationInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: b, reason: collision with root package name */
    public static x f8767b;

    /* renamed from: a, reason: collision with root package name */
    public List f8768a;

    public static x a() {
        if (f8767b == null) {
            synchronized (x.class) {
                f8767b = new x();
            }
        }
        return f8767b;
    }

    public static boolean d(int i3) {
        s5.a g10;
        String str;
        DataSetting data;
        String dataValue;
        if (k.f8731b == null) {
            synchronized (k.class) {
                k.f8731b = new k();
            }
        }
        k kVar = k.f8731b;
        boolean z5 = false;
        if (kVar != null) {
            if (kVar == null) {
                synchronized (k.class) {
                    k.f8731b = new k();
                }
            }
            User d5 = k.f8731b.d();
            if (d5 != null && d5.getUserId() != null && !d5.getUserId().isEmpty() && com.example.test.service.e.h().g() != null && (g10 = com.example.test.service.e.h().g()) != null && (str = g10.f18212c) != null && !str.isEmpty() && (data = SettingImpl.INSTANCE.getData(d5.getUserId(), g10.f18212c, "setting_message")) != null && (dataValue = data.getDataValue()) != null && dataValue.length() != 0 && !"null".equalsIgnoreCase(dataValue)) {
                for (MsgDataModel msgDataModel : com.example.baselibrary.utils.b.h(data.getDataValue(), new w().f3204b)) {
                    if (msgDataModel.getAppId() == 24) {
                        z5 = msgDataModel.isOpen();
                    }
                    if (msgDataModel.getAppId() == i3) {
                        return msgDataModel.isOpen();
                    }
                }
            }
        }
        return z5;
    }

    public final int b(String str) {
        List list = this.f8768a;
        if (list == null || list.isEmpty()) {
            return 24;
        }
        if (!((str == null || str.length() == 0 || "null".equalsIgnoreCase(str)) ? false : true)) {
            return 24;
        }
        for (NotificationInfo notificationInfo : this.f8768a) {
            for (String str2 : notificationInfo.getAppPackages().split(Const.STR_MART_ADD)) {
                if (str.contains(str2)) {
                    return notificationInfo.getAppId();
                }
            }
        }
        return 24;
    }

    public final void c(Application application) {
        StringBuilder sb2 = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(application.getAssets().open("normal_notification.json")));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else {
                    sb2.append(readLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String sb3 = sb2.toString();
        if (sb3 == null || sb3.length() == 0 || "null".equalsIgnoreCase(sb3)) {
            return;
        }
        this.f8768a = com.example.baselibrary.utils.b.h(sb3, new v().f3204b);
    }
}
