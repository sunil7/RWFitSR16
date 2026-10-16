package wh;

import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class i extends OutputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f19652a;

    public i(j jVar) {
        this.f19652a = jVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
    }

    public final String toString() {
        return this.f19652a + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i3) {
        this.f19652a.Z(i3);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] data, int i3, int i10) {
        kotlin.jvm.internal.e.f(data, "data");
        this.f19652a.Y(data, i3, i10);
    }
}
