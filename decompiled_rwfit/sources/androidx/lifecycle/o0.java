package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class o0 extends n0 {
    public static o0 e;

    /* renamed from: d, reason: collision with root package name */
    public final Application f2384d;

    public o0(Application application) {
        this.f2384d = application;
    }

    public final m0 a(Class cls, Application application) {
        if (!a.class.isAssignableFrom(cls)) {
            return super.d(cls);
        }
        try {
            m0 m0Var = (m0) cls.getConstructor(Application.class).newInstance(application);
            kotlin.jvm.internal.e.e(m0Var, "{\n                try {\n…          }\n            }");
            return m0Var;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Cannot create an instance of " + cls, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("Cannot create an instance of " + cls, e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("Cannot create an instance of " + cls, e12);
        } catch (InvocationTargetException e13) {
            throw new RuntimeException("Cannot create an instance of " + cls, e13);
        }
    }

    @Override // androidx.lifecycle.n0, androidx.lifecycle.p0
    public final m0 d(Class cls) {
        Application application = this.f2384d;
        if (application != null) {
            return a(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.p0
    public final m0 v(Class cls, w1.c cVar) {
        if (this.f2384d != null) {
            return d(cls);
        }
        Application application = (Application) cVar.f19464a.get(n0.f2381a);
        if (application != null) {
            return a(cls, application);
        }
        if (a.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return super.d(cls);
    }
}
