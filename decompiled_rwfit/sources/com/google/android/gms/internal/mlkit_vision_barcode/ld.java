package com.google.android.gms.internal.mlkit_vision_barcode;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class ld {

    /* renamed from: a, reason: collision with root package name */
    public static Field f9410a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f9411b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f9412c = true;

    public float a(View view) {
        float transitionAlpha;
        if (f9412c) {
            try {
                transitionAlpha = view.getTransitionAlpha();
                return transitionAlpha;
            } catch (NoSuchMethodError unused) {
                f9412c = false;
            }
        }
        return view.getAlpha();
    }

    public void b(View view, float f2) {
        if (f9412c) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f9412c = false;
            }
        }
        view.setAlpha(f2);
    }

    public void c(int i3, View view) {
        if (!f9411b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f9410a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f9411b = true;
        }
        Field field = f9410a;
        if (field != null) {
            try {
                f9410a.setInt(view, i3 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }
}
