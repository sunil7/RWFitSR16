package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class s0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f9827a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f9828b;

    static {
        Charset.forName("US-ASCII");
        f9827a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f9828b = bArr;
        ByteBuffer.wrap(bArr);
    }
}
