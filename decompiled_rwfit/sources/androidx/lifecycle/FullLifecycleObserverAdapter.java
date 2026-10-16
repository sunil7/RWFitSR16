package androidx.lifecycle;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements q {

    /* renamed from: a, reason: collision with root package name */
    public final f f2327a;

    /* renamed from: b, reason: collision with root package name */
    public final q f2328b;

    public FullLifecycleObserverAdapter(f fVar, q qVar) {
        this.f2327a = fVar;
        this.f2328b = qVar;
    }

    @Override // androidx.lifecycle.q
    public final void c(s sVar, Lifecycle$Event lifecycle$Event) {
        int i3 = h.f2359a[lifecycle$Event.ordinal()];
        f fVar = this.f2327a;
        if (i3 == 3) {
            fVar.onResume(sVar);
        } else if (i3 == 7) {
            throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        q qVar = this.f2328b;
        if (qVar != null) {
            qVar.c(sVar, lifecycle$Event);
        }
    }
}
