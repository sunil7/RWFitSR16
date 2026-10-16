package jh;

import java.lang.reflect.Method;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f15449a;

    static {
        Method method;
        Method[] throwableMethods = Throwable.class.getMethods();
        e.e(throwableMethods, "throwableMethods");
        int length = throwableMethods.length;
        int i3 = 0;
        while (true) {
            method = null;
            if (i3 >= length) {
                break;
            }
            Method method2 = throwableMethods[i3];
            if (e.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                e.e(parameterTypes, "it.parameterTypes");
                if (e.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i3++;
        }
        f15449a = method;
        int length2 = throwableMethods.length;
        for (int i10 = 0; i10 < length2 && !e.a(throwableMethods[i10].getName(), "getSuppressed"); i10++) {
        }
    }
}
