package com.amap.api.col.p0003sl;

import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class ec extends hc {

    /* renamed from: c, reason: collision with root package name */
    private StringBuilder f4025c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4026d;

    public ec(hc hcVar) {
        super(hcVar);
        this.f4025c = new StringBuilder();
        this.f4026d = true;
    }

    @Override // com.amap.api.col.p0003sl.hc
    public void a(byte[] bArr) {
        String c9 = n9.c(bArr);
        if (this.f4026d) {
            this.f4026d = false;
        } else {
            this.f4025c.append(Const.STR_MART_COMMA);
        }
        StringBuilder sb2 = this.f4025c;
        sb2.append("{\"log\":\"");
        sb2.append(c9);
        sb2.append("\"}");
    }

    @Override // com.amap.api.col.p0003sl.hc
    public byte[] b(byte[] bArr) {
        byte[] e = n9.e(this.f4025c.toString());
        this.f4277b = e;
        this.f4026d = true;
        StringBuilder sb2 = this.f4025c;
        sb2.delete(0, sb2.length());
        return e;
    }
}
