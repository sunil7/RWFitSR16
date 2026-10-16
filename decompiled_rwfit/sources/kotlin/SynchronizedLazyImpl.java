package kotlin;

import eh.b;
import eh.f;
import java.io.Serializable;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
final class SynchronizedLazyImpl<T> implements b, Serializable {
    private volatile Object _value;
    private oh.a initializer;
    private final Object lock;

    public SynchronizedLazyImpl(oh.a initializer, Object obj) {
        e.f(initializer, "initializer");
        this.initializer = initializer;
        this._value = f.f12632a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // eh.b
    public T getValue() {
        T t8;
        T t10 = (T) this._value;
        f fVar = f.f12632a;
        if (t10 != fVar) {
            return t10;
        }
        synchronized (this.lock) {
            t8 = (T) this._value;
            if (t8 == fVar) {
                oh.a aVar = this.initializer;
                e.c(aVar);
                t8 = (T) aVar.invoke();
                this._value = t8;
                this.initializer = null;
            }
        }
        return t8;
    }

    @Override // eh.b
    public boolean isInitialized() {
        return this._value != f.f12632a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(oh.a aVar, Object obj, int i3, c cVar) {
        this(aVar, (i3 & 2) != 0 ? null : obj);
    }
}
