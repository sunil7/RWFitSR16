package okhttp3;

import java.io.IOException;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.internal.authenticator.JavaNetAuthenticator;

/* loaded from: classes2.dex */
public interface Authenticator {
    public static final Companion Companion = new Companion(null);
    public static final Authenticator NONE = new Companion.AuthenticatorNone();
    public static final Authenticator JAVA_NET_AUTHENTICATOR = new JavaNetAuthenticator(null, 1, null);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        public static final class AuthenticatorNone implements Authenticator {
            @Override // okhttp3.Authenticator
            public Request authenticate(Route route, Response response) {
                e.f(response, "response");
                return null;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    Request authenticate(Route route, Response response) throws IOException;
}
