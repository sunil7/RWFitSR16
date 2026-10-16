package wh;

/* loaded from: classes2.dex */
public final class f implements a0 {
    @Override // wh.a0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // wh.a0, java.io.Flushable
    public final void flush() {
    }

    @Override // wh.a0
    public final f0 timeout() {
        return f0.NONE;
    }

    @Override // wh.a0
    public final void write(j source, long j4) {
        kotlin.jvm.internal.e.f(source, "source");
        source.a(j4);
    }
}
