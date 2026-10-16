package androidx.lifecycle;

/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements q {

    /* renamed from: a, reason: collision with root package name */
    public final i0 f2336a;

    public SavedStateHandleAttacher(i0 i0Var) {
        this.f2336a = i0Var;
    }

    @Override // androidx.lifecycle.q
    public final void c(s sVar, Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event != Lifecycle$Event.ON_CREATE) {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + lifecycle$Event).toString());
        }
        sVar.getLifecycle().b(this);
        i0 i0Var = this.f2336a;
        if (i0Var.f2366b) {
            return;
        }
        i0Var.f2367c = i0Var.f2365a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        i0Var.f2366b = true;
    }
}
