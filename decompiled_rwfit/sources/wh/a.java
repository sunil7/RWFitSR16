package wh;

import okio.ByteString;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f19635a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f19636b;

    static {
        ByteString.Companion.getClass();
        f19635a = m.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        f19636b = m.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final String a(byte[] encodeBase64, byte[] map) {
        kotlin.jvm.internal.e.f(encodeBase64, "$this$encodeBase64");
        kotlin.jvm.internal.e.f(map, "map");
        byte[] bArr = new byte[((encodeBase64.length + 2) / 3) * 4];
        int length = encodeBase64.length - (encodeBase64.length % 3);
        int i3 = 0;
        int i10 = 0;
        while (i3 < length) {
            byte b3 = encodeBase64[i3];
            int i11 = i3 + 2;
            byte b10 = encodeBase64[i3 + 1];
            i3 += 3;
            byte b11 = encodeBase64[i11];
            bArr[i10] = map[(b3 & 255) >> 2];
            bArr[i10 + 1] = map[((b3 & 3) << 4) | ((b10 & 255) >> 4)];
            int i12 = i10 + 3;
            bArr[i10 + 2] = map[((b10 & 15) << 2) | ((b11 & 255) >> 6)];
            i10 += 4;
            bArr[i12] = map[b11 & 63];
        }
        int length2 = encodeBase64.length - length;
        if (length2 == 1) {
            byte b12 = encodeBase64[i3];
            bArr[i10] = map[(b12 & 255) >> 2];
            bArr[i10 + 1] = map[(b12 & 3) << 4];
            byte b13 = (byte) 61;
            bArr[i10 + 2] = b13;
            bArr[i10 + 3] = b13;
        } else if (length2 == 2) {
            int i13 = i3 + 1;
            byte b14 = encodeBase64[i3];
            byte b15 = encodeBase64[i13];
            bArr[i10] = map[(b14 & 255) >> 2];
            bArr[i10 + 1] = map[((b14 & 3) << 4) | ((b15 & 255) >> 4)];
            bArr[i10 + 2] = map[(b15 & 15) << 2];
            bArr[i10 + 3] = (byte) 61;
        }
        return new String(bArr, kotlin.text.a.f15656a);
    }
}
