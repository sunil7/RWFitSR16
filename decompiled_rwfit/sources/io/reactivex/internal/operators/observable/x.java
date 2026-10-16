package io.reactivex.internal.operators.observable;

import java.util.Collection;

/* loaded from: classes2.dex */
public final class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14989a;

    /* renamed from: b, reason: collision with root package name */
    public final Collection f14990b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f14991c;

    public /* synthetic */ x(y yVar, Collection collection, int i3) {
        this.f14989a = i3;
        this.f14991c = yVar;
        this.f14990b = collection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f14989a) {
            case 0:
                synchronized (this.f14991c) {
                    this.f14991c.f15015l.remove(this.f14990b);
                }
                y yVar = this.f14991c;
                yVar.e(this.f14990b, yVar.f15014k);
                return;
            default:
                synchronized (this.f14991c) {
                    this.f14991c.f15015l.remove(this.f14990b);
                }
                y yVar2 = this.f14991c;
                yVar2.e(this.f14990b, yVar2.f15014k);
                return;
        }
    }
}
