package n9;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.p;
import q9.n;

/* loaded from: classes.dex */
public class f extends p {

    /* renamed from: q, reason: collision with root package name */
    public AlertDialog f16446q;
    public DialogInterface.OnCancelListener r;

    /* renamed from: s, reason: collision with root package name */
    public AlertDialog f16447s;

    @Override // androidx.fragment.app.p
    public final Dialog W() {
        AlertDialog alertDialog = this.f16446q;
        if (alertDialog != null) {
            return alertDialog;
        }
        this.f2242h = false;
        if (this.f16447s == null) {
            Context context = getContext();
            n.e(context);
            this.f16447s = new AlertDialog.Builder(context).create();
        }
        return this.f16447s;
    }

    @Override // androidx.fragment.app.p, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.r;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
