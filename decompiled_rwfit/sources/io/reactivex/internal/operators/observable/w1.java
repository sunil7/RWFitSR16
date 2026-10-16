package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class w1 implements vg.o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14972a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14973b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14974c;

    public /* synthetic */ w1(int i3, Object obj, Object obj2) {
        this.f14972a = i3;
        this.f14973b = obj;
        this.f14974c = obj2;
    }

    @Override // vg.o
    public final Object apply(Object obj) {
        switch (this.f14972a) {
            case 0:
                return ((vg.c) this.f14973b).a(this.f14974c, obj);
            case 1:
                Object apply = ((vg.o) this.f14974c).apply(obj);
                xg.c.b(apply, "The mapper returned a null ObservableSource");
                return new s2((rg.q) apply, new w1(0, (vg.c) this.f14973b, obj), 3);
            default:
                Object apply2 = ((vg.o) this.f14973b).apply((rg.l) obj);
                xg.c.b(apply2, "The selector returned a null ObservableSource");
                return rg.l.wrap((rg.q) apply2).observeOn((rg.x) this.f14974c);
        }
    }
}
