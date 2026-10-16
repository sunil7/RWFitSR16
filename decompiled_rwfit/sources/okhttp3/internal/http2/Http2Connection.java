package okhttp3.internal.http2;

import com.google.android.gms.internal.mlkit_vision_common.e6;
import com.tencent.open.SocialConstants;
import eh.g;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import oh.a;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.platform.Platform;
import okio.ByteString;
import wh.j;
import wh.k;
import wh.l;

/* loaded from: classes2.dex */
public final class Http2Connection implements Closeable, AutoCloseable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = new Companion(null);
    private static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextStreamId;
    private final Settings okHttpSettings;
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;
    private final Socket socket;
    private final Map<Integer, Http2Stream> streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    public static final class Builder {
        private boolean client;
        public String connectionName;
        private Listener listener;
        private int pingIntervalMillis;
        private PushObserver pushObserver;
        public k sink;
        public Socket socket;
        public l source;
        private final TaskRunner taskRunner;

        public Builder(boolean z5, TaskRunner taskRunner) {
            e.f(taskRunner, "taskRunner");
            this.client = z5;
            this.taskRunner = taskRunner;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket, String str, l lVar, k kVar, int i3, Object obj) throws IOException {
            if ((i3 & 2) != 0) {
                str = Util.peerName(socket);
            }
            if ((i3 & 4) != 0) {
                lVar = e6.b(e6.e(socket));
            }
            if ((i3 & 8) != 0) {
                kVar = e6.a(e6.d(socket));
            }
            return builder.socket(socket, str, lVar, kVar);
        }

        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            e.m("connectionName");
            throw null;
        }

        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final k getSink$okhttp() {
            k kVar = this.sink;
            if (kVar != null) {
                return kVar;
            }
            e.m("sink");
            throw null;
        }

        public final Socket getSocket$okhttp() {
            Socket socket = this.socket;
            if (socket != null) {
                return socket;
            }
            e.m("socket");
            throw null;
        }

        public final l getSource$okhttp() {
            l lVar = this.source;
            if (lVar != null) {
                return lVar;
            }
            e.m(SocialConstants.PARAM_SOURCE);
            throw null;
        }

        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final Builder listener(Listener listener) {
            e.f(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final Builder pingIntervalMillis(int i3) {
            this.pingIntervalMillis = i3;
            return this;
        }

        public final Builder pushObserver(PushObserver pushObserver) {
            e.f(pushObserver, "pushObserver");
            this.pushObserver = pushObserver;
            return this;
        }

        public final void setClient$okhttp(boolean z5) {
            this.client = z5;
        }

        public final void setConnectionName$okhttp(String str) {
            e.f(str, "<set-?>");
            this.connectionName = str;
        }

        public final void setListener$okhttp(Listener listener) {
            e.f(listener, "<set-?>");
            this.listener = listener;
        }

        public final void setPingIntervalMillis$okhttp(int i3) {
            this.pingIntervalMillis = i3;
        }

        public final void setPushObserver$okhttp(PushObserver pushObserver) {
            e.f(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final void setSink$okhttp(k kVar) {
            e.f(kVar, "<set-?>");
            this.sink = kVar;
        }

        public final void setSocket$okhttp(Socket socket) {
            e.f(socket, "<set-?>");
            this.socket = socket;
        }

        public final void setSource$okhttp(l lVar) {
            e.f(lVar, "<set-?>");
            this.source = lVar;
        }

        public final Builder socket(Socket socket) throws IOException {
            return socket$default(this, socket, null, null, null, 14, null);
        }

        public final Builder socket(Socket socket, String str) throws IOException {
            return socket$default(this, socket, str, null, null, 12, null);
        }

        public final Builder socket(Socket socket, String str, l lVar) throws IOException {
            return socket$default(this, socket, str, lVar, null, 8, null);
        }

        public final Builder socket(Socket socket, String peerName, l source, k sink) throws IOException {
            String concat;
            e.f(socket, "socket");
            e.f(peerName, "peerName");
            e.f(source, "source");
            e.f(sink, "sink");
            this.socket = socket;
            if (this.client) {
                concat = Util.okHttpName + ' ' + peerName;
            } else {
                concat = "MockWebServer ".concat(peerName);
            }
            this.connectionName = concat;
            this.source = source;
            this.sink = sink;
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public static abstract class Listener {
        public static final Companion Companion = new Companion(null);
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() { // from class: okhttp3.internal.http2.Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(Http2Stream stream) throws IOException {
                e.f(stream, "stream");
                stream.close(ErrorCode.REFUSED_STREAM, null);
            }
        };

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(c cVar) {
                this();
            }
        }

        public void onSettings(Http2Connection connection, Settings settings) {
            e.f(connection, "connection");
            e.f(settings, "settings");
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    public final class ReaderRunnable implements Http2Reader.Handler, a {
        private final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        public ReaderRunnable(Http2Connection http2Connection, Http2Reader reader) {
            e.f(reader, "reader");
            this.this$0 = http2Connection;
            this.reader = reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i3, String origin, ByteString protocol, String host, int i10, long j4) {
            e.f(origin, "origin");
            e.f(protocol, "protocol");
            e.f(host, "host");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [T, okhttp3.internal.http2.Settings] */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        public final void applyAndAckSettings(final boolean z5, final Settings settings) {
            ?? r12;
            T t8;
            e.f(settings, "settings");
            final Ref$LongRef ref$LongRef = new Ref$LongRef();
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            synchronized (this.this$0.getWriter()) {
                synchronized (this.this$0) {
                    try {
                        Settings peerSettings = this.this$0.getPeerSettings();
                        if (z5) {
                            r12 = settings;
                        } else {
                            Settings settings2 = new Settings();
                            settings2.merge(peerSettings);
                            settings2.merge(settings);
                            r12 = settings2;
                        }
                        ref$ObjectRef2.element = r12;
                        long initialWindowSize = r12.getInitialWindowSize() - peerSettings.getInitialWindowSize();
                        ref$LongRef.element = initialWindowSize;
                        if (initialWindowSize != 0 && !this.this$0.getStreams$okhttp().isEmpty()) {
                            Object[] array = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                            if (array == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                            t8 = (Http2Stream[]) array;
                            ref$ObjectRef.element = t8;
                            this.this$0.setPeerSettings((Settings) ref$ObjectRef2.element);
                            TaskQueue taskQueue = this.this$0.settingsListenerQueue;
                            final String str = this.this$0.getConnectionName$okhttp() + " onSettings";
                            final boolean z6 = true;
                            taskQueue.schedule(new Task(str, z6) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // okhttp3.internal.concurrent.Task
                                public long runOnce() {
                                    this.this$0.getListener$okhttp().onSettings(this.this$0, (Settings) ref$ObjectRef2.element);
                                    return -1L;
                                }
                            }, 0L);
                        }
                        t8 = 0;
                        ref$ObjectRef.element = t8;
                        this.this$0.setPeerSettings((Settings) ref$ObjectRef2.element);
                        TaskQueue taskQueue2 = this.this$0.settingsListenerQueue;
                        final String str2 = this.this$0.getConnectionName$okhttp() + " onSettings";
                        final boolean z62 = true;
                        taskQueue2.schedule(new Task(str2, z62) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // okhttp3.internal.concurrent.Task
                            public long runOnce() {
                                this.this$0.getListener$okhttp().onSettings(this.this$0, (Settings) ref$ObjectRef2.element);
                                return -1L;
                            }
                        }, 0L);
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                try {
                    this.this$0.getWriter().applyAndAckSettings((Settings) ref$ObjectRef2.element);
                } catch (IOException e) {
                    this.this$0.failConnection(e);
                }
            }
            T t10 = ref$ObjectRef.element;
            if (((Http2Stream[]) t10) != null) {
                Http2Stream[] http2StreamArr = (Http2Stream[]) t10;
                e.c(http2StreamArr);
                for (Http2Stream http2Stream : http2StreamArr) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(ref$LongRef.element);
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z5, int i3, l source, int i10) throws IOException {
            e.f(source, "source");
            if (this.this$0.pushedStream$okhttp(i3)) {
                this.this$0.pushDataLater$okhttp(i3, source, i10, z5);
                return;
            }
            Http2Stream stream = this.this$0.getStream(i3);
            if (stream == null) {
                this.this$0.writeSynResetLater$okhttp(i3, ErrorCode.PROTOCOL_ERROR);
                long j4 = i10;
                this.this$0.updateConnectionFlowControl$okhttp(j4);
                source.a(j4);
                return;
            }
            stream.receiveData(source, i10);
            if (z5) {
                stream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i3, ErrorCode errorCode, ByteString debugData) {
            int i10;
            Http2Stream[] http2StreamArr;
            e.f(errorCode, "errorCode");
            e.f(debugData, "debugData");
            debugData.size();
            synchronized (this.this$0) {
                Object[] array = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                http2StreamArr = (Http2Stream[]) array;
                this.this$0.isShutdown = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i3 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(final boolean z5, final int i3, int i10, final List<Header> headerBlock) {
            e.f(headerBlock, "headerBlock");
            if (this.this$0.pushedStream$okhttp(i3)) {
                this.this$0.pushHeadersLater$okhttp(i3, headerBlock, z5);
                return;
            }
            synchronized (this.this$0) {
                final Http2Stream stream = this.this$0.getStream(i3);
                if (stream != null) {
                    stream.receiveHeaders(Util.toHeaders(headerBlock), z5);
                    return;
                }
                if (this.this$0.isShutdown) {
                    return;
                }
                if (i3 <= this.this$0.getLastGoodStreamId$okhttp()) {
                    return;
                }
                if (i3 % 2 == this.this$0.getNextStreamId$okhttp() % 2) {
                    return;
                }
                final Http2Stream http2Stream = new Http2Stream(i3, this.this$0, false, z5, Util.toHeaders(headerBlock));
                this.this$0.setLastGoodStreamId$okhttp(i3);
                this.this$0.getStreams$okhttp().put(Integer.valueOf(i3), http2Stream);
                TaskQueue newQueue = this.this$0.taskRunner.newQueue();
                final String str = this.this$0.getConnectionName$okhttp() + '[' + i3 + "] onStream";
                final boolean z6 = true;
                newQueue.schedule(new Task(str, z6) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1
                    @Override // okhttp3.internal.concurrent.Task
                    public long runOnce() {
                        try {
                            this.this$0.getListener$okhttp().onStream(http2Stream);
                            return -1L;
                        } catch (IOException e) {
                            Platform.Companion.get().log("Http2Connection.Listener failure for " + this.this$0.getConnectionName$okhttp(), 4, e);
                            try {
                                http2Stream.close(ErrorCode.PROTOCOL_ERROR, e);
                                return -1L;
                            } catch (IOException unused) {
                                return -1L;
                            }
                        }
                    }
                }, 0L);
            }
        }

        @Override // oh.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m218invoke();
            return g.f12633a;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z5, final int i3, final int i10) {
            if (!z5) {
                TaskQueue taskQueue = this.this$0.writerQueue;
                final String str = this.this$0.getConnectionName$okhttp() + " ping";
                final boolean z6 = true;
                taskQueue.schedule(new Task(str, z6) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$ping$$inlined$execute$1
                    @Override // okhttp3.internal.concurrent.Task
                    public long runOnce() {
                        this.this$0.writePing(true, i3, i10);
                        return -1L;
                    }
                }, 0L);
                return;
            }
            synchronized (this.this$0) {
                try {
                    if (i3 == 1) {
                        this.this$0.intervalPongsReceived++;
                    } else if (i3 == 2) {
                        this.this$0.degradedPongsReceived++;
                    } else if (i3 == 3) {
                        this.this$0.awaitPongsReceived++;
                        Http2Connection http2Connection = this.this$0;
                        if (http2Connection == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                        http2Connection.notifyAll();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i3, int i10, int i11, boolean z5) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i3, int i10, List<Header> requestHeaders) {
            e.f(requestHeaders, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(i10, requestHeaders);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i3, ErrorCode errorCode) {
            e.f(errorCode, "errorCode");
            if (this.this$0.pushedStream$okhttp(i3)) {
                this.this$0.pushResetLater$okhttp(i3, errorCode);
                return;
            }
            Http2Stream removeStream$okhttp = this.this$0.removeStream$okhttp(i3);
            if (removeStream$okhttp != null) {
                removeStream$okhttp.receiveRstStream(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean z5, final Settings settings) {
            e.f(settings, "settings");
            TaskQueue taskQueue = this.this$0.writerQueue;
            final String str = this.this$0.getConnectionName$okhttp() + " applyAndAckSettings";
            final boolean z6 = true;
            taskQueue.schedule(new Task(str, z6) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$settings$$inlined$execute$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    this.applyAndAckSettings(z5, settings);
                    return -1L;
                }
            }, 0L);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i3, long j4) {
            if (i3 != 0) {
                Http2Stream stream = this.this$0.getStream(i3);
                if (stream != null) {
                    synchronized (stream) {
                        stream.addBytesToWriteWindow(j4);
                    }
                    return;
                }
                return;
            }
            synchronized (this.this$0) {
                Http2Connection http2Connection = this.this$0;
                http2Connection.writeBytesMaximum = http2Connection.getWriteBytesMaximum() + j4;
                Http2Connection http2Connection2 = this.this$0;
                if (http2Connection2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                http2Connection2.notifyAll();
            }
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public void m218invoke() {
            ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    this.reader.readConnectionPreface(this);
                    while (this.reader.nextFrame(false, this)) {
                    }
                    try {
                        this.this$0.close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
                        Util.closeQuietly(this.reader);
                    } catch (IOException e) {
                        e = e;
                        ErrorCode errorCode2 = ErrorCode.PROTOCOL_ERROR;
                        this.this$0.close$okhttp(errorCode2, errorCode2, e);
                        Util.closeQuietly(this.reader);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.this$0.close$okhttp(errorCode, errorCode, null);
                    Util.closeQuietly(this.reader);
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
            } catch (Throwable th3) {
                th = th3;
                this.this$0.close$okhttp(errorCode, errorCode, null);
                Util.closeQuietly(this.reader);
                throw th;
            }
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(7, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        settings.set(5, Http2.INITIAL_MAX_FRAME_SIZE);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(Builder builder) {
        e.f(builder, "builder");
        boolean client$okhttp = builder.getClient$okhttp();
        this.client = client$okhttp;
        this.listener = builder.getListener$okhttp();
        this.streams = new LinkedHashMap();
        String connectionName$okhttp = builder.getConnectionName$okhttp();
        this.connectionName = connectionName$okhttp;
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp;
        TaskQueue newQueue = taskRunner$okhttp.newQueue();
        this.writerQueue = newQueue;
        this.pushQueue = taskRunner$okhttp.newQueue();
        this.settingsListenerQueue = taskRunner$okhttp.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings = new Settings();
        if (builder.getClient$okhttp()) {
            settings.set(7, OKHTTP_CLIENT_WINDOW_SIZE);
        }
        this.okHttpSettings = settings;
        this.peerSettings = DEFAULT_SETTINGS;
        this.writeBytesMaximum = r2.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), client$okhttp);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.getSource$okhttp(), client$okhttp));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            final long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis$okhttp());
            final String l3 = android.support.v4.media.session.e.l(connectionName$okhttp, " ping");
            newQueue.schedule(new Task(l3) { // from class: okhttp3.internal.http2.Http2Connection$$special$$inlined$schedule$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    long j4;
                    long j10;
                    boolean z5;
                    synchronized (this) {
                        long j11 = this.intervalPongsReceived;
                        j4 = this.intervalPingsSent;
                        if (j11 < j4) {
                            z5 = true;
                        } else {
                            Http2Connection http2Connection = this;
                            j10 = http2Connection.intervalPingsSent;
                            http2Connection.intervalPingsSent = j10 + 1;
                            z5 = false;
                        }
                    }
                    if (z5) {
                        this.failConnection(null);
                        return -1L;
                    }
                    this.writePing(false, 1, 0);
                    return nanos;
                }
            }, nanos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void failConnection(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(errorCode, errorCode, iOException);
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z5, TaskRunner taskRunner, int i3, Object obj) throws IOException {
        if ((i3 & 1) != 0) {
            z5 = true;
        }
        if ((i3 & 2) != 0) {
            taskRunner = TaskRunner.INSTANCE;
        }
        http2Connection.start(z5, taskRunner);
    }

    public final synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(ErrorCode connectionCode, ErrorCode streamCode, IOException iOException) {
        int i3;
        Http2Stream[] http2StreamArr;
        e.f(connectionCode, "connectionCode");
        e.f(streamCode, "streamCode");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
        try {
            shutdown(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.streams.isEmpty()) {
                    http2StreamArr = null;
                } else {
                    Object[] array = this.streams.values().toArray(new Http2Stream[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    http2StreamArr = (Http2Stream[]) array;
                    this.streams.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final synchronized Http2Stream getStream(int i3) {
        return this.streams.get(Integer.valueOf(i3));
    }

    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final synchronized boolean isHealthy(long j4) {
        if (this.isShutdown) {
            return false;
        }
        if (this.degradedPongsReceived < this.degradedPingsSent) {
            if (j4 >= this.degradedPongDeadlineNs) {
                return false;
            }
        }
        return true;
    }

    public final Http2Stream newStream(List<Header> requestHeaders, boolean z5) throws IOException {
        e.f(requestHeaders, "requestHeaders");
        return newStream(0, requestHeaders, z5);
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    public final void pushDataLater$okhttp(final int i3, l source, final int i10, final boolean z5) throws IOException {
        e.f(source, "source");
        final j jVar = new j();
        long j4 = i10;
        source.P(j4);
        source.read(jVar, j4);
        TaskQueue taskQueue = this.pushQueue;
        final String str = this.connectionName + '[' + i3 + "] onData";
        final boolean z6 = true;
        taskQueue.schedule(new Task(str, z6) { // from class: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                PushObserver pushObserver;
                Set set;
                try {
                    pushObserver = this.pushObserver;
                    boolean onData = pushObserver.onData(i3, jVar, i10, z5);
                    if (onData) {
                        this.getWriter().rstStream(i3, ErrorCode.CANCEL);
                    }
                    if (!onData && !z5) {
                        return -1L;
                    }
                    synchronized (this) {
                        set = this.currentPushRequests;
                        set.remove(Integer.valueOf(i3));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void pushHeadersLater$okhttp(final int i3, final List<Header> requestHeaders, final boolean z5) {
        e.f(requestHeaders, "requestHeaders");
        TaskQueue taskQueue = this.pushQueue;
        final String str = this.connectionName + '[' + i3 + "] onHeaders";
        final boolean z6 = true;
        taskQueue.schedule(new Task(str, z6) { // from class: okhttp3.internal.http2.Http2Connection$pushHeadersLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                PushObserver pushObserver;
                Set set;
                pushObserver = this.pushObserver;
                boolean onHeaders = pushObserver.onHeaders(i3, requestHeaders, z5);
                if (onHeaders) {
                    try {
                        this.getWriter().rstStream(i3, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
                if (!onHeaders && !z5) {
                    return -1L;
                }
                synchronized (this) {
                    set = this.currentPushRequests;
                    set.remove(Integer.valueOf(i3));
                }
                return -1L;
            }
        }, 0L);
    }

    public final void pushRequestLater$okhttp(final int i3, final List<Header> requestHeaders) {
        Throwable th2;
        e.f(requestHeaders, "requestHeaders");
        synchronized (this) {
            try {
                if (this.currentPushRequests.contains(Integer.valueOf(i3))) {
                    try {
                        writeSynResetLater$okhttp(i3, ErrorCode.PROTOCOL_ERROR);
                        return;
                    } catch (Throwable th3) {
                        th2 = th3;
                        throw th2;
                    }
                }
                this.currentPushRequests.add(Integer.valueOf(i3));
                TaskQueue taskQueue = this.pushQueue;
                final String str = this.connectionName + '[' + i3 + "] onRequest";
                final boolean z5 = true;
                taskQueue.schedule(new Task(str, z5) { // from class: okhttp3.internal.http2.Http2Connection$pushRequestLater$$inlined$execute$1
                    @Override // okhttp3.internal.concurrent.Task
                    public long runOnce() {
                        PushObserver pushObserver;
                        Set set;
                        pushObserver = this.pushObserver;
                        if (!pushObserver.onRequest(i3, requestHeaders)) {
                            return -1L;
                        }
                        try {
                            this.getWriter().rstStream(i3, ErrorCode.CANCEL);
                            synchronized (this) {
                                set = this.currentPushRequests;
                                set.remove(Integer.valueOf(i3));
                            }
                            return -1L;
                        } catch (IOException unused) {
                            return -1L;
                        }
                    }
                }, 0L);
            } catch (Throwable th4) {
                th2 = th4;
            }
        }
    }

    public final void pushResetLater$okhttp(final int i3, final ErrorCode errorCode) {
        e.f(errorCode, "errorCode");
        TaskQueue taskQueue = this.pushQueue;
        final String str = this.connectionName + '[' + i3 + "] onReset";
        final boolean z5 = true;
        taskQueue.schedule(new Task(str, z5) { // from class: okhttp3.internal.http2.Http2Connection$pushResetLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                PushObserver pushObserver;
                Set set;
                pushObserver = this.pushObserver;
                pushObserver.onReset(i3, errorCode);
                synchronized (this) {
                    set = this.currentPushRequests;
                    set.remove(Integer.valueOf(i3));
                }
                return -1L;
            }
        }, 0L);
    }

    public final Http2Stream pushStream(int i3, List<Header> requestHeaders, boolean z5) throws IOException {
        e.f(requestHeaders, "requestHeaders");
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        return newStream(i3, requestHeaders, z5);
    }

    public final boolean pushedStream$okhttp(int i3) {
        return i3 != 0 && (i3 & 1) == 0;
    }

    public final synchronized Http2Stream removeStream$okhttp(int i3) {
        Http2Stream remove;
        remove = this.streams.remove(Integer.valueOf(i3));
        notifyAll();
        return remove;
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            long j4 = this.degradedPongsReceived;
            long j10 = this.degradedPingsSent;
            if (j4 < j10) {
                return;
            }
            this.degradedPingsSent = j10 + 1;
            this.degradedPongDeadlineNs = System.nanoTime() + DEGRADED_PONG_TIMEOUT_NS;
            TaskQueue taskQueue = this.writerQueue;
            final String f2 = r5.a.f(new StringBuilder(), this.connectionName, " ping");
            final boolean z5 = true;
            taskQueue.schedule(new Task(f2, z5) { // from class: okhttp3.internal.http2.Http2Connection$sendDegradedPingLater$$inlined$execute$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    this.writePing(false, 2, 0);
                    return -1L;
                }
            }, 0L);
        }
    }

    public final void setLastGoodStreamId$okhttp(int i3) {
        this.lastGoodStreamId = i3;
    }

    public final void setNextStreamId$okhttp(int i3) {
        this.nextStreamId = i3;
    }

    public final void setPeerSettings(Settings settings) {
        e.f(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final void setSettings(Settings settings) throws IOException {
        e.f(settings, "settings");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
            }
            this.writer.settings(settings);
        }
    }

    public final void shutdown(ErrorCode statusCode) throws IOException {
        e.f(statusCode, "statusCode");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                this.writer.goAway(this.lastGoodStreamId, statusCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public final void start() throws IOException {
        start$default(this, false, null, 3, null);
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j4) {
        long j10 = this.readBytesTotal + j4;
        this.readBytesTotal = j10;
        long j11 = j10 - this.readBytesAcknowledged;
        if (j11 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater$okhttp(0, j11);
            this.readBytesAcknowledged += j11;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.writer.maxDataLength());
        r6 = r2;
        r8.writeBytesTotal += r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void writeData(int r9, boolean r10, wh.j r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            okhttp3.internal.http2.Http2Writer r12 = r8.writer
            r12.data(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L6a
            monitor-enter(r8)
        L12:
            long r4 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            long r6 = r8.writeBytesMaximum     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L34
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r2 = r8.streams     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            if (r2 == 0) goto L2c
            r8.wait()     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            goto L12
        L2a:
            r9 = move-exception
            goto L68
        L2c:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
            throw r9     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5b
        L34:
            long r6 = r6 - r4
            long r4 = java.lang.Math.min(r12, r6)     // Catch: java.lang.Throwable -> L2a
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L2a
            okhttp3.internal.http2.Http2Writer r4 = r8.writer     // Catch: java.lang.Throwable -> L2a
            int r4 = r4.maxDataLength()     // Catch: java.lang.Throwable -> L2a
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L2a
            long r4 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L2a
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L2a
            long r4 = r4 + r6
            r8.writeBytesTotal = r4     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r8)
            long r12 = r12 - r6
            okhttp3.internal.http2.Http2Writer r4 = r8.writer
            if (r10 == 0) goto L56
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L56
            r5 = 1
            goto L57
        L56:
            r5 = r3
        L57:
            r4.data(r5, r9, r11, r2)
            goto Ld
        L5b:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2a
            r9.interrupt()     // Catch: java.lang.Throwable -> L2a
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L2a
            r9.<init>()     // Catch: java.lang.Throwable -> L2a
            throw r9     // Catch: java.lang.Throwable -> L2a
        L68:
            monitor-exit(r8)
            throw r9
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, wh.j, long):void");
    }

    public final void writeHeaders$okhttp(int i3, boolean z5, List<Header> alternating) throws IOException {
        e.f(alternating, "alternating");
        this.writer.headers(z5, i3, alternating);
    }

    public final void writePing(boolean z5, int i3, int i10) {
        try {
            this.writer.ping(z5, i3, i10);
        } catch (IOException e) {
            failConnection(e);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public final void writeSynReset$okhttp(int i3, ErrorCode statusCode) throws IOException {
        e.f(statusCode, "statusCode");
        this.writer.rstStream(i3, statusCode);
    }

    public final void writeSynResetLater$okhttp(final int i3, final ErrorCode errorCode) {
        e.f(errorCode, "errorCode");
        TaskQueue taskQueue = this.writerQueue;
        final String str = this.connectionName + '[' + i3 + "] writeSynReset";
        final boolean z5 = true;
        taskQueue.schedule(new Task(str, z5) { // from class: okhttp3.internal.http2.Http2Connection$writeSynResetLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    this.writeSynReset$okhttp(i3, errorCode);
                    return -1L;
                } catch (IOException e) {
                    this.failConnection(e);
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void writeWindowUpdateLater$okhttp(final int i3, final long j4) {
        TaskQueue taskQueue = this.writerQueue;
        final String str = this.connectionName + '[' + i3 + "] windowUpdate";
        final boolean z5 = true;
        taskQueue.schedule(new Task(str, z5) { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    this.getWriter().windowUpdate(i3, j4);
                    return -1L;
                } catch (IOException e) {
                    this.failConnection(e);
                    return -1L;
                }
            }
        }, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004d A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:15:0x0027, B:17:0x002c, B:19:0x0034, B:23:0x0047, B:25:0x004d, B:42:0x0080, B:43:0x0085), top: B:11:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059 A[Catch: all -> 0x005f, TryCatch #4 {all -> 0x005f, blocks: (B:26:0x0056, B:28:0x0059, B:34:0x0062, B:36:0x0066, B:37:0x0074, B:38:0x007b, B:46:0x0086, B:47:0x0087), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062 A[Catch: all -> 0x005f, TryCatch #4 {all -> 0x005f, blocks: (B:26:0x0056, B:28:0x0059, B:34:0x0062, B:36:0x0066, B:37:0x0074, B:38:0x007b, B:46:0x0086, B:47:0x0087), top: B:3:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final okhttp3.internal.http2.Http2Stream newStream(int r10, java.util.List<okhttp3.internal.http2.Header> r11, boolean r12) throws java.io.IOException {
        /*
            r9 = this;
            r3 = r12 ^ 1
            okhttp3.internal.http2.Http2Writer r6 = r9.writer
            monitor-enter(r6)
            monitor-enter(r9)     // Catch: java.lang.Throwable -> L88
            int r0 = r9.nextStreamId     // Catch: java.lang.Throwable -> L7c
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L18
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L13
            r9.shutdown(r0)     // Catch: java.lang.Throwable -> L13
            goto L18
        L13:
            r0 = move-exception
            r10 = r0
            r2 = r9
            goto L86
        L18:
            boolean r0 = r9.isShutdown     // Catch: java.lang.Throwable -> L7c
            if (r0 != 0) goto L7f
            int r1 = r9.nextStreamId     // Catch: java.lang.Throwable -> L7c
            int r0 = r1 + 2
            r9.nextStreamId = r0     // Catch: java.lang.Throwable -> L7c
            okhttp3.internal.http2.Http2Stream r0 = new okhttp3.internal.http2.Http2Stream     // Catch: java.lang.Throwable -> L7c
            r5 = 0
            r4 = 0
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L43
            if (r12 == 0) goto L46
            long r4 = r2.writeBytesTotal     // Catch: java.lang.Throwable -> L43
            long r7 = r2.writeBytesMaximum     // Catch: java.lang.Throwable -> L43
            int r12 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r12 >= 0) goto L46
            long r4 = r0.getWriteBytesTotal()     // Catch: java.lang.Throwable -> L43
            long r7 = r0.getWriteBytesMaximum()     // Catch: java.lang.Throwable -> L43
            int r12 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r12 < 0) goto L41
            goto L46
        L41:
            r12 = 0
            goto L47
        L43:
            r0 = move-exception
        L44:
            r10 = r0
            goto L86
        L46:
            r12 = 1
        L47:
            boolean r4 = r0.isOpen()     // Catch: java.lang.Throwable -> L43
            if (r4 == 0) goto L56
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r4 = r2.streams     // Catch: java.lang.Throwable -> L43
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L43
            r4.put(r5, r0)     // Catch: java.lang.Throwable -> L43
        L56:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L5f
            if (r10 != 0) goto L62
            okhttp3.internal.http2.Http2Writer r10 = r2.writer     // Catch: java.lang.Throwable -> L5f
            r10.headers(r3, r1, r11)     // Catch: java.lang.Throwable -> L5f
            goto L6b
        L5f:
            r0 = move-exception
        L60:
            r10 = r0
            goto L8b
        L62:
            boolean r3 = r2.client     // Catch: java.lang.Throwable -> L5f
            if (r3 != 0) goto L74
            okhttp3.internal.http2.Http2Writer r3 = r2.writer     // Catch: java.lang.Throwable -> L5f
            r3.pushPromise(r10, r1, r11)     // Catch: java.lang.Throwable -> L5f
        L6b:
            monitor-exit(r6)
            if (r12 == 0) goto L73
            okhttp3.internal.http2.Http2Writer r10 = r2.writer
            r10.flush()
        L73:
            return r0
        L74:
            java.lang.String r10 = "client streams shouldn't have associated stream IDs"
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L5f
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L5f
            throw r11     // Catch: java.lang.Throwable -> L5f
        L7c:
            r0 = move-exception
            r2 = r9
            goto L44
        L7f:
            r2 = r9
            okhttp3.internal.http2.ConnectionShutdownException r10 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L43
            r10.<init>()     // Catch: java.lang.Throwable -> L43
            throw r10     // Catch: java.lang.Throwable -> L43
        L86:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L5f
            throw r10     // Catch: java.lang.Throwable -> L5f
        L88:
            r0 = move-exception
            r2 = r9
            goto L60
        L8b:
            monitor-exit(r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.newStream(int, java.util.List, boolean):okhttp3.internal.http2.Http2Stream");
    }

    public final void start(boolean z5) throws IOException {
        start$default(this, z5, null, 2, null);
    }

    public final void start(boolean z5, TaskRunner taskRunner) throws IOException {
        e.f(taskRunner, "taskRunner");
        if (z5) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            if (this.okHttpSettings.getInitialWindowSize() != 65535) {
                this.writer.windowUpdate(0, r7 - Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            }
        }
        TaskQueue newQueue = taskRunner.newQueue();
        String str = this.connectionName;
        newQueue.schedule(new TaskQueue$execute$1(this.readerRunnable, str, true, str, true), 0L);
    }

    public final void writePing() throws InterruptedException {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }
}
