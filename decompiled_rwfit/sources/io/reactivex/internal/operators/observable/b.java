package io.reactivex.internal.operators.observable;

import java.util.Iterator;

/* loaded from: classes2.dex */
public final class b implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f14569a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14570b;

    public b(rg.l lVar, int i3) {
        this.f14569a = lVar;
        this.f14570b = i3;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        BlockingObservableIterable$BlockingObservableIterator blockingObservableIterable$BlockingObservableIterator = new BlockingObservableIterable$BlockingObservableIterator(this.f14570b);
        this.f14569a.subscribe(blockingObservableIterable$BlockingObservableIterator);
        return blockingObservableIterable$BlockingObservableIterator;
    }
}
