package kotlin.jvm.internal;

import uh.j;

/* loaded from: classes2.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements uh.h {
    public MutablePropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public uh.b computeReflected() {
        g.f15651a.getClass();
        return this;
    }

    public abstract /* synthetic */ Object get();

    @Override // uh.h
    public Object getDelegate() {
        return ((uh.h) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public /* bridge */ /* synthetic */ uh.i getGetter() {
        getGetter();
        return null;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public /* bridge */ /* synthetic */ uh.f getSetter() {
        getSetter();
        return null;
    }

    @Override // oh.a
    public Object invoke() {
        return get();
    }

    public abstract /* synthetic */ void set(Object obj);

    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public j getGetter() {
        ((uh.h) getReflected()).getGetter();
        return null;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public uh.g getSetter() {
        ((uh.h) getReflected()).getSetter();
        return null;
    }

    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, i3);
    }
}
