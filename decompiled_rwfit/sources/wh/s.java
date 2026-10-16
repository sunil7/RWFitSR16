package wh;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes2.dex */
public final class s implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public int f19663a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f19664b;

    /* renamed from: c, reason: collision with root package name */
    public final x f19665c;

    /* renamed from: d, reason: collision with root package name */
    public final Inflater f19666d;

    public s(x xVar, Inflater inflater) {
        this.f19665c = xVar;
        this.f19666d = inflater;
    }

    public final long b(j sink, long j4) {
        Inflater inflater = this.f19666d;
        kotlin.jvm.internal.e.f(sink, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(l0.l(j4, "byteCount < 0: ").toString());
        }
        if (this.f19664b) {
            throw new IllegalStateException("closed");
        }
        if (j4 != 0) {
            try {
                y O = sink.O(1);
                int min = (int) Math.min(j4, 8192 - O.f19683c);
                boolean needsInput = inflater.needsInput();
                x xVar = this.f19665c;
                if (needsInput && !xVar.D()) {
                    y yVar = xVar.f19678a.f19653a;
                    kotlin.jvm.internal.e.c(yVar);
                    int i3 = yVar.f19683c;
                    int i10 = yVar.f19682b;
                    int i11 = i3 - i10;
                    this.f19663a = i11;
                    inflater.setInput(yVar.f19681a, i10, i11);
                }
                int inflate = inflater.inflate(O.f19681a, O.f19683c, min);
                int i12 = this.f19663a;
                if (i12 != 0) {
                    int remaining = i12 - inflater.getRemaining();
                    this.f19663a -= remaining;
                    xVar.a(remaining);
                }
                if (inflate > 0) {
                    O.f19683c += inflate;
                    long j10 = inflate;
                    sink.f19654b += j10;
                    return j10;
                }
                if (O.f19682b == O.f19683c) {
                    sink.f19653a = O.a();
                    z.a(O);
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
        return 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f19664b) {
            return;
        }
        this.f19666d.end();
        this.f19664b = true;
        this.f19665c.close();
    }

    @Override // wh.c0
    public final long read(j sink, long j4) {
        kotlin.jvm.internal.e.f(sink, "sink");
        do {
            long b3 = b(sink, j4);
            if (b3 > 0) {
                return b3;
            }
            Inflater inflater = this.f19666d;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.f19665c.D());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // wh.c0
    public final f0 timeout() {
        return this.f19665c.f19680c.timeout();
    }
}
