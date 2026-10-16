package com.tencent.mmkv;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class MMKVRecoverStrategic {
    public static final MMKVRecoverStrategic OnErrorDiscard;
    public static final MMKVRecoverStrategic OnErrorRecover;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MMKVRecoverStrategic[] f11904a;

    static {
        MMKVRecoverStrategic mMKVRecoverStrategic = new MMKVRecoverStrategic("OnErrorDiscard", 0);
        OnErrorDiscard = mMKVRecoverStrategic;
        MMKVRecoverStrategic mMKVRecoverStrategic2 = new MMKVRecoverStrategic("OnErrorRecover", 1);
        OnErrorRecover = mMKVRecoverStrategic2;
        f11904a = new MMKVRecoverStrategic[]{mMKVRecoverStrategic, mMKVRecoverStrategic2};
    }

    public static MMKVRecoverStrategic valueOf(String str) {
        return (MMKVRecoverStrategic) Enum.valueOf(MMKVRecoverStrategic.class, str);
    }

    public static MMKVRecoverStrategic[] values() {
        return (MMKVRecoverStrategic[]) f11904a.clone();
    }
}
