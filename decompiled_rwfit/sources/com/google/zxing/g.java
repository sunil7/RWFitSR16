package com.google.zxing;

import java.util.EnumMap;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f11243a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f11244b;

    /* renamed from: c, reason: collision with root package name */
    public h[] f11245c;

    /* renamed from: d, reason: collision with root package name */
    public final BarcodeFormat f11246d;
    public EnumMap e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(String str, byte[] bArr, h[] hVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, hVarArr, barcodeFormat, 0);
        System.currentTimeMillis();
    }

    public final void a(EnumMap enumMap) {
        if (enumMap != null) {
            EnumMap enumMap2 = this.e;
            if (enumMap2 == null) {
                this.e = enumMap;
            } else {
                enumMap2.putAll(enumMap);
            }
        }
    }

    public final void b(ResultMetadataType resultMetadataType, Object obj) {
        if (this.e == null) {
            this.e = new EnumMap(ResultMetadataType.class);
        }
        this.e.put((EnumMap) resultMetadataType, (ResultMetadataType) obj);
    }

    public final String toString() {
        return this.f11243a;
    }

    public g(String str, byte[] bArr, h[] hVarArr, BarcodeFormat barcodeFormat, int i3) {
        this.f11243a = str;
        this.f11244b = bArr;
        this.f11245c = hVarArr;
        this.f11246d = barcodeFormat;
        this.e = null;
    }
}
