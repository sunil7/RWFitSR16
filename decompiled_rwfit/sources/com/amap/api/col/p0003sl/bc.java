package com.amap.api.col.p0003sl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class bc extends hc {

    /* renamed from: c, reason: collision with root package name */
    ByteArrayOutputStream f3793c;

    public bc(hc hcVar) {
        super(hcVar);
        this.f3793c = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.p0003sl.hc
    public void a(byte[] bArr) {
        try {
            this.f3793c.write(bArr);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003sl.hc
    public byte[] b(byte[] bArr) {
        byte[] byteArray = this.f3793c.toByteArray();
        try {
            this.f3793c.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f3793c = new ByteArrayOutputStream();
        return byteArray;
    }
}
