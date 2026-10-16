package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.pb;
import java.util.Map;

/* loaded from: classes.dex */
public class hb extends pb {

    /* renamed from: m, reason: collision with root package name */
    private byte[] f4274m;

    /* renamed from: n, reason: collision with root package name */
    private Map<String, String> f4275n;

    public hb(byte[] bArr, Map<String, String> map) {
        this.f4274m = bArr;
        this.f4275n = map;
        setDegradeAbility(pb.a.SINGLE);
        setHttpProtocol(pb.c.HTTPS);
    }

    @Override // com.amap.api.col.p0003sl.pb
    public byte[] getEntityBytes() {
        return this.f4274m;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        return this.f4275n;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }
}
