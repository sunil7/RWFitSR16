package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* loaded from: classes.dex */
public final class n implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f2226a;

    public n(p pVar) {
        this.f2226a = pVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        p pVar = this.f2226a;
        Dialog dialog = pVar.f2246l;
        if (dialog != null) {
            pVar.onDismiss(dialog);
        }
    }
}
