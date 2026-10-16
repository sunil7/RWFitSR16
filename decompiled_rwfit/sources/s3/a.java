package s3;

import android.view.KeyEvent;
import android.view.View;

/* loaded from: classes.dex */
public final class a implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f18163a;

    public a(c cVar) {
        this.f18163a = cVar;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
        if (i3 != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        c cVar = this.f18163a;
        if (cVar.c()) {
            return false;
        }
        if (cVar.f18167c.getParent() == null && !cVar.f18172i) {
            return false;
        }
        cVar.a();
        return true;
    }
}
