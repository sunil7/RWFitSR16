package com.google.zxing.datamatrix.decoder;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class DecodedBitStreamParser$Mode {
    public static final DecodedBitStreamParser$Mode ANSIX12_ENCODE;
    public static final DecodedBitStreamParser$Mode ASCII_ENCODE;
    public static final DecodedBitStreamParser$Mode BASE256_ENCODE;
    public static final DecodedBitStreamParser$Mode C40_ENCODE;
    public static final DecodedBitStreamParser$Mode ECI_ENCODE;
    public static final DecodedBitStreamParser$Mode EDIFACT_ENCODE;
    public static final DecodedBitStreamParser$Mode PAD_ENCODE;
    public static final DecodedBitStreamParser$Mode TEXT_ENCODE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DecodedBitStreamParser$Mode[] f11238a;

    static {
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode = new DecodedBitStreamParser$Mode("PAD_ENCODE", 0);
        PAD_ENCODE = decodedBitStreamParser$Mode;
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode2 = new DecodedBitStreamParser$Mode("ASCII_ENCODE", 1);
        ASCII_ENCODE = decodedBitStreamParser$Mode2;
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode3 = new DecodedBitStreamParser$Mode("C40_ENCODE", 2);
        C40_ENCODE = decodedBitStreamParser$Mode3;
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode4 = new DecodedBitStreamParser$Mode("TEXT_ENCODE", 3);
        TEXT_ENCODE = decodedBitStreamParser$Mode4;
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode5 = new DecodedBitStreamParser$Mode("ANSIX12_ENCODE", 4);
        ANSIX12_ENCODE = decodedBitStreamParser$Mode5;
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode6 = new DecodedBitStreamParser$Mode("EDIFACT_ENCODE", 5);
        EDIFACT_ENCODE = decodedBitStreamParser$Mode6;
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode7 = new DecodedBitStreamParser$Mode("BASE256_ENCODE", 6);
        BASE256_ENCODE = decodedBitStreamParser$Mode7;
        DecodedBitStreamParser$Mode decodedBitStreamParser$Mode8 = new DecodedBitStreamParser$Mode("ECI_ENCODE", 7);
        ECI_ENCODE = decodedBitStreamParser$Mode8;
        f11238a = new DecodedBitStreamParser$Mode[]{decodedBitStreamParser$Mode, decodedBitStreamParser$Mode2, decodedBitStreamParser$Mode3, decodedBitStreamParser$Mode4, decodedBitStreamParser$Mode5, decodedBitStreamParser$Mode6, decodedBitStreamParser$Mode7, decodedBitStreamParser$Mode8};
    }

    public static DecodedBitStreamParser$Mode valueOf(String str) {
        return (DecodedBitStreamParser$Mode) Enum.valueOf(DecodedBitStreamParser$Mode.class, str);
    }

    public static DecodedBitStreamParser$Mode[] values() {
        return (DecodedBitStreamParser$Mode[]) f11238a.clone();
    }
}
