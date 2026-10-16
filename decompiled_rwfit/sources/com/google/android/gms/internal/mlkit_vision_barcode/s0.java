package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.util.TypedValue;

/* loaded from: classes.dex */
public abstract class s0 {
    public static TypedValue a(Context context, int i3) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i3, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static int b(Context context, int i3, String str) {
        TypedValue a3 = a(context, i3);
        if (a3 != null) {
            return a3.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i3)));
    }
}
