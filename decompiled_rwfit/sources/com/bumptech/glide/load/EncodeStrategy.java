package com.bumptech.glide.load;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class EncodeStrategy {
    public static final EncodeStrategy NONE;
    public static final EncodeStrategy SOURCE;
    public static final EncodeStrategy TRANSFORMED;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EncodeStrategy[] f6956a;

    static {
        EncodeStrategy encodeStrategy = new EncodeStrategy("SOURCE", 0);
        SOURCE = encodeStrategy;
        EncodeStrategy encodeStrategy2 = new EncodeStrategy("TRANSFORMED", 1);
        TRANSFORMED = encodeStrategy2;
        EncodeStrategy encodeStrategy3 = new EncodeStrategy("NONE", 2);
        NONE = encodeStrategy3;
        f6956a = new EncodeStrategy[]{encodeStrategy, encodeStrategy2, encodeStrategy3};
    }

    public static EncodeStrategy valueOf(String str) {
        return (EncodeStrategy) Enum.valueOf(EncodeStrategy.class, str);
    }

    public static EncodeStrategy[] values() {
        return (EncodeStrategy[]) f6956a.clone();
    }
}
