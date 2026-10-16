package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class k extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14711b;

    /* renamed from: c, reason: collision with root package name */
    public final vg.p f14712c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(rg.l lVar, vg.p pVar, int i3) {
        super(lVar);
        this.f14711b = i3;
        this.f14712c = pVar;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14711b) {
            case 0:
                this.f14546a.subscribe(new j(sVar, this.f14712c, 0));
                break;
            case 1:
                this.f14546a.subscribe(new j(sVar, this.f14712c, 1));
                break;
            case 2:
                this.f14546a.subscribe(new v0(sVar, this.f14712c, 1));
                break;
            case 3:
                this.f14546a.subscribe(new j(sVar, this.f14712c, 2));
                break;
            case 4:
                this.f14546a.subscribe(new j(sVar, this.f14712c, 3));
                break;
            default:
                this.f14546a.subscribe(new j(sVar, this.f14712c, 4));
                break;
        }
    }
}
