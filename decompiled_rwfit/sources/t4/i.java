package t4;

import java.io.FilterInputStream;

/* loaded from: classes.dex */
public final class i extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public int f18518a;

    public i(e eVar) {
        super(eVar);
        this.f18518a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        int i3 = this.f18518a;
        return i3 == Integer.MIN_VALUE ? super.available() : Math.min(i3, super.available());
    }

    public final long b(long j4) {
        int i3 = this.f18518a;
        if (i3 == 0) {
            return -1L;
        }
        return (i3 == Integer.MIN_VALUE || j4 <= ((long) i3)) ? j4 : i3;
    }

    public final void c(long j4) {
        int i3 = this.f18518a;
        if (i3 == Integer.MIN_VALUE || j4 == -1) {
            return;
        }
        this.f18518a = (int) (i3 - j4);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i3) {
        super.mark(i3);
        this.f18518a = i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        if (b(1L) == -1) {
            return -1;
        }
        int read = super.read();
        c(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        super.reset();
        this.f18518a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j4) {
        long b3 = b(j4);
        if (b3 == -1) {
            return 0L;
        }
        long skip = super.skip(b3);
        c(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i3, int i10) {
        int b3 = (int) b(i10);
        if (b3 == -1) {
            return -1;
        }
        int read = super.read(bArr, i3, b3);
        c(read);
        return read;
    }
}
