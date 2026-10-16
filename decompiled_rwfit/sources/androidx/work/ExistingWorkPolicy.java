package androidx.work;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class ExistingWorkPolicy {
    public static final ExistingWorkPolicy APPEND;
    public static final ExistingWorkPolicy APPEND_OR_REPLACE;
    public static final ExistingWorkPolicy KEEP;
    public static final ExistingWorkPolicy REPLACE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExistingWorkPolicy[] f2991a;

    static {
        ExistingWorkPolicy existingWorkPolicy = new ExistingWorkPolicy("REPLACE", 0);
        REPLACE = existingWorkPolicy;
        ExistingWorkPolicy existingWorkPolicy2 = new ExistingWorkPolicy("KEEP", 1);
        KEEP = existingWorkPolicy2;
        ExistingWorkPolicy existingWorkPolicy3 = new ExistingWorkPolicy("APPEND", 2);
        APPEND = existingWorkPolicy3;
        ExistingWorkPolicy existingWorkPolicy4 = new ExistingWorkPolicy("APPEND_OR_REPLACE", 3);
        APPEND_OR_REPLACE = existingWorkPolicy4;
        f2991a = new ExistingWorkPolicy[]{existingWorkPolicy, existingWorkPolicy2, existingWorkPolicy3, existingWorkPolicy4};
    }

    public static ExistingWorkPolicy valueOf(String str) {
        return (ExistingWorkPolicy) Enum.valueOf(ExistingWorkPolicy.class, str);
    }

    public static ExistingWorkPolicy[] values() {
        return (ExistingWorkPolicy[]) f2991a.clone();
    }
}
