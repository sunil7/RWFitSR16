package androidx.fragment.app;

import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: b, reason: collision with root package name */
    public static final m0.k f2222b = new m0.k();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t0 f2223a;

    public m0(t0 t0Var) {
        this.f2223a = t0Var;
    }

    public static Class a(ClassLoader classLoader, String str) {
        m0.k kVar = f2222b;
        m0.k kVar2 = (m0.k) kVar.getOrDefault(classLoader, null);
        if (kVar2 == null) {
            kVar2 = new m0.k();
            kVar.put(classLoader, kVar2);
        }
        Class cls = (Class) kVar2.getOrDefault(str, null);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        kVar2.put(str, cls2);
        return cls2;
    }

    public static Class b(ClassLoader classLoader, String str) {
        try {
            return a(classLoader, str);
        } catch (ClassCastException e) {
            throw new Fragment.InstantiationException(com.google.android.gms.internal.mlkit_vision_barcode.l0.o("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
        } catch (ClassNotFoundException e10) {
            throw new Fragment.InstantiationException(com.google.android.gms.internal.mlkit_vision_barcode.l0.o("Unable to instantiate fragment ", str, ": make sure class name exists"), e10);
        }
    }
}
