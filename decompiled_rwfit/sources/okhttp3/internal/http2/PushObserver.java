package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import wh.l;

/* loaded from: classes2.dex */
public interface PushObserver {
    public static final Companion Companion = new Companion(null);
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        public static final class PushObserverCancel implements PushObserver {
            @Override // okhttp3.internal.http2.PushObserver
            public boolean onData(int i3, l source, int i10, boolean z5) throws IOException {
                e.f(source, "source");
                source.a(i10);
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onHeaders(int i3, List<Header> responseHeaders, boolean z5) {
                e.f(responseHeaders, "responseHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onRequest(int i3, List<Header> requestHeaders) {
                e.f(requestHeaders, "requestHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public void onReset(int i3, ErrorCode errorCode) {
                e.f(errorCode, "errorCode");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    boolean onData(int i3, l lVar, int i10, boolean z5) throws IOException;

    boolean onHeaders(int i3, List<Header> list, boolean z5);

    boolean onRequest(int i3, List<Header> list);

    void onReset(int i3, ErrorCode errorCode);
}
