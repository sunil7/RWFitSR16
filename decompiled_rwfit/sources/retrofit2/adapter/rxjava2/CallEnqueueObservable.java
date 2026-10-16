package retrofit2.adapter.rxjava2;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rg.l;
import rg.s;
import ug.b;

/* loaded from: classes2.dex */
final class CallEnqueueObservable<T> extends l<Response<T>> {
    private final Call<T> originalCall;

    public static final class CallCallback<T> implements b, Callback<T> {
        private final Call<?> call;
        private volatile boolean disposed;
        private final s observer;
        boolean terminated = false;

        public CallCallback(Call<?> call, s sVar) {
            this.call = call;
            this.observer = sVar;
        }

        @Override // ug.b
        public void dispose() {
            this.disposed = true;
            this.call.cancel();
        }

        @Override // ug.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call, Throwable th2) {
            if (call.isCanceled()) {
                return;
            }
            try {
                this.observer.onError(th2);
            } catch (Throwable th3) {
                ad.a(th3);
                a1.b(new CompositeException(th2, th3));
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call, Response<T> response) {
            if (this.disposed) {
                return;
            }
            try {
                this.observer.onNext(response);
                if (this.disposed) {
                    return;
                }
                this.terminated = true;
                this.observer.onComplete();
            } catch (Throwable th2) {
                if (this.terminated) {
                    a1.b(th2);
                    return;
                }
                if (this.disposed) {
                    return;
                }
                try {
                    this.observer.onError(th2);
                } catch (Throwable th3) {
                    ad.a(th3);
                    a1.b(new CompositeException(th2, th3));
                }
            }
        }
    }

    public CallEnqueueObservable(Call<T> call) {
        this.originalCall = call;
    }

    @Override // rg.l
    public void subscribeActual(s sVar) {
        Call<T> clone = this.originalCall.clone();
        CallCallback callCallback = new CallCallback(clone, sVar);
        sVar.onSubscribe(callCallback);
        clone.enqueue(callCallback);
    }
}
