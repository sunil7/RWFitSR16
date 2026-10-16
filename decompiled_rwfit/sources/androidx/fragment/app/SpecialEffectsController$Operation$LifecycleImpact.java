package androidx.fragment.app;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class SpecialEffectsController$Operation$LifecycleImpact {
    public static final SpecialEffectsController$Operation$LifecycleImpact ADDING;
    public static final SpecialEffectsController$Operation$LifecycleImpact NONE;
    public static final SpecialEffectsController$Operation$LifecycleImpact REMOVING;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SpecialEffectsController$Operation$LifecycleImpact[] f2124a;

    static {
        SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact = new SpecialEffectsController$Operation$LifecycleImpact("NONE", 0);
        NONE = specialEffectsController$Operation$LifecycleImpact;
        SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact2 = new SpecialEffectsController$Operation$LifecycleImpact("ADDING", 1);
        ADDING = specialEffectsController$Operation$LifecycleImpact2;
        SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact3 = new SpecialEffectsController$Operation$LifecycleImpact("REMOVING", 2);
        REMOVING = specialEffectsController$Operation$LifecycleImpact3;
        f2124a = new SpecialEffectsController$Operation$LifecycleImpact[]{specialEffectsController$Operation$LifecycleImpact, specialEffectsController$Operation$LifecycleImpact2, specialEffectsController$Operation$LifecycleImpact3};
    }

    public static SpecialEffectsController$Operation$LifecycleImpact valueOf(String str) {
        return (SpecialEffectsController$Operation$LifecycleImpact) Enum.valueOf(SpecialEffectsController$Operation$LifecycleImpact.class, str);
    }

    public static SpecialEffectsController$Operation$LifecycleImpact[] values() {
        return (SpecialEffectsController$Operation$LifecycleImpact[]) f2124a.clone();
    }
}
