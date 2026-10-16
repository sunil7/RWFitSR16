package androidx.fragment.app;

import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public final p1 f2203a;

    /* renamed from: b, reason: collision with root package name */
    public final h1.d f2204b;

    public j(p1 p1Var, h1.d dVar) {
        this.f2203a = p1Var;
        this.f2204b = dVar;
    }

    public final void a() {
        p1 p1Var = this.f2203a;
        HashSet hashSet = p1Var.e;
        if (hashSet.remove(this.f2204b) && hashSet.isEmpty()) {
            p1Var.b();
        }
    }

    public final boolean b() {
        p1 p1Var = this.f2203a;
        SpecialEffectsController$Operation$State from = SpecialEffectsController$Operation$State.from(p1Var.f2253c.mView);
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State = p1Var.f2251a;
        if (from == specialEffectsController$Operation$State) {
            return true;
        }
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State2 = SpecialEffectsController$Operation$State.VISIBLE;
        return (from == specialEffectsController$Operation$State2 || specialEffectsController$Operation$State == specialEffectsController$Operation$State2) ? false : true;
    }
}
