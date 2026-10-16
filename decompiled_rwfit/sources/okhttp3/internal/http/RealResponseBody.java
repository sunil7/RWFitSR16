package okhttp3.internal.http;

import kotlin.jvm.internal.e;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import wh.l;

/* loaded from: classes2.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final l source;

    public RealResponseBody(String str, long j4, l source) {
        e.f(source, "source");
        this.contentTypeString = str;
        this.contentLength = j4;
        this.source = source;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    public l source() {
        return this.source;
    }
}
