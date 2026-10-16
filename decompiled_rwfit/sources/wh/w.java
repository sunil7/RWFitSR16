package wh;

import java.nio.ByteBuffer;
import okio.ByteString;

/* loaded from: classes2.dex */
public final class w implements k {

    /* renamed from: a, reason: collision with root package name */
    public final j f19675a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f19676b;

    /* renamed from: c, reason: collision with root package name */
    public final a0 f19677c;

    public w(a0 sink) {
        kotlin.jvm.internal.e.f(sink, "sink");
        this.f19677c = sink;
        this.f19675a = new j();
    }

    @Override // wh.k
    public final k E(int i3) {
        if (this.f19676b) {
            throw new IllegalStateException("closed");
        }
        this.f19675a.Z(i3);
        J();
        return this;
    }

    @Override // wh.k
    public final k G(byte[] source) {
        kotlin.jvm.internal.e.f(source, "source");
        if (this.f19676b) {
            throw new IllegalStateException("closed");
        }
        this.f19675a.X(source);
        J();
        return this;
    }

    @Override // wh.k
    public final k H(ByteString byteString) {
        kotlin.jvm.internal.e.f(byteString, "byteString");
        if (this.f19676b) {
            throw new IllegalStateException("closed");
        }
        this.f19675a.W(byteString);
        J();
        return this;
    }

    @Override // wh.k
    public final k J() {
        if (this.f19676b) {
            throw new IllegalStateException("closed");
        }
        j jVar = this.f19675a;
        long e = jVar.e();
        if (e > 0) {
            this.f19677c.write(jVar, e);
        }
        return this;
    }

    @Override // wh.k
    public final k N(int i3, int i10, byte[] source) {
        kotlin.jvm.internal.e.f(source, "source");
        if (this.f19676b) {
            throw new IllegalStateException("closed");
        }
        this.f19675a.Y(source, i3, i10);
        J();
        return this;
    }

    @Override // wh.k
    public final k Q(String string) {
        kotlin.jvm.internal.e.f(string, "string");
        if (this.f19676b) {
            throw new IllegalStateException("closed");
        }
        this.f19675a.h0(string);
        J();
        return this;
    }

    @Override // wh.k
    public final k R(long j4) {
        if (this.f19676b) {
            throw new IllegalStateException("closed");
        }
        this.f19675a.a0(j4);
        J();
        return this;
    }

    @Override // wh.a0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a0 a0Var = this.f19677c;
        if (this.f19676b) {
            return;
        }
        try {
            j jVar = this.f19675a;
            long j4 = jVar.f19654b;
            if (j4 > 0) {
                a0Var.write(jVar, j4);
            }
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            a0Var.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f19676b = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // wh.k, wh.a0, java.io.Flushable
    public final void flush() {
        if (this.f19676b) {
            throw new IllegalStateException("closed");
        }
        j jVar = this.f19675a;
        long j4 = jVar.f19654b;
        a0 a0Var = this.f19677c;
        if (j4 > 0) {
            a0Var.write(jVar, j4);
        }
        a0Var.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f19676b;
    }

    @Override // wh.k
    public final j m() {
        return this.f19675a;
    }

    @Override // wh.k
    public final k p(long j4) {
        if (this.f19676b) {
            throw new IllegalStateException("closed");
        }
        this.f19675a.b0(j4);
        J();
        return this;
    }

    @Override // wh.a0
    public final f0 timeout() {
        return this.f19677c.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f19677c + ')';
    }

    @Override // wh.k
    public final long v(c0 c0Var) {
        long j4 = 0;
        while (true) {
            long read = ((d) c0Var).read(this.f19675a, 8192);
            if (read == -1) {
                return j4;
            }
            j4 += read;
            J();
        }
    }

    @Override // wh.k
    public final k w() {
        if (this.f19676b) {
            throw new IllegalStateException("closed");
        }
        j jVar = this.f19675a;
        long j4 = jVar.f19654b;
        if (j4 > 0) {
            this.f19677c.write(jVar, j4);
        }
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        kotlin.jvm.internal.e.f(source, "source");
        if (this.f19676b) {
            throw new IllegalStateException("closed");
        }
        int write = this.f19675a.write(source);
        J();
        return write;
    }

    @Override // wh.k
    public final k x(int i3) {
        if (this.f19676b) {
            throw new IllegalStateException("closed");
        }
        this.f19675a.e0(i3);
        J();
        return this;
    }

    @Override // wh.k
    public final k z(int i3) {
        if (this.f19676b) {
            throw new IllegalStateException("closed");
        }
        this.f19675a.c0(i3);
        J();
        return this;
    }

    @Override // wh.a0
    public final void write(j source, long j4) {
        kotlin.jvm.internal.e.f(source, "source");
        if (!this.f19676b) {
            this.f19675a.write(source, j4);
            J();
            return;
        }
        throw new IllegalStateException("closed");
    }
}
