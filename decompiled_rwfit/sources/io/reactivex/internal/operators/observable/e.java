package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class e implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public Object f14618a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f14619b;

    public e(f fVar) {
        this.f14619b = fVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        this.f14618a = this.f14619b.f14633b;
        return !NotificationLite.isComplete(r0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        try {
            if (this.f14618a == null) {
                this.f14618a = this.f14619b.f14633b;
            }
            if (NotificationLite.isComplete(this.f14618a)) {
                throw new NoSuchElementException();
            }
            if (NotificationLite.isError(this.f14618a)) {
                throw io.reactivex.internal.util.b.b(NotificationLite.getError(this.f14618a));
            }
            Object value = NotificationLite.getValue(this.f14618a);
            this.f14618a = null;
            return value;
        } catch (Throwable th2) {
            this.f14618a = null;
            throw th2;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Read only iterator");
    }
}
