package com.dh.imagepick.preview.utils;

import android.view.View;
import androidx.fragment.app.p;
import j2.f0;
import j2.g0;
import j2.j0;
import j2.o0;

/* loaded from: classes.dex */
public final class c extends g0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7150a;

    /* renamed from: b, reason: collision with root package name */
    public Object f7151b;

    public /* synthetic */ c() {
        this.f7150a = 3;
    }

    @Override // j2.g0, j2.e0
    public void a(f0 transition) {
        switch (this.f7150a) {
            case 0:
                kotlin.jvm.internal.e.f(transition, "transition");
                d.f7152a = true;
                break;
            case 3:
                j0 j0Var = (j0) this.f7151b;
                if (!j0Var.A) {
                    j0Var.G();
                    j0Var.A = true;
                    break;
                }
                break;
        }
    }

    @Override // j2.e0
    public final void e(f0 f0Var) {
        switch (this.f7150a) {
            case 0:
                if (d.f7152a) {
                    d.f7152a = false;
                    ((p) this.f7151b).I(true, false);
                    break;
                }
                break;
            case 1:
                o0.b((View) this.f7151b, 1.0f);
                o0.f15272a.getClass();
                f0Var.w(this);
                break;
            case 2:
                ((f0) this.f7151b).z();
                f0Var.w(this);
                break;
            default:
                j0 j0Var = (j0) this.f7151b;
                int i3 = j0Var.f15242z - 1;
                j0Var.f15242z = i3;
                if (i3 == 0) {
                    j0Var.A = false;
                    j0Var.m();
                }
                f0Var.w(this);
                break;
        }
    }

    public /* synthetic */ c(Object obj, int i3) {
        this.f7150a = i3;
        this.f7151b = obj;
    }
}
