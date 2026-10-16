package retrofit2.adapter.rxjava2;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import retrofit2.Call;
import retrofit2.Response;
import rg.l;
import rg.s;
import ug.b;

/* loaded from: classes2.dex */
final class CallExecuteObservable<T> extends l<Response<T>> {
    private final Call<T> originalCall;

    public static final class CallDisposable implements b {
        private final Call<?> call;
        private volatile boolean disposed;

        public CallDisposable(Call<?> call) {
            this.call = call;
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
    }

    public CallExecuteObservable(Call<T> call) {
        this.originalCall = call;
    }

    @Override // rg.l
    public void subscribeActual(s sVar) {
        Call<T> clone = this.originalCall.clone();
        CallDisposable callDisposable = new CallDisposable(clone);
        sVar.onSubscribe(callDisposable);
        boolean z5 = false;
        try {
            Response<T> execute = clone.execute();
            if (!callDisposable.isDisposed()) {
                sVar.onNext(execute);
            }
            if (callDisposable.isDisposed()) {
                return;
            }
            try {
                sVar.onComplete();
            } catch (Throwable th2) {
                th = th2;
                z5 = true;
                ad.a(th);
                if (z5) {
                    a1.b(th);
                    return;
                }
                if (callDisposable.isDisposed()) {
                    return;
                }
                try {
                    sVar.onError(th);
                } catch (Throwable th3) {
                    ad.a(th3);
                    a1.b(new CompositeException(th, th3));
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
