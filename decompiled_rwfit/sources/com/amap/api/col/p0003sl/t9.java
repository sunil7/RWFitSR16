package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class t9 {

    /* renamed from: a, reason: collision with root package name */
    private m9 f5098a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Map<String, t9> f5099a = new HashMap();
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f5100a;

        /* renamed from: b, reason: collision with root package name */
        private String f5101b;

        /* renamed from: c, reason: collision with root package name */
        private String f5102c;

        public b(String str, String str2, String str3) {
            this.f5100a = str;
            this.f5101b = str2;
            this.f5102c = str3;
        }

        public final boolean a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                str = this.f5100a;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f5101b;
            }
            return this.f5100a.equals(str) && this.f5101b.equals(str2);
        }

        public static JSONArray a(List<b> list) {
            JSONArray jSONArray = new JSONArray();
            for (b bVar : list) {
                if (bVar != null && !TextUtils.isEmpty(bVar.f5102c)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("sdkVersion", bVar.f5100a);
                        jSONObject.put("cpuType", bVar.f5101b);
                        jSONObject.put("content", bVar.f5102c);
                    } catch (Throwable unused) {
                        jSONObject = new JSONObject();
                    }
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray;
        }

        public static List<b> a(String str) {
            b bVar;
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    try {
                        bVar = new b(jSONObject.optString("sdkVersion"), jSONObject.optString("cpuType"), jSONObject.optString("content"));
                    } catch (Throwable unused) {
                        bVar = null;
                    }
                    arrayList.add(bVar);
                }
                return arrayList;
            } catch (Throwable unused2) {
                return new ArrayList();
            }
        }
    }

    private t9(m9 m9Var) {
        this.f5098a = m9Var;
    }

    public static t9 a(m9 m9Var) {
        if (m9Var == null || TextUtils.isEmpty(m9Var.d())) {
            return null;
        }
        if (a.f5099a.get(m9Var.d()) == null) {
            a.f5099a.put(m9Var.d(), new t9(m9Var));
        }
        return a.f5099a.get(m9Var.d());
    }

    private static void b(Context context, String str, String str2, String str3) {
        if (str3 == null || TextUtils.isEmpty(str)) {
            return;
        }
        String str4 = "C7ADB20F22F238708BA5EE26D0401DB9" + e9.c(str);
        String concat = "ik".concat(String.valueOf(str2));
        if (TextUtils.isEmpty(concat) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            return;
        }
        String b3 = n9.b(z8.b(n9.e(str3)));
        SharedPreferences.Editor edit = context.getSharedPreferences(str4, 0).edit();
        edit.putString(concat, b3);
        edit.commit();
    }

    public final String a(Context context, String str, String str2, String str3) {
        m9 m9Var;
        if (context != null && (m9Var = this.f5098a) != null && !TextUtils.isEmpty(m9Var.d())) {
            ArrayList arrayList = (ArrayList) b.a(a(context, this.f5098a.d(), str3));
            if (arrayList.size() == 0) {
                return "";
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                b bVar = (b) arrayList.get(i3);
                if (bVar.a(str, str2)) {
                    return bVar.f5102c;
                }
            }
        }
        return null;
    }

    public final void a(Context context, String str, String str2, String str3, String str4) {
        m9 m9Var;
        if (context == null || (m9Var = this.f5098a) == null || TextUtils.isEmpty(m9Var.d())) {
            return;
        }
        List<b> a3 = b.a(a(context, this.f5098a.d(), str3));
        int i3 = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) a3;
            if (i3 < arrayList.size()) {
                b bVar = (b) arrayList.get(i3);
                if (bVar.a(str, str2)) {
                    bVar.f5102c = str4;
                    b(context, this.f5098a.d(), str3, b.a(a3).toString());
                    return;
                }
                i3++;
            } else {
                arrayList.add(new b(str, str2, str4));
                b(context, this.f5098a.d(), str3, b.a(a3).toString());
                return;
            }
        }
    }

    private static String a(Context context, String str, String str2) {
        String str3 = "C7ADB20F22F238708BA5EE26D0401DB9" + e9.c(str);
        String concat = "ik".concat(String.valueOf(str2));
        return TextUtils.isEmpty(concat) ? "" : n9.c(z8.a(n9.c(context.getSharedPreferences(str3, 0).getString(concat, ""))));
    }
}
