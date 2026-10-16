package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.example.test.utils.y;
import com.google.android.material.R$animator;
import ja.e;
import ja.g;
import java.util.HashMap;
import java.util.WeakHashMap;
import l1.h0;
import l1.z0;
import x0.f;

@Deprecated
/* loaded from: classes.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: i, reason: collision with root package name */
    public HashMap f10995i;

    public FabTransformationSheetBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public final void s(View view, View view2, boolean z5, boolean z6) {
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z5) {
                this.f10995i = new HashMap(childCount);
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                boolean z8 = (childAt.getLayoutParams() instanceof f) && (((f) childAt.getLayoutParams()).f19716a instanceof FabTransformationScrimBehavior);
                if (childAt != view2 && !z8) {
                    if (z5) {
                        this.f10995i.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        WeakHashMap weakHashMap = z0.f15748a;
                        h0.s(childAt, 4);
                    } else {
                        HashMap hashMap = this.f10995i;
                        if (hashMap != null && hashMap.containsKey(childAt)) {
                            int intValue = ((Integer) this.f10995i.get(childAt)).intValue();
                            WeakHashMap weakHashMap2 = z0.f15748a;
                            h0.s(childAt, intValue);
                        }
                    }
                }
            }
            if (!z5) {
                this.f10995i = null;
            }
        }
        super.s(view, view2, z5, z6);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public final y z(Context context, boolean z5) {
        int i3 = z5 ? R$animator.mtrl_fab_transformation_sheet_expand_spec : R$animator.mtrl_fab_transformation_sheet_collapse_spec;
        y yVar = new y(24, false);
        yVar.f8773b = e.b(context, i3);
        yVar.f8774c = new g();
        return yVar;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
