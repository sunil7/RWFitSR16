package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.jvm.internal.e;
import oh.l;
import wh.a0;
import wh.j;
import wh.o;

/* loaded from: classes2.dex */
public class FaultHidingSink extends o {
    private boolean hasErrors;
    private final l onException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaultHidingSink(a0 delegate, l onException) {
        super(delegate);
        e.f(delegate, "delegate");
        e.f(onException, "onException");
        this.onException = onException;
    }

    @Override // wh.o, wh.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    @Override // wh.o, wh.a0, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    public final l getOnException() {
        return this.onException;
    }

    @Override // wh.o, wh.a0
    public void write(j source, long j4) {
        e.f(source, "source");
        if (this.hasErrors) {
            source.a(j4);
            return;
        }
        try {
            super.write(source, j4);
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }
}
