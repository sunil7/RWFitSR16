package com.google.zxing.datamatrix.decoder;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f11239a;

    static {
        int[] iArr = new int[DecodedBitStreamParser$Mode.values().length];
        f11239a = iArr;
        try {
            iArr[DecodedBitStreamParser$Mode.C40_ENCODE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f11239a[DecodedBitStreamParser$Mode.TEXT_ENCODE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f11239a[DecodedBitStreamParser$Mode.ANSIX12_ENCODE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f11239a[DecodedBitStreamParser$Mode.EDIFACT_ENCODE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f11239a[DecodedBitStreamParser$Mode.BASE256_ENCODE.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f11239a[DecodedBitStreamParser$Mode.ECI_ENCODE.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
