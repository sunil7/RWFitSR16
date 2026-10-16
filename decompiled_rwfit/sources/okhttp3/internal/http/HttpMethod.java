package okhttp3.internal.http;

import com.tencent.connect.common.Constants;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean permitsRequestBody(String method) {
        e.f(method, "method");
        return (method.equals(Constants.HTTP_GET) || method.equals("HEAD")) ? false : true;
    }

    public static final boolean requiresRequestBody(String method) {
        e.f(method, "method");
        return method.equals(Constants.HTTP_POST) || method.equals("PUT") || method.equals("PATCH") || method.equals("PROPPATCH") || method.equals("REPORT");
    }

    public final boolean invalidatesCache(String method) {
        e.f(method, "method");
        return method.equals(Constants.HTTP_POST) || method.equals("PATCH") || method.equals("PUT") || method.equals("DELETE") || method.equals("MOVE");
    }

    public final boolean redirectsToGet(String method) {
        e.f(method, "method");
        return !method.equals("PROPFIND");
    }

    public final boolean redirectsWithBody(String method) {
        e.f(method, "method");
        return method.equals("PROPFIND");
    }
}
