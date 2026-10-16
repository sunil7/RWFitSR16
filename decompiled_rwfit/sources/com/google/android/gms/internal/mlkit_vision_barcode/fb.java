package com.google.android.gms.internal.mlkit_vision_barcode;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class fb {
    public static TextView a(MaterialToolbar materialToolbar, CharSequence charSequence) {
        for (int i3 = 0; i3 < materialToolbar.getChildCount(); i3++) {
            View childAt = materialToolbar.getChildAt(i3);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    return textView;
                }
            }
        }
        return null;
    }
}
