package androidx.fragment.app;

/* loaded from: classes.dex */
public abstract /* synthetic */ class c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2151a;

    static {
        int[] iArr = new int[SpecialEffectsController$Operation$State.values().length];
        f2151a = iArr;
        try {
            iArr[SpecialEffectsController$Operation$State.GONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2151a[SpecialEffectsController$Operation$State.INVISIBLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f2151a[SpecialEffectsController$Operation$State.REMOVED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f2151a[SpecialEffectsController$Operation$State.VISIBLE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
