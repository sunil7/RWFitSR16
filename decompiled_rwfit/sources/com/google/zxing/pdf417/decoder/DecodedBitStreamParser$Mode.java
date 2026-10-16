package com.google.zxing.pdf417.decoder;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class DecodedBitStreamParser$Mode {
    public static final DecodedBitStreamParser$Mode ALPHA;
    public static final DecodedBitStreamParser$Mode ALPHA_SHIFT;
    public static final DecodedBitStreamParser$Mode LOWER;
    public static final DecodedBitStreamParser$Mode MIXED;
    public static final DecodedBitStreamParser$Mode PUNCT;
    public static final DecodedBitStreamParser$Mode PUNCT_SHIFT;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DecodedBitStreamParser$Mode[] f11255a;

    static {
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode = new DecodedBitStreamParser$Mode("ALPHA", 0);
        ALPHA = decodedBitStreamParser$Mode;
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode2 = new DecodedBitStreamParser$Mode("LOWER", 1);
        LOWER = decodedBitStreamParser$Mode2;
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode3 = new DecodedBitStreamParser$Mode("MIXED", 2);
        MIXED = decodedBitStreamParser$Mode3;
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode4 = new DecodedBitStreamParser$Mode("PUNCT", 3);
        PUNCT = decodedBitStreamParser$Mode4;
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode5 = new DecodedBitStreamParser$Mode("ALPHA_SHIFT", 4);
        ALPHA_SHIFT = decodedBitStreamParser$Mode5;
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode6 = new DecodedBitStreamParser$Mode("PUNCT_SHIFT", 5);
        PUNCT_SHIFT = decodedBitStreamParser$Mode6;
        f11255a = new DecodedBitStreamParser$Mode[]{decodedBitStreamParser$Mode, decodedBitStreamParser$Mode2, decodedBitStreamParser$Mode3, decodedBitStreamParser$Mode4, decodedBitStreamParser$Mode5, decodedBitStreamParser$Mode6};
    }

    public static DecodedBitStreamParser$Mode valueOf(String str) {
        return (DecodedBitStreamParser$Mode) Enum.valueOf(DecodedBitStreamParser$Mode.class, str);
    }

    public static DecodedBitStreamParser$Mode[] values() {
        return (DecodedBitStreamParser$Mode[]) f11255a.clone();
    }
}
