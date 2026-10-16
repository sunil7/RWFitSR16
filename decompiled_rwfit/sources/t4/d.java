package t4;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class d extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public final long f18507a;

    /* renamed from: b, reason: collision with root package name */
    public int f18508b;

    public d(InputStream inputStream, long j4) {
        super(inputStream);
        this.f18507a = j4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        return (int) Math.max(this.f18507a - this.f18508b, ((FilterInputStream) this).in.available());
    }

    public final void b(int i3) {
        if (i3 >= 0) {
            this.f18508b += i3;
            return;
        }
        long j4 = this.f18508b;
        long j10 = this.f18507a;
        if (j10 - j4 <= 0) {
            return;
        }
        throw new IOException("Failed to read all expected data, expected: " + j10 + ", but read: " + this.f18508b);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        int read;
        read = super.read();
        b(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i3, int i10) {
        int read;
        read = super.read(bArr, i3, i10);
        b(read);
        return read;
    }
}
