package okhttp3.internal.cache;

import java.io.IOException;
import wh.a0;

/* loaded from: classes2.dex */
public interface CacheRequest {
    void abort();

    a0 body() throws IOException;
}
