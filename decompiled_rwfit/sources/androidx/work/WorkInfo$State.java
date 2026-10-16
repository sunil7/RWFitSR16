package androidx.work;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class WorkInfo$State {
    public static final WorkInfo$State BLOCKED;
    public static final WorkInfo$State CANCELLED;
    public static final WorkInfo$State ENQUEUED;
    public static final WorkInfo$State FAILED;
    public static final WorkInfo$State RUNNING;
    public static final WorkInfo$State SUCCEEDED;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WorkInfo$State[] f2998a;

    static {
        WorkInfo$State workInfo$State = new WorkInfo$State("ENQUEUED", 0);
        ENQUEUED = workInfo$State;
        WorkInfo$State workInfo$State2 = new WorkInfo$State("RUNNING", 1);
        RUNNING = workInfo$State2;
        WorkInfo$State workInfo$State3 = new WorkInfo$State("SUCCEEDED", 2);
        SUCCEEDED = workInfo$State3;
        WorkInfo$State workInfo$State4 = new WorkInfo$State("FAILED", 3);
        FAILED = workInfo$State4;
        WorkInfo$State workInfo$State5 = new WorkInfo$State("BLOCKED", 4);
        BLOCKED = workInfo$State5;
        WorkInfo$State workInfo$State6 = new WorkInfo$State("CANCELLED", 5);
        CANCELLED = workInfo$State6;
        f2998a = new WorkInfo$State[]{workInfo$State, workInfo$State2, workInfo$State3, workInfo$State4, workInfo$State5, workInfo$State6};
    }

    public static WorkInfo$State valueOf(String str) {
        return (WorkInfo$State) Enum.valueOf(WorkInfo$State.class, str);
    }

    public static WorkInfo$State[] values() {
        return (WorkInfo$State[]) f2998a.clone();
    }

    public boolean isFinished() {
        return this == SUCCEEDED || this == FAILED || this == CANCELLED;
    }
}
