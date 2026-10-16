package okhttp3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.a;
import okhttp3.internal.Util;
import okio.ByteString;
import wh.d;
import wh.f0;
import wh.k;
import wh.t;

/* loaded from: classes2.dex */
public abstract class RequestBody {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr) {
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i3) {
            return create$default(this, mediaType, bArr, i3, 0, 8, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i3, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                mediaType = null;
            }
            if ((i11 & 2) != 0) {
                i3 = 0;
            }
            if ((i11 & 4) != 0) {
                i10 = bArr.length;
            }
            return companion.create(bArr, mediaType, i3, i10);
        }

        public final RequestBody create(byte[] bArr) {
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType) {
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i3, int i10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                i3 = 0;
            }
            if ((i11 & 8) != 0) {
                i10 = bArr.length;
            }
            return companion.create(mediaType, bArr, i3, i10);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType, int i3) {
            return create$default(this, bArr, mediaType, i3, 0, 4, (Object) null);
        }

        public final RequestBody create(String toRequestBody, MediaType mediaType) {
            e.f(toRequestBody, "$this$toRequestBody");
            Charset charset = a.f15656a;
            if (mediaType != null) {
                Charset charset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charset$default == null) {
                    mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charset$default;
                }
            }
            byte[] bytes = toRequestBody.getBytes(charset);
            e.e(bytes, "(this as java.lang.String).getBytes(charset)");
            return create(bytes, mediaType, 0, bytes.length);
        }

        public final RequestBody create(final ByteString toRequestBody, final MediaType mediaType) {
            e.f(toRequestBody, "$this$toRequestBody");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return ByteString.this.size();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(k sink) {
                    e.f(sink, "sink");
                    sink.H(ByteString.this);
                }
            };
        }

        public final RequestBody create(final byte[] toRequestBody, final MediaType mediaType, final int i3, final int i10) {
            e.f(toRequestBody, "$this$toRequestBody");
            Util.checkOffsetAndCount(toRequestBody.length, i3, i10);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i10;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(k sink) {
                    e.f(sink, "sink");
                    sink.N(i3, i10, toRequestBody);
                }
            };
        }

        public final RequestBody create(final File asRequestBody, final MediaType mediaType) {
            e.f(asRequestBody, "$this$asRequestBody");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return asRequestBody.length();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(k sink) {
                    e.f(sink, "sink");
                    File source = asRequestBody;
                    Logger logger = t.f19667a;
                    e.f(source, "$this$source");
                    d dVar = new d(1, new FileInputStream(source), new f0());
                    try {
                        sink.v(dVar);
                        dVar.close();
                    } finally {
                    }
                }
            };
        }

        public final RequestBody create(MediaType mediaType, String content) {
            e.f(content, "content");
            return create(content, mediaType);
        }

        public final RequestBody create(MediaType mediaType, ByteString content) {
            e.f(content, "content");
            return create(content, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] content, int i3, int i10) {
            e.f(content, "content");
            return create(content, mediaType, i3, i10);
        }

        public final RequestBody create(MediaType mediaType, File file) {
            e.f(file, "file");
            return create(file, mediaType);
        }
    }

    public static final RequestBody create(File file, MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(k kVar) throws IOException;

    public static final RequestBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, File file) {
        return Companion.create(mediaType, file);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final RequestBody create(MediaType mediaType, ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create$default(Companion, mediaType, bArr, 0, 0, 12, (Object) null);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i3) {
        return Companion.create$default(Companion, mediaType, bArr, i3, 0, 8, (Object) null);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i3, int i10) {
        return Companion.create(mediaType, bArr, i3, i10);
    }

    public static final RequestBody create(ByteString byteString, MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    public static final RequestBody create(byte[] bArr) {
        return Companion.create$default(Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create$default(Companion, bArr, mediaType, 0, 0, 6, (Object) null);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i3) {
        return Companion.create$default(Companion, bArr, mediaType, i3, 0, 4, (Object) null);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i3, int i10) {
        return Companion.create(bArr, mediaType, i3, i10);
    }
}
