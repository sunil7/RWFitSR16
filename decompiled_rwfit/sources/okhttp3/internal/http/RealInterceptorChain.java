package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.e;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;

/* loaded from: classes2.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;
    private final Request request;
    private final int writeTimeoutMillis;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(RealCall call, List<? extends Interceptor> interceptors, int i3, Exchange exchange, Request request, int i10, int i11, int i12) {
        e.f(call, "call");
        e.f(interceptors, "interceptors");
        e.f(request, "request");
        this.call = call;
        this.interceptors = interceptors;
        this.index = i3;
        this.exchange = exchange;
        this.request = request;
        this.connectTimeoutMillis = i10;
        this.readTimeoutMillis = i11;
        this.writeTimeoutMillis = i12;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i3, Exchange exchange, Request request, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i3 = realInterceptorChain.index;
        }
        if ((i13 & 2) != 0) {
            exchange = realInterceptorChain.exchange;
        }
        if ((i13 & 4) != 0) {
            request = realInterceptorChain.request;
        }
        if ((i13 & 8) != 0) {
            i10 = realInterceptorChain.connectTimeoutMillis;
        }
        if ((i13 & 16) != 0) {
            i11 = realInterceptorChain.readTimeoutMillis;
        }
        if ((i13 & 32) != 0) {
            i12 = realInterceptorChain.writeTimeoutMillis;
        }
        int i14 = i11;
        int i15 = i12;
        return realInterceptorChain.copy$okhttp(i3, exchange, request, i10, i14, i15);
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange.getConnection$okhttp();
        }
        return null;
    }

    public final RealInterceptorChain copy$okhttp(int i3, Exchange exchange, Request request, int i10, int i11, int i12) {
        e.f(request, "request");
        return new RealInterceptorChain(this.call, this.interceptors, i3, exchange, request, i10, i11, i12);
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request request) throws IOException {
        e.f(request, "request");
        if (!(this.index < this.interceptors.size())) {
            throw new IllegalStateException("Check failed.");
        }
        this.calls++;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            if (!exchange.getFinder$okhttp().sameHostAndPort(request.url())) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
            }
            if (!(this.calls == 1)) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
            }
        }
        RealInterceptorChain copy$okhttp$default = copy$okhttp$default(this, this.index + 1, null, request, 0, 0, 0, 58, null);
        Interceptor interceptor = this.interceptors.get(this.index);
        Response intercept = interceptor.intercept(copy$okhttp$default);
        if (intercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (this.exchange != null) {
            if (!(this.index + 1 >= this.interceptors.size() || copy$okhttp$default.calls == 1)) {
                throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
            }
        }
        if (intercept.body() != null) {
            return intercept;
        }
        throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i3, TimeUnit unit) {
        e.f(unit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, Util.checkDuration("connectTimeout", i3, unit), 0, 0, 55, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i3, TimeUnit unit) {
        e.f(unit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, Util.checkDuration("readTimeout", i3, unit), 0, 47, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i3, TimeUnit unit) {
        e.f(unit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, 0, Util.checkDuration("writeTimeout", i3, unit), 31, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
