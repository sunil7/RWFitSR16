package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* loaded from: classes.dex */
public final class m implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f2221a;

    public m(p pVar) {
        this.f2221a = pVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        p pVar = this.f2221a;
        Dialog dialog = pVar.f2246l;
        if (dialog != null) {
            pVar.onCancel(dialog);
        }
    }
}
