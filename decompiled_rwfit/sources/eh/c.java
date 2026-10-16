package eh;

import kotlin.LazyThreadSafetyMode;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f12631a;

    static {
        int[] iArr = new int[LazyThreadSafetyMode.values().length];
        try {
            iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f12631a = iArr;
    }
}
