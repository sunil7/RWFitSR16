package retrofit2;

import com.google.android.gms.internal.mlkit_vision_common.e6;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;
import wh.j;
import wh.l;
import wh.p;

/* loaded from: classes2.dex */
final class OkHttpCall<T> implements Call<T> {

    @Nullable
    private final Object[] args;
    private volatile boolean canceled;

    @GuardedBy("this")
    @Nullable
    private Throwable creationFailure;

    @GuardedBy("this")
    private boolean executed;

    @GuardedBy("this")
    @Nullable
    private okhttp3.Call rawCall;
    private final ServiceMethod<T, ?> serviceMethod;

    public static final class ExceptionCatchingRequestBody extends ResponseBody {
        private final ResponseBody delegate;
        IOException thrownException;

        public ExceptionCatchingRequestBody(ResponseBody responseBody) {
            this.delegate = responseBody;
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.delegate.contentType();
        }

        @Override // okhttp3.ResponseBody
        public l source() {
            return e6.b(new p(this.delegate.source()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingRequestBody.1
                @Override // wh.p, wh.c0
                public long read(j jVar, long j4) throws IOException {
                    try {
                        return super.read(jVar, j4);
                    } catch (IOException e) {
                        ExceptionCatchingRequestBody.this.thrownException = e;
                        throw e;
                    }
                }
            });
        }

        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    public static final class NoContentResponseBody extends ResponseBody {
        private final long contentLength;
        private final MediaType contentType;

        public NoContentResponseBody(MediaType mediaType, long j4) {
            this.contentType = mediaType;
            this.contentLength = j4;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.contentLength;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.contentType;
        }

        @Override // okhttp3.ResponseBody
        public l source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(ServiceMethod<T, ?> serviceMethod, @Nullable Object[] objArr) {
        this.serviceMethod = serviceMethod;
        this.args = objArr;
    }

    private okhttp3.Call createRawCall() throws IOException {
        okhttp3.Call call = this.serviceMethod.toCall(this.args);
        if (call != null) {
            return call;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    @Override // retrofit2.Call
    public void cancel() {
        okhttp3.Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
        }
        if (call != null) {
            call.cancel();
        }
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> callback) {
        okhttp3.Call call;
        Throwable th2;
        Utils.checkNotNull(callback, "callback == null");
        synchronized (this) {
            try {
                if (this.executed) {
                    throw new IllegalStateException("Already executed.");
                }
                this.executed = true;
                call = this.rawCall;
                th2 = this.creationFailure;
                if (call == null && th2 == null) {
                    try {
                        okhttp3.Call createRawCall = createRawCall();
                        this.rawCall = createRawCall;
                        call = createRawCall;
                    } catch (Throwable th3) {
                        th2 = th3;
                        Utils.throwIfFatal(th2);
                        this.creationFailure = th2;
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        if (th2 != null) {
            callback.onFailure(this, th2);
            return;
        }
        if (this.canceled) {
            call.cancel();
        }
        call.enqueue(new okhttp3.Callback() { // from class: retrofit2.OkHttpCall.1
            private void callFailure(Throwable th5) {
                try {
                    callback.onFailure(OkHttpCall.this, th5);
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(okhttp3.Call call2, IOException iOException) {
                callFailure(iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(okhttp3.Call call2, okhttp3.Response response) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(response));
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                } catch (Throwable th6) {
                    callFailure(th6);
                }
            }
        });
    }

    @Override // retrofit2.Call
    public Response<T> execute() throws IOException {
        okhttp3.Call call;
        synchronized (this) {
            try {
                if (this.executed) {
                    throw new IllegalStateException("Already executed.");
                }
                this.executed = true;
                Throwable th2 = this.creationFailure;
                if (th2 != null) {
                    if (th2 instanceof IOException) {
                        throw ((IOException) th2);
                    }
                    if (th2 instanceof RuntimeException) {
                        throw ((RuntimeException) th2);
                    }
                    throw ((Error) th2);
                }
                call = this.rawCall;
                if (call == null) {
                    try {
                        call = createRawCall();
                        this.rawCall = call;
                    } catch (IOException | Error | RuntimeException e) {
                        Utils.throwIfFatal(e);
                        this.creationFailure = e;
                        throw e;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (this.canceled) {
            call.cancel();
        }
        return parseResponse(call.execute());
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean z5 = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            try {
                okhttp3.Call call = this.rawCall;
                if (call == null || !call.isCanceled()) {
                    z5 = false;
                }
            } finally {
            }
        }
        return z5;
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public Response<T> parseResponse(okhttp3.Response response) throws IOException {
        ResponseBody body = response.body();
        okhttp3.Response build = response.newBuilder().body(new NoContentResponseBody(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return Response.error(Utils.buffer(body), build);
            } finally {
                body.close();
            }
        }
        if (code == 204 || code == 205) {
            body.close();
            return Response.success((Object) null, build);
        }
        ExceptionCatchingRequestBody exceptionCatchingRequestBody = new ExceptionCatchingRequestBody(body);
        try {
            return Response.success(this.serviceMethod.toResponse(exceptionCatchingRequestBody), build);
        } catch (RuntimeException e) {
            exceptionCatchingRequestBody.throwIfCaught();
            throw e;
        }
    }

    @Override // retrofit2.Call
    public synchronized Request request() {
        okhttp3.Call call = this.rawCall;
        if (call != null) {
            return call.request();
        }
        Throwable th2 = this.creationFailure;
        if (th2 != null) {
            if (th2 instanceof IOException) {
                throw new RuntimeException("Unable to create request.", this.creationFailure);
            }
            if (th2 instanceof RuntimeException) {
                throw ((RuntimeException) th2);
            }
            throw ((Error) th2);
        }
        try {
            okhttp3.Call createRawCall = createRawCall();
            this.rawCall = createRawCall;
            return createRawCall.request();
        } catch (IOException e) {
            this.creationFailure = e;
            throw new RuntimeException("Unable to create request.", e);
        } catch (Error e10) {
            e = e10;
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        } catch (RuntimeException e11) {
            e = e11;
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        }
    }

    @Override // retrofit2.Call
    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.serviceMethod, this.args);
    }
}
