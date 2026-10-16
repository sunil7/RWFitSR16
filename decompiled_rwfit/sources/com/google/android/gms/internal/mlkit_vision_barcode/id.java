package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class id {

    /* renamed from: a, reason: collision with root package name */
    public static Method f9352a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f9353b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f9354c;

    public static void a(Canvas canvas, boolean z5) {
        Method method;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            if (z5) {
                canvas.enableZ();
                return;
            } else {
                canvas.disableZ();
                return;
            }
        }
        if (i3 == 28) {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
        if (!f9354c) {
            try {
                Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", null);
                f9352a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", null);
                f9353b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f9354c = true;
        }
        if (z5) {
            try {
                Method method2 = f9352a;
                if (method2 != null) {
                    method2.invoke(canvas, null);
                }
            } catch (IllegalAccessException unused2) {
                return;
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        if (z5 || (method = f9353b) == null) {
            return;
        }
        method.invoke(canvas, null);
    }
}
