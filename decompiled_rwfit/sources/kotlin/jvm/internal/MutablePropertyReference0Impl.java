package kotlin.jvm.internal;

/* loaded from: classes2.dex */
public class MutablePropertyReference0Impl extends MutablePropertyReference0 {
    public MutablePropertyReference0Impl(uh.d dVar, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((a) dVar).a(), str, str2, !(dVar instanceof uh.c) ? 1 : 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0
    public Object get() {
        getGetter();
        throw null;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0
    public void set(Object obj) {
        getSetter();
        throw null;
    }

    public MutablePropertyReference0Impl(Class cls, String str, String str2, int i3) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i3);
    }

    public MutablePropertyReference0Impl(Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, i3);
    }
}
