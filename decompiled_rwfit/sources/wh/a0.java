package wh;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes2.dex */
public interface a0 extends Closeable, Flushable, AutoCloseable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    f0 timeout();

    void write(j jVar, long j4);
}
