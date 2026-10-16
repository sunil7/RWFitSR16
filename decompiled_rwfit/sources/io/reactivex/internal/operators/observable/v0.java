package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class v0 extends io.reactivex.internal.observers.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f14941f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f14942g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v0(rg.s sVar, Object obj, int i3) {
        super(sVar);
        this.f14941f = i3;
        this.f14942g = obj;
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14941f) {
            case 0:
                this.f14450a.onNext(obj);
                if (this.e == 0) {
                    try {
                        ((vg.g) this.f14942g).f(obj);
                        break;
                    } catch (Throwable th2) {
                        a(th2);
                        return;
                    }
                }
                break;
            case 1:
                int i3 = this.e;
                rg.s sVar = this.f14450a;
                if (i3 != 0) {
                    sVar.onNext(null);
                    break;
                } else {
                    try {
                        if (((vg.p) this.f14942g).l(obj)) {
                            sVar.onNext(obj);
                            break;
                        }
                    } catch (Throwable th3) {
                        a(th3);
                        return;
                    }
                }
                break;
            default:
                if (!this.f14453d) {
                    int i10 = this.e;
                    rg.s sVar2 = this.f14450a;
                    if (i10 != 0) {
                        sVar2.onNext(null);
                        break;
                    } else {
                        try {
                            Object apply = ((vg.o) this.f14942g).apply(obj);
                            xg.c.b(apply, "The mapper function returned a null value.");
                            sVar2.onNext(apply);
                            break;
                        } catch (Throwable th4) {
                            a(th4);
                        }
                    }
                }
                break;
        }
    }

    @Override // yg.f
    public final Object poll() {
        Object poll;
        switch (this.f14941f) {
            case 0:
                Object poll2 = this.f14452c.poll();
                if (poll2 != null) {
                    ((vg.g) this.f14942g).f(poll2);
                }
                return poll2;
            case 1:
                break;
            default:
                Object poll3 = this.f14452c.poll();
                if (poll3 == null) {
                    return null;
                }
                Object apply = ((vg.o) this.f14942g).apply(poll3);
                xg.c.b(apply, "The mapper function returned a null value.");
                return apply;
        }
        do {
            poll = this.f14452c.poll();
            if (poll != null) {
            }
            return poll;
        } while (!((vg.p) this.f14942g).l(poll));
        return poll;
    }
}
