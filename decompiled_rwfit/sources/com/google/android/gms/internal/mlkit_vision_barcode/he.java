package com.google.android.gms.internal.mlkit_vision_barcode;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class he {
    public static View a(int i3, View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View findViewById = viewGroup.getChildAt(i10).findViewById(i3);
            if (findViewById != null) {
                return findViewById;
            }
        }
        return null;
    }
}
