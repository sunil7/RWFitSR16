package com.amap.api.col.p0003sl;

import android.content.Context;

/* loaded from: classes.dex */
public class xb {

    /* renamed from: a, reason: collision with root package name */
    private Context f5408a;

    /* renamed from: b, reason: collision with root package name */
    private m9 f5409b;

    /* renamed from: c, reason: collision with root package name */
    private String f5410c;

    public xb(Context context, m9 m9Var, String str) {
        this.f5408a = context.getApplicationContext();
        this.f5409b = m9Var;
        this.f5410c = str;
    }

    public final byte[] a() {
        Context context = this.f5408a;
        m9 m9Var = this.f5409b;
        String str = this.f5410c;
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("\"sdkversion\":\"");
            sb2.append(m9Var.b());
            sb2.append("\",\"product\":\"");
            sb2.append(m9Var.d());
            sb2.append("\",\"nt\":\"");
            sb2.append(f9.j(context));
            sb2.append("\",\"details\":");
            sb2.append(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return n9.e(sb2.toString());
    }
}
