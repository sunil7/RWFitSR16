package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.internal.platform.Platform;

/* loaded from: classes2.dex */
public abstract class CertificateChainCleaner {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public final CertificateChainCleaner get(X509TrustManager trustManager) {
            e.f(trustManager, "trustManager");
            return Platform.Companion.get().buildCertificateChainCleaner(trustManager);
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }

        public final CertificateChainCleaner get(X509Certificate... caCerts) {
            e.f(caCerts, "caCerts");
            return new BasicCertificateChainCleaner(new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(caCerts, caCerts.length)));
        }
    }

    public abstract List<Certificate> clean(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException;
}
