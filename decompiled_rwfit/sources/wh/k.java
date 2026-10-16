package wh;

import java.nio.channels.WritableByteChannel;
import okio.ByteString;

/* loaded from: classes2.dex */
public interface k extends a0, WritableByteChannel {
    k E(int i3);

    k G(byte[] bArr);

    k H(ByteString byteString);

    k J();

    k N(int i3, int i10, byte[] bArr);

    k Q(String str);

    k R(long j4);

    @Override // wh.a0, java.io.Flushable
    void flush();

    j m();

    k p(long j4);

    long v(c0 c0Var);

    k w();

    k x(int i3);

    k z(int i3);
}
