package okhttp3.internal.ws;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_common.e6;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.e;
import okhttp3.internal.http2.Settings;
import wh.j;
import wh.s;

/* loaded from: classes2.dex */
public final class MessageInflater implements Closeable, AutoCloseable {
    private final j deflatedBytes;
    private final Inflater inflater;
    private final s inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean z5) {
        this.noContextTakeover = z5;
        j jVar = new j();
        this.deflatedBytes = jVar;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new s(e6.b(jVar), inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public final void inflate(j buffer) throws IOException {
        e.f(buffer, "buffer");
        if (this.deflatedBytes.f19654b != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.noContextTakeover) {
            this.inflater.reset();
        }
        this.deflatedBytes.v(buffer);
        this.deflatedBytes.c0(Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        long bytesRead = this.inflater.getBytesRead() + this.deflatedBytes.f19654b;
        do {
            this.inflaterSource.b(buffer, Format.OFFSET_SAMPLE_RELATIVE);
        } while (this.inflater.getBytesRead() < bytesRead);
    }
}
