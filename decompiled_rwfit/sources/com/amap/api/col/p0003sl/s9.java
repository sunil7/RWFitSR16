package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import java.util.Vector;

/* loaded from: classes.dex */
public final class s9 {

    /* renamed from: a, reason: collision with root package name */
    private Vector<p9> f5037a;

    /* renamed from: b, reason: collision with root package name */
    private int f5038b;

    /* renamed from: c, reason: collision with root package name */
    private int f5039c;

    public s9() {
        this.f5039c = 0;
        this.f5038b = 10;
        this.f5037a = new Vector<>();
    }

    public final synchronized boolean a(String str) {
        if (str == null) {
            return false;
        }
        if (this.f5037a.size() >= this.f5038b) {
            return true;
        }
        return this.f5039c + str.getBytes().length > 10000;
    }

    public final synchronized void b() {
        this.f5037a.clear();
        this.f5039c = 0;
    }

    public final Vector<p9> a() {
        return this.f5037a;
    }

    public final synchronized void a(p9 p9Var) {
        if (TextUtils.isEmpty(p9Var.b())) {
            return;
        }
        this.f5037a.add(p9Var);
        this.f5039c += p9Var.b().getBytes().length;
    }

    public s9(byte b3) {
        this.f5038b = 100;
        this.f5039c = 0;
        this.f5037a = new Vector<>();
    }
}
