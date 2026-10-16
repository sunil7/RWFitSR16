package com.bumptech.glide.load;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class PreferredColorSpace {
    public static final PreferredColorSpace DISPLAY_P3;
    public static final PreferredColorSpace SRGB;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreferredColorSpace[] f6957a;

    static {
        PreferredColorSpace preferredColorSpace = new PreferredColorSpace("SRGB", 0);
        SRGB = preferredColorSpace;
        PreferredColorSpace preferredColorSpace2 = new PreferredColorSpace("DISPLAY_P3", 1);
        DISPLAY_P3 = preferredColorSpace2;
        f6957a = new PreferredColorSpace[]{preferredColorSpace, preferredColorSpace2};
    }

    public static PreferredColorSpace valueOf(String str) {
        return (PreferredColorSpace) Enum.valueOf(PreferredColorSpace.class, str);
    }

    public static PreferredColorSpace[] values() {
        return (PreferredColorSpace[]) f6957a.clone();
    }
}
