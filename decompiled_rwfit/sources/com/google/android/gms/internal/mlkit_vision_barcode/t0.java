package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* loaded from: classes.dex */
public abstract class t0 {
    public static ColorStateList a(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        ColorStateList a3;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (a3 = pb.a(context, resourceId)) == null) ? typedArray.getColorStateList(i3) : a3;
    }

    public static ColorStateList b(Context context, de.o oVar, int i3) {
        int resourceId;
        ColorStateList a3;
        TypedArray typedArray = (TypedArray) oVar.f12378c;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (a3 = pb.a(context, resourceId)) == null) ? oVar.v(i3) : a3;
    }

    public static int c(Context context, TypedArray typedArray, int i3, int i10) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i3, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i3, i10);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i10);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable d(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        Drawable b3;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (b3 = pb.b(context, resourceId)) == null) ? typedArray.getDrawable(i3) : b3;
    }

    public static boolean e(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }
}
