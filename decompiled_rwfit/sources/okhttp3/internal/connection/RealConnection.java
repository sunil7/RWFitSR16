package okhttp3.internal.connection;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_common.e6;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.collections.j;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.h;
import oh.a;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import wh.f0;
import wh.k;
import wh.l;

/* loaded from: classes2.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection {
    public static final Companion Companion = new Companion(null);
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private int allocationLimit;
    private final List<Reference<RealCall>> calls;
    private final RealConnectionPool connectionPool;
    private Handshake handshake;
    private Http2Connection http2Connection;
    private long idleAtNs;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;
    private Protocol protocol;
    private Socket rawSocket;
    private int refusedStreamCount;
    private final Route route;
    private int routeFailureCount;
    private k sink;
    private Socket socket;
    private l source;
    private int successCount;

    public static final class Companion {
        private Companion() {
        }

        public final RealConnection newTestConnection(RealConnectionPool connectionPool, Route route, Socket socket, long j4) {
            e.f(connectionPool, "connectionPool");
            e.f(route, "route");
            e.f(socket, "socket");
            RealConnection realConnection = new RealConnection(connectionPool, route);
            realConnection.socket = socket;
            realConnection.setIdleAtNs$okhttp(j4);
            return realConnection;
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
        }
    }

    public RealConnection(RealConnectionPool connectionPool, Route route) {
        e.f(connectionPool, "connectionPool");
        e.f(route, "route");
        this.connectionPool = connectionPool;
        this.route = route;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = Format.OFFSET_SAMPLE_RELATIVE;
    }

    private final boolean certificateSupportHost(HttpUrl httpUrl, Handshake handshake) {
        List<Certificate> peerCertificates = handshake.peerCertificates();
        if (!peerCertificates.isEmpty()) {
            OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.INSTANCE;
            String host = httpUrl.host();
            Certificate certificate = peerCertificates.get(0);
            if (certificate == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            if (okHostnameVerifier.verify(host, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    private final void connectSocket(int i3, int i10, Call call, EventListener eventListener) throws IOException {
        Socket socket;
        int i11;
        Proxy proxy = this.route.proxy();
        Address address = this.route.address();
        Proxy.Type type = proxy.type();
        if (type != null && ((i11 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) == 1 || i11 == 2)) {
            socket = address.socketFactory().createSocket();
            e.c(socket);
        } else {
            socket = new Socket(proxy);
        }
        this.rawSocket = socket;
        eventListener.connectStart(call, this.route.socketAddress(), proxy);
        socket.setSoTimeout(i10);
        try {
            Platform.Companion.get().connectSocket(socket, this.route.socketAddress(), i3);
            try {
                this.source = e6.b(e6.e(socket));
                this.sink = e6.a(e6.d(socket));
            } catch (NullPointerException e) {
                if (e.a(e.getMessage(), NPE_THROW_WITH_NULL)) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e10) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.route.socketAddress());
            connectException.initCause(e10);
            throw connectException;
        }
    }

    private final void connectTls(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        final Address address = this.route.address();
        SSLSocketFactory sslSocketFactory = address.sslSocketFactory();
        SSLSocket sSLSocket = null;
        try {
            e.c(sslSocketFactory);
            Socket createSocket = sslSocketFactory.createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
            if (createSocket == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            SSLSocket sSLSocket2 = (SSLSocket) createSocket;
            try {
                ConnectionSpec configureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket2);
                if (configureSecureSocket.supportsTlsExtensions()) {
                    Platform.Companion.get().configureTlsExtensions(sSLSocket2, address.url().host(), address.protocols());
                }
                sSLSocket2.startHandshake();
                SSLSession sslSocketSession = sSLSocket2.getSession();
                Handshake.Companion companion = Handshake.Companion;
                e.e(sslSocketSession, "sslSocketSession");
                final Handshake handshake = companion.get(sslSocketSession);
                HostnameVerifier hostnameVerifier = address.hostnameVerifier();
                e.c(hostnameVerifier);
                if (hostnameVerifier.verify(address.url().host(), sslSocketSession)) {
                    final CertificatePinner certificatePinner = address.certificatePinner();
                    e.c(certificatePinner);
                    this.handshake = new Handshake(handshake.tlsVersion(), handshake.cipherSuite(), handshake.localCertificates(), new a() { // from class: okhttp3.internal.connection.RealConnection$connectTls$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // oh.a
                        public final List<Certificate> invoke() {
                            CertificateChainCleaner certificateChainCleaner$okhttp = CertificatePinner.this.getCertificateChainCleaner$okhttp();
                            e.c(certificateChainCleaner$okhttp);
                            return certificateChainCleaner$okhttp.clean(handshake.peerCertificates(), address.url().host());
                        }
                    });
                    certificatePinner.check$okhttp(address.url().host(), new a() { // from class: okhttp3.internal.connection.RealConnection$connectTls$2
                        {
                            super(0);
                        }

                        @Override // oh.a
                        public final List<X509Certificate> invoke() {
                            Handshake handshake2;
                            handshake2 = RealConnection.this.handshake;
                            e.c(handshake2);
                            List<Certificate> peerCertificates = handshake2.peerCertificates();
                            ArrayList arrayList = new ArrayList(j.g(peerCertificates));
                            for (Certificate certificate : peerCertificates) {
                                if (certificate == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                                }
                                arrayList.add((X509Certificate) certificate);
                            }
                            return arrayList;
                        }
                    });
                    String selectedProtocol = configureSecureSocket.supportsTlsExtensions() ? Platform.Companion.get().getSelectedProtocol(sSLSocket2) : null;
                    this.socket = sSLSocket2;
                    this.source = e6.b(e6.e(sSLSocket2));
                    this.sink = e6.a(e6.d(sSLSocket2));
                    this.protocol = selectedProtocol != null ? Protocol.Companion.get(selectedProtocol) : Protocol.HTTP_1_1;
                    Platform.Companion.get().afterHandshake(sSLSocket2);
                    return;
                }
                List<Certificate> peerCertificates = handshake.peerCertificates();
                if (peerCertificates.isEmpty()) {
                    throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
                }
                Certificate certificate = peerCertificates.get(0);
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                X509Certificate x509Certificate = (X509Certificate) certificate;
                StringBuilder sb2 = new StringBuilder("\n              |Hostname ");
                sb2.append(address.url().host());
                sb2.append(" not verified:\n              |    certificate: ");
                sb2.append(CertificatePinner.Companion.pin(x509Certificate));
                sb2.append("\n              |    DN: ");
                Principal subjectDN = x509Certificate.getSubjectDN();
                e.e(subjectDN, "cert.subjectDN");
                sb2.append(subjectDN.getName());
                sb2.append("\n              |    subjectAltNames: ");
                sb2.append(OkHostnameVerifier.INSTANCE.allSubjectAltNames(x509Certificate));
                sb2.append("\n              ");
                throw new SSLPeerUnverifiedException(h.b(sb2.toString()));
            } catch (Throwable th2) {
                th = th2;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    Platform.Companion.get().afterHandshake(sSLSocket);
                }
                if (sSLSocket != null) {
                    Util.closeQuietly((Socket) sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private final void connectTunnel(int i3, int i10, int i11, Call call, EventListener eventListener) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        for (int i12 = 0; i12 < 21; i12++) {
            connectSocket(i3, i10, call, eventListener);
            createTunnelRequest = createTunnel(i10, i11, createTunnelRequest, url);
            if (createTunnelRequest == null) {
                return;
            }
            Socket socket = this.rawSocket;
            if (socket != null) {
                Util.closeQuietly(socket);
            }
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
            eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), null);
        }
    }

    private final Request createTunnel(int i3, int i10, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + Util.toHostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            l lVar = this.source;
            e.c(lVar);
            k kVar = this.sink;
            e.c(kVar);
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, this, lVar, kVar);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            lVar.timeout().timeout(i3, timeUnit);
            kVar.timeout().timeout(i10, timeUnit);
            http1ExchangeCodec.writeRequest(request.headers(), str);
            http1ExchangeCodec.finishRequest();
            Response.Builder readResponseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            e.c(readResponseHeaders);
            Response build = readResponseHeaders.request(request).build();
            http1ExchangeCodec.skipConnectBody(build);
            int code = build.code();
            if (code == 200) {
                if (lVar.m().D() && kVar.m().D()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (code != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + build.code());
            }
            Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
            if (authenticate == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(Response.header$default(build, "Connection", null, 2, null))) {
                return authenticate;
            }
            request = authenticate;
        }
    }

    private final Request createTunnelRequest() throws IOException {
        Request build = new Request.Builder().url(this.route.address().url()).method("CONNECT", null).header("Host", Util.toHostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Util.userAgent).build();
        Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        return authenticate != null ? authenticate : build;
    }

    private final void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i3, Call call, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            connectTls(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.handshake);
            if (this.protocol == Protocol.HTTP_2) {
                startHttp2(i3);
                return;
            }
            return;
        }
        List<Protocol> protocols = this.route.address().protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!protocols.contains(protocol)) {
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
        } else {
            this.socket = this.rawSocket;
            this.protocol = protocol;
            startHttp2(i3);
        }
    }

    private final boolean routeMatchesAny(List<Route> list) {
        List<Route> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        for (Route route : list2) {
            Proxy.Type type = route.proxy().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && this.route.proxy().type() == type2 && e.a(this.route.socketAddress(), route.socketAddress())) {
                return true;
            }
        }
        return false;
    }

    private final void startHttp2(int i3) throws IOException {
        Socket socket = this.socket;
        e.c(socket);
        l lVar = this.source;
        e.c(lVar);
        k kVar = this.sink;
        e.c(kVar);
        socket.setSoTimeout(0);
        Http2Connection build = new Http2Connection.Builder(true, TaskRunner.INSTANCE).socket(socket, this.route.address().url().host(), lVar, kVar).listener(this).pingIntervalMillis(i3).build();
        this.http2Connection = build;
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(build, false, null, 3, null);
    }

    private final boolean supportsUrl(HttpUrl httpUrl) {
        Handshake handshake;
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
        HttpUrl url = this.route.address().url();
        if (httpUrl.port() != url.port()) {
            return false;
        }
        if (e.a(httpUrl.host(), url.host())) {
            return true;
        }
        if (!this.noCoalescedConnections && (handshake = this.handshake) != null) {
            e.c(handshake);
            if (certificateSupportHost(httpUrl, handshake)) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
        Socket socket = this.rawSocket;
        if (socket != null) {
            Util.closeQuietly(socket);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0140 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void connect(int r15, int r16, int r17, int r18, boolean r19, okhttp3.Call r20, okhttp3.EventListener r21) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    public final void connectFailed$okhttp(OkHttpClient client, Route failedRoute, IOException failure) {
        e.f(client, "client");
        e.f(failedRoute, "failedRoute");
        e.f(failure, "failure");
        if (failedRoute.proxy().type() != Proxy.Type.DIRECT) {
            Address address = failedRoute.address();
            address.proxySelector().connectFailed(address.url().uri(), failedRoute.proxy().address(), failure);
        }
        client.getRouteDatabase().failed(failedRoute);
    }

    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final long getIdleAtNs$okhttp() {
        return this.idleAtNs;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    @Override // okhttp3.Connection
    public Handshake handshake() {
        return this.handshake;
    }

    public final synchronized void incrementSuccessCount$okhttp() {
        this.successCount++;
    }

    public final boolean isEligible$okhttp(Address address, List<Route> list) {
        e.f(address, "address");
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
        if (this.calls.size() >= this.allocationLimit || this.noNewExchanges || !this.route.address().equalsNonHost$okhttp(address)) {
            return false;
        }
        if (e.a(address.url().host(), route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || list == null || !routeMatchesAny(list) || address.hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            CertificatePinner certificatePinner = address.certificatePinner();
            e.c(certificatePinner);
            String host = address.url().host();
            Handshake handshake = handshake();
            e.c(handshake);
            certificatePinner.check(host, handshake.peerCertificates());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean isHealthy(boolean z5) {
        long j4;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
        long nanoTime = System.nanoTime();
        Socket socket = this.rawSocket;
        e.c(socket);
        Socket socket2 = this.socket;
        e.c(socket2);
        l lVar = this.source;
        e.c(lVar);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return http2Connection.isHealthy(nanoTime);
        }
        synchronized (this) {
            j4 = nanoTime - this.idleAtNs;
        }
        if (j4 < IDLE_CONNECTION_HEALTHY_NS || !z5) {
            return true;
        }
        return Util.isHealthy(socket2, lVar);
    }

    public final boolean isMultiplexed$okhttp() {
        return this.http2Connection != null;
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient client, RealInterceptorChain chain) throws SocketException {
        e.f(client, "client");
        e.f(chain, "chain");
        Socket socket = this.socket;
        e.c(socket);
        l lVar = this.source;
        e.c(lVar);
        k kVar = this.sink;
        e.c(kVar);
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(client, this, chain, http2Connection);
        }
        socket.setSoTimeout(chain.readTimeoutMillis());
        f0 timeout = lVar.timeout();
        long readTimeoutMillis$okhttp = chain.getReadTimeoutMillis$okhttp();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(readTimeoutMillis$okhttp, timeUnit);
        kVar.timeout().timeout(chain.getWriteTimeoutMillis$okhttp(), timeUnit);
        return new Http1ExchangeCodec(client, this, lVar, kVar);
    }

    public final RealWebSocket.Streams newWebSocketStreams$okhttp(final Exchange exchange) throws SocketException {
        e.f(exchange, "exchange");
        Socket socket = this.socket;
        e.c(socket);
        final l lVar = this.source;
        e.c(lVar);
        final k kVar = this.sink;
        e.c(kVar);
        socket.setSoTimeout(0);
        noNewExchanges$okhttp();
        final boolean z5 = true;
        return new RealWebSocket.Streams(z5, lVar, kVar) { // from class: okhttp3.internal.connection.RealConnection$newWebSocketStreams$1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Exchange.this.bodyComplete(-1L, true, true, null);
            }
        };
    }

    public final synchronized void noCoalescedConnections$okhttp() {
        this.noCoalescedConnections = true;
    }

    public final synchronized void noNewExchanges$okhttp() {
        this.noNewExchanges = true;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public synchronized void onSettings(Http2Connection connection, Settings settings) {
        e.f(connection, "connection");
        e.f(settings, "settings");
        this.allocationLimit = settings.getMaxConcurrentStreams();
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream stream) throws IOException {
        e.f(stream, "stream");
        stream.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        Protocol protocol = this.protocol;
        e.c(protocol);
        return protocol;
    }

    @Override // okhttp3.Connection
    public Route route() {
        return this.route;
    }

    public final void setIdleAtNs$okhttp(long j4) {
        this.idleAtNs = j4;
    }

    public final void setNoNewExchanges(boolean z5) {
        this.noNewExchanges = z5;
    }

    public final void setRouteFailureCount$okhttp(int i3) {
        this.routeFailureCount = i3;
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        Socket socket = this.socket;
        e.c(socket);
        return socket;
    }

    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder("Connection{");
        sb2.append(this.route.address().url().host());
        sb2.append(':');
        sb2.append(this.route.address().url().port());
        sb2.append(", proxy=");
        sb2.append(this.route.proxy());
        sb2.append(" hostAddress=");
        sb2.append(this.route.socketAddress());
        sb2.append(" cipherSuite=");
        Handshake handshake = this.handshake;
        if (handshake == null || (obj = handshake.cipherSuite()) == null) {
            obj = "none";
        }
        sb2.append(obj);
        sb2.append(" protocol=");
        sb2.append(this.protocol);
        sb2.append('}');
        return sb2.toString();
    }

    public final synchronized void trackFailure$okhttp(RealCall call, IOException iOException) {
        try {
            e.f(call, "call");
            if (iOException instanceof StreamResetException) {
                if (((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                    int i3 = this.refusedStreamCount + 1;
                    this.refusedStreamCount = i3;
                    if (i3 > 1) {
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                    }
                } else if (((StreamResetException) iOException).errorCode != ErrorCode.CANCEL || !call.isCanceled()) {
                    this.noNewExchanges = true;
                    this.routeFailureCount++;
                }
            } else if (!isMultiplexed$okhttp() || (iOException instanceof ConnectionShutdownException)) {
                this.noNewExchanges = true;
                if (this.successCount == 0) {
                    if (iOException != null) {
                        connectFailed$okhttp(call.getClient(), this.route, iOException);
                    }
                    this.routeFailureCount++;
                }
            }
        } finally {
        }
    }
}
