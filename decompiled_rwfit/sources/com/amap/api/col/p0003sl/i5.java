package com.amap.api.col.p0003sl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class i5 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4281a = false;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<a> f4282b = new ArrayList<>();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f4283a;

        /* renamed from: b, reason: collision with root package name */
        private Object f4284b;

        /* renamed from: c, reason: collision with root package name */
        private Class<?>[] f4285c;

        /* renamed from: d, reason: collision with root package name */
        private Object[] f4286d;

        public a(Object obj, String str, Object... objArr) {
            this.f4284b = obj;
            this.f4283a = str;
            if (objArr == null || objArr.length <= 0) {
                return;
            }
            this.f4285c = new Class[objArr.length];
            for (int i3 = 0; i3 < objArr.length; i3++) {
                this.f4285c[i3] = objArr[i3].getClass();
            }
            this.f4286d = new Object[objArr.length];
            for (int i10 = 0; i10 < objArr.length; i10++) {
                this.f4286d[i10] = objArr[i10];
            }
        }
    }

    public synchronized void a() {
        Method method;
        if (this.f4281a) {
            return;
        }
        this.f4281a = true;
        for (int i3 = 0; i3 < this.f4282b.size(); i3++) {
            a aVar = this.f4282b.get(i3);
            try {
                try {
                    try {
                        if (aVar.f4284b != null) {
                            Class<?> cls = aVar.f4284b.getClass();
                            try {
                                method = cls.getDeclaredMethod(aVar.f4283a, aVar.f4285c);
                            } catch (NoSuchMethodException unused) {
                                if (aVar.f4285c.length > 0) {
                                    Class<?>[] clsArr = new Class[aVar.f4285c.length];
                                    for (int i10 = 0; i10 < aVar.f4285c.length; i10++) {
                                        if (aVar.f4285c[i10].getInterfaces().length > 0) {
                                            clsArr[i10] = aVar.f4285c[i10].getInterfaces()[0];
                                        }
                                    }
                                    method = cls.getDeclaredMethod(aVar.f4283a, clsArr);
                                } else {
                                    method = null;
                                }
                            }
                            if (method != null) {
                                method.setAccessible(true);
                                method.invoke(aVar.f4284b, aVar.f4286d);
                            }
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                } catch (IllegalAccessException e10) {
                    e10.printStackTrace();
                } catch (SecurityException e11) {
                    e11.printStackTrace();
                }
            } catch (IllegalArgumentException e12) {
                e12.printStackTrace();
            } catch (InvocationTargetException e13) {
                e13.printStackTrace();
            }
        }
        this.f4282b.clear();
    }

    public synchronized void a(Object obj, Object... objArr) {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 3) {
                this.f4282b.add(new a(obj, stackTrace[3].getMethodName(), objArr));
            }
        } catch (Throwable unused) {
        }
        this.f4281a = false;
    }
}
