package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response cachedResponse) {
        e.f(call, "call");
        e.f(cachedResponse, "cachedResponse");
    }

    public void cacheHit(Call call, Response response) {
        e.f(call, "call");
        e.f(response, "response");
    }

    public void cacheMiss(Call call) {
        e.f(call, "call");
    }

    public void callEnd(Call call) {
        e.f(call, "call");
    }

    public void callFailed(Call call, IOException ioe) {
        e.f(call, "call");
        e.f(ioe, "ioe");
    }

    public void callStart(Call call) {
        e.f(call, "call");
    }

    public void canceled(Call call) {
        e.f(call, "call");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        e.f(call, "call");
        e.f(inetSocketAddress, "inetSocketAddress");
        e.f(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        e.f(call, "call");
        e.f(inetSocketAddress, "inetSocketAddress");
        e.f(proxy, "proxy");
        e.f(ioe, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        e.f(call, "call");
        e.f(inetSocketAddress, "inetSocketAddress");
        e.f(proxy, "proxy");
    }

    public void connectionAcquired(Call call, Connection connection) {
        e.f(call, "call");
        e.f(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        e.f(call, "call");
        e.f(connection, "connection");
    }

    public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
        e.f(call, "call");
        e.f(domainName, "domainName");
        e.f(inetAddressList, "inetAddressList");
    }

    public void dnsStart(Call call, String domainName) {
        e.f(call, "call");
        e.f(domainName, "domainName");
    }

    public void proxySelectEnd(Call call, HttpUrl url, List<Proxy> proxies) {
        e.f(call, "call");
        e.f(url, "url");
        e.f(proxies, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl url) {
        e.f(call, "call");
        e.f(url, "url");
    }

    public void requestBodyEnd(Call call, long j4) {
        e.f(call, "call");
    }

    public void requestBodyStart(Call call) {
        e.f(call, "call");
    }

    public void requestFailed(Call call, IOException ioe) {
        e.f(call, "call");
        e.f(ioe, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        e.f(call, "call");
        e.f(request, "request");
    }

    public void requestHeadersStart(Call call) {
        e.f(call, "call");
    }

    public void responseBodyEnd(Call call, long j4) {
        e.f(call, "call");
    }

    public void responseBodyStart(Call call) {
        e.f(call, "call");
    }

    public void responseFailed(Call call, IOException ioe) {
        e.f(call, "call");
        e.f(ioe, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        e.f(call, "call");
        e.f(response, "response");
    }

    public void responseHeadersStart(Call call) {
        e.f(call, "call");
    }

    public void satisfactionFailure(Call call, Response response) {
        e.f(call, "call");
        e.f(response, "response");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        e.f(call, "call");
    }

    public void secureConnectStart(Call call) {
        e.f(call, "call");
    }
}
