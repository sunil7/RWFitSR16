package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.EmptyList;
import kotlin.collections.h;
import kotlin.jvm.internal.e;
import kotlin.text.m;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;

/* loaded from: classes2.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i3) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return EmptyList.INSTANCE;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && e.a(list.get(0), Integer.valueOf(i3)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return EmptyList.INSTANCE;
        }
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        Locale locale = Locale.US;
        e.e(locale, "Locale.US");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        e.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (INSTANCE.verifyHostname(lowerCase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (e.a(canonicalHost, HostnamesKt.toCanonicalHost((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate certificate) {
        e.f(certificate, "certificate");
        return h.s(getSubjectAltNames(certificate, 7), getSubjectAltNames(certificate, 2));
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String host, SSLSession session) {
        e.f(host, "host");
        e.f(session, "session");
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            if (certificate != null) {
                return verify(host, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }

    public final boolean verify(String host, X509Certificate certificate) {
        e.f(host, "host");
        e.f(certificate, "certificate");
        return Util.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        int length;
        if (str != null && str.length() != 0 && !m.x(str, ".", false) && !m.e(str, "..") && str2 != null && str2.length() != 0 && !m.x(str2, ".", false) && !m.e(str2, "..")) {
            if (!m.e(str, ".")) {
                str = str.concat(".");
            }
            if (!m.e(str2, ".")) {
                str2 = str2.concat(".");
            }
            Locale locale = Locale.US;
            e.e(locale, "Locale.US");
            if (str2 != null) {
                String lowerCase = str2.toLowerCase(locale);
                e.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!m.c(lowerCase, "*", false)) {
                    return e.a(str, lowerCase);
                }
                if (m.x(lowerCase, "*.", false) && m.i(lowerCase, '*', 1, 4) == -1 && str.length() >= lowerCase.length() && !"*.".equals(lowerCase)) {
                    String substring = lowerCase.substring(1);
                    e.e(substring, "(this as java.lang.String).substring(startIndex)");
                    if (m.e(str, substring) && ((length = str.length() - substring.length()) <= 0 || m.m(str, '.', length - 1, 4) == -1)) {
                        return true;
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return false;
    }
}
