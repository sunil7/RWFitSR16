package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.i9;
import com.autonavi.aps.amapapi.config.Const;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ra extends j9 {

    /* renamed from: m, reason: collision with root package name */
    public JSONObject f4959m = null;

    /* renamed from: n, reason: collision with root package name */
    public Context f4960n = null;

    @Override // com.amap.api.col.p0003sl.pb
    public final byte[] getEntityBytes() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            JSONObject jSONObject = this.f4959m;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    stringBuffer.append(next + "=" + URLEncoder.encode(this.f4959m.get(next).toString(), "utf-8") + Const.STR_MART_ADD);
                }
            }
            stringBuffer.append("output=json");
            String e = b9.e(this.f4960n);
            stringBuffer.append("&key=".concat(String.valueOf(e)));
            String c9 = e9.c();
            stringBuffer.append("&ts=".concat(String.valueOf(c9)));
            StringBuilder sb2 = new StringBuilder("&scode=");
            sb2.append(e9.a(this.f4960n, c9, "key=".concat(String.valueOf(e))));
            stringBuffer.append(sb2.toString());
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.pb
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public final Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.17");
        hashMap.put("X-INFO", e9.b(this.f4960n));
        hashMap.put("platinfo", "platform=Android&sdkversion=4.3.17&product=core");
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public final String getSDKName() {
        return "core";
    }

    @Override // com.amap.api.col.p0003sl.pb
    public final String getURL() {
        return i9.a.f4300a.b() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }
}
