package com.google.android.material.navigation;

import android.view.View;
import com.google.android.material.internal.a0;
import com.google.android.material.internal.z;
import java.util.WeakHashMap;
import l1.i0;
import l1.x1;
import l1.z0;

/* loaded from: classes.dex */
public final class d implements z {
    @Override // com.google.android.material.internal.z
    public final x1 b(View view, x1 x1Var, a0 a0Var) {
        a0Var.f10557d = x1Var.a() + a0Var.f10557d;
        WeakHashMap weakHashMap = z0.f15748a;
        boolean z5 = i0.d(view) == 1;
        int b3 = x1Var.b();
        int c9 = x1Var.c();
        int i3 = a0Var.f10554a + (z5 ? c9 : b3);
        a0Var.f10554a = i3;
        int i10 = a0Var.f10556c;
        if (!z5) {
            b3 = c9;
        }
        int i11 = i10 + b3;
        a0Var.f10556c = i11;
        i0.k(view, i3, a0Var.f10555b, i11, a0Var.f10557d);
        return x1Var;
    }
}
