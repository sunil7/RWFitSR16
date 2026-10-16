package androidx.lifecycle;

/* loaded from: classes.dex */
final class SavedStateHandleController implements q {

    /* renamed from: a, reason: collision with root package name */
    public final String f2337a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2338b = false;

    /* renamed from: c, reason: collision with root package name */
    public final h0 f2339c;

    public SavedStateHandleController(String str, h0 h0Var) {
        this.f2337a = str;
        this.f2339c = h0Var;
    }

    @Override // androidx.lifecycle.q
    public final void c(s sVar, Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event == Lifecycle$Event.ON_DESTROY) {
            this.f2338b = false;
            sVar.getLifecycle().b(this);
        }
    }
}
