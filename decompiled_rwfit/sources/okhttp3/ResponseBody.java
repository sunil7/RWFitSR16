package okhttp3;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.ke;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.a;
import okhttp3.internal.Util;
import okio.ByteString;
import wh.j;
import wh.l;

/* loaded from: classes2.dex */
public abstract class ResponseBody implements Closeable, AutoCloseable {
    public static final Companion Companion = new Companion(null);
    private Reader reader;

    public static final class BomAwareReader extends Reader implements AutoCloseable {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final l source;

        public BomAwareReader(l source, Charset charset) {
            e.f(source, "source");
            e.f(charset, "charset");
            this.source = source;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cbuf, int i3, int i10) throws IOException {
            e.f(cbuf, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.delegate;
            if (reader == null) {
                reader = new InputStreamReader(this.source.V(), Util.readBomAsCharset(this.source, this.charset));
                this.delegate = reader;
            }
            return reader.read(cbuf, i3, i10);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final ResponseBody create(String toResponseBody, MediaType mediaType) {
            e.f(toResponseBody, "$this$toResponseBody");
            Charset charset = a.f15656a;
            if (mediaType != null) {
                Charset charset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charset$default == null) {
                    mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charset$default;
                }
            }
            j jVar = new j();
            e.f(charset, "charset");
            jVar.f0(toResponseBody, 0, toResponseBody.length(), charset);
            return create(jVar, mediaType, jVar.f19654b);
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, l lVar, MediaType mediaType, long j4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            if ((i3 & 2) != 0) {
                j4 = -1;
            }
            return companion.create(lVar, mediaType, j4);
        }

        public final ResponseBody create(byte[] toResponseBody, MediaType mediaType) {
            e.f(toResponseBody, "$this$toResponseBody");
            j jVar = new j();
            jVar.X(toResponseBody);
            return create(jVar, mediaType, toResponseBody.length);
        }

        public final ResponseBody create(ByteString toResponseBody, MediaType mediaType) {
            e.f(toResponseBody, "$this$toResponseBody");
            j jVar = new j();
            jVar.W(toResponseBody);
            return create(jVar, mediaType, toResponseBody.size());
        }

        public final ResponseBody create(final l asResponseBody, final MediaType mediaType, final long j4) {
            e.f(asResponseBody, "$this$asResponseBody");
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                public long contentLength() {
                    return j4;
                }

                @Override // okhttp3.ResponseBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.ResponseBody
                public l source() {
                    return l.this;
                }
            };
        }

        public final ResponseBody create(MediaType mediaType, String content) {
            e.f(content, "content");
            return create(content, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, byte[] content) {
            e.f(content, "content");
            return create(content, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, ByteString content) {
            e.f(content, "content");
            return create(content, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, long j4, l content) {
            e.f(content, "content");
            return create(content, mediaType, j4);
        }
    }

    private final Charset charset() {
        Charset charset;
        MediaType contentType = contentType();
        return (contentType == null || (charset = contentType.charset(a.f15656a)) == null) ? a.f15656a : charset;
    }

    private final <T> T consumeSource(oh.l lVar, oh.l lVar2) {
        long contentLength = contentLength();
        if (contentLength > SubsamplingScaleImageView.TILE_SIZE_AUTO) {
            throw new IOException(l0.l(contentLength, "Cannot buffer entire body for content length: "));
        }
        l source = source();
        try {
            T t8 = (T) lVar.invoke(source);
            ke.a(source, null);
            int intValue = ((Number) lVar2.invoke(t8)).intValue();
            if (contentLength == -1 || contentLength == intValue) {
                return t8;
            }
            throw new IOException("Content-Length (" + contentLength + ") and stream length (" + intValue + ") disagree");
        } finally {
        }
    }

    public static final ResponseBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public final InputStream byteStream() {
        return source().V();
    }

    public final ByteString byteString() throws IOException {
        long contentLength = contentLength();
        if (contentLength > SubsamplingScaleImageView.TILE_SIZE_AUTO) {
            throw new IOException(l0.l(contentLength, "Cannot buffer entire body for content length: "));
        }
        l source = source();
        try {
            ByteString r = source.r();
            source.close();
            int size = r.size();
            if (contentLength == -1 || contentLength == size) {
                return r;
            }
            throw new IOException("Content-Length (" + contentLength + ") and stream length (" + size + ") disagree");
        } finally {
        }
    }

    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength > SubsamplingScaleImageView.TILE_SIZE_AUTO) {
            throw new IOException(l0.l(contentLength, "Cannot buffer entire body for content length: "));
        }
        l source = source();
        try {
            byte[] C = source.C();
            source.close();
            int length = C.length;
            if (contentLength == -1 || contentLength == length) {
                return C;
            }
            throw new IOException("Content-Length (" + contentLength + ") and stream length (" + length + ") disagree");
        } finally {
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract l source();

    public final String string() throws IOException {
        l source = source();
        try {
            String U = source.U(Util.readBomAsCharset(source, charset()));
            source.close();
            return U;
        } finally {
        }
    }

    public static final ResponseBody create(MediaType mediaType, long j4, l lVar) {
        return Companion.create(mediaType, j4, lVar);
    }

    public static final ResponseBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final ResponseBody create(MediaType mediaType, ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    public static final ResponseBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    public static final ResponseBody create(ByteString byteString, MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    public static final ResponseBody create(l lVar, MediaType mediaType, long j4) {
        return Companion.create(lVar, mediaType, j4);
    }

    public static final ResponseBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }
}
