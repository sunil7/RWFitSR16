package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.Mode;

/* loaded from: classes.dex */
public abstract /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f11276a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f11277b;

    static {
        int[] iArr = new int[Mode.values().length];
        f11277b = iArr;
        try {
            iArr[Mode.KANJI.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f11277b[Mode.ALPHANUMERIC.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f11277b[Mode.NUMERIC.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f11277b[Mode.BYTE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f11277b[Mode.ECI.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        int[] iArr2 = new int[MinimalEncoder$VersionSize.values().length];
        f11276a = iArr2;
        try {
            iArr2[MinimalEncoder$VersionSize.SMALL.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f11276a[MinimalEncoder$VersionSize.MEDIUM.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f11276a[MinimalEncoder$VersionSize.LARGE.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
    }
}
