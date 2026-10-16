package androidx.lifecycle;

/* loaded from: classes.dex */
public interface p0 {
    default m0 d(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    default m0 v(Class cls, w1.c cVar) {
        return d(cls);
    }
}
