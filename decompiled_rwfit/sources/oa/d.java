package oa;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.google.android.gms.internal.mlkit_vision_common.x;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import eb.h;
import java.util.WeakHashMap;
import l1.n0;
import l1.x1;
import l1.z0;

/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f16908a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16909b;

    /* renamed from: c, reason: collision with root package name */
    public final x1 f16910c;

    public d(View view, x1 x1Var) {
        ColorStateList g10;
        this.f16910c = x1Var;
        boolean z5 = (view.getSystemUiVisibility() & 8192) != 0;
        this.f16909b = z5;
        h hVar = BottomSheetBehavior.x(view).f10279i;
        if (hVar != null) {
            g10 = hVar.f12505a.f12490c;
        } else {
            WeakHashMap weakHashMap = z0.f15748a;
            g10 = n0.g(view);
        }
        if (g10 != null) {
            this.f16908a = x.c(g10.getDefaultColor());
        } else if (view.getBackground() instanceof ColorDrawable) {
            this.f16908a = x.c(((ColorDrawable) view.getBackground()).getColor());
        } else {
            this.f16908a = z5;
        }
    }

    @Override // oa.b
    public final void a(View view) {
        c(view);
    }

    @Override // oa.b
    public final void b(int i3, View view) {
        c(view);
    }

    public final void c(View view) {
        int top = view.getTop();
        x1 x1Var = this.f16910c;
        if (top < x1Var.d()) {
            int i3 = com.example.test.ui.dialog.c.D;
            int systemUiVisibility = view.getSystemUiVisibility();
            view.setSystemUiVisibility(this.f16908a ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
            view.setPadding(view.getPaddingLeft(), x1Var.d() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            return;
        }
        if (view.getTop() != 0) {
            int i10 = com.example.test.ui.dialog.c.D;
            int systemUiVisibility2 = view.getSystemUiVisibility();
            view.setSystemUiVisibility(this.f16909b ? systemUiVisibility2 | 8192 : systemUiVisibility2 & (-8193));
            view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
        }
    }
}
