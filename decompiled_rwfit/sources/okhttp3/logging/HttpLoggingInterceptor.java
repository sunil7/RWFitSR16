package okhttp3.logging;

import com.autonavi.aps.amapapi.config.Const;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import wh.j;
import wh.l;
import wh.r;

/* loaded from: classes2.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() { // from class: okhttp3.logging.HttpLoggingInterceptor.Logger.1
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public void log(String str) {
                Platform.get().log(4, str, (Throwable) null);
            }
        };

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    private boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || str.equalsIgnoreCase("identity") || str.equalsIgnoreCase("gzip")) ? false : true;
    }

    public static boolean isPlaintext(j jVar) {
        j jVar2;
        int i3;
        try {
            jVar2 = new j();
            long j4 = jVar.f19654b;
            jVar.f(0L, jVar2, j4 < 64 ? j4 : 64L);
        } catch (EOFException unused) {
        }
        for (i3 = 0; i3 < 16; i3++) {
            if (jVar2.D()) {
                return true;
            }
            int F = jVar2.F();
            if (Character.isISOControl(F) && !Character.isWhitespace(F)) {
                return false;
            }
        }
        return true;
    }

    public Level getLevel() {
        return this.level;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Long] */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z5;
        boolean z6;
        long j4;
        r rVar;
        boolean z8;
        int i3;
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z10 = level == Level.BODY;
        boolean z11 = z10 || level == Level.HEADERS;
        RequestBody body = request.body();
        boolean z12 = body != null;
        Connection connection = chain.connection();
        StringBuilder sb2 = new StringBuilder("--> ");
        sb2.append(request.method());
        sb2.append(' ');
        sb2.append(request.url());
        sb2.append(connection != null ? " " + connection.protocol() : "");
        String sb3 = sb2.toString();
        if (!z11 && z12) {
            StringBuilder u10 = l0.u(sb3, " (");
            u10.append(body.contentLength());
            u10.append("-byte body)");
            sb3 = u10.toString();
        }
        this.logger.log(sb3);
        if (z11) {
            if (z12) {
                if (body.contentType() != null) {
                    j4 = -1;
                    this.logger.log("Content-Type: " + body.contentType());
                } else {
                    j4 = -1;
                }
                if (body.contentLength() != j4) {
                    Logger logger = this.logger;
                    StringBuilder sb4 = new StringBuilder("Content-Length: ");
                    z6 = z10;
                    z8 = z12;
                    sb4.append(body.contentLength());
                    logger.log(sb4.toString());
                } else {
                    z6 = z10;
                    z8 = z12;
                }
            } else {
                z6 = z10;
                z8 = z12;
                j4 = -1;
            }
            Headers headers = request.headers();
            int size = headers.size();
            int i10 = 0;
            while (i10 < size) {
                String name = headers.name(i10);
                boolean z13 = z11;
                if ("Content-Type".equalsIgnoreCase(name) || "Content-Length".equalsIgnoreCase(name)) {
                    i3 = size;
                } else {
                    Logger logger2 = this.logger;
                    StringBuilder u11 = l0.u(name, ": ");
                    i3 = size;
                    u11.append(headers.value(i10));
                    logger2.log(u11.toString());
                }
                i10++;
                z11 = z13;
                size = i3;
            }
            z5 = z11;
            if (!z6 || !z8) {
                this.logger.log("--> END " + request.method());
            } else if (bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else {
                j jVar = new j();
                body.writeTo(jVar);
                Charset charset = UTF8;
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    charset = contentType.charset(charset);
                }
                this.logger.log("");
                if (isPlaintext(jVar)) {
                    this.logger.log(jVar.U(charset));
                    this.logger.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.logger.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                }
            }
        } else {
            z5 = z11;
            z6 = z10;
            j4 = -1;
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            long contentLength = body2.contentLength();
            String str = contentLength != j4 ? contentLength + "-byte" : "unknown-length";
            Logger logger3 = this.logger;
            StringBuilder sb5 = new StringBuilder("<-- ");
            sb5.append(proceed.code());
            sb5.append(proceed.message().isEmpty() ? "" : " " + proceed.message());
            sb5.append(' ');
            sb5.append(proceed.request().url());
            sb5.append(" (");
            sb5.append(millis);
            sb5.append(Const.SP_KEY_GSM_UPLOAD_MXSIZE);
            sb5.append(!z5 ? l0.o(", ", str, " body") : "");
            sb5.append(')');
            logger3.log(sb5.toString());
            if (z5) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    this.logger.log(headers2.name(i11) + ": " + headers2.value(i11));
                }
                if (z6 && HttpHeaders.hasBody(proceed)) {
                    if (bodyHasUnknownEncoding(proceed.headers())) {
                        this.logger.log("<-- END HTTP (encoded body omitted)");
                        return proceed;
                    }
                    l source = body2.source();
                    source.request(Format.OFFSET_SAMPLE_RELATIVE);
                    j q5 = source.q();
                    r rVar2 = null;
                    if ("gzip".equalsIgnoreCase(headers2.get("Content-Encoding"))) {
                        ?? valueOf = Long.valueOf(q5.f19654b);
                        try {
                            rVar = new r(q5.clone());
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            q5 = new j();
                            q5.v(rVar);
                            rVar.close();
                            rVar2 = valueOf;
                        } catch (Throwable th3) {
                            th = th3;
                            rVar2 = rVar;
                            if (rVar2 != null) {
                                rVar2.close();
                            }
                            throw th;
                        }
                    }
                    Charset charset2 = UTF8;
                    MediaType contentType2 = body2.contentType();
                    if (contentType2 != null) {
                        charset2 = contentType2.charset(charset2);
                    }
                    if (!isPlaintext(q5)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + q5.f19654b + "-byte body omitted)");
                        return proceed;
                    }
                    if (contentLength != 0) {
                        this.logger.log("");
                        this.logger.log(q5.clone().U(charset2));
                    }
                    if (rVar2 == null) {
                        this.logger.log("<-- END HTTP (" + q5.f19654b + "-byte body)");
                        return proceed;
                    }
                    this.logger.log("<-- END HTTP (" + q5.f19654b + "-byte, " + rVar2 + "-gzipped-byte body)");
                    return proceed;
                }
                this.logger.log("<-- END HTTP");
            }
            return proceed;
        } catch (Exception e) {
            this.logger.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    public HttpLoggingInterceptor setLevel(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.level = level;
        return this;
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.level = Level.NONE;
        this.logger = logger;
    }
}
