package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class v3 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final h.a f1069a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x3 f1070b;

    public v3(x3 x3Var) {
        this.f1070b = x3Var;
        Context context = x3Var.f1109a.getContext();
        CharSequence charSequence = x3Var.f1115h;
        h.a aVar = new h.a();
        aVar.e = 4096;
        aVar.f14072g = 4096;
        aVar.f14077l = null;
        aVar.f14078m = null;
        aVar.f14079n = false;
        aVar.f14080o = false;
        aVar.f14081p = 16;
        aVar.f14074i = context;
        aVar.f14067a = charSequence;
        this.f1069a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        x3 x3Var = this.f1070b;
        Window.Callback callback = x3Var.f1118k;
        if (callback == null || !x3Var.f1119l) {
            return;
        }
        callback.onMenuItemSelected(0, this.f1069a);
    }
}
