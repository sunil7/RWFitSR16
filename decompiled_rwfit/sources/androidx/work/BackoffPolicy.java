package androidx.work;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class BackoffPolicy {
    public static final BackoffPolicy EXPONENTIAL;
    public static final BackoffPolicy LINEAR;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackoffPolicy[] f2989a;

    static {
        BackoffPolicy backoffPolicy = new BackoffPolicy("EXPONENTIAL", 0);
        EXPONENTIAL = backoffPolicy;
        BackoffPolicy backoffPolicy2 = new BackoffPolicy("LINEAR", 1);
        LINEAR = backoffPolicy2;
        f2989a = new BackoffPolicy[]{backoffPolicy, backoffPolicy2};
    }

    public static BackoffPolicy valueOf(String str) {
        return (BackoffPolicy) Enum.valueOf(BackoffPolicy.class, str);
    }

    public static BackoffPolicy[] values() {
        return (BackoffPolicy[]) f2989a.clone();
    }
}
