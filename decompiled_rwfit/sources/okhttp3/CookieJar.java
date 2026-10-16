package okhttp3;

import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public interface CookieJar {
    public static final Companion Companion = new Companion(null);
    public static final CookieJar NO_COOKIES = new Companion.NoCookies();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        public static final class NoCookies implements CookieJar {
            @Override // okhttp3.CookieJar
            public List<Cookie> loadForRequest(HttpUrl url) {
                e.f(url, "url");
                return EmptyList.INSTANCE;
            }

            @Override // okhttp3.CookieJar
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                e.f(url, "url");
                e.f(cookies, "cookies");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
