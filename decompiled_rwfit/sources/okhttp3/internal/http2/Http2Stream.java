package okhttp3.internal.http2;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.Headers;
import okhttp3.internal.Util;
import wh.a0;
import wh.c0;
import wh.f0;
import wh.j;
import wh.l;

/* loaded from: classes2.dex */
public final class Http2Stream {
    public static final Companion Companion = new Companion(null);
    public static final long EMIT_BUFFER_SIZE = 16384;
    private final Http2Connection connection;
    private ErrorCode errorCode;
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;

    /* renamed from: id, reason: collision with root package name */
    private final int f16951id;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final StreamTimeout readTimeout;
    private final FramingSink sink;
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final StreamTimeout writeTimeout;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public final class FramingSource implements c0 {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private Headers trailers;
        private final j receiveBuffer = new j();
        private final j readBuffer = new j();

        public FramingSource(long j4, boolean z5) {
            this.maxByteCount = j4;
            this.finished = z5;
        }

        private final void updateConnectionFlowControl(long j4) {
            Http2Stream http2Stream = Http2Stream.this;
            if (!Util.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                Http2Stream.this.getConnection().updateConnectionFlowControl$okhttp(j4);
                return;
            }
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(http2Stream);
            throw new AssertionError(sb2.toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long j4;
            synchronized (Http2Stream.this) {
                this.closed = true;
                j jVar = this.readBuffer;
                j4 = jVar.f19654b;
                jVar.b();
                Http2Stream http2Stream = Http2Stream.this;
                if (http2Stream == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                http2Stream.notifyAll();
            }
            if (j4 > 0) {
                updateConnectionFlowControl(j4);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        public final j getReadBuffer() {
            return this.readBuffer;
        }

        public final j getReceiveBuffer() {
            return this.receiveBuffer;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        @Override // wh.c0
        public long read(j sink, long j4) throws IOException {
            IOException iOException;
            boolean z5;
            long j10;
            e.f(sink, "sink");
            long j11 = 0;
            if (!(j4 >= 0)) {
                throw new IllegalArgumentException(l0.l(j4, "byteCount < 0: ").toString());
            }
            while (true) {
                synchronized (Http2Stream.this) {
                    Http2Stream.this.getReadTimeout$okhttp().enter();
                    try {
                        if (Http2Stream.this.getErrorCode$okhttp() != null) {
                            iOException = Http2Stream.this.getErrorException$okhttp();
                            if (iOException == null) {
                                ErrorCode errorCode$okhttp = Http2Stream.this.getErrorCode$okhttp();
                                e.c(errorCode$okhttp);
                                iOException = new StreamResetException(errorCode$okhttp);
                            }
                        } else {
                            iOException = null;
                        }
                        if (this.closed) {
                            throw new IOException("stream closed");
                        }
                        j jVar = this.readBuffer;
                        long j12 = jVar.f19654b;
                        if (j12 > j11) {
                            j10 = jVar.read(sink, Math.min(j4, j12));
                            Http2Stream http2Stream = Http2Stream.this;
                            http2Stream.setReadBytesTotal$okhttp(http2Stream.getReadBytesTotal() + j10);
                            long readBytesTotal = Http2Stream.this.getReadBytesTotal() - Http2Stream.this.getReadBytesAcknowledged();
                            if (iOException == null && readBytesTotal >= Http2Stream.this.getConnection().getOkHttpSettings().getInitialWindowSize() / 2) {
                                Http2Stream.this.getConnection().writeWindowUpdateLater$okhttp(Http2Stream.this.getId(), readBytesTotal);
                                Http2Stream http2Stream2 = Http2Stream.this;
                                http2Stream2.setReadBytesAcknowledged$okhttp(http2Stream2.getReadBytesTotal());
                            }
                            z5 = false;
                        } else {
                            if (this.finished || iOException != null) {
                                z5 = false;
                            } else {
                                Http2Stream.this.waitForIo$okhttp();
                                z5 = true;
                            }
                            j10 = -1;
                        }
                    } finally {
                        Http2Stream.this.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                    }
                }
                if (!z5) {
                    if (j10 != -1) {
                        updateConnectionFlowControl(j10);
                        return j10;
                    }
                    if (iOException == null) {
                        return -1L;
                    }
                    throw iOException;
                }
                j11 = 0;
            }
        }

        public final void receive$okhttp(l source, long j4) throws IOException {
            boolean z5;
            boolean z6;
            long j10;
            e.f(source, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                StringBuilder sb2 = new StringBuilder("Thread ");
                Thread currentThread = Thread.currentThread();
                e.e(currentThread, "Thread.currentThread()");
                sb2.append(currentThread.getName());
                sb2.append(" MUST NOT hold lock on ");
                sb2.append(http2Stream);
                throw new AssertionError(sb2.toString());
            }
            while (j4 > 0) {
                synchronized (Http2Stream.this) {
                    z5 = this.finished;
                    z6 = this.readBuffer.f19654b + j4 > this.maxByteCount;
                }
                if (z6) {
                    source.a(j4);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z5) {
                    source.a(j4);
                    return;
                }
                long read = source.read(this.receiveBuffer, j4);
                if (read == -1) {
                    throw new EOFException();
                }
                j4 -= read;
                synchronized (Http2Stream.this) {
                    try {
                        if (this.closed) {
                            j jVar = this.receiveBuffer;
                            j10 = jVar.f19654b;
                            jVar.b();
                        } else {
                            j jVar2 = this.readBuffer;
                            boolean z8 = jVar2.f19654b == 0;
                            jVar2.v(this.receiveBuffer);
                            if (z8) {
                                Http2Stream http2Stream2 = Http2Stream.this;
                                if (http2Stream2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                }
                                http2Stream2.notifyAll();
                            }
                            j10 = 0;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (j10 > 0) {
                    updateConnectionFlowControl(j10);
                }
            }
        }

        public final void setClosed$okhttp(boolean z5) {
            this.closed = z5;
        }

        public final void setFinished$okhttp(boolean z5) {
            this.finished = z5;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // wh.c0
        public f0 timeout() {
            return Http2Stream.this.getReadTimeout$okhttp();
        }
    }

    public final class StreamTimeout extends wh.e {
        public StreamTimeout() {
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // wh.e
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // wh.e
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.getConnection().sendDegradedPingLater$okhttp();
        }
    }

    public Http2Stream(int i3, Http2Connection connection, boolean z5, boolean z6, Headers headers) {
        e.f(connection, "connection");
        this.f16951id = i3;
        this.connection = connection;
        this.writeBytesMaximum = connection.getPeerSettings().getInitialWindowSize();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(connection.getOkHttpSettings().getInitialWindowSize(), z6);
        this.sink = new FramingSink(z5);
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (headers == null) {
            if (!isLocallyInitiated()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (isLocallyInitiated()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(headers);
        }
    }

    private final boolean closeInternal(ErrorCode errorCode, IOException iOException) {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.getFinished$okhttp() && this.sink.getFinished()) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = iOException;
            notifyAll();
            this.connection.removeStream$okhttp(this.f16951id);
            return true;
        }
    }

    public final void addBytesToWriteWindow(long j4) {
        this.writeBytesMaximum += j4;
        if (j4 > 0) {
            notifyAll();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        boolean z5;
        boolean isOpen;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
        synchronized (this) {
            try {
                if (this.source.getFinished$okhttp() || !this.source.getClosed$okhttp() || (!this.sink.getFinished() && !this.sink.getClosed())) {
                    z5 = false;
                    isOpen = isOpen();
                }
                z5 = true;
                isOpen = isOpen();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z5) {
            close(ErrorCode.CANCEL, null);
        } else {
            if (isOpen) {
                return;
            }
            this.connection.removeStream$okhttp(this.f16951id);
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        if (this.sink.getClosed()) {
            throw new IOException("stream closed");
        }
        if (this.sink.getFinished()) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.errorCode;
            e.c(errorCode);
            throw new StreamResetException(errorCode);
        }
    }

    public final void close(ErrorCode rstStatusCode, IOException iOException) throws IOException {
        e.f(rstStatusCode, "rstStatusCode");
        if (closeInternal(rstStatusCode, iOException)) {
            this.connection.writeSynReset$okhttp(this.f16951id, rstStatusCode);
        }
    }

    public final void closeLater(ErrorCode errorCode) {
        e.f(errorCode, "errorCode");
        if (closeInternal(errorCode, null)) {
            this.connection.writeSynResetLater$okhttp(this.f16951id, errorCode);
        }
    }

    public final void enqueueTrailers(Headers trailers) {
        e.f(trailers, "trailers");
        synchronized (this) {
            if (this.sink.getFinished()) {
                throw new IllegalStateException("already finished");
            }
            if (!(trailers.size() != 0)) {
                throw new IllegalArgumentException("trailers.size() == 0");
            }
            this.sink.setTrailers(trailers);
        }
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final synchronized ErrorCode getErrorCode$okhttp() {
        return this.errorCode;
    }

    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.f16951id;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    public final a0 getSink() {
        synchronized (this) {
            if (!(this.hasResponseHeaders || isLocallyInitiated())) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    public final c0 getSource() {
        return this.source;
    }

    public final FramingSource getSource$okhttp() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        return this.connection.getClient$okhttp() == ((this.f16951id & 1) == 1);
    }

    public final synchronized boolean isOpen() {
        try {
            if (this.errorCode != null) {
                return false;
            }
            if (!this.source.getFinished$okhttp()) {
                if (this.source.getClosed$okhttp()) {
                }
                return true;
            }
            if (this.sink.getFinished() || this.sink.getClosed()) {
                if (this.hasResponseHeaders) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final f0 readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(l source, int i3) throws IOException {
        e.f(source, "source");
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            this.source.receive$okhttp(source, i3);
            return;
        }
        StringBuilder sb2 = new StringBuilder("Thread ");
        Thread currentThread = Thread.currentThread();
        e.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST NOT hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053 A[Catch: all -> 0x0048, TryCatch #0 {all -> 0x0048, blocks: (B:10:0x003a, B:14:0x0042, B:16:0x0053, B:17:0x0058, B:24:0x004a), top: B:9:0x003a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void receiveHeaders(okhttp3.Headers r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.e.f(r3, r0)
            boolean r0 = okhttp3.internal.Util.assertionsEnabled
            if (r0 == 0) goto L39
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto L10
            goto L39
        L10:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "Thread "
            r4.<init>(r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r1 = "Thread.currentThread()"
            kotlin.jvm.internal.e.e(r0, r1)
            java.lang.String r0 = r0.getName()
            r4.append(r0)
            java.lang.String r0 = " MUST NOT hold lock on "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L39:
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch: java.lang.Throwable -> L48
            r1 = 1
            if (r0 == 0) goto L4a
            if (r4 != 0) goto L42
            goto L4a
        L42:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.source     // Catch: java.lang.Throwable -> L48
            r0.setTrailers(r3)     // Catch: java.lang.Throwable -> L48
            goto L51
        L48:
            r3 = move-exception
            goto L6a
        L4a:
            r2.hasResponseHeaders = r1     // Catch: java.lang.Throwable -> L48
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch: java.lang.Throwable -> L48
            r0.add(r3)     // Catch: java.lang.Throwable -> L48
        L51:
            if (r4 == 0) goto L58
            okhttp3.internal.http2.Http2Stream$FramingSource r3 = r2.source     // Catch: java.lang.Throwable -> L48
            r3.setFinished$okhttp(r1)     // Catch: java.lang.Throwable -> L48
        L58:
            boolean r3 = r2.isOpen()     // Catch: java.lang.Throwable -> L48
            r2.notifyAll()     // Catch: java.lang.Throwable -> L48
            monitor-exit(r2)
            if (r3 != 0) goto L69
            okhttp3.internal.http2.Http2Connection r3 = r2.connection
            int r4 = r2.f16951id
            r3.removeStream$okhttp(r4)
        L69:
            return
        L6a:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.receiveHeaders(okhttp3.Headers, boolean):void");
    }

    public final synchronized void receiveRstStream(ErrorCode errorCode) {
        e.f(errorCode, "errorCode");
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public final void setErrorCode$okhttp(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final void setErrorException$okhttp(IOException iOException) {
        this.errorException = iOException;
    }

    public final void setReadBytesAcknowledged$okhttp(long j4) {
        this.readBytesAcknowledged = j4;
    }

    public final void setReadBytesTotal$okhttp(long j4) {
        this.readBytesTotal = j4;
    }

    public final void setWriteBytesMaximum$okhttp(long j4) {
        this.writeBytesMaximum = j4;
    }

    public final void setWriteBytesTotal$okhttp(long j4) {
        this.writeBytesTotal = j4;
    }

    public final synchronized Headers takeHeaders() throws IOException {
        Headers removeFirst;
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                waitForIo$okhttp();
            } catch (Throwable th2) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th2;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (this.headersQueue.isEmpty()) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.errorCode;
            e.c(errorCode);
            throw new StreamResetException(errorCode);
        }
        removeFirst = this.headersQueue.removeFirst();
        e.e(removeFirst, "headersQueue.removeFirst()");
        return removeFirst;
    }

    public final synchronized Headers trailers() throws IOException {
        Headers trailers;
        try {
            if (this.errorCode != null) {
                IOException iOException = this.errorException;
                if (iOException != null) {
                    throw iOException;
                }
                ErrorCode errorCode = this.errorCode;
                e.c(errorCode);
                throw new StreamResetException(errorCode);
            }
            if (!(this.source.getFinished$okhttp() && this.source.getReceiveBuffer().D() && this.source.getReadBuffer().D())) {
                throw new IllegalStateException("too early; can't read the trailers yet");
            }
            trailers = this.source.getTrailers();
            if (trailers == null) {
                trailers = Util.EMPTY_HEADERS;
            }
        } finally {
        }
        return trailers;
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void writeHeaders(List<Header> responseHeaders, boolean z5, boolean z6) throws IOException {
        boolean z8;
        e.f(responseHeaders, "responseHeaders");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
        synchronized (this) {
            this.hasResponseHeaders = true;
            if (z5) {
                this.sink.setFinished(true);
            }
        }
        if (!z6) {
            synchronized (this.connection) {
                z8 = this.connection.getWriteBytesTotal() >= this.connection.getWriteBytesMaximum();
            }
            z6 = z8;
        }
        this.connection.writeHeaders$okhttp(this.f16951id, z5, responseHeaders);
        if (z6) {
            this.connection.flush();
        }
    }

    public final f0 writeTimeout() {
        return this.writeTimeout;
    }

    public final class FramingSink implements a0 {
        private boolean closed;
        private boolean finished;
        private final j sendBuffer;
        private Headers trailers;

        public FramingSink(boolean z5) {
            this.finished = z5;
            this.sendBuffer = new j();
        }

        /* JADX WARN: Finally extract failed */
        private final void emitFrame(boolean z5) throws IOException {
            long min;
            boolean z6;
            synchronized (Http2Stream.this) {
                Http2Stream.this.getWriteTimeout$okhttp().enter();
                while (Http2Stream.this.getWriteBytesTotal() >= Http2Stream.this.getWriteBytesMaximum() && !this.finished && !this.closed && Http2Stream.this.getErrorCode$okhttp() == null) {
                    try {
                        Http2Stream.this.waitForIo$okhttp();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                Http2Stream.this.checkOutNotClosed$okhttp();
                min = Math.min(Http2Stream.this.getWriteBytesMaximum() - Http2Stream.this.getWriteBytesTotal(), this.sendBuffer.f19654b);
                Http2Stream http2Stream = Http2Stream.this;
                http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + min);
                z6 = z5 && min == this.sendBuffer.f19654b && Http2Stream.this.getErrorCode$okhttp() == null;
            }
            Http2Stream.this.getWriteTimeout$okhttp().enter();
            try {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z6, this.sendBuffer, min);
            } finally {
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            }
        }

        @Override // wh.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                StringBuilder sb2 = new StringBuilder("Thread ");
                Thread currentThread = Thread.currentThread();
                e.e(currentThread, "Thread.currentThread()");
                sb2.append(currentThread.getName());
                sb2.append(" MUST NOT hold lock on ");
                sb2.append(http2Stream);
                throw new AssertionError(sb2.toString());
            }
            synchronized (Http2Stream.this) {
                if (this.closed) {
                    return;
                }
                boolean z5 = Http2Stream.this.getErrorCode$okhttp() == null;
                if (!Http2Stream.this.getSink$okhttp().finished) {
                    boolean z6 = this.sendBuffer.f19654b > 0;
                    if (this.trailers != null) {
                        while (this.sendBuffer.f19654b > 0) {
                            emitFrame(false);
                        }
                        Http2Connection connection = Http2Stream.this.getConnection();
                        int id2 = Http2Stream.this.getId();
                        Headers headers = this.trailers;
                        e.c(headers);
                        connection.writeHeaders$okhttp(id2, z5, Util.toHeaderList(headers));
                    } else if (z6) {
                        while (this.sendBuffer.f19654b > 0) {
                            emitFrame(true);
                        }
                    } else if (z5) {
                        Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.closed = true;
                }
                Http2Stream.this.getConnection().flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
            }
        }

        @Override // wh.a0, java.io.Flushable
        public void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                StringBuilder sb2 = new StringBuilder("Thread ");
                Thread currentThread = Thread.currentThread();
                e.e(currentThread, "Thread.currentThread()");
                sb2.append(currentThread.getName());
                sb2.append(" MUST NOT hold lock on ");
                sb2.append(http2Stream);
                throw new AssertionError(sb2.toString());
            }
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed$okhttp();
            }
            while (this.sendBuffer.f19654b > 0) {
                emitFrame(false);
                Http2Stream.this.getConnection().flush();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean z5) {
            this.closed = z5;
        }

        public final void setFinished(boolean z5) {
            this.finished = z5;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // wh.a0
        public f0 timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        @Override // wh.a0
        public void write(j source, long j4) throws IOException {
            e.f(source, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (!Util.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                this.sendBuffer.write(source, j4);
                while (this.sendBuffer.f19654b >= 16384) {
                    emitFrame(false);
                }
            } else {
                StringBuilder sb2 = new StringBuilder("Thread ");
                Thread currentThread = Thread.currentThread();
                e.e(currentThread, "Thread.currentThread()");
                sb2.append(currentThread.getName());
                sb2.append(" MUST NOT hold lock on ");
                sb2.append(http2Stream);
                throw new AssertionError(sb2.toString());
            }
        }

        public /* synthetic */ FramingSink(Http2Stream http2Stream, boolean z5, int i3, c cVar) {
            this((i3 & 1) != 0 ? false : z5);
        }
    }
}
