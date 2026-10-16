package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.k0;
import l1.z0;
import va.a;
import x0.c;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends c {

    /* renamed from: a, reason: collision with root package name */
    public int f10986a = 0;

    public ExpandableBehavior() {
    }

    @Override // x0.c
    public abstract boolean b(View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x0.c
    public final boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        Object obj = (a) view2;
        boolean z5 = ((FloatingActionButton) obj).f10508o.f867b;
        if (z5) {
            int i3 = this.f10986a;
            if (i3 != 0 && i3 != 2) {
                return false;
            }
        } else if (this.f10986a != 1) {
            return false;
        }
        this.f10986a = z5 ? 1 : 2;
        s((View) obj, view, z5, true);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x0.c
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i3) {
        a aVar;
        boolean z5;
        int i10;
        WeakHashMap weakHashMap = z0.f15748a;
        if (!k0.c(view)) {
            ArrayList o3 = coordinatorLayout.o(view);
            int size = o3.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    aVar = null;
                    break;
                }
                View view2 = (View) o3.get(i11);
                if (b(view, view2)) {
                    aVar = (a) view2;
                    break;
                }
                i11++;
            }
            if (aVar != null && (!(z5 = ((FloatingActionButton) aVar).f10508o.f867b) ? this.f10986a == 1 : !((i10 = this.f10986a) != 0 && i10 != 2))) {
                int i12 = z5 ? 1 : 2;
                this.f10986a = i12;
                view.getViewTreeObserver().addOnPreDrawListener(new kb.a(this, view, i12, aVar));
            }
        }
        return false;
    }

    public abstract void s(View view, View view2, boolean z5, boolean z6);

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
    }
}
