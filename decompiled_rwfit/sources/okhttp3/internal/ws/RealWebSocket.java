package okhttp3.internal.ws;

import com.amap.api.services.core.AMapException;
import com.google.android.gms.internal.mlkit_vision_barcode.wd;
import com.tencent.connect.common.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketReader;
import okio.ByteString;
import r5.a;
import wh.k;
import wh.l;
import wh.m;

/* loaded from: classes2.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;
    private String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;
    public static final Companion Companion = new Companion(null);
    private static final List<Protocol> ONLY_HTTP1 = wd.a(Protocol.HTTP_1_1);

    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public Close(int i3, ByteString byteString, long j4) {
            this.code = i3;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j4;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public Message(int i3, ByteString data) {
            e.f(data, "data");
            this.formatOpcode = i3;
            this.data = data;
        }

        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final k sink;
        private final l source;

        public Streams(boolean z5, l source, k sink) {
            e.f(source, "source");
            e.f(sink, "sink");
            this.client = z5;
            this.source = source;
            this.sink = sink;
        }

        public final boolean getClient() {
            return this.client;
        }

        public final k getSink() {
            return this.sink;
        }

        public final l getSource() {
            return this.source;
        }
    }

    public final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            try {
                return RealWebSocket.this.writeOneFrame$okhttp() ? 0L : -1L;
            } catch (IOException e) {
                RealWebSocket.this.failWebSocket(e, null);
                return -1L;
            }
        }
    }

    public RealWebSocket(TaskRunner taskRunner, Request originalRequest, WebSocketListener listener, Random random, long j4, WebSocketExtensions webSocketExtensions, long j10) {
        e.f(taskRunner, "taskRunner");
        e.f(originalRequest, "originalRequest");
        e.f(listener, "listener");
        e.f(random, "random");
        this.originalRequest = originalRequest;
        this.listener = listener;
        this.random = random;
        this.pingIntervalMillis = j4;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j10;
        this.taskQueue = taskRunner.newQueue();
        this.pongQueue = new ArrayDeque<>();
        this.messageAndCloseQueue = new ArrayDeque<>();
        this.receivedCloseCode = -1;
        if (!Constants.HTTP_GET.equals(originalRequest.method())) {
            throw new IllegalArgumentException(("Request must be GET: " + originalRequest.method()).toString());
        }
        m mVar = ByteString.Companion;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = m.d(mVar, bArr).base64();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        Integer num = webSocketExtensions.serverMaxWindowBits;
        if (num == null) {
            return true;
        }
        int intValue = num.intValue();
        return 8 <= intValue && 15 >= intValue;
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0L, 2, null);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder("Thread ");
        Thread currentThread = Thread.currentThread();
        e.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    public final void awaitTermination(long j4, TimeUnit timeUnit) throws InterruptedException {
        e.f(timeUnit, "timeUnit");
        this.taskQueue.idleLatch().await(j4, timeUnit);
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call call = this.call;
        e.c(call);
        call.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(Response response, Exchange exchange) throws IOException {
        e.f(response, "response");
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
        String header$default = Response.header$default(response, "Connection", null, 2, null);
        if (!"Upgrade".equalsIgnoreCase(header$default)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header$default + '\'');
        }
        String header$default2 = Response.header$default(response, "Upgrade", null, 2, null);
        if (!"websocket".equalsIgnoreCase(header$default2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header$default2 + '\'');
        }
        String header$default3 = Response.header$default(response, "Sec-WebSocket-Accept", null, 2, null);
        m mVar = ByteString.Companion;
        String str = this.key + WebSocketProtocol.ACCEPT_MAGIC;
        mVar.getClass();
        String base64 = m.c(str).sha1().base64();
        if (e.a(base64, header$default3)) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header$default3 + '\'');
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i3, String str) {
        return close(i3, str, 60000L);
    }

    public final void connect(OkHttpClient client) {
        e.f(client, "client");
        if (this.originalRequest.header("Sec-WebSocket-Extensions") != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        OkHttpClient build = client.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request build2 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP).header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        RealCall realCall = new RealCall(build, build2, true);
        this.call = realCall;
        realCall.enqueue(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket$connect$1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                e.f(call, "call");
                e.f(e, "e");
                RealWebSocket.this.failWebSocket(e, null);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                boolean isValid;
                ArrayDeque arrayDeque;
                e.f(call, "call");
                e.f(response, "response");
                Exchange exchange = response.exchange();
                try {
                    RealWebSocket.this.checkUpgradeSuccess$okhttp(response, exchange);
                    e.c(exchange);
                    RealWebSocket.Streams newWebSocketStreams = exchange.newWebSocketStreams();
                    WebSocketExtensions parse = WebSocketExtensions.Companion.parse(response.headers());
                    RealWebSocket.this.extensions = parse;
                    isValid = RealWebSocket.this.isValid(parse);
                    if (!isValid) {
                        synchronized (RealWebSocket.this) {
                            arrayDeque = RealWebSocket.this.messageAndCloseQueue;
                            arrayDeque.clear();
                            RealWebSocket.this.close(AMapException.CODE_AMAP_IP_QUERY_OVER_LIMIT, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    try {
                        RealWebSocket.this.initReaderAndWriter(Util.okHttpName + " WebSocket " + build2.url().redact(), newWebSocketStreams);
                        RealWebSocket.this.getListener$okhttp().onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        RealWebSocket.this.failWebSocket(e, null);
                    }
                } catch (IOException e10) {
                    if (exchange != null) {
                        exchange.webSocketUpgradeFailed();
                    }
                    RealWebSocket.this.failWebSocket(e10, response);
                    Util.closeQuietly(response);
                }
            }
        });
    }

    public final void failWebSocket(Exception e, Response response) {
        e.f(e, "e");
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            Streams streams = this.streams;
            this.streams = null;
            WebSocketReader webSocketReader = this.reader;
            this.reader = null;
            WebSocketWriter webSocketWriter = this.writer;
            this.writer = null;
            this.taskQueue.shutdown();
            try {
                this.listener.onFailure(this, e, response);
            } finally {
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
                if (webSocketReader != null) {
                    Util.closeQuietly(webSocketReader);
                }
                if (webSocketWriter != null) {
                    Util.closeQuietly(webSocketWriter);
                }
            }
        }
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(final String name, final Streams streams) throws IOException {
        RealWebSocket realWebSocket = this;
        e.f(name, "name");
        e.f(streams, "streams");
        final WebSocketExtensions webSocketExtensions = realWebSocket.extensions;
        e.c(webSocketExtensions);
        synchronized (this) {
            try {
                realWebSocket.name = name;
                realWebSocket.streams = streams;
                realWebSocket.writer = new WebSocketWriter(streams.getClient(), streams.getSink(), realWebSocket.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams.getClient()), realWebSocket.minimumDeflateSize);
                realWebSocket.writerTask = realWebSocket.new WriterTask();
                long j4 = realWebSocket.pingIntervalMillis;
                if (j4 != 0) {
                    final long nanos = TimeUnit.MILLISECONDS.toNanos(j4);
                    TaskQueue taskQueue = realWebSocket.taskQueue;
                    final String concat = name.concat(" ping");
                    try {
                        try {
                            realWebSocket = this;
                            taskQueue.schedule(new Task(concat) { // from class: okhttp3.internal.ws.RealWebSocket$initReaderAndWriter$$inlined$synchronized$lambda$1
                                @Override // okhttp3.internal.concurrent.Task
                                public long runOnce() {
                                    this.writePingFrame$okhttp();
                                    return nanos;
                                }
                            }, nanos);
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                if (!realWebSocket.messageAndCloseQueue.isEmpty()) {
                    realWebSocket.runWriter();
                }
                realWebSocket.reader = new WebSocketReader(streams.getClient(), streams.getSource(), realWebSocket, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams.getClient()));
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            e.c(webSocketReader);
            webSocketReader.processNextFrame();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i3, String reason) {
        Streams streams;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        e.f(reason, "reason");
        if (!(i3 != -1)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        synchronized (this) {
            if (!(this.receivedCloseCode == -1)) {
                throw new IllegalStateException("already closed");
            }
            this.receivedCloseCode = i3;
            this.receivedCloseReason = reason;
            streams = null;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                Streams streams2 = this.streams;
                this.streams = null;
                webSocketReader = this.reader;
                this.reader = null;
                webSocketWriter = this.writer;
                this.writer = null;
                this.taskQueue.shutdown();
                streams = streams2;
            } else {
                webSocketReader = null;
                webSocketWriter = null;
            }
        }
        try {
            this.listener.onClosing(this, i3, reason);
            if (streams != null) {
                this.listener.onClosed(this, i3, reason);
            }
        } finally {
            if (streams != null) {
                Util.closeQuietly(streams);
            }
            if (webSocketReader != null) {
                Util.closeQuietly(webSocketReader);
            }
            if (webSocketWriter != null) {
                Util.closeQuietly(webSocketWriter);
            }
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String text) throws IOException {
        e.f(text, "text");
        this.listener.onMessage(this, text);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString payload) {
        try {
            e.f(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                this.receivedPingCount++;
            }
        } finally {
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString payload) {
        e.f(payload, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final synchronized boolean pong(ByteString payload) {
        try {
            e.f(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                return true;
            }
            return false;
        } finally {
        }
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            e.c(webSocketReader);
            webSocketReader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e) {
            failWebSocket(e, null);
            return false;
        }
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String text) {
        e.f(text, "text");
        ByteString.Companion.getClass();
        return send(m.c(text), 1);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19, types: [T, okhttp3.internal.ws.RealWebSocket$Streams] */
    /* JADX WARN: Type inference failed for: r1v20, types: [T, okhttp3.internal.ws.WebSocketReader] */
    /* JADX WARN: Type inference failed for: r1v21, types: [T, okhttp3.internal.ws.WebSocketWriter] */
    /* JADX WARN: Type inference failed for: r2v7, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.String] */
    public final boolean writeOneFrame$okhttp() throws IOException {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = -1;
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = null;
        final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        ref$ObjectRef3.element = null;
        final Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
        ref$ObjectRef4.element = null;
        final Ref$ObjectRef ref$ObjectRef5 = new Ref$ObjectRef();
        ref$ObjectRef5.element = null;
        synchronized (this) {
            try {
                if (this.failed) {
                    return false;
                }
                final WebSocketWriter webSocketWriter = this.writer;
                final ByteString poll = this.pongQueue.poll();
                if (poll == null) {
                    ?? poll2 = this.messageAndCloseQueue.poll();
                    ref$ObjectRef.element = poll2;
                    if (poll2 instanceof Close) {
                        int i3 = this.receivedCloseCode;
                        ref$IntRef.element = i3;
                        ref$ObjectRef2.element = this.receivedCloseReason;
                        if (i3 != -1) {
                            ref$ObjectRef3.element = this.streams;
                            this.streams = null;
                            ref$ObjectRef4.element = this.reader;
                            this.reader = null;
                            ref$ObjectRef5.element = this.writer;
                            this.writer = null;
                            this.taskQueue.shutdown();
                        } else {
                            T t8 = ref$ObjectRef.element;
                            if (t8 == 0) {
                                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                            }
                            long cancelAfterCloseMillis = ((Close) t8).getCancelAfterCloseMillis();
                            TaskQueue taskQueue = this.taskQueue;
                            final String str = this.name + " cancel";
                            final boolean z5 = true;
                            taskQueue.schedule(new Task(str, z5) { // from class: okhttp3.internal.ws.RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1
                                @Override // okhttp3.internal.concurrent.Task
                                public long runOnce() {
                                    this.cancel();
                                    return -1L;
                                }
                            }, TimeUnit.MILLISECONDS.toNanos(cancelAfterCloseMillis));
                        }
                    } else if (poll2 == 0) {
                        return false;
                    }
                }
                try {
                    if (poll != null) {
                        e.c(webSocketWriter);
                        webSocketWriter.writePong(poll);
                    } else {
                        T t10 = ref$ObjectRef.element;
                        if (t10 instanceof Message) {
                            if (t10 == 0) {
                                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
                            }
                            Message message = (Message) t10;
                            e.c(webSocketWriter);
                            webSocketWriter.writeMessageFrame(message.getFormatOpcode(), message.getData());
                            synchronized (this) {
                                this.queueSize -= message.getData().size();
                            }
                        } else {
                            if (!(t10 instanceof Close)) {
                                throw new AssertionError();
                            }
                            if (t10 == 0) {
                                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                            }
                            Close close = (Close) t10;
                            e.c(webSocketWriter);
                            webSocketWriter.writeClose(close.getCode(), close.getReason());
                            if (((Streams) ref$ObjectRef3.element) != null) {
                                WebSocketListener webSocketListener = this.listener;
                                int i10 = ref$IntRef.element;
                                String str2 = (String) ref$ObjectRef2.element;
                                e.c(str2);
                                webSocketListener.onClosed(this, i10, str2);
                            }
                        }
                    }
                    Streams streams = (Streams) ref$ObjectRef3.element;
                    if (streams != null) {
                        Util.closeQuietly(streams);
                    }
                    WebSocketReader webSocketReader = (WebSocketReader) ref$ObjectRef4.element;
                    if (webSocketReader != null) {
                        Util.closeQuietly(webSocketReader);
                    }
                    WebSocketWriter webSocketWriter2 = (WebSocketWriter) ref$ObjectRef5.element;
                    if (webSocketWriter2 != null) {
                        Util.closeQuietly(webSocketWriter2);
                    }
                    return true;
                } catch (Throwable th2) {
                    Streams streams2 = (Streams) ref$ObjectRef3.element;
                    if (streams2 != null) {
                        Util.closeQuietly(streams2);
                    }
                    WebSocketReader webSocketReader2 = (WebSocketReader) ref$ObjectRef4.element;
                    if (webSocketReader2 != null) {
                        Util.closeQuietly(webSocketReader2);
                    }
                    WebSocketWriter webSocketWriter3 = (WebSocketWriter) ref$ObjectRef5.element;
                    if (webSocketWriter3 != null) {
                        Util.closeQuietly(webSocketWriter3);
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void writePingFrame$okhttp() {
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                WebSocketWriter webSocketWriter = this.writer;
                if (webSocketWriter != null) {
                    int i3 = this.awaitingPong ? this.sentPingCount : -1;
                    this.sentPingCount++;
                    this.awaitingPong = true;
                    if (i3 != -1) {
                        StringBuilder sb2 = new StringBuilder("sent ping but didn't receive pong within ");
                        sb2.append(this.pingIntervalMillis);
                        sb2.append("ms (after ");
                        failWebSocket(new SocketTimeoutException(a.e(sb2, i3 - 1, " successful ping/pongs)")), null);
                        return;
                    }
                    try {
                        webSocketWriter.writePing(ByteString.EMPTY);
                    } catch (IOException e) {
                        failWebSocket(e, null);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final synchronized boolean close(int i3, String str, long j4) {
        ByteString byteString;
        try {
            WebSocketProtocol.INSTANCE.validateCloseCode(i3);
            if (str != null) {
                ByteString.Companion.getClass();
                byteString = m.c(str);
                if (byteString.size() > 123) {
                    throw new IllegalArgumentException("reason.size() > 123: ".concat(str).toString());
                }
            } else {
                byteString = null;
            }
            if (!this.failed && !this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i3, byteString, j4));
                runWriter();
                return true;
            }
            return false;
        } finally {
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString bytes) throws IOException {
        e.f(bytes, "bytes");
        this.listener.onMessage(this, bytes);
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString bytes) {
        e.f(bytes, "bytes");
        return send(bytes, 2);
    }

    private final synchronized boolean send(ByteString byteString, int i3) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + byteString.size() > MAX_QUEUE_SIZE) {
                close(1001, null);
                return false;
            }
            this.queueSize += byteString.size();
            this.messageAndCloseQueue.add(new Message(i3, byteString));
            runWriter();
            return true;
        }
        return false;
    }
}
