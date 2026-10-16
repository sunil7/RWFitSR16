package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.col.p0003sl.a3;
import com.amap.api.col.p0003sl.t2;
import java.io.IOException;

/* loaded from: classes.dex */
public class f2 extends rc implements t2.a {

    /* renamed from: a, reason: collision with root package name */
    private t2 f4066a;

    /* renamed from: b, reason: collision with root package name */
    private w2 f4067b;

    /* renamed from: c, reason: collision with root package name */
    private z2 f4068c;

    /* renamed from: d, reason: collision with root package name */
    private Context f4069d;
    private Bundle e = new Bundle();

    /* renamed from: f, reason: collision with root package name */
    private boolean f4070f = false;

    public f2(z2 z2Var, Context context) {
        this.f4068c = z2Var;
        this.f4069d = context;
    }

    private void b() throws IOException {
        t2 t2Var = new t2(new u2(this.f4068c.getUrl(), v4.a(this.f4069d), this.f4068c.d(), 1, this.f4068c.getId()), this.f4068c.getUrl(), this.f4069d, this.f4068c);
        this.f4066a = t2Var;
        t2Var.a(this);
        z2 z2Var = this.f4068c;
        this.f4067b = new w2(z2Var, z2Var);
        if (this.f4070f) {
            return;
        }
        this.f4066a.g();
    }

    public void a() {
        Bundle bundle = this.e;
        if (bundle != null) {
            bundle.clear();
            this.e = null;
        }
    }

    public void c() {
        w2 w2Var = this.f4067b;
        if (w2Var != null) {
            w2Var.a();
        }
    }

    public void d() {
        this.f4070f = true;
        t2 t2Var = this.f4066a;
        if (t2Var != null) {
            t2Var.f();
        } else {
            cancelTask();
        }
        w2 w2Var = this.f4067b;
        if (w2Var != null) {
            w2Var.b();
        }
    }

    @Override // com.amap.api.col.p0003sl.rc
    public void runTask() {
        if (this.f4068c.f()) {
            this.f4068c.a(a3.a.file_io_exception);
            return;
        }
        try {
            b();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
