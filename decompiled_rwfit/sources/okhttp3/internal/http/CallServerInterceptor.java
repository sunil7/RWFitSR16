package okhttp3.internal.http;

import com.google.android.gms.internal.mlkit_vision_common.e6;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.e;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import wh.w;

/* loaded from: classes2.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z5) {
        this.forWebSocket = z5;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response.Builder builder;
        boolean z5;
        e.f(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange$okhttp = realInterceptorChain.getExchange$okhttp();
        e.c(exchange$okhttp);
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RequestBody body = request$okhttp.body();
        long currentTimeMillis = System.currentTimeMillis();
        exchange$okhttp.writeRequestHeaders(request$okhttp);
        boolean z6 = true;
        if (!HttpMethod.permitsRequestBody(request$okhttp.method()) || body == null) {
            exchange$okhttp.noRequestBody();
            builder = null;
        } else {
            if ("100-continue".equalsIgnoreCase(request$okhttp.header("Expect"))) {
                exchange$okhttp.flushRequest();
                builder = exchange$okhttp.readResponseHeaders(true);
                exchange$okhttp.responseHeadersStart();
                z5 = false;
            } else {
                z5 = true;
                builder = null;
            }
            if (builder != null) {
                exchange$okhttp.noRequestBody();
                if (!exchange$okhttp.getConnection$okhttp().isMultiplexed$okhttp()) {
                    exchange$okhttp.noNewExchangesOnConnection();
                }
            } else if (body.isDuplex()) {
                exchange$okhttp.flushRequest();
                body.writeTo(e6.a(exchange$okhttp.createRequestBody(request$okhttp, true)));
            } else {
                w a3 = e6.a(exchange$okhttp.createRequestBody(request$okhttp, false));
                body.writeTo(a3);
                a3.close();
            }
            z6 = z5;
        }
        if (body == null || !body.isDuplex()) {
            exchange$okhttp.finishRequest();
        }
        if (builder == null) {
            builder = exchange$okhttp.readResponseHeaders(false);
            e.c(builder);
            if (z6) {
                exchange$okhttp.responseHeadersStart();
                z6 = false;
            }
        }
        Response build = builder.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int code = build.code();
        if (code == 100) {
            Response.Builder readResponseHeaders = exchange$okhttp.readResponseHeaders(false);
            e.c(readResponseHeaders);
            if (z6) {
                exchange$okhttp.responseHeadersStart();
            }
            build = readResponseHeaders.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = build.code();
        }
        exchange$okhttp.responseHeadersEnd(build);
        Response build2 = (this.forWebSocket && code == 101) ? build.newBuilder().body(Util.EMPTY_RESPONSE).build() : build.newBuilder().body(exchange$okhttp.openResponseBody(build)).build();
        if ("close".equalsIgnoreCase(build2.request().header("Connection")) || "close".equalsIgnoreCase(Response.header$default(build2, "Connection", null, 2, null))) {
            exchange$okhttp.noNewExchangesOnConnection();
        }
        if (code == 204 || code == 205) {
            ResponseBody body2 = build2.body();
            if ((body2 != null ? body2.contentLength() : -1L) > 0) {
                StringBuilder q5 = android.support.v4.media.session.e.q(code, "HTTP ", " had non-zero Content-Length: ");
                ResponseBody body3 = build2.body();
                q5.append(body3 != null ? Long.valueOf(body3.contentLength()) : null);
                throw new ProtocolException(q5.toString());
            }
        }
        return build2;
    }
}
