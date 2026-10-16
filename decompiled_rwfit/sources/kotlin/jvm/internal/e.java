package kotlin.jvm.internal;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Object[] f15649a = new Object[0];

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str.concat(" must not be null"));
        j(illegalStateException, e.class.getName());
        throw illegalStateException;
    }

    public static void c(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        j(nullPointerException, e.class.getName());
        throw nullPointerException;
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str);
        j(nullPointerException, e.class.getName());
        throw nullPointerException;
    }

    public static void e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        j(nullPointerException, e.class.getName());
        throw nullPointerException;
    }

    public static void f(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(i(str));
        j(nullPointerException, e.class.getName());
        throw nullPointerException;
    }

    public static void g(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(i(str));
        j(illegalArgumentException, e.class.getName());
        throw illegalArgumentException;
    }

    public static int h(int i3, int i10) {
        if (i3 < i10) {
            return -1;
        }
        return i3 == i10 ? 0 : 1;
    }

    public static String i(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = e.class.getName();
        int i3 = 0;
        while (!stackTrace[i3].getClassName().equals(name)) {
            i3++;
        }
        while (stackTrace[i3].getClassName().equals(name)) {
            i3++;
        }
        StackTraceElement stackTraceElement = stackTrace[i3];
        StringBuilder v6 = l0.v("Parameter specified as non-null is null: method ", stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName(), ", parameter ");
        v6.append(str);
        return v6.toString();
    }

    public static void j(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i3 = -1;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(stackTrace[i10].getClassName())) {
                i3 = i10;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i3 + 1, length));
    }

    public static String k(Object obj, String str) {
        return str + obj;
    }

    public static void l() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        j(kotlinNullPointerException, e.class.getName());
        throw kotlinNullPointerException;
    }

    public static void m(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(l0.o("lateinit property ", str, " has not been initialized"));
        j(uninitializedPropertyAccessException, e.class.getName());
        throw uninitializedPropertyAccessException;
    }

    public static final Object[] n(Collection collection) {
        int size = collection.size();
        Object[] objArr = f15649a;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArr2 = new Object[size];
                int i3 = 0;
                while (true) {
                    int i10 = i3 + 1;
                    objArr2[i3] = it.next();
                    if (i10 >= objArr2.length) {
                        if (!it.hasNext()) {
                            return objArr2;
                        }
                        int i11 = ((i10 * 3) + 1) >>> 1;
                        if (i11 <= i10) {
                            i11 = 2147483645;
                            if (i10 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr2 = Arrays.copyOf(objArr2, i11);
                        e(objArr2, "copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr2, i10);
                        e(copyOf, "copyOf(result, size)");
                        return copyOf;
                    }
                    i3 = i10;
                }
            }
        }
        return objArr;
    }

    public static final Object[] o(Collection collection, Object[] objArr) {
        Object[] objArr2;
        int size = collection.size();
        int i3 = 0;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArr2 = objArr;
                } else {
                    Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    d(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    objArr2 = (Object[]) newInstance;
                }
                while (true) {
                    int i10 = i3 + 1;
                    objArr2[i3] = it.next();
                    if (i10 >= objArr2.length) {
                        if (!it.hasNext()) {
                            return objArr2;
                        }
                        int i11 = ((i10 * 3) + 1) >>> 1;
                        if (i11 <= i10) {
                            i11 = 2147483645;
                            if (i10 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr2 = Arrays.copyOf(objArr2, i11);
                        e(objArr2, "copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        if (objArr2 == objArr) {
                            objArr[i10] = null;
                            return objArr;
                        }
                        Object[] copyOf = Arrays.copyOf(objArr2, i10);
                        e(copyOf, "copyOf(result, size)");
                        return copyOf;
                    }
                    i3 = i10;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
            }
        } else if (objArr.length > 0) {
            objArr[0] = null;
            return objArr;
        }
        return objArr;
    }
}
