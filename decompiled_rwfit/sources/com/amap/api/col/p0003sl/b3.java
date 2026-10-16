package com.amap.api.col.p0003sl;

import java.util.Hashtable;
import java.util.Map;

/* loaded from: classes.dex */
public class b3 extends b4 {

    /* renamed from: m, reason: collision with root package name */
    private String f3774m;

    public b3(String str) {
        this.f3774m = str;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getIPV6URL() {
        return this.f3774m;
    }

    @Override // com.amap.api.col.p0003sl.b4, com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(32);
        hashtable.put("User-Agent", "MAC=channel:amapapi");
        return hashtable;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return this.f3774m;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public boolean isSupportIPV6() {
        return false;
    }
}
