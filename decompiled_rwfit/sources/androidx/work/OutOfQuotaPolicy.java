package androidx.work;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class OutOfQuotaPolicy {
    public static final OutOfQuotaPolicy DROP_WORK_REQUEST;
    public static final OutOfQuotaPolicy RUN_AS_NON_EXPEDITED_WORK_REQUEST;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OutOfQuotaPolicy[] f2997a;

    static {
        OutOfQuotaPolicy outOfQuotaPolicy = new OutOfQuotaPolicy("RUN_AS_NON_EXPEDITED_WORK_REQUEST", 0);
        RUN_AS_NON_EXPEDITED_WORK_REQUEST = outOfQuotaPolicy;
        OutOfQuotaPolicy outOfQuotaPolicy2 = new OutOfQuotaPolicy("DROP_WORK_REQUEST", 1);
        DROP_WORK_REQUEST = outOfQuotaPolicy2;
        f2997a = new OutOfQuotaPolicy[]{outOfQuotaPolicy, outOfQuotaPolicy2};
    }

    public static OutOfQuotaPolicy valueOf(String str) {
        return (OutOfQuotaPolicy) Enum.valueOf(OutOfQuotaPolicy.class, str);
    }

    public static OutOfQuotaPolicy[] values() {
        return (OutOfQuotaPolicy[]) f2997a.clone();
    }
}
