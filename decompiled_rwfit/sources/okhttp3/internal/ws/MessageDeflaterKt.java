package okhttp3.internal.ws;

import okio.ByteString;
import wh.m;

/* loaded from: classes2.dex */
public final class MessageDeflaterKt {
    private static final ByteString EMPTY_DEFLATE_BLOCK;
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;

    static {
        ByteString.Companion.getClass();
        EMPTY_DEFLATE_BLOCK = m.b("000000ffff");
    }
}
