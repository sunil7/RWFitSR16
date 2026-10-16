package com.autonavi.aps.amapapi.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class Reflect {
    public static int getStaticIntProp(String str, String str2) throws Exception {
        return ((Integer) getStaticProp(str, str2)).intValue();
    }

    public static Object getStaticProp(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        Field field = cls.getField(str2);
        field.setAccessible(true);
        return field.get(cls);
    }

    public static int invokeIntMethod(Object obj, String str, Object... objArr) throws Exception {
        return ((Integer) invokeMethod(obj, str, objArr)).intValue();
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) {
        try {
            return invokeMethod(obj, obj.getClass(), str, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object invokeMethodExt(Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            return invokeMethodExt(obj, obj.getClass(), str, clsArr, objArr);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Object[] objArr, Class<?>[] clsArr) throws Exception {
        return invokeStaticMethod(Class.forName(str), str2, objArr, clsArr);
    }

    public static Object newInstance(String str, Object... objArr) throws Exception {
        Class<?> cls = Class.forName(str);
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i3 = 0; i3 < objArr.length; i3++) {
            clsArr[i3] = objArr[i3].getClass();
        }
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static Object invokeMethod(Object obj, Class<?> cls, String str, Object... objArr) throws Exception {
        Class<?>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            Class<?> cls2 = objArr[i3].getClass();
            clsArr[i3] = cls2;
            if (cls2 == Integer.class) {
                clsArr[i3] = Integer.TYPE;
            }
            if (clsArr[i3] == Boolean.class) {
                clsArr[i3] = Boolean.TYPE;
            }
            if (clsArr[i3] == Double.class) {
                clsArr[i3] = Double.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        try {
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable th2) {
            try {
                if (!(th2 instanceof InvocationTargetException)) {
                    return null;
                }
                CoreUtil.reportError(th2.getTargetException(), "Reflect", "invokeMethod " + str);
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws Exception {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(null, objArr);
    }

    public static Object invokeMethodExt(Object obj, Class<?> cls, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable th2) {
            try {
                if (!(th2 instanceof InvocationTargetException)) {
                    return null;
                }
                CoreUtil.reportError(th2.getTargetException(), cls.getName(), "invokeMethod " + str);
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static Object newInstance(String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        return Class.forName(str).getConstructor(clsArr).newInstance(objArr);
    }
}
