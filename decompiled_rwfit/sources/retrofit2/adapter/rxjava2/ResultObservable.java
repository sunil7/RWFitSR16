package retrofit2.adapter.rxjava2;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import retrofit2.Response;
import rg.l;
import rg.s;
import ug.b;

/* loaded from: classes2.dex */
final class ResultObservable<T> extends l<Result<T>> {
    private final l<Response<T>> upstream;

    public static class ResultObserver<R> implements s {
        private final s observer;

        public ResultObserver(s sVar) {
            this.observer = sVar;
        }

        @Override // rg.s
        public void onComplete() {
            this.observer.onComplete();
        }

        @Override // rg.s
        public void onError(Throwable th2) {
            try {
                this.observer.onNext(Result.error(th2));
                this.observer.onComplete();
            } catch (Throwable th3) {
                try {
                    this.observer.onError(th3);
                } catch (Throwable th4) {
                    ad.a(th4);
                    a1.b(new CompositeException(th3, th4));
                }
            }
        }

        @Override // rg.s
        public void onSubscribe(b bVar) {
            this.observer.onSubscribe(bVar);
        }

        @Override // rg.s
        public void onNext(Response<R> response) {
            this.observer.onNext(Result.response(response));
        }
    }

    public ResultObservable(l<Response<T>> lVar) {
        this.upstream = lVar;
    }

    @Override // rg.l
    public void subscribeActual(s sVar) {
        this.upstream.subscribe(new ResultObserver(sVar));
    }
}
