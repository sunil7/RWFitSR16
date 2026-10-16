package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.ByteString;
import wh.j;
import wh.k;
import wh.m;

/* loaded from: classes2.dex */
public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    public static final Companion Companion = new Companion(null);
    private static final byte[] DASHDASH;
    public static final MediaType DIGEST;
    public static final MediaType FORM;
    public static final MediaType MIXED;
    public static final MediaType PARALLEL;
    private final ByteString boundaryByteString;
    private long contentLength;
    private final MediaType contentType;
    private final List<Part> parts;
    private final MediaType type;

    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final Builder addFormDataPart(String name, String value) {
            e.f(name, "name");
            e.f(value, "value");
            addPart(Part.Companion.createFormData(name, value));
            return this;
        }

        public final Builder addPart(RequestBody body) {
            e.f(body, "body");
            addPart(Part.Companion.create(body));
            return this;
        }

        public final MultipartBody build() {
            if (this.parts.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
        }

        public final Builder setType(MediaType type) {
            e.f(type, "type");
            if (e.a(type.type(), "multipart")) {
                this.type = type;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + type).toString());
        }

        public Builder(String boundary) {
            e.f(boundary, "boundary");
            ByteString.Companion.getClass();
            this.boundary = m.c(boundary);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        public final Builder addFormDataPart(String name, String str, RequestBody body) {
            e.f(name, "name");
            e.f(body, "body");
            addPart(Part.Companion.createFormData(name, str, body));
            return this;
        }

        public final Builder addPart(Headers headers, RequestBody body) {
            e.f(body, "body");
            addPart(Part.Companion.create(headers, body));
            return this;
        }

        public final Builder addPart(Part part) {
            e.f(part, "part");
            this.parts.add(part);
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ Builder(java.lang.String r1, int r2, kotlin.jvm.internal.c r3) {
            /*
                r0 = this;
                r2 = r2 & 1
                if (r2 == 0) goto L11
                java.util.UUID r1 = java.util.UUID.randomUUID()
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "UUID.randomUUID().toString()"
                kotlin.jvm.internal.e.e(r1, r2)
            L11:
                r0.<init>(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartBody.Builder.<init>(java.lang.String, int, kotlin.jvm.internal.c):void");
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public final void appendQuotedString$okhttp(StringBuilder appendQuotedString, String key) {
            e.f(appendQuotedString, "$this$appendQuotedString");
            e.f(key, "key");
            appendQuotedString.append('\"');
            int length = key.length();
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = key.charAt(i3);
                if (charAt == '\n') {
                    appendQuotedString.append("%0A");
                } else if (charAt == '\r') {
                    appendQuotedString.append("%0D");
                } else if (charAt != '\"') {
                    appendQuotedString.append(charAt);
                } else {
                    appendQuotedString.append("%22");
                }
            }
            appendQuotedString.append('\"');
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public static final class Part {
        public static final Companion Companion = new Companion(null);
        private final RequestBody body;
        private final Headers headers;

        public static final class Companion {
            private Companion() {
            }

            public final Part create(RequestBody body) {
                e.f(body, "body");
                return create(null, body);
            }

            public final Part createFormData(String name, String value) {
                e.f(name, "name");
                e.f(value, "value");
                return createFormData(name, null, RequestBody.Companion.create$default(RequestBody.Companion, value, (MediaType) null, 1, (Object) null));
            }

            public /* synthetic */ Companion(c cVar) {
                this();
            }

            public final Part create(Headers headers, RequestBody body) {
                e.f(body, "body");
                c cVar = null;
                if ((headers != null ? headers.get("Content-Type") : null) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if ((headers != null ? headers.get("Content-Length") : null) == null) {
                    return new Part(headers, body, cVar);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }

            public final Part createFormData(String name, String str, RequestBody body) {
                e.f(name, "name");
                e.f(body, "body");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("form-data; name=");
                Companion companion = MultipartBody.Companion;
                companion.appendQuotedString$okhttp(sb2, name);
                if (str != null) {
                    sb2.append("; filename=");
                    companion.appendQuotedString$okhttp(sb2, str);
                }
                String sb3 = sb2.toString();
                e.e(sb3, "StringBuilder().apply(builderAction).toString()");
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", sb3).build(), body);
            }
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public static final Part create(Headers headers, RequestBody requestBody) {
            return Companion.create(headers, requestBody);
        }

        public static final Part createFormData(String str, String str2) {
            return Companion.createFormData(str, str2);
        }

        /* renamed from: -deprecated_body, reason: not valid java name */
        public final RequestBody m166deprecated_body() {
            return this.body;
        }

        /* renamed from: -deprecated_headers, reason: not valid java name */
        public final Headers m167deprecated_headers() {
            return this.headers;
        }

        public final RequestBody body() {
            return this.body;
        }

        public final Headers headers() {
            return this.headers;
        }

        public /* synthetic */ Part(Headers headers, RequestBody requestBody, c cVar) {
            this(headers, requestBody);
        }

        public static final Part create(RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        public static final Part createFormData(String str, String str2, RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }
    }

    static {
        MediaType.Companion companion = MediaType.Companion;
        MIXED = companion.get("multipart/mixed");
        ALTERNATIVE = companion.get("multipart/alternative");
        DIGEST = companion.get("multipart/digest");
        PARALLEL = companion.get("multipart/parallel");
        FORM = companion.get("multipart/form-data");
        COLONSPACE = new byte[]{(byte) 58, (byte) 32};
        CRLF = new byte[]{(byte) 13, (byte) 10};
        byte b3 = (byte) 45;
        DASHDASH = new byte[]{b3, b3};
    }

    public MultipartBody(ByteString boundaryByteString, MediaType type, List<Part> parts) {
        e.f(boundaryByteString, "boundaryByteString");
        e.f(type, "type");
        e.f(parts, "parts");
        this.boundaryByteString = boundaryByteString;
        this.type = type;
        this.parts = parts;
        this.contentType = MediaType.Companion.get(type + "; boundary=" + boundary());
        this.contentLength = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long writeOrCountBytes(k kVar, boolean z5) throws IOException {
        j jVar;
        if (z5) {
            kVar = new j();
            jVar = kVar;
        } else {
            jVar = 0;
        }
        int size = this.parts.size();
        long j4 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Part part = this.parts.get(i3);
            Headers headers = part.headers();
            RequestBody body = part.body();
            e.c(kVar);
            kVar.G(DASHDASH);
            kVar.H(this.boundaryByteString);
            kVar.G(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    kVar.Q(headers.name(i10)).G(COLONSPACE).Q(headers.value(i10)).G(CRLF);
                }
            }
            MediaType contentType = body.contentType();
            if (contentType != null) {
                kVar.Q("Content-Type: ").Q(contentType.toString()).G(CRLF);
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                kVar.Q("Content-Length: ").R(contentLength).G(CRLF);
            } else if (z5) {
                e.c(jVar);
                jVar.b();
                return -1L;
            }
            byte[] bArr = CRLF;
            kVar.G(bArr);
            if (z5) {
                j4 += contentLength;
            } else {
                body.writeTo(kVar);
            }
            kVar.G(bArr);
        }
        e.c(kVar);
        byte[] bArr2 = DASHDASH;
        kVar.G(bArr2);
        kVar.H(this.boundaryByteString);
        kVar.G(bArr2);
        kVar.G(CRLF);
        if (!z5) {
            return j4;
        }
        e.c(jVar);
        long j10 = j4 + jVar.f19654b;
        jVar.b();
        return j10;
    }

    /* renamed from: -deprecated_boundary, reason: not valid java name */
    public final String m162deprecated_boundary() {
        return boundary();
    }

    /* renamed from: -deprecated_parts, reason: not valid java name */
    public final List<Part> m163deprecated_parts() {
        return this.parts;
    }

    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m164deprecated_size() {
        return size();
    }

    /* renamed from: -deprecated_type, reason: not valid java name */
    public final MediaType m165deprecated_type() {
        return this.type;
    }

    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j4 = this.contentLength;
        if (j4 != -1) {
            return j4;
        }
        long writeOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = writeOrCountBytes;
        return writeOrCountBytes;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.contentType;
    }

    public final Part part(int i3) {
        return this.parts.get(i3);
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    public final MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(k sink) throws IOException {
        e.f(sink, "sink");
        writeOrCountBytes(sink, false);
    }
}
