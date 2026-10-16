package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.m;
import okhttp3.Protocol;
import okhttp3.Response;

/* loaded from: classes2.dex */
public final class StatusLine {
    public static final Companion Companion = new Companion(null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    public static final class Companion {
        private Companion() {
        }

        public final StatusLine get(Response response) {
            e.f(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String statusLine) throws IOException {
            Protocol protocol;
            int i3;
            String str;
            e.f(statusLine, "statusLine");
            if (m.x(statusLine, "HTTP/1.", false)) {
                i3 = 9;
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                int charAt = statusLine.charAt(7) - '0';
                if (charAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (charAt != 1) {
                        throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                if (!m.x(statusLine, "ICY ", false)) {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                protocol = Protocol.HTTP_1_0;
                i3 = 4;
            }
            int i10 = i3 + 3;
            if (statusLine.length() < i10) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            try {
                String substring = statusLine.substring(i3, i10);
                e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int parseInt = Integer.parseInt(substring);
                if (statusLine.length() <= i10) {
                    str = "";
                } else {
                    if (statusLine.charAt(i10) != ' ') {
                        throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                    }
                    str = statusLine.substring(i3 + 4);
                    e.e(str, "(this as java.lang.String).substring(startIndex)");
                }
                return new StatusLine(protocol, parseInt, str);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public StatusLine(Protocol protocol, int i3, String message) {
        e.f(protocol, "protocol");
        e.f(message, "message");
        this.protocol = protocol;
        this.code = i3;
        this.message = message;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb2.append("HTTP/1.0");
        } else {
            sb2.append("HTTP/1.1");
        }
        sb2.append(' ');
        sb2.append(this.code);
        sb2.append(' ');
        sb2.append(this.message);
        String sb3 = sb2.toString();
        e.e(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
