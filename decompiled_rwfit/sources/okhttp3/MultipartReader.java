package okhttp3;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.e6;
import com.google.android.gms.internal.mlkit_vision_common.f6;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.internal.http1.HeadersReader;
import okio.ByteString;
import wh.c0;
import wh.e0;
import wh.f0;
import wh.j;
import wh.l;
import wh.m;
import wh.u;

/* loaded from: classes2.dex */
public final class MultipartReader implements Closeable, AutoCloseable {
    public static final Companion Companion = new Companion(null);
    private static final u afterBoundaryOptions;
    private final String boundary;
    private boolean closed;
    private final ByteString crlfDashDashBoundary;
    private PartSource currentPart;
    private final ByteString dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final l source;

    public static final class Companion {
        private Companion() {
        }

        public final u getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public static final class Part implements Closeable, AutoCloseable {
        private final l body;
        private final Headers headers;

        public Part(Headers headers, l body) {
            e.f(headers, "headers");
            e.f(body, "body");
            this.headers = headers;
            this.body = body;
        }

        public final l body() {
            return this.body;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.body.close();
        }

        public final Headers headers() {
            return this.headers;
        }
    }

    public final class PartSource implements c0 {
        private final f0 timeout = new f0();

        public PartSource() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (e.a(MultipartReader.this.currentPart, this)) {
                MultipartReader.this.currentPart = null;
            }
        }

        @Override // wh.c0
        public long read(j sink, long j4) {
            e.f(sink, "sink");
            if (j4 < 0) {
                throw new IllegalArgumentException(l0.l(j4, "byteCount < 0: ").toString());
            }
            if (!e.a(MultipartReader.this.currentPart, this)) {
                throw new IllegalStateException("closed");
            }
            f0 timeout = MultipartReader.this.source.timeout();
            f0 f0Var = this.timeout;
            long timeoutNanos = timeout.timeoutNanos();
            e0 e0Var = f0.Companion;
            long timeoutNanos2 = f0Var.timeoutNanos();
            long timeoutNanos3 = timeout.timeoutNanos();
            e0Var.getClass();
            if (timeoutNanos2 == 0 || (timeoutNanos3 != 0 && timeoutNanos2 >= timeoutNanos3)) {
                timeoutNanos2 = timeoutNanos3;
            }
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            timeout.timeout(timeoutNanos2, timeUnit);
            if (!timeout.hasDeadline()) {
                if (f0Var.hasDeadline()) {
                    timeout.deadlineNanoTime(f0Var.deadlineNanoTime());
                }
                try {
                    long currentPartBytesRemaining = MultipartReader.this.currentPartBytesRemaining(j4);
                    long read = currentPartBytesRemaining == 0 ? -1L : MultipartReader.this.source.read(sink, currentPartBytesRemaining);
                    timeout.timeout(timeoutNanos, timeUnit);
                    if (f0Var.hasDeadline()) {
                        timeout.clearDeadline();
                    }
                    return read;
                } catch (Throwable th2) {
                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (f0Var.hasDeadline()) {
                        timeout.clearDeadline();
                    }
                    throw th2;
                }
            }
            long deadlineNanoTime = timeout.deadlineNanoTime();
            if (f0Var.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), f0Var.deadlineNanoTime()));
            }
            try {
                long currentPartBytesRemaining2 = MultipartReader.this.currentPartBytesRemaining(j4);
                long read2 = currentPartBytesRemaining2 == 0 ? -1L : MultipartReader.this.source.read(sink, currentPartBytesRemaining2);
                timeout.timeout(timeoutNanos, timeUnit);
                if (f0Var.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                return read2;
            } catch (Throwable th3) {
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (f0Var.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                throw th3;
            }
        }

        @Override // wh.c0
        public f0 timeout() {
            return this.timeout;
        }
    }

    static {
        ByteString.Companion.getClass();
        afterBoundaryOptions = f6.b(m.c("\r\n"), m.c("--"), m.c(" "), m.c("\t"));
    }

    public MultipartReader(l source, String boundary) throws IOException {
        e.f(source, "source");
        e.f(boundary, "boundary");
        this.source = source;
        this.boundary = boundary;
        j jVar = new j();
        jVar.h0("--");
        jVar.h0(boundary);
        this.dashDashBoundary = jVar.s(jVar.f19654b);
        j jVar2 = new j();
        jVar2.h0("\r\n--");
        jVar2.h0(boundary);
        this.crlfDashDashBoundary = jVar2.s(jVar2.f19654b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long currentPartBytesRemaining(long r23) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartReader.currentPartBytesRemaining(long):long");
    }

    public final String boundary() {
        return this.boundary;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    public final Part nextPart() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.noMoreParts) {
            return null;
        }
        if (this.partCount == 0 && this.source.S(0L, this.dashDashBoundary)) {
            this.source.a(this.dashDashBoundary.size());
        } else {
            while (true) {
                long currentPartBytesRemaining = currentPartBytesRemaining(PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (currentPartBytesRemaining == 0) {
                    break;
                }
                this.source.a(currentPartBytesRemaining);
            }
            this.source.a(this.crlfDashDashBoundary.size());
        }
        boolean z5 = false;
        while (true) {
            int L = this.source.L(afterBoundaryOptions);
            if (L == -1) {
                throw new ProtocolException("unexpected characters after boundary");
            }
            if (L == 0) {
                this.partCount++;
                Headers readHeaders = new HeadersReader(this.source).readHeaders();
                PartSource partSource = new PartSource();
                this.currentPart = partSource;
                return new Part(readHeaders, e6.b(partSource));
            }
            if (L == 1) {
                if (z5) {
                    throw new ProtocolException("unexpected characters after boundary");
                }
                if (this.partCount == 0) {
                    throw new ProtocolException("expected at least 1 part");
                }
                this.noMoreParts = true;
                return null;
            }
            if (L == 2 || L == 3) {
                z5 = true;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MultipartReader(okhttp3.ResponseBody r3) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.e.f(r3, r0)
            wh.l r0 = r3.source()
            okhttp3.MediaType r3 = r3.contentType()
            if (r3 == 0) goto L1b
            java.lang.String r1 = "boundary"
            java.lang.String r3 = r3.parameter(r1)
            if (r3 == 0) goto L1b
            r2.<init>(r0, r3)
            return
        L1b:
            java.net.ProtocolException r3 = new java.net.ProtocolException
            java.lang.String r0 = "expected the Content-Type to have a boundary parameter"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartReader.<init>(okhttp3.ResponseBody):void");
    }
}
