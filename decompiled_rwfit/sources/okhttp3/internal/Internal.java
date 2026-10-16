package okhttp3.internal;

import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.e;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String line) {
        e.f(builder, "builder");
        e.f(line, "line");
        return builder.addLenient$okhttp(line);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sslSocket, boolean z5) {
        e.f(connectionSpec, "connectionSpec");
        e.f(sslSocket, "sslSocket");
        connectionSpec.apply$okhttp(sslSocket, z5);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        e.f(cache, "cache");
        e.f(request, "request");
        return cache.get$okhttp(request);
    }

    public static final String cookieToString(Cookie cookie, boolean z5) {
        e.f(cookie, "cookie");
        return cookie.toString$okhttp(z5);
    }

    public static final Cookie parseCookie(long j4, HttpUrl url, String setCookie) {
        e.f(url, "url");
        e.f(setCookie, "setCookie");
        return Cookie.Companion.parse$okhttp(j4, url, setCookie);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String name, String value) {
        e.f(builder, "builder");
        e.f(name, "name");
        e.f(value, "value");
        return builder.addLenient$okhttp(name, value);
    }
}
