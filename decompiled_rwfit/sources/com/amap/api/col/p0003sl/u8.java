package com.amap.api.col.p0003sl;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class u8<T, V> extends t8<T, V> {
    public u8(Context context, T t8) {
        super(context, t8);
    }

    @Override // com.amap.api.col.p0003sl.t8
    public V e() {
        return null;
    }

    public abstract String f();

    @Override // com.amap.api.col.p0003sl.pb
    public byte[] getEntityBytes() {
        try {
            return f().getBytes("utf-8");
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.b4, com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.t8, com.amap.api.col.p0003sl.pb
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("Content-Type", " application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Trace 11.1.063");
        hashMap.put("x-INFO", e9.b(this.f5095o));
        Locale locale = Locale.US;
        hashMap.put("platinfo", "platform=Android&sdkversion=11.1.063&product=trace");
        hashMap.put("logversion", "2.1");
        return hashMap;
    }
}
