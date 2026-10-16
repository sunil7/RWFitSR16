package com.google.zxing.pdf417.decoder;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f11256a;

    static {
        int[] iArr = new int[DecodedBitStreamParser$Mode.values().length];
        f11256a = iArr;
        try {
            iArr[DecodedBitStreamParser$Mode.ALPHA.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f11256a[DecodedBitStreamParser$Mode.LOWER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f11256a[DecodedBitStreamParser$Mode.MIXED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f11256a[DecodedBitStreamParser$Mode.PUNCT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f11256a[DecodedBitStreamParser$Mode.ALPHA_SHIFT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f11256a[DecodedBitStreamParser$Mode.PUNCT_SHIFT.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
