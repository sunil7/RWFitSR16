package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.r2;
import java.io.File;

/* loaded from: classes.dex */
class y1 implements r2.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f5450a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ File f5451b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ z1 f5452c;

    public y1(z1 z1Var, String str, File file) {
        this.f5452c = z1Var;
        this.f5450a = str;
        this.f5451b = file;
    }

    @Override // com.amap.api.col.3sl.r2.a
    public void a(String str, String str2, float f2) {
        long j4;
        int i3 = (int) ((f2 * 0.39d) + 60.0d);
        if (i3 - this.f5452c.getcompleteCode() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            j4 = this.f5452c.A;
            if (currentTimeMillis - j4 > 1000) {
                this.f5452c.setCompleteCode(i3);
                this.f5452c.A = System.currentTimeMillis();
            }
        }
    }

    @Override // com.amap.api.col.3sl.r2.a
    public void a(String str, String str2) {
        try {
            if (new File(this.f5450a).delete()) {
                x2.a(this.f5451b);
                this.f5452c.setCompleteCode(100);
                this.f5452c.f5534v.a();
            }
        } catch (Exception unused) {
            z1 z1Var = this.f5452c;
            z1Var.f5534v.a(z1Var.f5533u.e());
        }
    }

    @Override // com.amap.api.col.3sl.r2.a
    public void a(String str, String str2, int i3) {
        z1 z1Var = this.f5452c;
        z1Var.f5534v.a(z1Var.f5533u.e());
    }
}
