package okhttp3.internal.http;

import com.google.android.gms.internal.mlkit_vision_common.e6;
import java.io.IOException;
import java.util.List;
import kotlin.collections.i;
import kotlin.jvm.internal.e;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import wh.r;

/* loaded from: classes2.dex */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar) {
        e.f(cookieJar, "cookieJar");
        this.cookieJar = cookieJar;
    }

    private final String cookieHeader(List<Cookie> list) {
        StringBuilder sb2 = new StringBuilder();
        int i3 = 0;
        for (Object obj : list) {
            int i10 = i3 + 1;
            if (i3 < 0) {
                i.f();
                throw null;
            }
            Cookie cookie = (Cookie) obj;
            if (i3 > 0) {
                sb2.append("; ");
            }
            sb2.append(cookie.name());
            sb2.append('=');
            sb2.append(cookie.value());
            i3 = i10;
        }
        String sb3 = sb2.toString();
        e.e(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        ResponseBody body;
        e.f(chain, "chain");
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body2 = request.body();
        if (body2 != null) {
            MediaType contentType = body2.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                newBuilder.header("Content-Length", String.valueOf(contentLength));
                newBuilder.removeHeader("Transfer-Encoding");
            } else {
                newBuilder.header("Transfer-Encoding", "chunked");
                newBuilder.removeHeader("Content-Length");
            }
        }
        boolean z5 = true;
        if (request.header("Host") == null) {
            newBuilder.header("Host", Util.toHostHeader$default(request.url(), false, 1, null));
        }
        if (request.header("Connection") == null) {
            newBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null && request.header("Range") == null) {
            newBuilder.header("Accept-Encoding", "gzip");
        } else {
            z5 = false;
        }
        List<Cookie> loadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header("Cookie", cookieHeader(loadForRequest));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Util.userAgent);
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z5 && "gzip".equalsIgnoreCase(Response.header$default(proceed, "Content-Encoding", null, 2, null)) && HttpHeaders.promisesBody(proceed) && (body = proceed.body()) != null) {
            r rVar = new r(body.source());
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            request2.body(new RealResponseBody(Response.header$default(proceed, "Content-Type", null, 2, null), -1L, e6.b(rVar)));
        }
        return request2.build();
    }
}
