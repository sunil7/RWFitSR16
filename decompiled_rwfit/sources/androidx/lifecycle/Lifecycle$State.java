package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class Lifecycle$State {
    public static final Lifecycle$State CREATED;
    public static final Lifecycle$State DESTROYED;
    public static final Lifecycle$State INITIALIZED;
    public static final Lifecycle$State RESUMED;
    public static final Lifecycle$State STARTED;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Lifecycle$State[] f2331a;

    static {
        Lifecycle$State lifecycle$State = new Lifecycle$State("DESTROYED", 0);
        DESTROYED = lifecycle$State;
        Lifecycle$State lifecycle$State2 = new Lifecycle$State("INITIALIZED", 1);
        INITIALIZED = lifecycle$State2;
        Lifecycle$State lifecycle$State3 = new Lifecycle$State("CREATED", 2);
        CREATED = lifecycle$State3;
        Lifecycle$State lifecycle$State4 = new Lifecycle$State("STARTED", 3);
        STARTED = lifecycle$State4;
        Lifecycle$State lifecycle$State5 = new Lifecycle$State("RESUMED", 4);
        RESUMED = lifecycle$State5;
        f2331a = new Lifecycle$State[]{lifecycle$State, lifecycle$State2, lifecycle$State3, lifecycle$State4, lifecycle$State5};
    }

    public static Lifecycle$State valueOf(String str) {
        return (Lifecycle$State) Enum.valueOf(Lifecycle$State.class, str);
    }

    public static Lifecycle$State[] values() {
        return (Lifecycle$State[]) f2331a.clone();
    }

    public boolean isAtLeast(Lifecycle$State lifecycle$State) {
        return compareTo(lifecycle$State) >= 0;
    }
}
