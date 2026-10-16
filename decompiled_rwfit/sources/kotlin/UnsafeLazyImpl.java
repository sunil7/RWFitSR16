package kotlin;

import eh.b;
import eh.f;
import java.io.Serializable;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public final class UnsafeLazyImpl<T> implements b, Serializable {
    private Object _value;
    private oh.a initializer;

    public UnsafeLazyImpl(oh.a initializer) {
        e.f(initializer, "initializer");
        this.initializer = initializer;
        this._value = f.f12632a;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // eh.b
    public T getValue() {
        if (this._value == f.f12632a) {
            oh.a aVar = this.initializer;
            e.c(aVar);
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    @Override // eh.b
    public boolean isInitialized() {
        return this._value != f.f12632a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
