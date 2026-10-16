package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.g;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public interface Dns {
    public static final Companion Companion = new Companion(null);
    public static final Dns SYSTEM = new Companion.DnsSystem();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        public static final class DnsSystem implements Dns {
            @Override // okhttp3.Dns
            public List<InetAddress> lookup(String hostname) {
                e.f(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    e.e(allByName, "InetAddress.getAllByName(hostname)");
                    return g.g(allByName);
                } catch (NullPointerException e) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostname));
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
