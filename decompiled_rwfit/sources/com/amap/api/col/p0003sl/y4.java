package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class y4 {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, z4> f5458a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private static String f5459b = "";

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f5460c = 0;

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            f5458a.put("overlay", new b5());
            f5458a.put("normal", new a5());
        } catch (Throwable unused) {
        }
        try {
            q9.a(v4.b()).a(context.getApplicationContext());
        } catch (Throwable unused2) {
        }
    }

    public static void b(String str, String str2) {
        a(0, "normal", f5459b, str, str2);
    }

    public static void c(String str, String str2) {
        a(1, "overlay", f5459b, str, str2);
    }

    public static void d(String str, String str2) {
        a(0, "overlay", f5459b, str, str2);
    }

    public static void a(String str, String str2) {
        a(1, "normal", f5459b, str, str2);
    }

    private static void a(int i3, String str, String str2, String str3, String str4) {
        Map<String, z4> map;
        z4 z4Var;
        try {
            String str5 = str3 + str4;
            if (!x4.f5332a || (map = f5458a) == null || (z4Var = map.get(str)) == null) {
                return;
            }
            z4Var.a(i3, str2, str5);
        } catch (Throwable unused) {
        }
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean a3 = c9.a(jSONObject.optString("able", ""), false);
            boolean a10 = c9.a(jSONObject.optString("mobile", ""), false);
            boolean a11 = c9.a(jSONObject.optString("debugupload", ""), false);
            boolean a12 = c9.a(jSONObject.optString("debugwrite", ""), false);
            boolean a13 = c9.a(jSONObject.optString("forcedUpload", ""), false);
            x4.f5332a = a3;
            boolean a14 = c9.a(jSONObject.optString("di", ""), false);
            String optString = jSONObject.optString("dis", "");
            if (!a14 || n9.d(optString)) {
                q9.a(v4.b()).a(a3, a10, a12, a11, Arrays.asList(jSONObject.optString("filter", "").split(Const.STR_MART_ADD)));
                if (a13) {
                    q9.a(v4.b()).c(a13);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a() {
        try {
            if (x4.f5332a) {
                Iterator<Map.Entry<String, z4>> it = f5458a.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().flush();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, MarkerOptions markerOptions) {
        if (markerOptions != null) {
            StringBuilder u10 = l0.u(str2, " ");
            u10.append(markerOptions.getPosition());
            u10.append(" ");
            u10.append(markerOptions.getIcons());
            c(str, u10.toString());
            return;
        }
        c(str, str2);
    }
}
