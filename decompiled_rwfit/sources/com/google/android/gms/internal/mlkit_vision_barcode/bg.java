package com.google.android.gms.internal.mlkit_vision_barcode;

import android.util.Log;
import com.google.firebase.components.InvalidRegistrarException;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final /* synthetic */ class bg implements vb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9245a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9246b;

    public /* synthetic */ bg(Object obj, int i3) {
        this.f9245a = i3;
        this.f9246b = obj;
    }

    @Override // vb.a
    public final Object get() {
        switch (this.f9245a) {
            case 0:
                return ((de.o) this.f9246b).D(new x7.b("json"), new eg(3));
            case 1:
                return ((de.o) this.f9246b).D(new x7.b("proto"), new eg(2));
            case 2:
                return ((de.o) this.f9246b).D(new x7.b("json"), com.google.android.gms.internal.mlkit_vision_common.na.e);
            case 3:
                return ((de.o) this.f9246b).D(new x7.b("proto"), com.google.android.gms.internal.mlkit_vision_common.na.f10050d);
            default:
                String str = (String) this.f9246b;
                try {
                    Class<?> cls = Class.forName(str);
                    if (pb.c.class.isAssignableFrom(cls)) {
                        return (pb.c) cls.getDeclaredConstructor(null).newInstance(null);
                    }
                    throw new InvalidRegistrarException("Class " + str + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                } catch (ClassNotFoundException unused) {
                    Log.w("ComponentDiscovery", "Class " + str + " is not an found.");
                    return null;
                } catch (IllegalAccessException e) {
                    throw new InvalidRegistrarException(l0.o("Could not instantiate ", str, "."), e);
                } catch (InstantiationException e10) {
                    throw new InvalidRegistrarException(l0.o("Could not instantiate ", str, "."), e10);
                } catch (NoSuchMethodException e11) {
                    throw new InvalidRegistrarException(l0.n("Could not instantiate ", str), e11);
                } catch (InvocationTargetException e12) {
                    throw new InvalidRegistrarException(l0.n("Could not instantiate ", str), e12);
                }
        }
    }
}
