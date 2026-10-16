package androidx.camera.core;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class UseCase$State {
    public static final UseCase$State ACTIVE;
    public static final UseCase$State INACTIVE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UseCase$State[] f1287a;

    static {
        UseCase$State useCase$State = new UseCase$State("ACTIVE", 0);
        ACTIVE = useCase$State;
        UseCase$State useCase$State2 = new UseCase$State("INACTIVE", 1);
        INACTIVE = useCase$State2;
        f1287a = new UseCase$State[]{useCase$State, useCase$State2};
    }

    public static UseCase$State valueOf(String str) {
        return (UseCase$State) Enum.valueOf(UseCase$State.class, str);
    }

    public static UseCase$State[] values() {
        return (UseCase$State[]) f1287a.clone();
    }
}
