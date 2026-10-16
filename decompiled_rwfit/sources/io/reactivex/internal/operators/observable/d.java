package io.reactivex.internal.operators.observable;

import java.util.Iterator;

/* loaded from: classes2.dex */
public final class d implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14605a;

    /* renamed from: b, reason: collision with root package name */
    public final rg.l f14606b;

    public /* synthetic */ d(rg.l lVar, int i3) {
        this.f14605a = i3;
        this.f14606b = lVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f14605a) {
            case 0:
                c cVar = new c();
                rg.l.wrap(this.f14606b).materialize().subscribe(cVar);
                return cVar;
            default:
                return new h(this.f14606b, new i());
        }
    }
}
