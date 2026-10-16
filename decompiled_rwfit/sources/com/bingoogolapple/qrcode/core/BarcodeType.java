package com.bingoogolapple.qrcode.core;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class BarcodeType {
    public static final BarcodeType ALL;
    public static final BarcodeType CUSTOM;
    public static final BarcodeType HIGH_FREQUENCY;
    public static final BarcodeType ONE_DIMENSION;
    public static final BarcodeType ONLY_CODE_128;
    public static final BarcodeType ONLY_EAN_13;
    public static final BarcodeType ONLY_QR_CODE;
    public static final BarcodeType TWO_DIMENSION;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BarcodeType[] f6851a;

    static {
        BarcodeType barcodeType = new BarcodeType("ALL", 0);
        ALL = barcodeType;
        BarcodeType barcodeType2 = new BarcodeType("ONE_DIMENSION", 1);
        ONE_DIMENSION = barcodeType2;
        BarcodeType barcodeType3 = new BarcodeType("TWO_DIMENSION", 2);
        TWO_DIMENSION = barcodeType3;
        BarcodeType barcodeType4 = new BarcodeType("ONLY_QR_CODE", 3);
        ONLY_QR_CODE = barcodeType4;
        BarcodeType barcodeType5 = new BarcodeType("ONLY_CODE_128", 4);
        ONLY_CODE_128 = barcodeType5;
        BarcodeType barcodeType6 = new BarcodeType("ONLY_EAN_13", 5);
        ONLY_EAN_13 = barcodeType6;
        BarcodeType barcodeType7 = new BarcodeType("HIGH_FREQUENCY", 6);
        HIGH_FREQUENCY = barcodeType7;
        BarcodeType barcodeType8 = new BarcodeType("CUSTOM", 7);
        CUSTOM = barcodeType8;
        f6851a = new BarcodeType[]{barcodeType, barcodeType2, barcodeType3, barcodeType4, barcodeType5, barcodeType6, barcodeType7, barcodeType8};
    }

    public static BarcodeType valueOf(String str) {
        return (BarcodeType) Enum.valueOf(BarcodeType.class, str);
    }

    public static BarcodeType[] values() {
        return (BarcodeType[]) f6851a.clone();
    }
}
