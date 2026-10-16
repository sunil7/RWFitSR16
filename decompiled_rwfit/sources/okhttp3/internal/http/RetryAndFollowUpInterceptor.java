package okhttp3.internal.http;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.mlkit.common.MlKitException;
import com.tencent.connect.common.Constants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.EmptyList;
import kotlin.collections.h;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;

/* loaded from: classes2.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public RetryAndFollowUpInterceptor(OkHttpClient client) {
        e.f(client, "client");
        this.client = client;
    }

    private final Request buildRedirectRequest(Response response, String str) {
        String header$default;
        HttpUrl resolve;
        if (!this.client.followRedirects() || (header$default = Response.header$default(response, "Location", null, 2, null)) == null || (resolve = response.request().url().resolve(header$default)) == null) {
            return null;
        }
        if (!e.a(resolve.scheme(), response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(str)) {
            int code = response.code();
            HttpMethod httpMethod = HttpMethod.INSTANCE;
            boolean z5 = httpMethod.redirectsWithBody(str) || code == 308 || code == 307;
            if (!httpMethod.redirectsToGet(str) || code == 308 || code == 307) {
                newBuilder.method(str, z5 ? response.request().body() : null);
            } else {
                newBuilder.method(Constants.HTTP_GET, null);
            }
            if (!z5) {
                newBuilder.removeHeader("Transfer-Encoding");
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor(response.request().url(), resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    private final Request followUpRequest(Response response, Exchange exchange) throws IOException {
        RealConnection connection$okhttp;
        Route route = (exchange == null || (connection$okhttp = exchange.getConnection$okhttp()) == null) ? null : connection$okhttp.route();
        int code = response.code();
        String method = response.request().method();
        if (code != 307 && code != 308) {
            if (code == 401) {
                return this.client.authenticator().authenticate(route, response);
            }
            if (code == 421) {
                RequestBody body = response.request().body();
                if ((body != null && body.isOneShot()) || exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                    return null;
                }
                exchange.getConnection$okhttp().noCoalescedConnections$okhttp();
                return response.request();
            }
            if (code == 503) {
                Response priorResponse = response.priorResponse();
                if ((priorResponse == null || priorResponse.code() != 503) && retryAfter(response, SubsamplingScaleImageView.TILE_SIZE_AUTO) == 0) {
                    return response.request();
                }
                return null;
            }
            if (code == 407) {
                e.c(route);
                if (route.proxy().type() == Proxy.Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (code == 408) {
                if (!this.client.retryOnConnectionFailure()) {
                    return null;
                }
                RequestBody body2 = response.request().body();
                if (body2 != null && body2.isOneShot()) {
                    return null;
                }
                Response priorResponse2 = response.priorResponse();
                if ((priorResponse2 == null || priorResponse2.code() != 408) && retryAfter(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            }
            switch (code) {
                case 300:
                case MlKitException.LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE /* 301 */:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return buildRedirectRequest(response, method);
    }

    private final boolean isRecoverable(IOException iOException, boolean z5) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z5 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean recover(IOException iOException, RealCall realCall, Request request, boolean z5) {
        if (this.client.retryOnConnectionFailure()) {
            return !(z5 && requestIsOneShot(iOException, request)) && isRecoverable(iOException, z5) && realCall.retryAfterFailure();
        }
        return false;
    }

    private final boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody body = request.body();
        return (body != null && body.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private final int retryAfter(Response response, int i3) {
        String header$default = Response.header$default(response, "Retry-After", null, 2, null);
        if (header$default == null) {
            return i3;
        }
        if (!new Regex("\\d+").matches(header$default)) {
            return SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }
        Integer valueOf = Integer.valueOf(header$default);
        e.e(valueOf, "Integer.valueOf(header)");
        return valueOf.intValue();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Exchange interceptorScopedExchange$okhttp;
        Request followUpRequest;
        e.f(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RealCall call$okhttp = realInterceptorChain.getCall$okhttp();
        List list = EmptyList.INSTANCE;
        boolean z5 = true;
        int i3 = 0;
        Response response = null;
        while (true) {
            call$okhttp.enterNetworkInterceptorExchange(request$okhttp, z5);
            try {
                if (call$okhttp.isCanceled()) {
                    throw new IOException("Canceled");
                }
                try {
                    try {
                        Response proceed = realInterceptorChain.proceed(request$okhttp);
                        if (response != null) {
                            proceed = proceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                        }
                        response = proceed;
                        interceptorScopedExchange$okhttp = call$okhttp.getInterceptorScopedExchange$okhttp();
                        followUpRequest = followUpRequest(response, interceptorScopedExchange$okhttp);
                    } catch (IOException e) {
                        if (!recover(e, call$okhttp, request$okhttp, !(e instanceof ConnectionShutdownException))) {
                            throw Util.withSuppressed(e, list);
                        }
                        list = h.r(list, e);
                        call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                        z5 = false;
                    }
                } catch (RouteException e10) {
                    if (!recover(e10.getLastConnectException(), call$okhttp, request$okhttp, false)) {
                        throw Util.withSuppressed(e10.getFirstConnectException(), list);
                    }
                    list = h.r(list, e10.getFirstConnectException());
                    call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                    z5 = false;
                }
                if (followUpRequest == null) {
                    if (interceptorScopedExchange$okhttp != null && interceptorScopedExchange$okhttp.isDuplex$okhttp()) {
                        call$okhttp.timeoutEarlyExit();
                    }
                    call$okhttp.exitNetworkInterceptorExchange$okhttp(false);
                    return response;
                }
                RequestBody body = followUpRequest.body();
                if (body != null && body.isOneShot()) {
                    call$okhttp.exitNetworkInterceptorExchange$okhttp(false);
                    return response;
                }
                ResponseBody body2 = response.body();
                if (body2 != null) {
                    Util.closeQuietly(body2);
                }
                i3++;
                if (i3 > 20) {
                    throw new ProtocolException("Too many follow-up requests: " + i3);
                }
                call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                request$okhttp = followUpRequest;
                z5 = true;
            } catch (Throwable th2) {
                call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                throw th2;
            }
        }
    }
}
