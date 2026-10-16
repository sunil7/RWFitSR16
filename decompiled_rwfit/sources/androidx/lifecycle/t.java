package androidx.lifecycle;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public Lifecycle$State f2387a;

    /* renamed from: b, reason: collision with root package name */
    public q f2388b;

    public final void a(s sVar, Lifecycle$Event lifecycle$Event) {
        Lifecycle$State targetState = lifecycle$Event.getTargetState();
        Lifecycle$State lifecycle$State = this.f2387a;
        if (targetState != null && targetState.compareTo(lifecycle$State) < 0) {
            lifecycle$State = targetState;
        }
        this.f2387a = lifecycle$State;
        this.f2388b.c(sVar, lifecycle$Event);
        this.f2387a = targetState;
    }
}
