package t4;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class a extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f18503a;

    /* renamed from: b, reason: collision with root package name */
    public int f18504b = -1;

    public a(ByteBuffer byteBuffer) {
        this.f18503a = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f18503a.remaining();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i3) {
        this.f18504b = this.f18503a.position();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        ByteBuffer byteBuffer = this.f18503a;
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        int i3 = this.f18504b;
        if (i3 == -1) {
            throw new IOException("Cannot reset to unset mark position");
        }
        this.f18503a.position(i3);
    }

    @Override // java.io.InputStream
    public final long skip(long j4) {
        ByteBuffer byteBuffer = this.f18503a;
        if (!byteBuffer.hasRemaining()) {
            return -1L;
        }
        long min = Math.min(j4, byteBuffer.remaining());
        byteBuffer.position((int) (byteBuffer.position() + min));
        return min;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i10) {
        ByteBuffer byteBuffer = this.f18503a;
        if (!byteBuffer.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i10, byteBuffer.remaining());
        byteBuffer.get(bArr, i3, min);
        return min;
    }
}
