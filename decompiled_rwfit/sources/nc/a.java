package nc;

import java.nio.ByteBuffer;
import q9.n;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public volatile ByteBuffer f16459a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16460b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16461c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16462d;
    public final int e;

    public a(ByteBuffer byteBuffer, int i3, int i10, int i11) {
        n.e(byteBuffer);
        this.f16459a = byteBuffer;
        n.a("Image dimension, ByteBuffer size and format don't match. Please check if the ByteBuffer is in the decalred format.", byteBuffer.limit() > i3 * i10);
        byteBuffer.rewind();
        this.f16460b = i3;
        this.f16461c = i10;
        n.a("Invalid rotation. Only 0, 90, 180, 270 are supported currently.", i11 == 0 || i11 == 90 || i11 == 180 || i11 == 270);
        this.f16462d = i11;
        this.e = 17;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static nc.a a(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.a.a(int, byte[], int, int):nc.a");
    }
}
