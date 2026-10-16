package jd;

import com.google.zxing.qrcode.decoder.Mode;

/* loaded from: classes.dex */
public abstract /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f15406a;

    static {
        int[] iArr = new int[Mode.values().length];
        f15406a = iArr;
        try {
            iArr[Mode.NUMERIC.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15406a[Mode.ALPHANUMERIC.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f15406a[Mode.BYTE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f15406a[Mode.KANJI.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f15406a[Mode.TERMINATOR.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f15406a[Mode.FNC1_FIRST_POSITION.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f15406a[Mode.FNC1_SECOND_POSITION.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f15406a[Mode.STRUCTURED_APPEND.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f15406a[Mode.ECI.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f15406a[Mode.HANZI.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
