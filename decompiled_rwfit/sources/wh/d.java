package wh;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.e6;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class d implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19641a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f19642b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f19643c;

    public /* synthetic */ d(int i3, Object obj, Object obj2) {
        this.f19641a = i3;
        this.f19642b = obj;
        this.f19643c = obj2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f19641a) {
            case 0:
                e eVar = (e) this.f19642b;
                eVar.enter();
                try {
                    ((c0) this.f19643c).close();
                    if (eVar.exit()) {
                        throw eVar.access$newTimeoutException(null);
                    }
                    return;
                } catch (IOException e) {
                    if (!eVar.exit()) {
                        throw e;
                    }
                    throw eVar.access$newTimeoutException(e);
                } finally {
                    eVar.exit();
                }
            default:
                ((InputStream) this.f19642b).close();
                return;
        }
    }

    @Override // wh.c0
    public final long read(j sink, long j4) {
        switch (this.f19641a) {
            case 0:
                kotlin.jvm.internal.e.f(sink, "sink");
                e eVar = (e) this.f19642b;
                eVar.enter();
                try {
                    long read = ((c0) this.f19643c).read(sink, j4);
                    if (eVar.exit()) {
                        throw eVar.access$newTimeoutException(null);
                    }
                    return read;
                } catch (IOException e) {
                    if (eVar.exit()) {
                        throw eVar.access$newTimeoutException(e);
                    }
                    throw e;
                } finally {
                    eVar.exit();
                }
            default:
                kotlin.jvm.internal.e.f(sink, "sink");
                if (j4 == 0) {
                    return 0L;
                }
                if (!(j4 >= 0)) {
                    throw new IllegalArgumentException(l0.l(j4, "byteCount < 0: ").toString());
                }
                try {
                    ((f0) this.f19643c).throwIfReached();
                    y O = sink.O(1);
                    int read2 = ((InputStream) this.f19642b).read(O.f19681a, O.f19683c, (int) Math.min(j4, 8192 - O.f19683c));
                    if (read2 == -1) {
                        if (O.f19682b == O.f19683c) {
                            sink.f19653a = O.a();
                            z.a(O);
                        }
                        return -1L;
                    }
                    O.f19683c += read2;
                    long j10 = read2;
                    sink.f19654b += j10;
                    return j10;
                } catch (AssertionError e10) {
                    if (e6.c(e10)) {
                        throw new IOException(e10);
                    }
                    throw e10;
                }
        }
    }

    @Override // wh.c0
    public final f0 timeout() {
        switch (this.f19641a) {
            case 0:
                return (e) this.f19642b;
            default:
                return (f0) this.f19643c;
        }
    }

    public final String toString() {
        switch (this.f19641a) {
            case 0:
                return "AsyncTimeout.source(" + ((c0) this.f19643c) + ')';
            default:
                return "source(" + ((InputStream) this.f19642b) + ')';
        }
    }
}
