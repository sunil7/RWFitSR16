package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.EncodeStrategy;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6983a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f6984b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f6985c;

    static {
        int[] iArr = new int[EncodeStrategy.values().length];
        f6985c = iArr;
        try {
            iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f6985c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[DecodeJob$Stage.values().length];
        f6984b = iArr2;
        try {
            iArr2[DecodeJob$Stage.RESOURCE_CACHE.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f6984b[DecodeJob$Stage.DATA_CACHE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f6984b[DecodeJob$Stage.SOURCE.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f6984b[DecodeJob$Stage.FINISHED.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f6984b[DecodeJob$Stage.INITIALIZE.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        int[] iArr3 = new int[DecodeJob$RunReason.values().length];
        f6983a = iArr3;
        try {
            iArr3[DecodeJob$RunReason.INITIALIZE.ordinal()] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f6983a[DecodeJob$RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f6983a[DecodeJob$RunReason.DECODE_DATA.ordinal()] = 3;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
