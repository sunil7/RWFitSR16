package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class rb {
    public static qb a(int i3) {
        if (i3 != 0 && i3 == 1) {
            return new eb.d();
        }
        return new eb.k();
    }

    public static void b(ViewGroup viewGroup, float f2) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof eb.h) {
            ((eb.h) background).k(f2);
        }
    }

    public static void c(View view, eb.h hVar) {
        ua.a aVar = hVar.f12505a.f12489b;
        if (aVar == null || !aVar.f19028a) {
            return;
        }
        float f2 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            WeakHashMap weakHashMap = l1.z0.f15748a;
            f2 += l1.n0.i((View) parent);
        }
        eb.g gVar = hVar.f12505a;
        if (gVar.f12498l != f2) {
            gVar.f12498l = f2;
            hVar.t();
        }
    }

    public static void d(ViewGroup viewGroup) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof eb.h) {
            c(viewGroup, (eb.h) background);
        }
    }
}
