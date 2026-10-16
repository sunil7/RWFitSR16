package kotlin.coroutines;

import gh.c;
import gh.d;
import gh.e;
import java.io.Serializable;
import oh.p;

/* loaded from: classes2.dex */
public final class EmptyCoroutineContext implements e, Serializable {
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    public <R> R fold(R r, p operation) {
        kotlin.jvm.internal.e.f(operation, "operation");
        return r;
    }

    @Override // gh.e
    public <E extends c> E get(d key) {
        kotlin.jvm.internal.e.f(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public e minusKey(d key) {
        kotlin.jvm.internal.e.f(key, "key");
        return this;
    }

    public e plus(e context) {
        kotlin.jvm.internal.e.f(context, "context");
        return context;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
