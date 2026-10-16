package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.e;
import oh.l;
import okhttp3.Interceptor;

/* loaded from: classes2.dex */
public interface Interceptor {
    public static final Companion Companion = Companion.$$INSTANCE;

    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        Connection connection();

        Response proceed(Request request) throws IOException;

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int i3, TimeUnit timeUnit);

        Chain withReadTimeout(int i3, TimeUnit timeUnit);

        Chain withWriteTimeout(int i3, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final Interceptor invoke(final l block) {
            e.f(block, "block");
            return new Interceptor() { // from class: okhttp3.Interceptor$Companion$invoke$1
                @Override // okhttp3.Interceptor
                public final Response intercept(Interceptor.Chain it) {
                    e.f(it, "it");
                    return (Response) l.this.invoke(it);
                }
            };
        }
    }

    Response intercept(Chain chain) throws IOException;
}
