package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.maps.AMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class j2 {

    /* renamed from: c, reason: collision with root package name */
    private static j2 f4311c;

    /* renamed from: a, reason: collision with root package name */
    private qc f4312a;

    /* renamed from: b, reason: collision with root package name */
    private LinkedHashMap<String, rc> f4313b = new LinkedHashMap<>();

    private j2(boolean z5, int i3) {
        if (z5) {
            try {
                if (this.f4312a == null) {
                    this.f4312a = qc.c();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static j2 a(int i3) {
        j2 j2Var;
        synchronized (j2.class) {
            try {
                j2 j2Var2 = f4311c;
                if (j2Var2 == null) {
                    f4311c = new j2(true, i3);
                } else if (j2Var2.f4312a == null) {
                    j2Var2.f4312a = qc.e();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            j2Var = f4311c;
        }
        return j2Var;
    }

    public void b(i2 i2Var) {
        synchronized (this.f4313b) {
            try {
                f2 f2Var = (f2) this.f4313b.get(((z1) i2Var).getUrl());
                if (f2Var == null) {
                    return;
                }
                f2Var.d();
                this.f4313b.remove(((z1) i2Var).getUrl());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a() {
        synchronized (this.f4313b) {
            try {
                if (this.f4313b.size() >= 1) {
                    for (Map.Entry<String, rc> entry : this.f4313b.entrySet()) {
                        entry.getKey();
                        ((f2) entry.getValue()).d();
                    }
                    this.f4313b.clear();
                }
            } finally {
            }
        }
        this.f4312a.a();
        this.f4312a = null;
        f4311c = null;
    }

    public void a(i2 i2Var, Context context, AMap aMap) throws a9 {
        z1 z1Var = (z1) i2Var;
        if (!this.f4313b.containsKey(z1Var.getUrl())) {
            f2 f2Var = new f2((z2) i2Var, context.getApplicationContext());
            synchronized (this.f4313b) {
                this.f4313b.put(((z1) i2Var).getUrl(), f2Var);
            }
        }
        this.f4312a.b(this.f4313b.get(z1Var.getUrl()));
    }

    public void a(i2 i2Var) {
        f2 f2Var = (f2) this.f4313b.get(((z1) i2Var).getUrl());
        if (f2Var != null) {
            synchronized (this.f4313b) {
                f2Var.a();
                this.f4313b.remove(((z1) i2Var).getUrl());
            }
        }
    }
}
