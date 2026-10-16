package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.pb;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ia extends j9 {

    /* renamed from: m, reason: collision with root package name */
    private byte[] f4304m;

    /* renamed from: n, reason: collision with root package name */
    private String f4305n;

    public ia(byte[] bArr, String str) {
        this.f4305n = "1";
        this.f4304m = (byte[]) bArr.clone();
        this.f4305n = str;
        setDegradeAbility(pb.a.SINGLE);
        setHttpProtocol(pb.c.HTTP);
    }

    @Override // com.amap.api.col.p0003sl.pb
    public byte[] getEntityBytes() {
        return this.f4304m;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f4304m.length));
        return hashMap;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        boolean z5 = ca.f3870b;
        String b3 = n9.b("IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz");
        String str = this.f4305n;
        byte[] e = n9.e("9aj&#k81");
        byte[] bArr = new byte[e.length + 50];
        System.arraycopy(this.f4304m, 0, bArr, 0, 50);
        System.arraycopy(e, 0, bArr, 50, e.length);
        return String.format(b3, "1", str, "1", "open", e9.a(bArr));
    }

    @Override // com.amap.api.col.p0003sl.pb
    public boolean isHostToIP() {
        return false;
    }
}
