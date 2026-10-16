package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.m9;
import com.amap.api.services.core.ServiceSettings;

/* loaded from: classes.dex */
public class m6 {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f4571a = {"com.amap.api.services", "com.amap.api.search.admic"};

    public static String a(Context context) {
        g9 b3 = g9.b(context);
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://" + b3.a(62);
        }
        return "https://" + b3.a(62);
    }

    public static String b(Context context) {
        int protocol = ServiceSettings.getInstance().getProtocol();
        g9 b3 = g9.b(context);
        if (protocol == 1) {
            return "http://" + b3.a(60) + "/v3";
        }
        return "https://" + b3.a(60) + "/v3";
    }

    public static String c(Context context) {
        g9 b3 = g9.b(context);
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://" + b3.a(60) + "/v4";
        }
        return "https://" + b3.a(60) + "/v4";
    }

    public static String d(Context context) {
        ServiceSettings serviceSettings = ServiceSettings.getInstance();
        g9 b3 = g9.b(context);
        if (serviceSettings.getProtocol() == 1) {
            return "http://" + b3.a(60) + "/v5";
        }
        return "https://" + b3.a(60) + "/v5";
    }

    public static String e(Context context) {
        g9 b3 = g9.b(context);
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://" + b3.a(60) + "/rest/me/cpoint";
        }
        return "https://" + b3.a(60) + "/rest/me/cpoint";
    }

    public static String f(Context context) {
        g9 b3 = g9.b(context);
        if (ServiceSettings.getInstance().getProtocol() == 1) {
            return "http://" + b3.a(61);
        }
        return "https://" + b3.a(61);
    }

    public static m9 a(boolean z5) {
        try {
            return new m9.a("sea", "9.7.4", "AMAP SDK Android Search 9.7.4").a(f4571a).a(z5).a("9.7.4").a();
        } catch (a9 e) {
            d6.a(e, "ConfigableConst", "getSDKInfo");
            return null;
        }
    }
}
