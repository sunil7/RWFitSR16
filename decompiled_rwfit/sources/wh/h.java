package wh;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_common.d6;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class h extends InputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19650a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f19651b;

    public /* synthetic */ h(l lVar, int i3) {
        this.f19650a = i3;
        this.f19651b = lVar;
    }

    private final void b() {
    }

    @Override // java.io.InputStream
    public final int available() {
        switch (this.f19650a) {
            case 0:
                return (int) Math.min(((j) this.f19651b).f19654b, SubsamplingScaleImageView.TILE_SIZE_AUTO);
            default:
                x xVar = (x) this.f19651b;
                if (xVar.f19679b) {
                    throw new IOException("closed");
                }
                return (int) Math.min(xVar.f19678a.f19654b, SubsamplingScaleImageView.TILE_SIZE_AUTO);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f19650a) {
            case 0:
                break;
            default:
                ((x) this.f19651b).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        switch (this.f19650a) {
            case 0:
                j jVar = (j) this.f19651b;
                if (jVar.f19654b > 0) {
                    return jVar.readByte() & 255;
                }
                return -1;
            default:
                x xVar = (x) this.f19651b;
                if (xVar.f19679b) {
                    throw new IOException("closed");
                }
                j jVar2 = xVar.f19678a;
                if (jVar2.f19654b == 0) {
                    if (xVar.f19680c.read(jVar2, 8192) == -1) {
                        return -1;
                    }
                }
                return jVar2.readByte() & 255;
        }
    }

    public final String toString() {
        switch (this.f19650a) {
            case 0:
                return ((j) this.f19651b) + ".inputStream()";
            default:
                return ((x) this.f19651b) + ".inputStream()";
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] sink, int i3, int i10) {
        switch (this.f19650a) {
            case 0:
                kotlin.jvm.internal.e.f(sink, "sink");
                return ((j) this.f19651b).j(sink, i3, i10);
            default:
                kotlin.jvm.internal.e.f(sink, "data");
                x xVar = (x) this.f19651b;
                if (!xVar.f19679b) {
                    d6.b(sink.length, i3, i10);
                    j jVar = xVar.f19678a;
                    if (jVar.f19654b == 0) {
                        if (xVar.f19680c.read(jVar, 8192) == -1) {
                            return -1;
                        }
                    }
                    return jVar.j(sink, i3, i10);
                }
                throw new IOException("closed");
        }
    }
}
