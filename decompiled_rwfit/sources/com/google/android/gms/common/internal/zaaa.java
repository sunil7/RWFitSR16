package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class zaaa extends Button {
    public zaaa(Context context, AttributeSet attributeSet) {
        super(context, null, R.attr.buttonStyle);
    }

    public static final int a(int i3, int i10, int i11, int i12) {
        if (i3 == 0) {
            return i10;
        }
        if (i3 == 1) {
            return i11;
        }
        if (i3 == 2) {
            return i12;
        }
        throw new IllegalStateException(l0.j(i3, "Unknown color scheme: "));
    }
}
