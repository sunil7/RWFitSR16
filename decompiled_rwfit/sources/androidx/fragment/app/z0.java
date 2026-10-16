package androidx.fragment.app;

import androidx.lifecycle.Lifecycle$State;

/* loaded from: classes.dex */
public abstract /* synthetic */ class z0 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2325a;

    static {
        int[] iArr = new int[Lifecycle$State.values().length];
        f2325a = iArr;
        try {
            iArr[Lifecycle$State.RESUMED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2325a[Lifecycle$State.STARTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f2325a[Lifecycle$State.CREATED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f2325a[Lifecycle$State.INITIALIZED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
