package wh;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class o implements a0 {
    private final a0 delegate;

    public o(a0 delegate) {
        kotlin.jvm.internal.e.f(delegate, "delegate");
        this.delegate = delegate;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final a0 m224deprecated_delegate() {
        return this.delegate;
    }

    @Override // wh.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final a0 delegate() {
        return this.delegate;
    }

    @Override // wh.a0, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // wh.a0
    public f0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // wh.a0
    public void write(j source, long j4) throws IOException {
        kotlin.jvm.internal.e.f(source, "source");
        this.delegate.write(source, j4);
    }
}
