package x2;

import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;

/* loaded from: classes.dex */
public abstract /* synthetic */ class j {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f19767a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f19768b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f19769c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f19770d;

    static {
        int[] iArr = new int[OutOfQuotaPolicy.values().length];
        f19770d = iArr;
        try {
            iArr[OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19770d[OutOfQuotaPolicy.DROP_WORK_REQUEST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[NetworkType.values().length];
        f19769c = iArr2;
        try {
            iArr2[NetworkType.NOT_REQUIRED.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f19769c[NetworkType.CONNECTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f19769c[NetworkType.UNMETERED.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f19769c[NetworkType.NOT_ROAMING.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f19769c[NetworkType.METERED.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        int[] iArr3 = new int[BackoffPolicy.values().length];
        f19768b = iArr3;
        try {
            iArr3[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f19768b[BackoffPolicy.LINEAR.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        int[] iArr4 = new int[WorkInfo$State.values().length];
        f19767a = iArr4;
        try {
            iArr4[WorkInfo$State.ENQUEUED.ordinal()] = 1;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f19767a[WorkInfo$State.RUNNING.ordinal()] = 2;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f19767a[WorkInfo$State.SUCCEEDED.ordinal()] = 3;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f19767a[WorkInfo$State.FAILED.ordinal()] = 4;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f19767a[WorkInfo$State.BLOCKED.ordinal()] = 5;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            f19767a[WorkInfo$State.CANCELLED.ordinal()] = 6;
        } catch (NoSuchFieldError unused15) {
        }
    }
}
