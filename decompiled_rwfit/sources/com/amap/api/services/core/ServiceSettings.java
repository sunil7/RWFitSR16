package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.col.p0003sl.d6;
import com.amap.api.col.p0003sl.d9;
import com.amap.api.col.p0003sl.i9;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.m6;
import com.amap.api.col.p0003sl.u7;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class ServiceSettings {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    private static ServiceSettings e;

    /* renamed from: a, reason: collision with root package name */
    private String f5974a = "zh-CN";

    /* renamed from: b, reason: collision with root package name */
    private int f5975b = 1;

    /* renamed from: c, reason: collision with root package name */
    private int f5976c = Const.I_CITY_TILE_LEN;

    /* renamed from: d, reason: collision with root package name */
    private int f5977d = Const.I_CITY_TILE_LEN;

    private ServiceSettings() {
    }

    public static ServiceSettings getInstance() {
        if (e == null) {
            e = new ServiceSettings();
        }
        return e;
    }

    public static synchronized void updatePrivacyAgree(Context context, boolean z5) {
        synchronized (ServiceSettings.class) {
            k9.a(context, z5, m6.a(false));
        }
    }

    public static synchronized void updatePrivacyShow(Context context, boolean z5, boolean z6) {
        synchronized (ServiceSettings.class) {
            k9.a(context, z5, z6, m6.a(false));
        }
    }

    public void destroyInnerAsynThreadPool() {
        try {
            u7.a();
        } catch (Throwable th2) {
            d6.a(th2, "ServiceSettings", "destroyInnerAsynThreadPool");
        }
    }

    public int getConnectionTimeOut() {
        return this.f5976c;
    }

    public String getLanguage() {
        return this.f5974a;
    }

    public int getProtocol() {
        return this.f5975b;
    }

    public int getSoTimeOut() {
        return this.f5977d;
    }

    public void setApiKey(String str) {
        d9.a(str);
    }

    public void setConnectionTimeOut(int i3) {
        if (i3 < 5000) {
            this.f5976c = 5000;
        } else if (i3 > 30000) {
            this.f5976c = Const.I_LOC_JUMP_DELAY;
        } else {
            this.f5976c = i3;
        }
    }

    public void setLanguage(String str) {
        this.f5974a = str;
    }

    public void setProtocol(int i3) {
        this.f5975b = i3;
        i9.a().b(this.f5975b == 2);
    }

    public void setSoTimeOut(int i3) {
        if (i3 < 5000) {
            this.f5977d = 5000;
        } else if (i3 > 30000) {
            this.f5977d = Const.I_LOC_JUMP_DELAY;
        } else {
            this.f5977d = i3;
        }
    }
}
