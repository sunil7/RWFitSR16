package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f2396a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f2397b = new HashMap();

    public static void a(Constructor constructor, r rVar) {
        try {
            if (constructor.newInstance(rVar) == null) {
            } else {
                throw new ClassCastException();
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static String b(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    public static int c(Class cls) {
        Constructor<?> constructor;
        boolean z5;
        ArrayList arrayList;
        HashMap hashMap = f2396a;
        Integer num = (Integer) hashMap.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i3 = 1;
        if (cls.getCanonicalName() != null) {
            try {
                Package r32 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = r32 != null ? r32.getName() : "";
                if (!name.isEmpty()) {
                    canonicalName = canonicalName.substring(name.length() + 1);
                }
                String b3 = b(canonicalName);
                if (!name.isEmpty()) {
                    b3 = name + "." + b3;
                }
                constructor = Class.forName(b3).getDeclaredConstructor(cls);
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            HashMap hashMap2 = f2397b;
            if (constructor != null) {
                hashMap2.put(cls, Collections.singletonList(constructor));
            } else {
                d dVar = d.f2345c;
                HashMap hashMap3 = dVar.f2347b;
                Boolean bool = (Boolean) hashMap3.get(cls);
                if (bool != null) {
                    z5 = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i10 = 0;
                        while (true) {
                            if (i10 >= length) {
                                hashMap3.put(cls, Boolean.FALSE);
                                z5 = false;
                                break;
                            }
                            if (((d0) declaredMethods[i10].getAnnotation(d0.class)) != null) {
                                dVar.a(cls, declaredMethods);
                                z5 = true;
                                break;
                            }
                            i10++;
                        }
                    } catch (NoClassDefFoundError e10) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
                    }
                }
                if (!z5) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && r.class.isAssignableFrom(superclass)) {
                        arrayList = c(superclass) != 1 ? new ArrayList((Collection) hashMap2.get(superclass)) : null;
                    }
                    Class<?>[] interfaces = cls.getInterfaces();
                    int length2 = interfaces.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 < length2) {
                            Class<?> cls2 = interfaces[i11];
                            if (cls2 != null && r.class.isAssignableFrom(cls2)) {
                                if (c(cls2) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.addAll((Collection) hashMap2.get(cls2));
                            }
                            i11++;
                        } else if (arrayList != null) {
                            hashMap2.put(cls, arrayList);
                        }
                    }
                }
            }
            i3 = 2;
        }
        hashMap.put(cls, Integer.valueOf(i3));
        return i3;
    }
}
