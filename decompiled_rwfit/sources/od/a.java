package od;

import android.os.Looper;
import android.view.View;
import com.jakewharton.rxbinding2.internal.Notification;
import java.util.concurrent.atomic.AtomicBoolean;
import pe.o;
import rg.s;
import tg.d;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f16917a = new AtomicBoolean();

    /* renamed from: b, reason: collision with root package name */
    public final View f16918b;

    /* renamed from: c, reason: collision with root package name */
    public final s f16919c;

    public a(View view, s sVar) {
        this.f16918b = view;
        this.f16919c = sVar;
    }

    @Override // ug.b
    public final void dispose() {
        if (this.f16917a.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f16918b.setOnClickListener(null);
                return;
            }
            d dVar = tg.b.f18629a;
            if (dVar == null) {
                throw new NullPointerException("scheduler == null");
            }
            dVar.c(new o(this, 6));
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f16917a.get();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f16917a.get()) {
            return;
        }
        this.f16919c.onNext(Notification.INSTANCE);
    }
}
