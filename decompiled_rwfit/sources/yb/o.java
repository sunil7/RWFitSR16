package yb;

import com.google.gson.stream.JsonToken;

/* loaded from: classes.dex */
public abstract /* synthetic */ class o {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f20085a;

    static {
        int[] iArr = new int[JsonToken.values().length];
        f20085a = iArr;
        try {
            iArr[JsonToken.NUMBER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20085a[JsonToken.BOOLEAN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f20085a[JsonToken.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f20085a[JsonToken.NULL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f20085a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f20085a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f20085a[JsonToken.END_DOCUMENT.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f20085a[JsonToken.NAME.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f20085a[JsonToken.END_OBJECT.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f20085a[JsonToken.END_ARRAY.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
