package com.bumptech.glide.load;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class DecodeFormat {
    public static final DecodeFormat DEFAULT;
    public static final DecodeFormat PREFER_ARGB_8888;
    public static final DecodeFormat PREFER_RGB_565;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DecodeFormat[] f6955a;

    static {
        DecodeFormat decodeFormat = new DecodeFormat("PREFER_ARGB_8888", 0);
        PREFER_ARGB_8888 = decodeFormat;
        DecodeFormat decodeFormat2 = new DecodeFormat("PREFER_RGB_565", 1);
        PREFER_RGB_565 = decodeFormat2;
        f6955a = new DecodeFormat[]{decodeFormat, decodeFormat2};
        DEFAULT = decodeFormat;
    }

    public static DecodeFormat valueOf(String str) {
        return (DecodeFormat) Enum.valueOf(DecodeFormat.class, str);
    }

    public static DecodeFormat[] values() {
        return (DecodeFormat[]) f6955a.clone();
    }
}
