package okhttp3;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_common.e6;
import com.tencent.connect.common.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.m;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.ByteString;
import wh.a0;
import wh.c0;
import wh.h;
import wh.j;
import wh.k;
import wh.l;
import wh.o;
import wh.p;
import wh.w;
import wh.x;

/* loaded from: classes2.dex */
public final class Cache implements Closeable, Flushable, AutoCloseable {
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    public static final class CacheResponseBody extends ResponseBody {
        private final l bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String str, String str2) {
            e.f(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            final c0 source = snapshot.getSource(1);
            this.bodySource = e6.b(new p(source) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // wh.p, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    CacheResponseBody.this.getSnapshot().close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String str = this.contentLength;
            if (str != null) {
                return Util.toLongOrDefault(str, -1L);
            }
            return -1L;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.Companion.parse(str);
            }
            return null;
        }

        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        public l source() {
            return this.bodySource;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        private final Set<String> varyFields(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i3 = 0; i3 < size; i3++) {
                if ("Vary".equalsIgnoreCase(headers.name(i3))) {
                    String value = headers.value(i3);
                    if (treeSet == null) {
                        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
                        e.e(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
                        treeSet = new TreeSet(CASE_INSENSITIVE_ORDER);
                    }
                    for (String str : m.v(value, new char[]{','})) {
                        if (str == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        treeSet.add(m.B(str).toString());
                    }
                }
            }
            return treeSet != null ? treeSet : EmptySet.INSTANCE;
        }

        public final boolean hasVaryAll(Response hasVaryAll) {
            e.f(hasVaryAll, "$this$hasVaryAll");
            return varyFields(hasVaryAll.headers()).contains("*");
        }

        public final String key(HttpUrl url) {
            e.f(url, "url");
            wh.m mVar = ByteString.Companion;
            String httpUrl = url.toString();
            mVar.getClass();
            return wh.m.c(httpUrl).md5().hex();
        }

        public final int readInt$okhttp(l source) throws IOException {
            e.f(source, "source");
            try {
                long K = source.K();
                String B = source.B();
                if (K >= 0 && K <= SubsamplingScaleImageView.TILE_SIZE_AUTO && B.length() <= 0) {
                    return (int) K;
                }
                throw new IOException("expected an int but was \"" + K + B + '\"');
            } catch (NumberFormatException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final Headers varyHeaders(Response varyHeaders) {
            e.f(varyHeaders, "$this$varyHeaders");
            Response networkResponse = varyHeaders.networkResponse();
            e.c(networkResponse);
            return varyHeaders(networkResponse.request().headers(), varyHeaders.headers());
        }

        public final boolean varyMatches(Response cachedResponse, Headers cachedRequest, Request newRequest) {
            e.f(cachedResponse, "cachedResponse");
            e.f(cachedRequest, "cachedRequest");
            e.f(newRequest, "newRequest");
            Set<String> varyFields = varyFields(cachedResponse.headers());
            if (varyFields != null && varyFields.isEmpty()) {
                return true;
            }
            for (String str : varyFields) {
                if (!e.a(cachedRequest.values(str), newRequest.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> varyFields = varyFields(headers2);
            if (varyFields.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i3 = 0; i3 < size; i3++) {
                String name = headers.name(i3);
                if (varyFields.contains(name)) {
                    builder.add(name, headers.value(i3));
                }
            }
            return builder.build();
        }
    }

    public final class RealCacheRequest implements CacheRequest {
        private final a0 body;
        private final a0 cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(Cache cache, DiskLruCache.Editor editor) {
            e.f(editor, "editor");
            this.this$0 = cache;
            this.editor = editor;
            a0 newSink = editor.newSink(1);
            this.cacheOut = newSink;
            this.body = new o(newSink) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // wh.o, wh.a0, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    synchronized (RealCacheRequest.this.this$0) {
                        if (RealCacheRequest.this.getDone()) {
                            return;
                        }
                        RealCacheRequest.this.setDone(true);
                        Cache cache2 = RealCacheRequest.this.this$0;
                        cache2.setWriteSuccessCount$okhttp(cache2.getWriteSuccessCount$okhttp() + 1);
                        super.close();
                        RealCacheRequest.this.editor.commit();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            synchronized (this.this$0) {
                if (this.done) {
                    return;
                }
                this.done = true;
                Cache cache = this.this$0;
                cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                Util.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public a0 body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z5) {
            this.done = z5;
        }
    }

    public Cache(File directory, long j4, FileSystem fileSystem) {
        e.f(directory, "directory");
        e.f(fileSystem, "fileSystem");
        this.cache = new DiskLruCache(fileSystem, directory, VERSION, 2, j4, TaskRunner.INSTANCE);
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static final String key(HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    /* renamed from: -deprecated_directory, reason: not valid java name */
    public final File m95deprecated_directory() {
        return this.cache.getDirectory();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final File directory() {
        return this.cache.getDirectory();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    public final Response get$okhttp(Request request) {
        e.f(request, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot != null) {
                try {
                    Entry entry = new Entry(snapshot.getSource(0));
                    Response response = entry.response(snapshot);
                    if (entry.matches(request, response)) {
                        return response;
                    }
                    ResponseBody body = response.body();
                    if (body != null) {
                        Util.closeQuietly(body);
                    }
                    return null;
                } catch (IOException unused) {
                    Util.closeQuietly(snapshot);
                }
            }
        } catch (IOException unused2) {
        }
        return null;
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final CacheRequest put$okhttp(Response response) {
        DiskLruCache.Editor editor;
        e.f(response, "response");
        String method = response.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!e.a(method, Constants.HTTP_GET)) {
            return null;
        }
        Companion companion = Companion;
        if (companion.hasVaryAll(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            editor = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0L, 2, null);
            if (editor == null) {
                return null;
            }
            try {
                entry.writeTo(editor);
                return new RealCacheRequest(this, editor);
            } catch (IOException unused2) {
                abortQuietly(editor);
                return null;
            }
        } catch (IOException unused3) {
            editor = null;
        }
    }

    public final void remove$okhttp(Request request) throws IOException {
        e.f(request, "request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int i3) {
        this.writeAbortCount = i3;
    }

    public final void setWriteSuccessCount$okhttp(int i3) {
        this.writeSuccessCount = i3;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        try {
            e.f(cacheStrategy, "cacheStrategy");
            this.requestCount++;
            if (cacheStrategy.getNetworkRequest() != null) {
                this.networkCount++;
            } else if (cacheStrategy.getCacheResponse() != null) {
                this.hitCount++;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void update$okhttp(Response cached, Response network) {
        DiskLruCache.Editor editor;
        e.f(cached, "cached");
        e.f(network, "network");
        Entry entry = new Entry(network);
        ResponseBody body = cached.body();
        if (body == null) {
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        }
        try {
            editor = ((CacheResponseBody) body).getSnapshot().edit();
            if (editor != null) {
                try {
                    entry.writeTo(editor);
                    editor.commit();
                } catch (IOException unused) {
                    abortQuietly(editor);
                }
            }
        } catch (IOException unused2) {
            editor = null;
        }
    }

    public final Iterator<String> urls() throws IOException {
        return new Cache$urls$1(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(File directory, long j4) {
        this(directory, j4, FileSystem.SYSTEM);
        e.f(directory, "directory");
    }

    public static final class Entry {
        public static final Companion Companion = new Companion(null);
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final Headers varyHeaders;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(c cVar) {
                this();
            }
        }

        static {
            StringBuilder sb2 = new StringBuilder();
            Platform.Companion companion = Platform.Companion;
            sb2.append(companion.get().getPrefix());
            sb2.append("-Sent-Millis");
            SENT_MILLIS = sb2.toString();
            RECEIVED_MILLIS = companion.get().getPrefix() + "-Received-Millis";
        }

        public Entry(c0 rawSource) throws IOException {
            e.f(rawSource, "rawSource");
            try {
                x b3 = e6.b(rawSource);
                this.url = b3.M(Format.OFFSET_SAMPLE_RELATIVE);
                this.requestMethod = b3.M(Format.OFFSET_SAMPLE_RELATIVE);
                Headers.Builder builder = new Headers.Builder();
                int readInt$okhttp = Cache.Companion.readInt$okhttp(b3);
                for (int i3 = 0; i3 < readInt$okhttp; i3++) {
                    builder.addLenient$okhttp(b3.M(Format.OFFSET_SAMPLE_RELATIVE));
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.Companion.parse(b3.M(Format.OFFSET_SAMPLE_RELATIVE));
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt$okhttp2 = Cache.Companion.readInt$okhttp(b3);
                for (int i10 = 0; i10 < readInt$okhttp2; i10++) {
                    builder2.addLenient$okhttp(b3.M(Format.OFFSET_SAMPLE_RELATIVE));
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0L;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : 0L;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String M = b3.M(Format.OFFSET_SAMPLE_RELATIVE);
                    if (M.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + M + '\"');
                    }
                    this.handshake = Handshake.Companion.get(!b3.D() ? TlsVersion.Companion.forJavaName(b3.M(Format.OFFSET_SAMPLE_RELATIVE)) : TlsVersion.SSL_3_0, CipherSuite.Companion.forJavaName(b3.M(Format.OFFSET_SAMPLE_RELATIVE)), readCertificateList(b3), readCertificateList(b3));
                } else {
                    this.handshake = null;
                }
                rawSource.close();
            } catch (Throwable th2) {
                rawSource.close();
                throw th2;
            }
        }

        private final boolean isHttps() {
            return m.x(this.url, "https://", false);
        }

        private final List<Certificate> readCertificateList(l lVar) throws IOException {
            int readInt$okhttp = Cache.Companion.readInt$okhttp(lVar);
            if (readInt$okhttp == -1) {
                return EmptyList.INSTANCE;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt$okhttp);
                for (int i3 = 0; i3 < readInt$okhttp; i3++) {
                    String B = lVar.B();
                    j jVar = new j();
                    ByteString.Companion.getClass();
                    ByteString a3 = wh.m.a(B);
                    e.c(a3);
                    jVar.W(a3);
                    arrayList.add(certificateFactory.generateCertificate(new h(jVar, 0)));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private final void writeCertList(k kVar, List<? extends Certificate> list) throws IOException {
            try {
                kVar.R(list.size()).E(10);
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    byte[] bytes = list.get(i3).getEncoded();
                    wh.m mVar = ByteString.Companion;
                    e.e(bytes, "bytes");
                    kVar.Q(wh.m.d(mVar, bytes).base64()).E(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            e.f(request, "request");
            e.f(response, "response");
            return e.a(this.url, request.url().toString()) && e.a(this.requestMethod, request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        }

        public final Response response(DiskLruCache.Snapshot snapshot) {
            e.f(snapshot, "snapshot");
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public final void writeTo(DiskLruCache.Editor editor) throws IOException {
            e.f(editor, "editor");
            w a3 = e6.a(editor.newSink(0));
            try {
                a3.Q(this.url);
                a3.E(10);
                a3.Q(this.requestMethod);
                a3.E(10);
                a3.R(this.varyHeaders.size());
                a3.E(10);
                int size = this.varyHeaders.size();
                for (int i3 = 0; i3 < size; i3++) {
                    a3.Q(this.varyHeaders.name(i3));
                    a3.Q(": ");
                    a3.Q(this.varyHeaders.value(i3));
                    a3.E(10);
                }
                a3.Q(new StatusLine(this.protocol, this.code, this.message).toString());
                a3.E(10);
                a3.R(this.responseHeaders.size() + 2);
                a3.E(10);
                int size2 = this.responseHeaders.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    a3.Q(this.responseHeaders.name(i10));
                    a3.Q(": ");
                    a3.Q(this.responseHeaders.value(i10));
                    a3.E(10);
                }
                a3.Q(SENT_MILLIS);
                a3.Q(": ");
                a3.R(this.sentRequestMillis);
                a3.E(10);
                a3.Q(RECEIVED_MILLIS);
                a3.Q(": ");
                a3.R(this.receivedResponseMillis);
                a3.E(10);
                if (isHttps()) {
                    a3.E(10);
                    Handshake handshake = this.handshake;
                    e.c(handshake);
                    a3.Q(handshake.cipherSuite().javaName());
                    a3.E(10);
                    writeCertList(a3, this.handshake.peerCertificates());
                    writeCertList(a3, this.handshake.localCertificates());
                    a3.Q(this.handshake.tlsVersion().javaName());
                    a3.E(10);
                }
                a3.close();
            } finally {
            }
        }

        public Entry(Response response) {
            e.f(response, "response");
            this.url = response.request().url().toString();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
