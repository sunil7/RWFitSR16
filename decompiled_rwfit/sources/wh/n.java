package wh;

import com.google.android.gms.internal.mlkit_vision_common.d6;
import com.google.android.gms.internal.mlkit_vision_common.e6;
import java.util.zip.Deflater;

/* loaded from: classes2.dex */
public final class n implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f19655a;

    /* renamed from: b, reason: collision with root package name */
    public final w f19656b;

    /* renamed from: c, reason: collision with root package name */
    public final Deflater f19657c;

    public n(j jVar, Deflater deflater) {
        this.f19656b = e6.a(jVar);
        this.f19657c = deflater;
    }

    public final void b(boolean z5) {
        y O;
        int deflate;
        w wVar = this.f19656b;
        j jVar = wVar.f19675a;
        while (true) {
            O = jVar.O(1);
            Deflater deflater = this.f19657c;
            byte[] bArr = O.f19681a;
            if (z5) {
                int i3 = O.f19683c;
                deflate = deflater.deflate(bArr, i3, 8192 - i3, 2);
            } else {
                int i10 = O.f19683c;
                deflate = deflater.deflate(bArr, i10, 8192 - i10);
            }
            if (deflate > 0) {
                O.f19683c += deflate;
                jVar.f19654b += deflate;
                wVar.J();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (O.f19682b == O.f19683c) {
            jVar.f19653a = O.a();
            z.a(O);
        }
    }

    @Override // wh.a0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Deflater deflater = this.f19657c;
        if (this.f19655a) {
            return;
        }
        try {
            deflater.finish();
            b(false);
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            deflater.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.f19656b.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.f19655a = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // wh.a0, java.io.Flushable
    public final void flush() {
        b(true);
        this.f19656b.flush();
    }

    @Override // wh.a0
    public final f0 timeout() {
        return this.f19656b.f19677c.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f19656b + ')';
    }

    @Override // wh.a0
    public final void write(j source, long j4) {
        kotlin.jvm.internal.e.f(source, "source");
        d6.b(source.f19654b, 0L, j4);
        while (j4 > 0) {
            y yVar = source.f19653a;
            kotlin.jvm.internal.e.c(yVar);
            int min = (int) Math.min(j4, yVar.f19683c - yVar.f19682b);
            this.f19657c.setInput(yVar.f19681a, yVar.f19682b, min);
            b(false);
            long j10 = min;
            source.f19654b -= j10;
            int i3 = yVar.f19682b + min;
            yVar.f19682b = i3;
            if (i3 == yVar.f19683c) {
                source.f19653a = yVar.a();
                z.a(yVar);
            }
            j4 -= j10;
        }
    }
}
