package com.google.zxing.aztec.decoder;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f11219a;

    static {
        int[] iArr = new int[Decoder$Table.values().length];
        f11219a = iArr;
        try {
            iArr[Decoder$Table.UPPER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f11219a[Decoder$Table.LOWER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f11219a[Decoder$Table.MIXED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f11219a[Decoder$Table.PUNCT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f11219a[Decoder$Table.DIGIT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
