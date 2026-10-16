package s3;

import android.content.DialogInterface;

/* loaded from: classes.dex */
public final class b implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f18164a;

    public b(c cVar) {
        this.f18164a = cVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f18164a.getClass();
    }
}
