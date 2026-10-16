package retrofit2.adapter.rxjava2;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import retrofit2.Response;
import rg.l;
import rg.s;
import ug.b;

/* loaded from: classes2.dex */
final class BodyObservable<T> extends l<T> {
    private final l<Response<T>> upstream;

    public static class BodyObserver<R> implements s {
        private final s observer;
        private boolean terminated;

        public BodyObserver(s sVar) {
            this.observer = sVar;
        }

        @Override // rg.s
        public void onComplete() {
            if (this.terminated) {
                return;
            }
            this.observer.onComplete();
        }

        @Override // rg.s
        public void onError(Throwable th2) {
            if (!this.terminated) {
                this.observer.onError(th2);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th2);
            a1.b(assertionError);
        }

        @Override // rg.s
        public void onSubscribe(b bVar) {
            this.observer.onSubscribe(bVar);
        }

        @Override // rg.s
        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.observer.onNext(response.body());
                return;
            }
            this.terminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.observer.onError(httpException);
            } catch (Throwable th2) {
                ad.a(th2);
                a1.b(new CompositeException(httpException, th2));
            }
        }
    }

    public BodyObservable(l<Response<T>> lVar) {
        this.upstream = lVar;
    }

    @Override // rg.l
    public void subscribeActual(s sVar) {
        this.upstream.subscribe(new BodyObserver(sVar));
    }
}
