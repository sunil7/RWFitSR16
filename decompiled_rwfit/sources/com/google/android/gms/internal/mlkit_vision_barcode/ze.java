package com.google.android.gms.internal.mlkit_vision_barcode;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class ze {
    public static void a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + cls.getDeclaredConstructor(null).newInstance(null));
            } catch (IllegalAccessException e) {
                b(cls, e);
                throw null;
            } catch (InstantiationException e10) {
                b(cls, e10);
                throw null;
            } catch (NoSuchMethodException e11) {
                b(cls, e11);
                throw null;
            } catch (InvocationTargetException e12) {
                b(cls, e12);
                throw null;
            }
        } catch (ClassNotFoundException e13) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e13);
        }
    }

    public static void b(Class cls, ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, reflectiveOperationException);
    }
}
