package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class p9 {

    /* renamed from: a, reason: collision with root package name */
    private String f4824a;

    /* renamed from: b, reason: collision with root package name */
    private int f4825b;

    /* renamed from: c, reason: collision with root package name */
    private long f4826c = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name */
    private String f4827d;

    private p9(int i3, String str, String str2) {
        this.f4824a = str2;
        this.f4825b = i3;
        this.f4827d = str;
    }

    public static p9 a(String str, String str2) {
        return new p9(2, str, str2);
    }

    public static p9 b(String str, String str2) {
        return new p9(1, str, str2);
    }

    public int c() {
        return this.f4825b;
    }

    public String a() {
        return this.f4825b == 2 ? "error" : "info";
    }

    public String b() {
        new JSONObject();
        return this.f4824a;
    }

    public static String a(Context context, List<p9> list) {
        String str;
        if (list == null) {
            return "";
        }
        try {
            if (list.size() == 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (p9 p9Var : list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", p9Var.b());
                    jSONObject.put("session", p9Var.f4827d);
                    jSONObject.put("timestamp", p9Var.f4826c);
                    str = jSONObject.toString();
                } catch (Throwable unused) {
                    str = "";
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONArray.put(str);
                }
            }
            return jSONArray.toString();
        } catch (Throwable unused2) {
            return "";
        }
    }
}
