package androidx.activity;

import androidx.fragment.app.k0;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import com.google.android.gms.internal.mlkit_vision_barcode.ic;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements q, a {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.lifecycle.n f350a;

    /* renamed from: b, reason: collision with root package name */
    public final k0 f351b;

    /* renamed from: c, reason: collision with root package name */
    public n f352c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o f353d;

    public OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(o oVar, androidx.lifecycle.n nVar, k0 k0Var) {
        this.f353d = oVar;
        this.f350a = nVar;
        this.f351b = k0Var;
        nVar.a(this);
    }

    @Override // androidx.lifecycle.q
    public final void c(s sVar, Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event != Lifecycle$Event.ON_START) {
            if (lifecycle$Event != Lifecycle$Event.ON_STOP) {
                if (lifecycle$Event == Lifecycle$Event.ON_DESTROY) {
                    cancel();
                    return;
                }
                return;
            } else {
                n nVar = this.f352c;
                if (nVar != null) {
                    nVar.cancel();
                    return;
                }
                return;
            }
        }
        o oVar = this.f353d;
        ArrayDeque arrayDeque = oVar.f374b;
        k0 k0Var = this.f351b;
        arrayDeque.add(k0Var);
        n nVar2 = new n(oVar, k0Var);
        k0Var.f2210b.add(nVar2);
        if (ic.b()) {
            oVar.c();
            k0Var.f2211c = oVar.f375c;
        }
        this.f352c = nVar2;
    }

    @Override // androidx.activity.a
    public final void cancel() {
        this.f350a.b(this);
        this.f351b.f2210b.remove(this);
        n nVar = this.f352c;
        if (nVar != null) {
            nVar.cancel();
            this.f352c = null;
        }
    }
}
