package okhttp3.internal.http1;

import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.Headers;
import wh.l;

/* loaded from: classes2.dex */
public final class HeadersReader {
    public static final Companion Companion = new Companion(null);
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit;
    private final l source;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public HeadersReader(l source) {
        e.f(source, "source");
        this.source = source;
        this.headerLimit = HEADER_LIMIT;
    }

    public final l getSource() {
        return this.source;
    }

    public final Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readLine = readLine();
            if (readLine.length() == 0) {
                return builder.build();
            }
            builder.addLenient$okhttp(readLine);
        }
    }

    public final String readLine() {
        String M = this.source.M(this.headerLimit);
        this.headerLimit -= M.length();
        return M;
    }
}
