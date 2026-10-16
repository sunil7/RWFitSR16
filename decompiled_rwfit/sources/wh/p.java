package wh;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class p implements c0 {
    private final c0 delegate;

    public p(c0 delegate) {
        kotlin.jvm.internal.e.f(delegate, "delegate");
        this.delegate = delegate;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final c0 m225deprecated_delegate() {
        return this.delegate;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final c0 delegate() {
        return this.delegate;
    }

    @Override // wh.c0
    public long read(j sink, long j4) throws IOException {
        kotlin.jvm.internal.e.f(sink, "sink");
        return this.delegate.read(sink, j4);
    }

    @Override // wh.c0
    public f0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
