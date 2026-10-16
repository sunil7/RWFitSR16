package mg;

import com.tencent.mmkv.MMKVLogLevel;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f16128a;

    static {
        int[] iArr = new int[MMKVLogLevel.values().length];
        f16128a = iArr;
        try {
            iArr[MMKVLogLevel.LevelDebug.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f16128a[MMKVLogLevel.LevelWarning.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f16128a[MMKVLogLevel.LevelError.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f16128a[MMKVLogLevel.LevelNone.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f16128a[MMKVLogLevel.LevelInfo.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
