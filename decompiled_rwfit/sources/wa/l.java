package wa;

/* loaded from: classes.dex */
public final class l extends m {
    public final /* synthetic */ int e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ p f19560f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(p pVar, int i3) {
        super(pVar);
        this.e = i3;
        this.f19560f = pVar;
    }

    @Override // wa.m
    public final float a() {
        switch (this.e) {
            case 0:
                p pVar = this.f19560f;
                return pVar.f19571h + pVar.f19572i;
            case 1:
                p pVar2 = this.f19560f;
                return pVar2.f19571h + pVar2.f19573j;
            default:
                return this.f19560f.f19571h;
        }
    }
}
