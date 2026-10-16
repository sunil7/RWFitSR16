package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class t4 {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f5077a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f5078b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f5079c = false;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f5080d = false;
    private static boolean e = false;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f5081f = false;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f5082g = false;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f5083h = false;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f5084i = false;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f5085j = false;

    /* renamed from: k, reason: collision with root package name */
    private static HashMap<String, Boolean> f5086k = new HashMap<>();

    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public static void a(Context context, boolean z5) {
        String str;
        try {
            try {
                str = "{\"Quest\":" + z5 + "}";
            } catch (Throwable th2) {
                th2.printStackTrace();
                str = null;
            }
            zb zbVar = new zb(context, "3dmap", "11.1.063", "O001");
            zbVar.a(str);
            ac.a(zbVar, context);
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public static void b(Context context, boolean z5) {
        if (f5077a) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_stylemap", Integer.valueOf(z5 ? 1 : 0));
            a(context, "O006", a(hashMap));
            f5077a = true;
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context, boolean z5) {
        if (f5078b) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_indoormap", Integer.valueOf(z5 ? 1 : 0));
            a(context, "O007", a(hashMap));
            f5078b = true;
        } catch (Throwable unused) {
        }
    }

    public static void d(Context context) {
        if (f5080d) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_offlinemap", 1);
            a(context, "O010", a(hashMap));
            f5080d = true;
        } catch (Throwable unused) {
        }
    }

    public static void e(Context context) {
        if (e) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_particleoverlay", 1);
            a(context, "O011", a(hashMap));
            e = true;
        } catch (Throwable unused) {
        }
    }

    public static void f(Context context) {
        if (f5083h) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_wxmapreview", 1);
            a(context, ReportUtil.STATISTICS_ID_LOCTIME_NOTGPS, a(hashMap));
            f5083h = true;
        } catch (Throwable unused) {
        }
    }

    public static void g(Context context) {
        if (f5081f) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_renderfps", 1);
            a(context, ReportUtil.STATISTICS_ID_LOCTIME_NETWORK, a(hashMap));
            f5081f = true;
        } catch (Throwable unused) {
        }
    }

    public static void h(Context context) {
        if (f5084i) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_dxmapreview", 1);
            a(context, "0016", a(hashMap));
            f5084i = true;
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context) {
        if (f5079c) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_heatmap", 1);
            a(context, "O009", a(hashMap));
            f5079c = true;
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context) {
        if (f5082g) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_bzmapreview", 1);
            a(context, ReportUtil.STATISTICS_ID_SERVICE_ALIVE_TIME, a(hashMap));
            f5082g = true;
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, long j4) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_rendertime", Long.valueOf(j4));
            hashMap.put("amap_3dmap_render_background", 0L);
            a(context, "O005", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_engine_init_fail", str);
            a(context, ReportUtil.STATICS_ID_COORDINATE, a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_res_load_fail", str);
            a(context, "O022", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static synchronized void a(Context context, String str) {
        synchronized (t4.class) {
            if (f5086k != null && !TextUtils.isEmpty(str)) {
                if (f5086k.containsKey(str) && f5086k.get(str).booleanValue()) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("amap_3dmap_coordinate", str);
                a(context, "O008", a(hashMap));
                if (!f5086k.containsKey(str)) {
                    f5086k.put(str, Boolean.TRUE);
                }
            }
        }
    }

    public static void a(Context context) {
        if (f5085j) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_buildingoverlay", 1);
            a(context, ReportUtil.STATISTICS_ID_LOCTIME_GPS, a(hashMap));
            f5085j = true;
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_draw_fail", Integer.valueOf(i3));
            a(context, ReportUtil.STATICS_ID_OFFLINECOUNT, a(hashMap));
        } catch (Throwable unused) {
        }
    }

    private static <T> String a(Map<String, T> map) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Const.STR_MART_JSON_BEGIN);
            for (Map.Entry<String, T> entry : map.entrySet()) {
                sb2.append("\"" + entry.getKey() + "\":");
                sb2.append(entry.getValue());
                sb2.append(Const.STR_MART_COMMA);
            }
            sb2.deleteCharAt(sb2.length() - 1);
            sb2.append("}");
            return sb2.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    private static void a(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            zb zbVar = new zb(context, "3dmap", "11.1.063", str);
            zbVar.a(str2);
            ac.a(zbVar, context);
        } catch (Throwable unused) {
        }
    }
}
