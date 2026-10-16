package androidx.lifecycle;

import android.app.Application;
import com.google.android.gms.internal.mlkit_vision_barcode.wd;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class l0 {

    /* renamed from: a, reason: collision with root package name */
    public static final List f2377a = kotlin.collections.i.d(Application.class, h0.class);

    /* renamed from: b, reason: collision with root package name */
    public static final List f2378b = wd.a(h0.class);

    public static final Constructor a(Class cls, List signature) {
        kotlin.jvm.internal.e.f(signature, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        kotlin.jvm.internal.e.e(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            kotlin.jvm.internal.e.e(parameterTypes, "constructor.parameterTypes");
            List g10 = kotlin.collections.g.g(parameterTypes);
            if (signature.equals(g10)) {
                return constructor;
            }
            if (signature.size() == g10.size() && g10.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final m0 b(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (m0) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access " + cls, e);
        } catch (InstantiationException e10) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e11.getCause());
        }
    }
}
