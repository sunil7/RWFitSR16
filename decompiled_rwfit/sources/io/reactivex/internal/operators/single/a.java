package io.reactivex.internal.operators.single;

import rg.l;
import rg.s;
import rg.y;
import rg.z;

/* loaded from: classes2.dex */
public final class a extends l {

    /* renamed from: a, reason: collision with root package name */
    public final y f15045a;

    public a(y yVar) {
        this.f15045a = yVar;
    }

    public static z c(s sVar) {
        return new SingleToObservable$SingleToObservableObserver(sVar);
    }

    @Override // rg.l
    public final void subscribeActual(s sVar) {
        this.f15045a.b(new SingleToObservable$SingleToObservableObserver(sVar));
    }
}
