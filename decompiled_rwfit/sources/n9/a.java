package n9;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import q9.n;

/* loaded from: classes.dex */
public class a extends DialogFragment {

    /* renamed from: a, reason: collision with root package name */
    public AlertDialog f16434a;

    /* renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f16435b;

    /* renamed from: c, reason: collision with root package name */
    public AlertDialog f16436c;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f16435b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog alertDialog = this.f16434a;
        if (alertDialog != null) {
            return alertDialog;
        }
        setShowsDialog(false);
        if (this.f16436c == null) {
            Activity activity = getActivity();
            n.e(activity);
            this.f16436c = new AlertDialog.Builder(activity).create();
        }
        return this.f16436c;
    }
}
