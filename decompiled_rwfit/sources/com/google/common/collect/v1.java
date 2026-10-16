package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.jb;

/* loaded from: classes.dex */
public final class v1 extends t1 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f11136a;

    /* renamed from: b, reason: collision with root package name */
    public int f11137b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w1 f11138c;

    public v1(w1 w1Var, int i3) {
        this.f11138c = w1Var;
        this.f11136a = w1Var.f11139a[i3];
        this.f11137b = i3;
    }

    @Override // com.google.common.collect.r1
    public final int getCount() {
        int i3 = this.f11137b;
        w1 w1Var = this.f11138c;
        Object obj = this.f11136a;
        if (i3 == -1 || i3 >= w1Var.f11141c || !jb.a(obj, w1Var.f11139a[i3])) {
            this.f11137b = w1Var.d(obj);
        }
        int i10 = this.f11137b;
        if (i10 == -1) {
            return 0;
        }
        return w1Var.f11140b[i10];
    }

    @Override // com.google.common.collect.r1
    public final Object getElement() {
        return this.f11136a;
    }
}
