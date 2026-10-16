package wh;

import com.google.android.gms.internal.mlkit_vision_common.d6;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class c implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19638a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f19639b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f19640c;

    public /* synthetic */ c(int i3, Object obj, Object obj2) {
        this.f19638a = i3;
        this.f19639b = obj;
        this.f19640c = obj2;
    }

    @Override // wh.a0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f19638a) {
            case 0:
                e eVar = (e) this.f19639b;
                eVar.enter();
                try {
                    ((a0) this.f19640c).close();
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
                ((OutputStream) this.f19639b).close();
                return;
        }
    }

    @Override // wh.a0, java.io.Flushable
    public final void flush() {
        switch (this.f19638a) {
            case 0:
                e eVar = (e) this.f19639b;
                eVar.enter();
                try {
                    ((a0) this.f19640c).flush();
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
                ((OutputStream) this.f19639b).flush();
                return;
        }
    }

    @Override // wh.a0
    public final f0 timeout() {
        switch (this.f19638a) {
            case 0:
                return (e) this.f19639b;
            default:
                return (f0) this.f19640c;
        }
    }

    public final String toString() {
        switch (this.f19638a) {
            case 0:
                return "AsyncTimeout.sink(" + ((a0) this.f19640c) + ')';
            default:
                return "sink(" + ((OutputStream) this.f19639b) + ')';
        }
    }

    @Override // wh.a0
    public final void write(j source, long j4) {
        switch (this.f19638a) {
            case 0:
                kotlin.jvm.internal.e.f(source, "source");
                d6.b(source.f19654b, 0L, j4);
                long j10 = j4;
                while (true) {
                    long j11 = 0;
                    if (j10 <= 0) {
                        return;
                    }
                    y yVar = source.f19653a;
                    kotlin.jvm.internal.e.c(yVar);
                    while (true) {
                        if (j11 < WXMediaMessage.THUMB_LENGTH_LIMIT) {
                            j11 += yVar.f19683c - yVar.f19682b;
                            if (j11 >= j10) {
                                j11 = j10;
                            } else {
                                yVar = yVar.f19685f;
                                kotlin.jvm.internal.e.c(yVar);
                            }
                        }
                    }
                    e eVar = (e) this.f19639b;
                    eVar.enter();
                    try {
                        try {
                            ((a0) this.f19640c).write(source, j11);
                            if (eVar.exit()) {
                                throw eVar.access$newTimeoutException(null);
                            }
                            j10 -= j11;
                        } catch (IOException e) {
                            if (!eVar.exit()) {
                                throw e;
                            }
                            throw eVar.access$newTimeoutException(e);
                        }
                    } catch (Throwable th2) {
                        eVar.exit();
                        throw th2;
                    }
                }
            default:
                kotlin.jvm.internal.e.f(source, "source");
                d6.b(source.f19654b, 0L, j4);
                while (j4 > 0) {
                    ((f0) this.f19640c).throwIfReached();
                    y yVar2 = source.f19653a;
                    kotlin.jvm.internal.e.c(yVar2);
                    int min = (int) Math.min(j4, yVar2.f19683c - yVar2.f19682b);
                    ((OutputStream) this.f19639b).write(yVar2.f19681a, yVar2.f19682b, min);
                    int i3 = yVar2.f19682b + min;
                    yVar2.f19682b = i3;
                    long j12 = min;
                    j4 -= j12;
                    source.f19654b -= j12;
                    if (i3 == yVar2.f19683c) {
                        source.f19653a = yVar2.a();
                        z.a(yVar2);
                    }
                }
                return;
        }
    }
}
