package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.jvm.internal.e;
import okio.ByteString;
import wh.g;
import wh.j;
import wh.n;

/* loaded from: classes2.dex */
public final class MessageDeflater implements Closeable, AutoCloseable {
    private final j deflatedBytes;
    private final Deflater deflater;
    private final n deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z5) {
        this.noContextTakeover = z5;
        j jVar = new j();
        this.deflatedBytes = jVar;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new n(jVar, deflater);
    }

    private final boolean endsWith(j jVar, ByteString byteString) {
        return jVar.S(jVar.f19654b - byteString.size(), byteString);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.deflaterSink.close();
    }

    public final void deflate(j buffer) throws IOException {
        ByteString byteString;
        e.f(buffer, "buffer");
        if (this.deflatedBytes.f19654b != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.noContextTakeover) {
            this.deflater.reset();
        }
        this.deflaterSink.write(buffer, buffer.f19654b);
        this.deflaterSink.flush();
        j jVar = this.deflatedBytes;
        byteString = MessageDeflaterKt.EMPTY_DEFLATE_BLOCK;
        if (endsWith(jVar, byteString)) {
            j jVar2 = this.deflatedBytes;
            long j4 = jVar2.f19654b - 4;
            g gVar = new g();
            jVar2.k(gVar);
            try {
                gVar.b(j4);
                gVar.close();
            } finally {
            }
        } else {
            this.deflatedBytes.Z(0);
        }
        j jVar3 = this.deflatedBytes;
        buffer.write(jVar3, jVar3.f19654b);
    }
}
