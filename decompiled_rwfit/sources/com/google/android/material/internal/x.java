package com.google.android.material.internal;

import android.view.View;
import com.example.test.ui.device.activity.e0;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import java.util.WeakHashMap;
import l1.i0;
import l1.x1;
import l1.z0;

/* loaded from: classes.dex */
public final class x implements z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f10641a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f10642b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f10643c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e0 f10644d;

    public x(boolean z5, boolean z6, boolean z8, e0 e0Var) {
        this.f10641a = z5;
        this.f10642b = z6;
        this.f10643c = z8;
        this.f10644d = e0Var;
    }

    @Override // com.google.android.material.internal.z
    public final x1 b(View view, x1 x1Var, a0 a0Var) {
        if (this.f10641a) {
            a0Var.f10557d = x1Var.a() + a0Var.f10557d;
        }
        boolean d5 = gb.d(view);
        if (this.f10642b) {
            if (d5) {
                a0Var.f10556c = x1Var.b() + a0Var.f10556c;
            } else {
                a0Var.f10554a = x1Var.b() + a0Var.f10554a;
            }
        }
        if (this.f10643c) {
            if (d5) {
                a0Var.f10554a = x1Var.c() + a0Var.f10554a;
            } else {
                a0Var.f10556c = x1Var.c() + a0Var.f10556c;
            }
        }
        int i3 = a0Var.f10554a;
        int i10 = a0Var.f10556c;
        int i11 = a0Var.f10557d;
        WeakHashMap weakHashMap = z0.f15748a;
        i0.k(view, i3, a0Var.f10555b, i10, i11);
        this.f10644d.b(view, x1Var, a0Var);
        return x1Var;
    }
}
