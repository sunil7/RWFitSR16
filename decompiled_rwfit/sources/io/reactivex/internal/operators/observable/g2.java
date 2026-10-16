package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class g2 extends rg.y {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14651a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14652b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14653c;

    public /* synthetic */ g2(int i3, Object obj, Object obj2) {
        this.f14651a = i3;
        this.f14652b = obj;
        this.f14653c = obj2;
    }

    @Override // rg.y
    public final void c(rg.z zVar) {
        switch (this.f14651a) {
            case 0:
                ((rg.l) this.f14652b).subscribe(new io.reactivex.internal.observers.e(zVar, this.f14653c));
                break;
            case 1:
                ((rg.l) this.f14652b).subscribe(new c0(zVar, this.f14653c));
                break;
            default:
                ((rg.y) this.f14652b).b(new com.example.test.utils.y(zVar, 22, (n6.a) this.f14653c, false));
                break;
        }
    }
}
