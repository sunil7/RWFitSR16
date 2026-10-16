package od;

import android.os.Looper;
import android.view.View;
import rg.l;
import rg.s;

/* loaded from: classes.dex */
public final class b extends l {

    /* renamed from: a, reason: collision with root package name */
    public final View f16920a;

    public b(View view) {
        this.f16920a = view;
    }

    @Override // rg.l
    public final void subscribeActual(s sVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            sVar.onError(new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName()));
        } else {
            View view = this.f16920a;
            a aVar = new a(view, sVar);
            sVar.onSubscribe(aVar);
            view.setOnClickListener(aVar);
        }
    }
}
