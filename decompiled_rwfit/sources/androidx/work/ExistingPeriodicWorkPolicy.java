package androidx.work;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class ExistingPeriodicWorkPolicy {
    public static final ExistingPeriodicWorkPolicy KEEP;
    public static final ExistingPeriodicWorkPolicy REPLACE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExistingPeriodicWorkPolicy[] f2990a;

    static {
        ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy = new ExistingPeriodicWorkPolicy("REPLACE", 0);
        REPLACE = existingPeriodicWorkPolicy;
        ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy2 = new ExistingPeriodicWorkPolicy("KEEP", 1);
        KEEP = existingPeriodicWorkPolicy2;
        f2990a = new ExistingPeriodicWorkPolicy[]{existingPeriodicWorkPolicy, existingPeriodicWorkPolicy2};
    }

    public static ExistingPeriodicWorkPolicy valueOf(String str) {
        return (ExistingPeriodicWorkPolicy) Enum.valueOf(ExistingPeriodicWorkPolicy.class, str);
    }

    public static ExistingPeriodicWorkPolicy[] values() {
        return (ExistingPeriodicWorkPolicy[]) f2990a.clone();
    }
}
