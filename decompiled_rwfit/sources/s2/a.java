package s2;

import androidx.work.NetworkType;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18156a;

    static {
        int[] iArr = new int[NetworkType.values().length];
        f18156a = iArr;
        try {
            iArr[NetworkType.NOT_REQUIRED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f18156a[NetworkType.CONNECTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f18156a[NetworkType.UNMETERED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f18156a[NetworkType.NOT_ROAMING.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f18156a[NetworkType.METERED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
