package yh;

import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f20134a;

    static {
        int[] iArr = new int[ThreadMode.values().length];
        f20134a = iArr;
        try {
            iArr[ThreadMode.POSTING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20134a[ThreadMode.MAIN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f20134a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f20134a[ThreadMode.BACKGROUND.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f20134a[ThreadMode.ASYNC.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
