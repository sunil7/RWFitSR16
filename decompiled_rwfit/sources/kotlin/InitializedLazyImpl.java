package kotlin;

import eh.b;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class InitializedLazyImpl<T> implements b, Serializable {
    private final T value;

    public InitializedLazyImpl(T t8) {
        this.value = t8;
    }

    @Override // eh.b
    public T getValue() {
        return this.value;
    }

    @Override // eh.b
    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
