package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.trans.HttpRequest;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    ib f3626a;

    public b(Context context) {
        this.f3626a = null;
        try {
            i9.a().a(context);
        } catch (Throwable unused) {
        }
        this.f3626a = ib.a();
    }

    public String a(Context context, String str, String str2, String str3, String str4, String str5) {
        Map<String, String> a3 = a(context, str2, str3, str4, str5, null, null, null);
        HashMap hashMap = (HashMap) a3;
        hashMap.put("children", "1");
        hashMap.put("page", "1");
        hashMap.put("extensions", "base");
        return a(context, str, a3);
    }

    public String b(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map<String, String> a3 = a(context, str2, str3, null, str4, str5, str6, str7);
        HashMap hashMap = (HashMap) a3;
        hashMap.put("children", "1");
        hashMap.put("page", "1");
        hashMap.put("extensions", "base");
        return a(context, str, a3);
    }

    public String a(Context context, String str, String str2) {
        Map<String, String> a3 = a(context, str2, null, null, null, null, null, null);
        HashMap hashMap = (HashMap) a3;
        hashMap.put("extensions", "all");
        hashMap.put("subdistrict", "0");
        return a(context, str, a3);
    }

    private String a(Context context, String str, Map<String, String> map) {
        try {
            HashMap hashMap = new HashMap(16);
            HttpRequest httpRequest = new HttpRequest();
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", CoreUtil.HTTP_HEADER_USER_AGENT);
            String c9 = e9.c();
            String a3 = e9.a(context, c9, n9.a(map));
            map.put(Constants.TS, c9);
            map.put("scode", a3);
            httpRequest.setParams(map);
            httpRequest.setHead(hashMap);
            httpRequest.setUrl(str);
            httpRequest.setProxy(e9.d(context));
            httpRequest.setConnectionTimeout(CoreUtil.iTo);
            httpRequest.setSoTimeout(CoreUtil.iTo);
            try {
                return new String(this.f3626a.a(httpRequest).f4927a, "utf-8");
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "GeoFenceNetManager", "post");
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public Map<String, String> a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", b9.e(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("keywords", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            hashMap.put("location", str6 + Const.STR_MART_COMMA + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("city", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("offset", str4);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("radius", str7);
        }
        return hashMap;
    }
}
