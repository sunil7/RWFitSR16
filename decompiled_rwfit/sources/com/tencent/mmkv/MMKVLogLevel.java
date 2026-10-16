package com.tencent.mmkv;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class MMKVLogLevel {
    public static final MMKVLogLevel LevelDebug;
    public static final MMKVLogLevel LevelError;
    public static final MMKVLogLevel LevelInfo;
    public static final MMKVLogLevel LevelNone;
    public static final MMKVLogLevel LevelWarning;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MMKVLogLevel[] f11903a;

    static {
        MMKVLogLevel mMKVLogLevel = new MMKVLogLevel("LevelDebug", 0);
        LevelDebug = mMKVLogLevel;
        MMKVLogLevel mMKVLogLevel2 = new MMKVLogLevel("LevelInfo", 1);
        LevelInfo = mMKVLogLevel2;
        MMKVLogLevel mMKVLogLevel3 = new MMKVLogLevel("LevelWarning", 2);
        LevelWarning = mMKVLogLevel3;
        MMKVLogLevel mMKVLogLevel4 = new MMKVLogLevel("LevelError", 3);
        LevelError = mMKVLogLevel4;
        MMKVLogLevel mMKVLogLevel5 = new MMKVLogLevel("LevelNone", 4);
        LevelNone = mMKVLogLevel5;
        f11903a = new MMKVLogLevel[]{mMKVLogLevel, mMKVLogLevel2, mMKVLogLevel3, mMKVLogLevel4, mMKVLogLevel5};
    }

    public static MMKVLogLevel valueOf(String str) {
        return (MMKVLogLevel) Enum.valueOf(MMKVLogLevel.class, str);
    }

    public static MMKVLogLevel[] values() {
        return (MMKVLogLevel[]) f11903a.clone();
    }
}
