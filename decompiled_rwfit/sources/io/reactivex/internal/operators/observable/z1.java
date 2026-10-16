package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class z1 implements vg.c, vg.g, vg.o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15036a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f15037b;

    public /* synthetic */ z1(Object obj, int i3) {
        this.f15036a = i3;
        this.f15037b = obj;
    }

    @Override // vg.c
    public Object a(Object obj, Object obj2) {
        switch (this.f15036a) {
            case 0:
                ((vg.b) this.f15037b).i(obj, (rg.d) obj2);
                break;
            default:
                ((vg.g) this.f15037b).f((rg.d) obj2);
                break;
        }
        return obj;
    }

    @Override // vg.o
    public Object apply(Object obj) {
        Object apply = ((r) this.f15037b).f14849d.apply(new Object[]{obj});
        xg.c.b(apply, "The combiner returned a null value");
        return apply;
    }

    @Override // vg.g
    public void f(Object obj) {
        ((ObserverResourceWrapper) this.f15037b).setResource((ug.b) obj);
    }
}
