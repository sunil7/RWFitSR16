package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class g implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f14643a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14644b;

    public g(rg.l lVar, Object obj) {
        this.f14643a = lVar;
        this.f14644b = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Object obj = this.f14644b;
        f fVar = new f();
        fVar.f14633b = NotificationLite.next(obj);
        this.f14643a.subscribe(fVar);
        return new e(fVar);
    }
}
