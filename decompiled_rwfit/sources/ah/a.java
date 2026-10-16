package ah;

import com.google.android.gms.internal.mlkit_vision_barcode.fd;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import rg.s;

/* loaded from: classes2.dex */
public abstract class a implements s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f291a = new AtomicReference();

    @Override // ug.b
    public final void dispose() {
        DisposableHelper.dispose(this.f291a);
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f291a.get() == DisposableHelper.DISPOSED;
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        AtomicReference atomicReference = this.f291a;
        Class<?> cls = getClass();
        xg.c.b(bVar, "next is null");
        while (!atomicReference.compareAndSet(null, bVar)) {
            if (atomicReference.get() != null) {
                bVar.dispose();
                if (atomicReference.get() != DisposableHelper.DISPOSED) {
                    fd.a(cls);
                    return;
                }
                return;
            }
        }
    }
}
