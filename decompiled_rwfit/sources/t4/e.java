package t4;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class e extends InputStream implements AutoCloseable {

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayDeque f18509c;

    /* renamed from: a, reason: collision with root package name */
    public com.bumptech.glide.load.resource.bitmap.a f18510a;

    /* renamed from: b, reason: collision with root package name */
    public IOException f18511b;

    static {
        char[] cArr = l.f18523a;
        f18509c = new ArrayDeque(0);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f18510a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f18510a.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i3) {
        this.f18510a.mark(i3);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        this.f18510a.getClass();
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        try {
            return this.f18510a.read();
        } catch (IOException e) {
            this.f18511b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.f18510a.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j4) {
        try {
            return this.f18510a.skip(j4);
        } catch (IOException e) {
            this.f18511b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        try {
            return this.f18510a.read(bArr);
        } catch (IOException e) {
            this.f18511b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i10) {
        try {
            return this.f18510a.read(bArr, i3, i10);
        } catch (IOException e) {
            this.f18511b = e;
            throw e;
        }
    }
}
