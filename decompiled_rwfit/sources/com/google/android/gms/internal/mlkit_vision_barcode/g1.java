package com.google.android.gms.internal.mlkit_vision_barcode;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class g1 {
    public static final View a(ViewGroup viewGroup, int i3) {
        View a3;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            kotlin.jvm.internal.e.b(childAt, "getChildAt(index)");
            if (kotlin.jvm.internal.e.a(childAt.getTag(i3), -1L)) {
                return childAt;
            }
            if ((childAt instanceof ViewGroup) && (a3 = a((ViewGroup) childAt, i3)) != null) {
                return a3;
            }
        }
        return null;
    }

    public static final Activity b(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }
}
