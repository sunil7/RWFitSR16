package kotlin;

import eh.b;
import eh.e;
import eh.f;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes2.dex */
final class SafePublicationLazyImpl<T> implements b, Serializable {
    public static final e Companion = new e();

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15626a = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    private volatile Object _value;

    /* renamed from: final, reason: not valid java name */
    private final Object f0final;
    private volatile oh.a initializer;

    public SafePublicationLazyImpl(oh.a initializer) {
        kotlin.jvm.internal.e.f(initializer, "initializer");
        this.initializer = initializer;
        f fVar = f.f12632a;
        this._value = fVar;
        this.f0final = fVar;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // eh.b
    public T getValue() {
        T t8 = (T) this._value;
        f fVar = f.f12632a;
        if (t8 != fVar) {
            return t8;
        }
        oh.a aVar = this.initializer;
        if (aVar != null) {
            T t10 = (T) aVar.invoke();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15626a;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, fVar, t10)) {
                if (atomicReferenceFieldUpdater.get(this) != fVar) {
                }
            }
            this.initializer = null;
            return t10;
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
