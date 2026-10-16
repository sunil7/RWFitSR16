package okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.e;
import kotlin.text.a;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.ByteString;
import wh.j;
import wh.m;

/* loaded from: classes2.dex */
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS;
    private static final ByteString TOKEN_DELIMITERS;

    static {
        ByteString.Companion.getClass();
        QUOTED_STRING_DELIMITERS = m.c("\"\\");
        TOKEN_DELIMITERS = m.c("\t ,=");
    }

    public static final boolean hasBody(Response response) {
        e.f(response, "response");
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers parseChallenges, String headerName) {
        e.f(parseChallenges, "$this$parseChallenges");
        e.f(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = parseChallenges.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (headerName.equalsIgnoreCase(parseChallenges.name(i3))) {
                j jVar = new j();
                jVar.h0(parseChallenges.value(i3));
                try {
                    readChallengeHeader(jVar, arrayList);
                } catch (EOFException e) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response promisesBody) {
        e.f(promisesBody, "$this$promisesBody");
        if (e.a(promisesBody.request().method(), "HEAD")) {
            return false;
        }
        int code = promisesBody.code();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && Util.headersContentLength(promisesBody) == -1 && !"chunked".equalsIgnoreCase(Response.header$default(promisesBody, "Transfer-Encoding", null, 2, null))) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ba, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ba, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void readChallengeHeader(wh.j r8, java.util.List<okhttp3.Challenge> r9) throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.readChallengeHeader(wh.j, java.util.List):void");
    }

    private static final String readQuotedString(j jVar) throws EOFException {
        byte b3 = (byte) 34;
        if (!(jVar.readByte() == b3)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        j jVar2 = new j();
        while (true) {
            long i3 = jVar.i(QUOTED_STRING_DELIMITERS);
            if (i3 == -1) {
                return null;
            }
            if (jVar.g(i3) == b3) {
                jVar2.write(jVar, i3);
                jVar.readByte();
                return jVar2.A();
            }
            if (jVar.f19654b == i3 + 1) {
                return null;
            }
            jVar2.write(jVar, i3);
            jVar.readByte();
            jVar2.write(jVar, 1L);
        }
    }

    private static final String readToken(j jVar) {
        long i3 = jVar.i(TOKEN_DELIMITERS);
        if (i3 == -1) {
            i3 = jVar.f19654b;
        }
        if (i3 != 0) {
            return jVar.y(i3, a.f15656a);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar receiveHeaders, HttpUrl url, Headers headers) {
        e.f(receiveHeaders, "$this$receiveHeaders");
        e.f(url, "url");
        e.f(headers, "headers");
        if (receiveHeaders == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.Companion.parseAll(url, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        receiveHeaders.saveFromResponse(url, parseAll);
    }

    private static final boolean skipCommasAndWhitespace(j jVar) {
        boolean z5 = false;
        while (!jVar.D()) {
            byte g10 = jVar.g(0L);
            if (g10 == 9 || g10 == 32) {
                jVar.readByte();
            } else {
                if (g10 != 44) {
                    break;
                }
                jVar.readByte();
                z5 = true;
            }
        }
        return z5;
    }

    private static final boolean startsWith(j jVar, byte b3) {
        return !jVar.D() && jVar.g(0L) == b3;
    }
}
