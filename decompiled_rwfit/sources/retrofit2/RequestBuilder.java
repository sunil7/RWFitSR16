package retrofit2;

import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import wh.j;
import wh.k;

/* loaded from: classes2.dex */
final class RequestBuilder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final HttpUrl baseUrl;

    @Nullable
    private RequestBody body;

    @Nullable
    private MediaType contentType;

    @Nullable
    private FormBody.Builder formBuilder;
    private final boolean hasBody;
    private final String method;

    @Nullable
    private MultipartBody.Builder multipartBuilder;

    @Nullable
    private String relativeUrl;
    private final Request.Builder requestBuilder;

    @Nullable
    private HttpUrl.Builder urlBuilder;

    public static class ContentTypeOverridingRequestBody extends RequestBody {
        private final MediaType contentType;
        private final RequestBody delegate;

        public ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
            this.delegate = requestBody;
            this.contentType = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.contentType;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(k kVar) throws IOException {
            this.delegate.writeTo(kVar);
        }
    }

    public RequestBuilder(String str, HttpUrl httpUrl, @Nullable String str2, @Nullable Headers headers, @Nullable MediaType mediaType, boolean z5, boolean z6, boolean z8) {
        this.method = str;
        this.baseUrl = httpUrl;
        this.relativeUrl = str2;
        Request.Builder builder = new Request.Builder();
        this.requestBuilder = builder;
        this.contentType = mediaType;
        this.hasBody = z5;
        if (headers != null) {
            builder.headers(headers);
        }
        if (z6) {
            this.formBuilder = new FormBody.Builder();
        } else if (z8) {
            MultipartBody.Builder builder2 = new MultipartBody.Builder();
            this.multipartBuilder = builder2;
            builder2.setType(MultipartBody.FORM);
        }
    }

    private static String canonicalizeForPath(String str, boolean z5) {
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z5 && (codePointAt == 47 || codePointAt == 37))) {
                j jVar = new j();
                jVar.g0(0, i3, str);
                canonicalizeForPath(jVar, str, i3, length, z5);
                return jVar.A();
            }
            i3 += Character.charCount(codePointAt);
        }
        return str;
    }

    public void addFormField(String str, String str2, boolean z5) {
        if (z5) {
            this.formBuilder.addEncoded(str, str2);
        } else {
            this.formBuilder.add(str, str2);
        }
    }

    public void addHeader(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.requestBuilder.addHeader(str, str2);
            return;
        }
        MediaType parse = MediaType.parse(str2);
        if (parse == null) {
            throw new IllegalArgumentException(l0.n("Malformed content type: ", str2));
        }
        this.contentType = parse;
    }

    public void addPart(Headers headers, RequestBody requestBody) {
        this.multipartBuilder.addPart(headers, requestBody);
    }

    public void addPathParam(String str, String str2, boolean z5) {
        String str3 = this.relativeUrl;
        if (str3 == null) {
            throw new AssertionError();
        }
        this.relativeUrl = str3.replace(l0.o(Const.STR_MART_JSON_BEGIN, str, "}"), canonicalizeForPath(str2, z5));
    }

    public void addQueryParam(String str, @Nullable String str2, boolean z5) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            HttpUrl.Builder newBuilder = this.baseUrl.newBuilder(str3);
            this.urlBuilder = newBuilder;
            if (newBuilder == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
            this.relativeUrl = null;
        }
        if (z5) {
            this.urlBuilder.addEncodedQueryParameter(str, str2);
        } else {
            this.urlBuilder.addQueryParameter(str, str2);
        }
    }

    public Request build() {
        HttpUrl resolve;
        HttpUrl.Builder builder = this.urlBuilder;
        if (builder != null) {
            resolve = builder.build();
        } else {
            resolve = this.baseUrl.resolve(this.relativeUrl);
            if (resolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        RequestBody requestBody = this.body;
        if (requestBody == null) {
            FormBody.Builder builder2 = this.formBuilder;
            if (builder2 != null) {
                requestBody = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.multipartBuilder;
                if (builder3 != null) {
                    requestBody = builder3.build();
                } else if (this.hasBody) {
                    requestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.contentType;
        if (mediaType != null) {
            if (requestBody != null) {
                requestBody = new ContentTypeOverridingRequestBody(requestBody, mediaType);
            } else {
                this.requestBuilder.addHeader("Content-Type", mediaType.toString());
            }
        }
        return this.requestBuilder.url(resolve).method(this.method, requestBody).build();
    }

    public void setBody(RequestBody requestBody) {
        this.body = requestBody;
    }

    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    public void addPart(MultipartBody.Part part) {
        this.multipartBuilder.addPart(part);
    }

    private static void canonicalizeForPath(j jVar, String str, int i3, int i10, boolean z5) {
        j jVar2 = null;
        while (i3 < i10) {
            int codePointAt = str.codePointAt(i3);
            if (!z5 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt >= 32 && codePointAt < 127 && PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) == -1 && (z5 || (codePointAt != 47 && codePointAt != 37))) {
                    jVar.i0(codePointAt);
                } else {
                    if (jVar2 == null) {
                        jVar2 = new j();
                    }
                    jVar2.i0(codePointAt);
                    while (!jVar2.D()) {
                        byte readByte = jVar2.readByte();
                        jVar.Z(37);
                        char[] cArr = HEX_DIGITS;
                        jVar.Z(cArr[((readByte & 255) >> 4) & 15]);
                        jVar.Z(cArr[readByte & 15]);
                    }
                }
            }
            i3 += Character.charCount(codePointAt);
        }
    }
}
