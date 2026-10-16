package okhttp3.internal.http2;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.ByteString;
import th.a;
import wh.c0;
import wh.f0;
import wh.j;
import wh.l;

/* loaded from: classes2.dex */
public final class Http2Reader implements Closeable, AutoCloseable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final l source;

    public static final class Companion {
        private Companion() {
        }

        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int i3, int i10, int i11) throws IOException {
            if ((i10 & 8) != 0) {
                i3--;
            }
            if (i11 <= i3) {
                return i3 - i11;
            }
            throw new IOException(l0.i(i11, i3, "PROTOCOL_ERROR padding ", " > remaining length "));
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public static final class ContinuationSource implements c0 {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final l source;
        private int streamId;

        public ContinuationSource(l source) {
            e.f(source, "source");
            this.source = source;
        }

        private final void readContinuationHeader() throws IOException {
            int i3 = this.streamId;
            int readMedium = Util.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            int and = Util.and(this.source.readByte(), 255);
            this.flags = Util.and(this.source.readByte(), 255);
            Companion companion = Http2Reader.Companion;
            if (companion.getLogger().isLoggable(Level.FINE)) {
                companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, and, this.flags));
            }
            int readInt = this.source.readInt() & SubsamplingScaleImageView.TILE_SIZE_AUTO;
            this.streamId = readInt;
            if (and == 9) {
                if (readInt != i3) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(and + " != TYPE_CONTINUATION");
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // wh.c0
        public long read(j sink, long j4) throws IOException {
            e.f(sink, "sink");
            while (true) {
                int i3 = this.left;
                if (i3 != 0) {
                    long read = this.source.read(sink, Math.min(j4, i3));
                    if (read == -1) {
                        return -1L;
                    }
                    this.left -= (int) read;
                    return read;
                }
                this.source.a(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        public final void setFlags(int i3) {
            this.flags = i3;
        }

        public final void setLeft(int i3) {
            this.left = i3;
        }

        public final void setLength(int i3) {
            this.length = i3;
        }

        public final void setPadding(int i3) {
            this.padding = i3;
        }

        public final void setStreamId(int i3) {
            this.streamId = i3;
        }

        @Override // wh.c0
        public f0 timeout() {
            return this.source.timeout();
        }
    }

    public interface Handler {
        void ackSettings();

        void alternateService(int i3, String str, ByteString byteString, String str2, int i10, long j4);

        void data(boolean z5, int i3, l lVar, int i10) throws IOException;

        void goAway(int i3, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z5, int i3, int i10, List<Header> list);

        void ping(boolean z5, int i3, int i10);

        void priority(int i3, int i10, int i11, boolean z5);

        void pushPromise(int i3, int i10, List<Header> list) throws IOException;

        void rstStream(int i3, ErrorCode errorCode);

        void settings(boolean z5, Settings settings);

        void windowUpdate(int i3, long j4);
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        e.e(logger2, "Logger.getLogger(Http2::class.java.name)");
        logger = logger2;
    }

    public Http2Reader(l source, boolean z5) {
        e.f(source, "source");
        this.source = source;
        this.client = z5;
        ContinuationSource continuationSource = new ContinuationSource(source);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, 4096, 0, 4, null);
    }

    private final void readData(Handler handler, int i3, int i10, int i11) throws IOException {
        if (i11 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z5 = (i10 & 1) != 0;
        if ((i10 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int and = (i10 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        handler.data(z5, i11, this.source, Companion.lengthWithoutPadding(i3, i10, and));
        this.source.a(and);
    }

    private final void readGoAway(Handler handler, int i3, int i10, int i11) throws IOException {
        if (i3 < 8) {
            throw new IOException(l0.j(i3, "TYPE_GOAWAY length < 8: "));
        }
        if (i11 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int readInt = this.source.readInt();
        int readInt2 = this.source.readInt();
        int i12 = i3 - 8;
        ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt2);
        if (fromHttp2 == null) {
            throw new IOException(l0.j(readInt2, "TYPE_GOAWAY unexpected error code: "));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i12 > 0) {
            byteString = this.source.s(i12);
        }
        handler.goAway(readInt, fromHttp2, byteString);
    }

    private final List<Header> readHeaderBlock(int i3, int i10, int i11, int i12) throws IOException {
        this.continuation.setLeft(i3);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(i10);
        this.continuation.setFlags(i11);
        this.continuation.setStreamId(i12);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int i3, int i10, int i11) throws IOException {
        if (i11 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z5 = (i10 & 1) != 0;
        int and = (i10 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        if ((i10 & 32) != 0) {
            readPriority(handler, i11);
            i3 -= 5;
        }
        handler.headers(z5, i11, -1, readHeaderBlock(Companion.lengthWithoutPadding(i3, i10, and), and, i10, i11));
    }

    private final void readPing(Handler handler, int i3, int i10, int i11) throws IOException {
        if (i3 != 8) {
            throw new IOException(l0.j(i3, "TYPE_PING length != 8: "));
        }
        if (i11 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        handler.ping((i10 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private final void readPriority(Handler handler, int i3, int i10, int i11) throws IOException {
        if (i3 != 5) {
            throw new IOException(l0.k(i3, "TYPE_PRIORITY length: ", " != 5"));
        }
        if (i11 == 0) {
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
        readPriority(handler, i11);
    }

    private final void readPushPromise(Handler handler, int i3, int i10, int i11) throws IOException {
        if (i11 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int and = (i10 & 8) != 0 ? Util.and(this.source.readByte(), 255) : 0;
        handler.pushPromise(i11, this.source.readInt() & SubsamplingScaleImageView.TILE_SIZE_AUTO, readHeaderBlock(Companion.lengthWithoutPadding(i3 - 4, i10, and), and, i10, i11));
    }

    private final void readRstStream(Handler handler, int i3, int i10, int i11) throws IOException {
        if (i3 != 4) {
            throw new IOException(l0.k(i3, "TYPE_RST_STREAM length: ", " != 4"));
        }
        if (i11 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int readInt = this.source.readInt();
        ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt);
        if (fromHttp2 == null) {
            throw new IOException(l0.j(readInt, "TYPE_RST_STREAM unexpected error code: "));
        }
        handler.rstStream(i11, fromHttp2);
    }

    private final void readSettings(Handler handler, int i3, int i10, int i11) throws IOException {
        int readInt;
        if (i11 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i10 & 1) != 0) {
            if (i3 != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            handler.ackSettings();
            return;
        }
        if (i3 % 6 != 0) {
            throw new IOException(l0.j(i3, "TYPE_SETTINGS length % 6 != 0: "));
        }
        Settings settings = new Settings();
        a a3 = com.google.android.gms.internal.mlkit_vision_common.f0.a(com.google.android.gms.internal.mlkit_vision_common.f0.b(0, i3), 6);
        int i12 = a3.f18633a;
        int i13 = a3.f18634b;
        int i14 = a3.f18635c;
        if (i14 < 0 ? i12 >= i13 : i12 <= i13) {
            while (true) {
                int and = Util.and(this.source.readShort(), Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                readInt = this.source.readInt();
                if (and != 2) {
                    if (and == 3) {
                        and = 4;
                    } else if (and != 4) {
                        if (and == 5 && (readInt < 16384 || readInt > 16777215)) {
                            break;
                        }
                    } else {
                        if (readInt < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        and = 7;
                    }
                } else if (readInt != 0 && readInt != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                settings.set(and, readInt);
                if (i12 == i13) {
                    break;
                } else {
                    i12 += i14;
                }
            }
            throw new IOException(l0.j(readInt, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
        }
        handler.settings(false, settings);
    }

    private final void readWindowUpdate(Handler handler, int i3, int i10, int i11) throws IOException {
        if (i3 != 4) {
            throw new IOException(l0.j(i3, "TYPE_WINDOW_UPDATE length !=4: "));
        }
        long and = Util.and(this.source.readInt(), 2147483647L);
        if (and == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        handler.windowUpdate(i11, and);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean z5, Handler handler) throws IOException {
        e.f(handler, "handler");
        try {
            this.source.P(9L);
            int readMedium = Util.readMedium(this.source);
            if (readMedium > 16384) {
                throw new IOException(l0.j(readMedium, "FRAME_SIZE_ERROR: "));
            }
            int and = Util.and(this.source.readByte(), 255);
            int and2 = Util.and(this.source.readByte(), 255);
            int readInt = this.source.readInt() & SubsamplingScaleImageView.TILE_SIZE_AUTO;
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Http2.INSTANCE.frameLog(true, readInt, readMedium, and, and2));
            }
            if (z5 && and != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + Http2.INSTANCE.formattedType$okhttp(and));
            }
            switch (and) {
                case 0:
                    readData(handler, readMedium, and2, readInt);
                    return true;
                case 1:
                    readHeaders(handler, readMedium, and2, readInt);
                    return true;
                case 2:
                    readPriority(handler, readMedium, and2, readInt);
                    return true;
                case 3:
                    readRstStream(handler, readMedium, and2, readInt);
                    return true;
                case 4:
                    readSettings(handler, readMedium, and2, readInt);
                    return true;
                case 5:
                    readPushPromise(handler, readMedium, and2, readInt);
                    return true;
                case 6:
                    readPing(handler, readMedium, and2, readInt);
                    return true;
                case 7:
                    readGoAway(handler, readMedium, and2, readInt);
                    return true;
                case 8:
                    readWindowUpdate(handler, readMedium, and2, readInt);
                    return true;
                default:
                    this.source.a(readMedium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(Handler handler) throws IOException {
        e.f(handler, "handler");
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        l lVar = this.source;
        ByteString byteString = Http2.CONNECTION_PREFACE;
        ByteString s7 = lVar.s(byteString.size());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Util.format("<< CONNECTION " + s7.hex(), new Object[0]));
        }
        if (e.a(byteString, s7)) {
            return;
        }
        throw new IOException("Expected a connection header but was " + s7.utf8());
    }

    private final void readPriority(Handler handler, int i3) throws IOException {
        int readInt = this.source.readInt();
        handler.priority(i3, readInt & SubsamplingScaleImageView.TILE_SIZE_AUTO, Util.and(this.source.readByte(), 255) + 1, (((int) 2147483648L) & readInt) != 0);
    }
}
