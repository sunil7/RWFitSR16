package androidx.lifecycle;

/* loaded from: classes.dex */
class LiveData$LifecycleBoundObserver extends x implements q {
    public final s e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ y f2333f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveData$LifecycleBoundObserver(y yVar, s sVar, c0 c0Var) {
        super(yVar, c0Var);
        this.f2333f = yVar;
        this.e = sVar;
    }

    @Override // androidx.lifecycle.x
    public final void b() {
        this.e.getLifecycle().b(this);
    }

    @Override // androidx.lifecycle.q
    public final void c(s sVar, Lifecycle$Event lifecycle$Event) {
        s sVar2 = this.e;
        Lifecycle$State lifecycle$State = ((u) sVar2.getLifecycle()).f2390b;
        if (lifecycle$State == Lifecycle$State.DESTROYED) {
            this.f2333f.j(this.f2398a);
            return;
        }
        Lifecycle$State lifecycle$State2 = null;
        while (lifecycle$State2 != lifecycle$State) {
            a(e());
            lifecycle$State2 = lifecycle$State;
            lifecycle$State = ((u) sVar2.getLifecycle()).f2390b;
        }
    }

    @Override // androidx.lifecycle.x
    public final boolean d(s sVar) {
        return this.e == sVar;
    }

    @Override // androidx.lifecycle.x
    public final boolean e() {
        return ((u) this.e.getLifecycle()).f2390b.isAtLeast(Lifecycle$State.STARTED);
    }
}
