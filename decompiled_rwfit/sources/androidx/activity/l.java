package androidx.activity;

import android.window.OnBackInvokedCallback;
import androidx.appcompat.app.c0;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements OnBackInvokedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f369a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f370b;

    public /* synthetic */ l(Object obj, int i3) {
        this.f369a = i3;
        this.f370b = obj;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        switch (this.f369a) {
            case 0:
                ((Runnable) this.f370b).run();
                break;
            default:
                ((c0) this.f370b).D();
                break;
        }
    }
}
