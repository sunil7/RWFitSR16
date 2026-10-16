package com.tencent.open.a;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
class c implements g {

    /* renamed from: a, reason: collision with root package name */
    private String f11945a;

    /* renamed from: b, reason: collision with root package name */
    private int f11946b;

    /* renamed from: c, reason: collision with root package name */
    private int f11947c;

    /* renamed from: d, reason: collision with root package name */
    private int f11948d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, List<String>> f11949f = new HashMap();

    public c(HttpURLConnection httpURLConnection, String str, int i3, int i10, int i11, String str2) {
        Map<String, List<String>> headerFields;
        this.f11945a = str;
        this.f11946b = i3;
        this.f11947c = i10;
        this.f11948d = i11;
        this.e = str2;
        if (httpURLConnection == null || (headerFields = httpURLConnection.getHeaderFields()) == null) {
            return;
        }
        this.f11949f.putAll(headerFields);
    }

    @Override // com.tencent.open.a.g
    public String a() {
        return this.f11945a;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.f11946b;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.f11947c;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.f11948d;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + "\ncontent = [" + this.f11945a + "]\nresponseSize = " + this.f11946b + "\nrequestSize = " + this.f11947c + "\nresultCode = " + this.f11948d + "\nerrorMsg = " + this.e;
    }
}
