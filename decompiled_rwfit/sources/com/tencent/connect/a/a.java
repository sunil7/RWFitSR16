package com.tencent.connect.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Class<?> f11690a = null;

    /* renamed from: b, reason: collision with root package name */
    private static Class<?> f11691b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Method f11692c = null;

    /* renamed from: d, reason: collision with root package name */
    private static Method f11693d = null;
    private static Method e = null;

    /* renamed from: f, reason: collision with root package name */
    private static Method f11694f = null;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f11695g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return i.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f11694f.invoke(f11690a, Boolean.TRUE);
            } else {
                f11694f.invoke(f11690a, Boolean.FALSE);
            }
        } catch (Exception e10) {
            SLog.e("OpenConfig", "checkStatStatus exception: " + e10.toString());
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String n4 = l0.n("Aqc", qQToken.getAppId());
        try {
            f11690a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f11691b = cls;
            f11692c = cls.getMethod("reportQQ", Context.class, String.class);
            f11693d = f11691b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            Class<?> cls2 = f11691b;
            Class cls3 = Integer.TYPE;
            e = cls2.getMethod("commitEvents", Context.class, cls3);
            Class<?> cls4 = f11690a;
            Class cls5 = Boolean.TYPE;
            f11694f = cls4.getMethod("setEnableStatService", cls5);
            b(context, qQToken);
            f11690a.getMethod("setAutoExceptionCaught", cls5).invoke(f11690a, Boolean.FALSE);
            f11690a.getMethod("setEnableSmartReporting", cls5).invoke(f11690a, Boolean.TRUE);
            f11690a.getMethod("setSendPeriodMinutes", cls3).invoke(f11690a, 1440);
            Class<?> cls6 = Class.forName("com.tencent.stat.StatReportStrategy");
            f11690a.getMethod("setStatSendStrategy", cls6).invoke(f11690a, cls6.getField("PERIOD").get(null));
            f11691b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f11691b, context, n4, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f11695g = true;
        } catch (Exception e10) {
            SLog.e("OpenConfig", "start4QQConnect exception: " + e10.toString());
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (!TextUtils.isEmpty(qQToken.getOpenId())) {
            e.a().a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "0", "0", "0");
        }
        if (f11695g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f11692c.invoke(f11691b, context, qQToken.getOpenId());
                } catch (Exception e10) {
                    SLog.e("OpenConfig", "reportQQ exception: " + e10.toString());
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f11695g) {
            b(context, qQToken);
            try {
                f11693d.invoke(f11691b, context, str, strArr);
            } catch (Exception e10) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e10.toString());
            }
        }
    }
}
