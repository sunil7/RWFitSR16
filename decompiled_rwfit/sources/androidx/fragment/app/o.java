package androidx.fragment.app;

import android.app.Dialog;
import android.view.View;

/* loaded from: classes.dex */
public final class o extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f2231a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f2232b;

    public o(p pVar, f0 f0Var) {
        this.f2232b = pVar;
        this.f2231a = f0Var;
    }

    @Override // androidx.fragment.app.f0
    public final View b(int i3) {
        f0 f0Var = this.f2231a;
        if (f0Var.c()) {
            return f0Var.b(i3);
        }
        Dialog dialog = this.f2232b.f2246l;
        if (dialog != null) {
            return dialog.findViewById(i3);
        }
        return null;
    }

    @Override // androidx.fragment.app.f0
    public final boolean c() {
        return this.f2231a.c() || this.f2232b.f2250p;
    }
}
