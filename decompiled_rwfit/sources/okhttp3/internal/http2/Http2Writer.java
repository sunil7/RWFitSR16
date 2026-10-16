package okhttp3.internal.http2;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import wh.j;
import wh.k;

/* loaded from: classes2.dex */
public final class Http2Writer implements Closeable, AutoCloseable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final j hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final k sink;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public Http2Writer(k sink, boolean z5) {
        e.f(sink, "sink");
        this.sink = sink;
        this.client = z5;
        j jVar = new j();
        this.hpackBuffer = jVar;
        this.maxFrameSize = Http2.INITIAL_MAX_FRAME_SIZE;
        this.hpackWriter = new Hpack.Writer(0, false, jVar, 3, null);
    }

    private final void writeContinuationFrames(int i3, long j4) throws IOException {
        while (j4 > 0) {
            long min = Math.min(this.maxFrameSize, j4);
            j4 -= min;
            frameHeader(i3, (int) min, 9, j4 == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, min);
        }
    }

    public final synchronized void applyAndAckSettings(Settings peerSettings) throws IOException {
        try {
            e.f(peerSettings, "peerSettings");
            if (this.closed) {
                throw new IOException("closed");
            }
            this.maxFrameSize = peerSettings.getMaxFrameSize(this.maxFrameSize);
            if (peerSettings.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(peerSettings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() throws IOException {
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                }
                this.sink.H(Http2.CONNECTION_PREFACE);
                this.sink.flush();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void data(boolean z5, int i3, j jVar, int i10) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        dataFrame(i3, z5 ? 1 : 0, jVar, i10);
    }

    public final void dataFrame(int i3, int i10, j jVar, int i11) throws IOException {
        frameHeader(i3, i11, 0, i10);
        if (i11 > 0) {
            k kVar = this.sink;
            e.c(jVar);
            kVar.write(jVar, i11);
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final void frameHeader(int i3, int i10, int i11, int i12) throws IOException {
        int i13;
        int i14;
        int i15;
        int i16;
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            i13 = i3;
            i14 = i10;
            i15 = i11;
            i16 = i12;
            logger2.fine(Http2.INSTANCE.frameLog(false, i13, i14, i15, i16));
        } else {
            i13 = i3;
            i14 = i10;
            i15 = i11;
            i16 = i12;
        }
        if (i14 > this.maxFrameSize) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i14).toString());
        }
        if ((((int) 2147483648L) & i13) != 0) {
            throw new IllegalArgumentException(l0.j(i13, "reserved bit set: ").toString());
        }
        Util.writeMedium(this.sink, i14);
        this.sink.E(i15 & 255);
        this.sink.E(i16 & 255);
        this.sink.z(Integer.MAX_VALUE & i13);
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i3, ErrorCode errorCode, byte[] debugData) throws IOException {
        e.f(errorCode, "errorCode");
        e.f(debugData, "debugData");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (errorCode.getHttpCode() == -1) {
            throw new IllegalArgumentException("errorCode.httpCode == -1");
        }
        frameHeader(0, debugData.length + 8, 7, 0);
        this.sink.z(i3);
        this.sink.z(errorCode.getHttpCode());
        if (debugData.length != 0) {
            this.sink.G(debugData);
        }
        this.sink.flush();
    }

    public final synchronized void headers(boolean z5, int i3, List<Header> headerBlock) throws IOException {
        e.f(headerBlock, "headerBlock");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(headerBlock);
        long j4 = this.hpackBuffer.f19654b;
        long min = Math.min(this.maxFrameSize, j4);
        int i10 = j4 == min ? 4 : 0;
        if (z5) {
            i10 |= 1;
        }
        frameHeader(i3, (int) min, 1, i10);
        this.sink.write(this.hpackBuffer, min);
        if (j4 > min) {
            writeContinuationFrames(i3, j4 - min);
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z5, int i3, int i10) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, 6, z5 ? 1 : 0);
        this.sink.z(i3);
        this.sink.z(i10);
        this.sink.flush();
    }

    public final synchronized void pushPromise(int i3, int i10, List<Header> requestHeaders) throws IOException {
        e.f(requestHeaders, "requestHeaders");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(requestHeaders);
        long j4 = this.hpackBuffer.f19654b;
        int min = (int) Math.min(this.maxFrameSize - 4, j4);
        long j10 = min;
        frameHeader(i3, min + 4, 5, j4 == j10 ? 4 : 0);
        this.sink.z(i10 & SubsamplingScaleImageView.TILE_SIZE_AUTO);
        this.sink.write(this.hpackBuffer, j10);
        if (j4 > j10) {
            writeContinuationFrames(i3, j4 - j10);
        }
    }

    public final synchronized void rstStream(int i3, ErrorCode errorCode) throws IOException {
        e.f(errorCode, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (errorCode.getHttpCode() == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        frameHeader(i3, 4, 3, 0);
        this.sink.z(errorCode.getHttpCode());
        this.sink.flush();
    }

    public final synchronized void settings(Settings settings) throws IOException {
        try {
            e.f(settings, "settings");
            if (this.closed) {
                throw new IOException("closed");
            }
            int i3 = 0;
            frameHeader(0, settings.size() * 6, 4, 0);
            while (i3 < 10) {
                if (settings.isSet(i3)) {
                    this.sink.x(i3 != 4 ? i3 != 7 ? i3 : 4 : 3);
                    this.sink.z(settings.get(i3));
                }
                i3++;
            }
            this.sink.flush();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void windowUpdate(int i3, long j4) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j4 == 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j4).toString());
        }
        frameHeader(i3, 4, 8, 0);
        this.sink.z((int) j4);
        this.sink.flush();
    }
}
