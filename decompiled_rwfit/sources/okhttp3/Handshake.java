package okhttp3;

import eh.b;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.collections.EmptyList;
import kotlin.collections.j;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import oh.a;
import okhttp3.internal.Util;

/* loaded from: classes2.dex */
public final class Handshake {
    public static final Companion Companion = new Companion(null);
    private final CipherSuite cipherSuite;
    private final List<Certificate> localCertificates;
    private final b peerCertificates$delegate;
    private final TlsVersion tlsVersion;

    public static final class Companion {
        private Companion() {
        }

        private final List<Certificate> toImmutableList(Certificate[] certificateArr) {
            return certificateArr != null ? Util.immutableListOf((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length)) : EmptyList.INSTANCE;
        }

        /* renamed from: -deprecated_get, reason: not valid java name */
        public final Handshake m131deprecated_get(SSLSession sslSession) throws IOException {
            e.f(sslSession, "sslSession");
            return get(sslSession);
        }

        public final Handshake get(SSLSession handshake) throws IOException {
            final List<Certificate> list;
            e.f(handshake, "$this$handshake");
            String cipherSuite = handshake.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null");
            }
            int hashCode = cipherSuite.hashCode();
            if (hashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : hashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == ".concat(cipherSuite));
            }
            CipherSuite forJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
            String protocol = handshake.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            }
            if ("NONE".equals(protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion forJavaName2 = TlsVersion.Companion.forJavaName(protocol);
            try {
                list = toImmutableList(handshake.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                list = EmptyList.INSTANCE;
            }
            return new Handshake(forJavaName2, forJavaName, toImmutableList(handshake.getLocalCertificates()), new a() { // from class: okhttp3.Handshake$Companion$handshake$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // oh.a
                public final List<Certificate> invoke() {
                    return list;
                }
            });
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }

        public final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> peerCertificates, List<? extends Certificate> localCertificates) {
            e.f(tlsVersion, "tlsVersion");
            e.f(cipherSuite, "cipherSuite");
            e.f(peerCertificates, "peerCertificates");
            e.f(localCertificates, "localCertificates");
            final List immutableList = Util.toImmutableList(peerCertificates);
            return new Handshake(tlsVersion, cipherSuite, Util.toImmutableList(localCertificates), new a() { // from class: okhttp3.Handshake$Companion$get$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // oh.a
                public final List<Certificate> invoke() {
                    return immutableList;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> localCertificates, final a peerCertificatesFn) {
        e.f(tlsVersion, "tlsVersion");
        e.f(cipherSuite, "cipherSuite");
        e.f(localCertificates, "localCertificates");
        e.f(peerCertificatesFn, "peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = localCertificates;
        this.peerCertificates$delegate = kotlin.a.b(new a() { // from class: okhttp3.Handshake$peerCertificates$2
            {
                super(0);
            }

            @Override // oh.a
            public final List<Certificate> invoke() {
                try {
                    return (List) a.this.invoke();
                } catch (SSLPeerUnverifiedException unused) {
                    return EmptyList.INSTANCE;
                }
            }
        });
    }

    public static final Handshake get(SSLSession sSLSession) throws IOException {
        return Companion.get(sSLSession);
    }

    private final String getName(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        e.e(type, "type");
        return type;
    }

    /* renamed from: -deprecated_cipherSuite, reason: not valid java name */
    public final CipherSuite m125deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    /* renamed from: -deprecated_localCertificates, reason: not valid java name */
    public final List<Certificate> m126deprecated_localCertificates() {
        return this.localCertificates;
    }

    /* renamed from: -deprecated_localPrincipal, reason: not valid java name */
    public final Principal m127deprecated_localPrincipal() {
        return localPrincipal();
    }

    /* renamed from: -deprecated_peerCertificates, reason: not valid java name */
    public final List<Certificate> m128deprecated_peerCertificates() {
        return peerCertificates();
    }

    /* renamed from: -deprecated_peerPrincipal, reason: not valid java name */
    public final Principal m129deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    /* renamed from: -deprecated_tlsVersion, reason: not valid java name */
    public final TlsVersion m130deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return handshake.tlsVersion == this.tlsVersion && e.a(handshake.cipherSuite, this.cipherSuite) && e.a(handshake.peerCertificates(), peerCertificates()) && e.a(handshake.localCertificates, this.localCertificates);
    }

    public int hashCode() {
        return this.localCertificates.hashCode() + ((peerCertificates().hashCode() + ((this.cipherSuite.hashCode() + ((this.tlsVersion.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    public final Principal localPrincipal() {
        List<Certificate> list = this.localCertificates;
        e.f(list, "<this>");
        Certificate certificate = list.isEmpty() ? null : list.get(0);
        if (!(certificate instanceof X509Certificate)) {
            certificate = null;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    public final List<Certificate> peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    public final Principal peerPrincipal() {
        List<Certificate> peerCertificates = peerCertificates();
        e.f(peerCertificates, "<this>");
        Certificate certificate = peerCertificates.isEmpty() ? null : peerCertificates.get(0);
        if (!(certificate instanceof X509Certificate)) {
            certificate = null;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public String toString() {
        List<Certificate> peerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(j.g(peerCertificates));
        Iterator<T> it = peerCertificates.iterator();
        while (it.hasNext()) {
            arrayList.add(getName((Certificate) it.next()));
        }
        String obj = arrayList.toString();
        StringBuilder sb2 = new StringBuilder("Handshake{tlsVersion=");
        sb2.append(this.tlsVersion);
        sb2.append(" cipherSuite=");
        sb2.append(this.cipherSuite);
        sb2.append(" peerCertificates=");
        sb2.append(obj);
        sb2.append(" localCertificates=");
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(j.g(list));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(getName((Certificate) it2.next()));
        }
        sb2.append(arrayList2);
        sb2.append('}');
        return sb2.toString();
    }

    public static final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, List<? extends Certificate> list2) {
        return Companion.get(tlsVersion, cipherSuite, list, list2);
    }
}
