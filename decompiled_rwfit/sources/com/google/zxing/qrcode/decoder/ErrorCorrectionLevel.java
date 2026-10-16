package com.google.zxing.qrcode.decoder;

/* loaded from: classes.dex */
public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* renamed from: a, reason: collision with root package name */
    public static final ErrorCorrectionLevel[] f11261a;
    private final int bits;

    static {
        ErrorCorrectionLevel errorCorrectionLevel = L;
        ErrorCorrectionLevel errorCorrectionLevel2 = M;
        ErrorCorrectionLevel errorCorrectionLevel3 = Q;
        f11261a = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, H, errorCorrectionLevel3};
    }

    ErrorCorrectionLevel(int i3) {
        this.bits = i3;
    }

    public static ErrorCorrectionLevel forBits(int i3) {
        if (i3 < 0 || i3 >= 4) {
            throw new IllegalArgumentException();
        }
        return f11261a[i3];
    }

    public int getBits() {
        return this.bits;
    }
}
