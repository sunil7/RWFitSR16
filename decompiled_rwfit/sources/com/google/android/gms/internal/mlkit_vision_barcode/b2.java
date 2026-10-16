package com.google.android.gms.internal.mlkit_vision_barcode;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import org.greenrobot.eventbus.EventBusException;

/* loaded from: classes.dex */
public abstract class b2 {
    public static void a(Object obj) {
        boolean containsKey;
        int i3;
        n.v0 v0Var;
        Method[] methods;
        yh.k kVar;
        boolean b3;
        yh.d b10 = yh.d.b();
        synchronized (b10) {
            containsKey = b10.f20142b.containsKey(obj);
        }
        if (containsKey) {
            return;
        }
        yh.d b11 = yh.d.b();
        Class<?> cls = obj.getClass();
        b11.f20148i.getClass();
        ConcurrentHashMap concurrentHashMap = yh.n.f20176a;
        List list = (List) concurrentHashMap.get(cls);
        List list2 = list;
        if (list == null) {
            synchronized (yh.n.f20177b) {
                i3 = 0;
                int i10 = 0;
                while (true) {
                    if (i10 >= 4) {
                        v0Var = new n.v0();
                        break;
                    }
                    try {
                        n.v0[] v0VarArr = yh.n.f20177b;
                        v0Var = v0VarArr[i10];
                        if (v0Var != null) {
                            v0VarArr[i10] = null;
                        } else {
                            i10++;
                        }
                    } finally {
                    }
                }
            }
            v0Var.f16310f = cls;
            v0Var.f16306a = false;
            while (true) {
                Class cls2 = (Class) v0Var.f16310f;
                if (cls2 != null) {
                    int i11 = 1;
                    try {
                        try {
                            methods = cls2.getDeclaredMethods();
                        } catch (Throwable unused) {
                            methods = ((Class) v0Var.f16310f).getMethods();
                            v0Var.f16306a = true;
                        }
                        int length = methods.length;
                        int i12 = 0;
                        while (i12 < length) {
                            Method method = methods[i12];
                            int modifiers = method.getModifiers();
                            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                                Class<?>[] parameterTypes = method.getParameterTypes();
                                if (parameterTypes.length == i11 && (kVar = (yh.k) method.getAnnotation(yh.k.class)) != null) {
                                    Class<?> cls3 = parameterTypes[0];
                                    HashMap hashMap = (HashMap) v0Var.f16308c;
                                    Object put = hashMap.put(cls3, method);
                                    if (put == null) {
                                        b3 = true;
                                    } else {
                                        if (put instanceof Method) {
                                            if (!v0Var.b((Method) put, cls3)) {
                                                throw new IllegalStateException();
                                            }
                                            hashMap.put(cls3, v0Var);
                                        }
                                        b3 = v0Var.b(method, cls3);
                                    }
                                    if (b3) {
                                        ((ArrayList) v0Var.f16307b).add(new yh.m(method, cls3, kVar.threadMode(), kVar.priority(), kVar.sticky()));
                                    }
                                }
                            }
                            i12++;
                            i11 = 1;
                        }
                        if (v0Var.f16306a) {
                            v0Var.f16310f = null;
                        } else {
                            Class superclass = ((Class) v0Var.f16310f).getSuperclass();
                            v0Var.f16310f = superclass;
                            String name = superclass.getName();
                            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                                v0Var.f16310f = null;
                            }
                        }
                    } catch (LinkageError e) {
                        throw new EventBusException(android.support.v4.media.session.e.l("Could not inspect methods of ".concat(((Class) v0Var.f16310f).getName()), ". Please make this class visible to EventBus annotation processor to avoid reflection."), e);
                    }
                } else {
                    ArrayList arrayList = new ArrayList((ArrayList) v0Var.f16307b);
                    ((ArrayList) v0Var.f16307b).clear();
                    ((HashMap) v0Var.f16308c).clear();
                    ((HashMap) v0Var.f16309d).clear();
                    ((StringBuilder) v0Var.e).setLength(0);
                    v0Var.f16310f = null;
                    v0Var.f16306a = false;
                    synchronized (yh.n.f20177b) {
                        while (true) {
                            if (i3 >= 4) {
                                break;
                            }
                            try {
                                n.v0[] v0VarArr2 = yh.n.f20177b;
                                if (v0VarArr2[i3] == null) {
                                    v0VarArr2[i3] = v0Var;
                                    break;
                                }
                                i3++;
                            } finally {
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
                    }
                    concurrentHashMap.put(cls, arrayList);
                    list2 = arrayList;
                }
            }
        }
        synchronized (b11) {
            try {
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    b11.i(obj, (yh.m) it.next());
                }
            } finally {
            }
        }
    }

    public static void b(Object obj) {
        yh.d b3 = yh.d.b();
        synchronized (b3) {
            try {
                List list = (List) b3.f20142b.get(obj);
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        List list2 = (List) b3.f20141a.get((Class) it.next());
                        if (list2 != null) {
                            int size = list2.size();
                            int i3 = 0;
                            while (i3 < size) {
                                yh.o oVar = (yh.o) list2.get(i3);
                                if (oVar.f20178a == obj) {
                                    oVar.f20180c = false;
                                    list2.remove(i3);
                                    i3--;
                                    size--;
                                }
                                i3++;
                            }
                        }
                    }
                    b3.f20142b.remove(obj);
                } else {
                    b3.f20155p.a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
