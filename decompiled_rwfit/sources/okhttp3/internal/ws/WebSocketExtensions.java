package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.m;
import okhttp3.Headers;
import okhttp3.internal.Util;

/* loaded from: classes2.dex */
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    public static final class Companion {
        private Companion() {
        }

        public final WebSocketExtensions parse(Headers responseHeaders) throws IOException {
            boolean z5;
            String str;
            e.f(responseHeaders, "responseHeaders");
            int size = responseHeaders.size();
            boolean z6 = false;
            boolean z8 = false;
            boolean z10 = false;
            boolean z11 = false;
            Integer num = null;
            Integer num2 = null;
            for (int i3 = 0; i3 < size; i3++) {
                if (m.f(responseHeaders.name(i3), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION)) {
                    String value = responseHeaders.value(i3);
                    int i10 = 0;
                    while (i10 < value.length()) {
                        int delimiterOffset$default = Util.delimiterOffset$default(value, ',', i10, 0, 4, (Object) null);
                        char c9 = ';';
                        int delimiterOffset = Util.delimiterOffset(value, ';', i10, delimiterOffset$default);
                        String trimSubstring = Util.trimSubstring(value, i10, delimiterOffset);
                        int i11 = delimiterOffset + 1;
                        boolean z12 = true;
                        if (m.f(trimSubstring, "permessage-deflate")) {
                            if (z6) {
                                z11 = true;
                            }
                            while (i11 < delimiterOffset$default) {
                                int delimiterOffset2 = Util.delimiterOffset(value, c9, i11, delimiterOffset$default);
                                int delimiterOffset3 = Util.delimiterOffset(value, '=', i11, delimiterOffset2);
                                String trimSubstring2 = Util.trimSubstring(value, i11, delimiterOffset3);
                                if (delimiterOffset3 < delimiterOffset2) {
                                    str = Util.trimSubstring(value, delimiterOffset3 + 1, delimiterOffset2);
                                    e.f(str, "<this>");
                                    if (str.length() >= 2 && m.x(str, "\"", false) && m.e(str, "\"")) {
                                        z5 = z12;
                                        str = str.substring(z5 ? 1 : 0, str.length() - 1);
                                        e.e(str, "this as java.lang.String…ing(startIndex, endIndex)");
                                    } else {
                                        z5 = z12;
                                    }
                                } else {
                                    z5 = z12;
                                    str = null;
                                }
                                int i12 = delimiterOffset2 + 1;
                                if (m.f(trimSubstring2, "client_max_window_bits")) {
                                    if (num != null) {
                                        z11 = z5;
                                    }
                                    Integer A = str != null ? m.A(str) : null;
                                    num = A;
                                    if (A != null) {
                                        z12 = z5;
                                        c9 = ';';
                                        i11 = i12;
                                    }
                                    z11 = z5;
                                    z12 = z5;
                                    c9 = ';';
                                    i11 = i12;
                                } else {
                                    if (m.f(trimSubstring2, "client_no_context_takeover")) {
                                        if (z8) {
                                            z11 = z5;
                                        }
                                        if (str != null) {
                                            z11 = z5;
                                        }
                                        z8 = z5;
                                    } else if (m.f(trimSubstring2, "server_max_window_bits")) {
                                        if (num2 != null) {
                                            z11 = z5;
                                        }
                                        Integer A2 = str != null ? m.A(str) : null;
                                        num2 = A2;
                                        if (A2 != null) {
                                        }
                                        z11 = z5;
                                    } else {
                                        if (m.f(trimSubstring2, "server_no_context_takeover")) {
                                            if (z10) {
                                                z11 = z5;
                                            }
                                            if (str != null) {
                                                z11 = z5;
                                            }
                                            z10 = z5;
                                        }
                                        z11 = z5;
                                    }
                                    z12 = z5;
                                    c9 = ';';
                                    i11 = i12;
                                }
                            }
                            z6 = z12;
                        } else {
                            z11 = true;
                        }
                        i10 = i11;
                    }
                }
            }
            return new WebSocketExtensions(z6, num, z8, num2, z10, z11);
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z5, Integer num, boolean z6, Integer num2, boolean z8, boolean z10, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z5 = webSocketExtensions.perMessageDeflate;
        }
        if ((i3 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        if ((i3 & 4) != 0) {
            z6 = webSocketExtensions.clientNoContextTakeover;
        }
        if ((i3 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        if ((i3 & 16) != 0) {
            z8 = webSocketExtensions.serverNoContextTakeover;
        }
        if ((i3 & 32) != 0) {
            z10 = webSocketExtensions.unknownValues;
        }
        boolean z11 = z8;
        boolean z12 = z10;
        return webSocketExtensions.copy(z5, num, z6, num2, z11, z12);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z5, Integer num, boolean z6, Integer num2, boolean z8, boolean z10) {
        return new WebSocketExtensions(z5, num, z6, num2, z8, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && e.a(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && e.a(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z5 = this.perMessageDeflate;
        ?? r02 = z5;
        if (z5) {
            r02 = 1;
        }
        int i3 = r02 * 31;
        Integer num = this.clientMaxWindowBits;
        int hashCode = (i3 + (num != null ? num.hashCode() : 0)) * 31;
        ?? r22 = this.clientNoContextTakeover;
        int i10 = r22;
        if (r22 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int hashCode2 = (i11 + (num2 != null ? num2.hashCode() : 0)) * 31;
        ?? r23 = this.serverNoContextTakeover;
        int i12 = r23;
        if (r23 != 0) {
            i12 = 1;
        }
        int i13 = (hashCode2 + i12) * 31;
        boolean z6 = this.unknownValues;
        return i13 + (z6 ? 1 : z6 ? 1 : 0);
    }

    public final boolean noContextTakeover(boolean z5) {
        return z5 ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ")";
    }

    public WebSocketExtensions(boolean z5, Integer num, boolean z6, Integer num2, boolean z8, boolean z10) {
        this.perMessageDeflate = z5;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z6;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z8;
        this.unknownValues = z10;
    }

    public /* synthetic */ WebSocketExtensions(boolean z5, Integer num, boolean z6, Integer num2, boolean z8, boolean z10, int i3, c cVar) {
        this((i3 & 1) != 0 ? false : z5, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? false : z6, (i3 & 8) != 0 ? null : num2, (i3 & 16) != 0 ? false : z8, (i3 & 32) != 0 ? false : z10);
    }
}
