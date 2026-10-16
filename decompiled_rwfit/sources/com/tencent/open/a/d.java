package com.tencent.open.a;

import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes2.dex */
class d implements g {

    /* renamed from: a, reason: collision with root package name */
    private Response f11950a;

    /* renamed from: b, reason: collision with root package name */
    private String f11951b = null;

    /* renamed from: c, reason: collision with root package name */
    private int f11952c;

    /* renamed from: d, reason: collision with root package name */
    private int f11953d;
    private int e;

    public d(Response response, int i3) {
        this.f11950a = response;
        this.f11953d = i3;
        this.f11952c = response.code();
        ResponseBody body = this.f11950a.body();
        if (body != null) {
            this.e = (int) body.contentLength();
        } else {
            this.e = 0;
        }
    }

    @Override // com.tencent.open.a.g
    public String a() throws IOException {
        if (this.f11951b == null) {
            ResponseBody body = this.f11950a.body();
            if (body != null) {
                this.f11951b = body.string();
            }
            if (this.f11951b == null) {
                this.f11951b = "";
            }
        }
        return this.f11951b;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.e;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.f11953d;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.f11952c;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + this.f11951b + this.f11952c + this.f11953d + this.e;
    }
}
