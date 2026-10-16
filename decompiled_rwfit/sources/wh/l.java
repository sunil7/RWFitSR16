package wh;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

/* loaded from: classes2.dex */
public interface l extends c0, ReadableByteChannel {
    String B();

    byte[] C();

    boolean D();

    long K();

    int L(u uVar);

    String M(long j4);

    void P(long j4);

    boolean S(long j4, ByteString byteString);

    long T();

    String U(Charset charset);

    InputStream V();

    void a(long j4);

    long d(j jVar);

    j m();

    x peek();

    j q();

    ByteString r();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    boolean request(long j4);

    ByteString s(long j4);

    void t(j jVar, long j4);
}
