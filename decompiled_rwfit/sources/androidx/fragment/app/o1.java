package androidx.fragment.app;

/* loaded from: classes.dex */
public abstract /* synthetic */ class o1 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2234a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f2235b;

    static {
        int[] iArr = new int[SpecialEffectsController$Operation$LifecycleImpact.values().length];
        f2235b = iArr;
        try {
            iArr[SpecialEffectsController$Operation$LifecycleImpact.ADDING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2235b[SpecialEffectsController$Operation$LifecycleImpact.REMOVING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f2235b[SpecialEffectsController$Operation$LifecycleImpact.NONE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[SpecialEffectsController$Operation$State.values().length];
        f2234a = iArr2;
        try {
            iArr2[SpecialEffectsController$Operation$State.REMOVED.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f2234a[SpecialEffectsController$Operation$State.VISIBLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f2234a[SpecialEffectsController$Operation$State.GONE.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f2234a[SpecialEffectsController$Operation$State.INVISIBLE.ordinal()] = 4;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
