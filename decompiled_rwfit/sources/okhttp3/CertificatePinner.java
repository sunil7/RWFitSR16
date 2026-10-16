package okhttp3;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.collections.g;
import kotlin.collections.h;
import kotlin.collections.j;
import kotlin.collections.p;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.i;
import oh.a;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import wh.m;

/* loaded from: classes2.dex */
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final Builder add(String pattern, String... pins) {
            e.f(pattern, "pattern");
            e.f(pins, "pins");
            for (String str : pins) {
                this.pins.add(new Pin(pattern, str));
            }
            return this;
        }

        public final CertificatePinner build() {
            Set singleton;
            Set set;
            List<Pin> list = this.pins;
            e.f(list, "<this>");
            if (list instanceof Collection) {
                List<Pin> list2 = list;
                int size = list2.size();
                if (size == 0) {
                    set = EmptySet.INSTANCE;
                } else if (size != 1) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(p.b(list2.size()));
                    h.u(list, linkedHashSet);
                    set = linkedHashSet;
                } else {
                    singleton = Collections.singleton(list instanceof List ? list.get(0) : list.iterator().next());
                    e.e(singleton, "singleton(element)");
                    set = singleton;
                }
            } else {
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                h.u(list, linkedHashSet2);
                int size2 = linkedHashSet2.size();
                if (size2 == 0) {
                    set = EmptySet.INSTANCE;
                } else if (size2 != 1) {
                    set = linkedHashSet2;
                } else {
                    singleton = Collections.singleton(linkedHashSet2.iterator().next());
                    e.e(singleton, "singleton(element)");
                    set = singleton;
                }
            }
            return new CertificatePinner(set, null, 2, false ? 1 : 0);
        }

        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public final String pin(Certificate certificate) {
            e.f(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
            }
            return "sha256/" + sha256Hash((X509Certificate) certificate).base64();
        }

        public final ByteString sha1Hash(X509Certificate sha1Hash) {
            e.f(sha1Hash, "$this$sha1Hash");
            m mVar = ByteString.Companion;
            PublicKey publicKey = sha1Hash.getPublicKey();
            e.e(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            e.e(encoded, "publicKey.encoded");
            return m.d(mVar, encoded).sha1();
        }

        public final ByteString sha256Hash(X509Certificate sha256Hash) {
            e.f(sha256Hash, "$this$sha256Hash");
            m mVar = ByteString.Companion;
            PublicKey publicKey = sha256Hash.getPublicKey();
            e.e(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            e.e(encoded, "publicKey.encoded");
            return m.d(mVar, encoded).sha256();
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public static final class Pin {
        private final ByteString hash;
        private final String hashAlgorithm;
        private final String pattern;

        public Pin(String pattern, String pin) {
            e.f(pattern, "pattern");
            e.f(pin, "pin");
            if ((!kotlin.text.m.x(pattern, "*.", false) || kotlin.text.m.j(pattern, "*", 1, false, 4) != -1) && ((!kotlin.text.m.x(pattern, "**.", false) || kotlin.text.m.j(pattern, "*", 2, false, 4) != -1) && kotlin.text.m.j(pattern, "*", 0, false, 6) != -1)) {
                throw new IllegalArgumentException("Unexpected pattern: ".concat(pattern).toString());
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(pattern);
            if (canonicalHost == null) {
                throw new IllegalArgumentException("Invalid pattern: ".concat(pattern));
            }
            this.pattern = canonicalHost;
            if (kotlin.text.m.x(pin, "sha1/", false)) {
                this.hashAlgorithm = "sha1";
                m mVar = ByteString.Companion;
                String substring = pin.substring(5);
                e.e(substring, "(this as java.lang.String).substring(startIndex)");
                mVar.getClass();
                ByteString a3 = m.a(substring);
                if (a3 == null) {
                    throw new IllegalArgumentException("Invalid pin hash: ".concat(pin));
                }
                this.hash = a3;
                return;
            }
            if (!kotlin.text.m.x(pin, "sha256/", false)) {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': ".concat(pin));
            }
            this.hashAlgorithm = "sha256";
            m mVar2 = ByteString.Companion;
            String substring2 = pin.substring(7);
            e.e(substring2, "(this as java.lang.String).substring(startIndex)");
            mVar2.getClass();
            ByteString a10 = m.a(substring2);
            if (a10 == null) {
                throw new IllegalArgumentException("Invalid pin hash: ".concat(pin));
            }
            this.hash = a10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return e.a(this.pattern, pin.pattern) && e.a(this.hashAlgorithm, pin.hashAlgorithm) && e.a(this.hash, pin.hash);
        }

        public final ByteString getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return this.hash.hashCode() + l0.d(this.pattern.hashCode() * 31, 31, this.hashAlgorithm);
        }

        public final boolean matchesCertificate(X509Certificate certificate) {
            e.f(certificate, "certificate");
            String str = this.hashAlgorithm;
            int hashCode = str.hashCode();
            if (hashCode == -903629273) {
                if (str.equals("sha256")) {
                    return e.a(this.hash, CertificatePinner.Companion.sha256Hash(certificate));
                }
                return false;
            }
            if (hashCode == 3528965 && str.equals("sha1")) {
                return e.a(this.hash, CertificatePinner.Companion.sha1Hash(certificate));
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x006c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x006b A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean matchesHostname(java.lang.String r11) {
            /*
                r10 = this;
                java.lang.String r0 = "hostname"
                kotlin.jvm.internal.e.f(r11, r0)
                java.lang.String r0 = r10.pattern
                java.lang.String r1 = "**."
                r2 = 0
                boolean r0 = kotlin.text.m.x(r0, r1, r2)
                r1 = 46
                r3 = 1
                if (r0 == 0) goto L3a
                java.lang.String r0 = r10.pattern
                int r0 = r0.length()
                int r6 = r0 + (-3)
                int r0 = r11.length()
                int r0 = r0 - r6
                int r4 = r11.length()
                int r4 = r4 - r6
                java.lang.String r8 = r10.pattern
                r9 = 0
                r5 = 3
                r7 = r11
                boolean r11 = kotlin.text.m.o(r4, r5, r6, r7, r8, r9)
                if (r11 == 0) goto L6c
                if (r0 == 0) goto L6b
                int r0 = r0 - r3
                char r11 = r7.charAt(r0)
                if (r11 != r1) goto L6c
                goto L6b
            L3a:
                r7 = r11
                java.lang.String r11 = r10.pattern
                java.lang.String r0 = "*."
                boolean r11 = kotlin.text.m.x(r11, r0, r2)
                if (r11 == 0) goto L6d
                java.lang.String r11 = r10.pattern
                int r11 = r11.length()
                int r6 = r11 + (-1)
                int r11 = r7.length()
                int r11 = r11 - r6
                int r0 = r7.length()
                int r4 = r0 - r6
                java.lang.String r8 = r10.pattern
                r9 = 0
                r5 = 1
                boolean r0 = kotlin.text.m.o(r4, r5, r6, r7, r8, r9)
                if (r0 == 0) goto L6c
                int r11 = r11 - r3
                r0 = 4
                int r11 = kotlin.text.m.m(r7, r1, r11, r0)
                r0 = -1
                if (r11 != r0) goto L6c
            L6b:
                return r3
            L6c:
                return r2
            L6d:
                java.lang.String r11 = r10.pattern
                boolean r11 = r7.equals(r11)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CertificatePinner.Pin.matchesHostname(java.lang.String):boolean");
        }

        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }
    }

    public CertificatePinner(Set<Pin> pins, CertificateChainCleaner certificateChainCleaner) {
        e.f(pins, "pins");
        this.pins = pins;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    public static final ByteString sha1Hash(X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    public static final ByteString sha256Hash(X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(final String hostname, final List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        e.f(hostname, "hostname");
        e.f(peerCertificates, "peerCertificates");
        check$okhttp(hostname, new a() { // from class: okhttp3.CertificatePinner$check$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // oh.a
            public final List<X509Certificate> invoke() {
                List<Certificate> list;
                CertificateChainCleaner certificateChainCleaner$okhttp = CertificatePinner.this.getCertificateChainCleaner$okhttp();
                if (certificateChainCleaner$okhttp == null || (list = certificateChainCleaner$okhttp.clean(peerCertificates, hostname)) == null) {
                    list = peerCertificates;
                }
                List<Certificate> list2 = list;
                ArrayList arrayList = new ArrayList(j.g(list2));
                for (Certificate certificate : list2) {
                    if (certificate == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    arrayList.add((X509Certificate) certificate);
                }
                return arrayList;
            }
        });
    }

    public final void check$okhttp(String hostname, a cleanedPeerCertificatesFn) {
        e.f(hostname, "hostname");
        e.f(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<Pin> findMatchingPins = findMatchingPins(hostname);
        if (findMatchingPins.isEmpty()) {
            return;
        }
        List<X509Certificate> list = (List) cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : list) {
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (Pin pin : findMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                int hashCode = hashAlgorithm.hashCode();
                if (hashCode != -903629273) {
                    if (hashCode == 3528965 && hashAlgorithm.equals("sha1")) {
                        if (byteString2 == null) {
                            byteString2 = Companion.sha1Hash(x509Certificate);
                        }
                        if (e.a(pin.getHash(), byteString2)) {
                            return;
                        }
                    }
                    throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                }
                if (!hashAlgorithm.equals("sha256")) {
                    throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                }
                if (byteString == null) {
                    byteString = Companion.sha256Hash(x509Certificate);
                }
                if (e.a(pin.getHash(), byteString)) {
                    return;
                }
            }
        }
        StringBuilder sb2 = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : list) {
            sb2.append("\n    ");
            sb2.append(Companion.pin(x509Certificate2));
            sb2.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            e.e(subjectDN, "element.subjectDN");
            sb2.append(subjectDN.getName());
        }
        sb2.append("\n  Pinned certificates for ");
        sb2.append(hostname);
        sb2.append(":");
        for (Pin pin2 : findMatchingPins) {
            sb2.append("\n    ");
            sb2.append(pin2);
        }
        String sb3 = sb2.toString();
        e.e(sb3, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(sb3);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return e.a(certificatePinner.pins, this.pins) && e.a(certificatePinner.certificateChainCleaner, this.certificateChainCleaner);
    }

    public final List<Pin> findMatchingPins(String hostname) {
        e.f(hostname, "hostname");
        Set<Pin> set = this.pins;
        List list = EmptyList.INSTANCE;
        for (Object obj : set) {
            if (((Pin) obj).matchesHostname(hostname)) {
                if (list.isEmpty()) {
                    list = new ArrayList();
                }
                i.b(list).add(obj);
            }
        }
        return list;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int hashCode = (this.pins.hashCode() + 1517) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return hashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        e.f(certificateChainCleaner, "certificateChainCleaner");
        return e.a(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i3, c cVar) {
        this(set, (i3 & 2) != 0 ? null : certificateChainCleaner);
    }

    public final void check(String hostname, Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        e.f(hostname, "hostname");
        e.f(peerCertificates, "peerCertificates");
        check(hostname, g.g(peerCertificates));
    }
}
