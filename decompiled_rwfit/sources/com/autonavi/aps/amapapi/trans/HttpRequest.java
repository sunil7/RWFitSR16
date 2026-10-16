package com.autonavi.aps.amapapi.trans;

import android.text.TextUtils;
import com.amap.api.col.p0003sl.j9;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpRequest extends j9 {

    /* renamed from: m, reason: collision with root package name */
    Map<String, String> f6763m = null;

    /* renamed from: n, reason: collision with root package name */
    Map<String, String> f6764n = null;

    /* renamed from: o, reason: collision with root package name */
    String f6765o = "";

    /* renamed from: p, reason: collision with root package name */
    byte[] f6766p = null;

    /* renamed from: q, reason: collision with root package name */
    private String f6767q = null;

    @Override // com.amap.api.col.p0003sl.pb
    public byte[] getEntityBytes() {
        return this.f6766p;
    }

    @Override // com.amap.api.col.p0003sl.j9, com.amap.api.col.p0003sl.pb
    public String getIPV6URL() {
        return !TextUtils.isEmpty(this.f6767q) ? this.f6767q : super.getIPV6URL();
    }

    @Override // com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        return this.f6764n;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public Map<String, String> getRequestHead() {
        return this.f6763m;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        return this.f6765o;
    }

    public void setEntity(byte[] bArr) {
        this.f6766p = bArr;
    }

    public void setHead(Map<String, String> map) {
        this.f6763m = map;
    }

    public void setIpv6Url(String str) {
        this.f6767q = str;
    }

    public void setParams(Map<String, String> map) {
        this.f6764n = map;
    }

    public void setUrl(String str) {
        this.f6765o = str;
    }
}
