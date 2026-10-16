package androidx.activity;

import androidx.fragment.app.k0;
import com.google.android.gms.internal.mlkit_vision_barcode.ic;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class n implements a {

    /* renamed from: a, reason: collision with root package name */
    public final k0 f371a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f372b;

    public n(o oVar, k0 k0Var) {
        this.f372b = oVar;
        this.f371a = k0Var;
    }

    @Override // androidx.activity.a
    public final void cancel() {
        o oVar = this.f372b;
        ArrayDeque arrayDeque = oVar.f374b;
        k0 k0Var = this.f371a;
        arrayDeque.remove(k0Var);
        k0Var.f2210b.remove(this);
        if (ic.b()) {
            k0Var.f2211c = null;
            oVar.c();
        }
    }
}
