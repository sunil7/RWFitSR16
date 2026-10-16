package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.jb;
import com.amap.api.col.p0003sl.m9;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class LocationRequest extends jb {

    /* renamed from: m, reason: collision with root package name */
    Map<String, String> f6773m;

    /* renamed from: n, reason: collision with root package name */
    private String f6774n;

    /* renamed from: o, reason: collision with root package name */
    String f6775o;

    /* renamed from: p, reason: collision with root package name */
    String f6776p;

    /* renamed from: q, reason: collision with root package name */
    byte[] f6777q;
    byte[] r;

    /* renamed from: s, reason: collision with root package name */
    boolean f6778s;

    /* renamed from: t, reason: collision with root package name */
    String f6779t;

    /* renamed from: u, reason: collision with root package name */
    Map<String, String> f6780u;

    /* renamed from: v, reason: collision with root package name */
    boolean f6781v;

    public LocationRequest(Context context, m9 m9Var) {
        super(context, m9Var);
        this.f6773m = null;
        this.f6774n = "";
        this.f6775o = "";
        this.f6776p = "";
        this.f6777q = null;
        this.r = null;
        this.f6778s = false;
        this.f6779t = null;
        this.f6780u = null;
        this.f6781v = false;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getIPDNSName() {
        return this.f6774n;
    }

    @Override // com.amap.api.col.p0003sl.j9, com.amap.api.col.p0003sl.pb
    public String getIPV6URL() {
        return this.f6776p;
    }

    @Override // com.amap.api.col.p0003sl.jb, com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        return this.f6780u;
    }

    @Override // com.amap.api.col.p0003sl.jb
    public String getPlatInfo() {
        return this.f6779t;
    }

    public String getPlatinfo() {
        return this.f6779t;
    }

    @Override // com.amap.api.col.p0003sl.jb
    public byte[] getRawDatas() {
        return this.f6777q;
    }

    @Override // com.amap.api.col.p0003sl.jb, com.amap.api.col.p0003sl.pb
    public Map<String, String> getRequestHead() {
        return this.f6773m;
    }

    @Override // com.amap.api.col.p0003sl.jb
    public byte[] getRsaAesRawDatas() {
        return this.r;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getSDKName() {
        return "loc";
    }

    @Override // com.amap.api.col.p0003sl.jb, com.amap.api.col.p0003sl.pb
    public String getURL() {
        return this.f6775o;
    }

    @Override // com.amap.api.col.p0003sl.jb
    public boolean getXinfoFlag() {
        return this.f6778s;
    }

    @Override // com.amap.api.col.p0003sl.jb
    public boolean isLocRequest() {
        return this.f6781v;
    }

    public void setAesEntity(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                if (bArr != null) {
                    try {
                        byteArrayOutputStream.write(getDatasLength(bArr));
                        byteArrayOutputStream.write(bArr);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    }
                }
                this.r = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public void setDnsHostName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f6774n = "";
        } else {
            this.f6774n = str;
        }
    }

    public void setEntity(byte[] bArr) {
        this.f6777q = bArr;
    }

    public void setHead(Map<String, String> map) {
        this.f6773m = map;
    }

    public void setIPV6Url(String str) {
        this.f6776p = str;
    }

    public void setIsXinfo(boolean z5) {
        this.f6778s = z5;
    }

    public void setLocRequest(boolean z5) {
        this.f6781v = z5;
    }

    public void setParamsMap(Map<String, String> map) {
        this.f6780u = map;
    }

    public void setPlatinfo(String str) {
        this.f6779t = str;
    }

    public void setUrl(String str) {
        this.f6775o = str;
    }
}
