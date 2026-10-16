package kotlin.jvm.internal;

/* loaded from: classes2.dex */
public abstract class MutablePropertyReference extends PropertyReference {
    public MutablePropertyReference() {
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public abstract /* synthetic */ uh.i getGetter();

    public abstract /* synthetic */ uh.f getSetter();

    public MutablePropertyReference(Object obj) {
        super(obj);
    }

    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, i3);
    }
}
