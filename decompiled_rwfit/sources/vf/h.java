package vf;

import android.view.SurfaceHolder;
import ff.q;

/* loaded from: classes2.dex */
public final class h implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f19256a;

    public h(i iVar) {
        this.f19256a = iVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i10, int i11) {
        ef.b bVar = i.f19257l;
        Integer valueOf = Integer.valueOf(i10);
        Integer valueOf2 = Integer.valueOf(i11);
        i iVar = this.f19256a;
        bVar.b(1, "callback:", "surfaceChanged", "w:", valueOf, "h:", valueOf2, "dispatched:", Boolean.valueOf(iVar.f19258j));
        if (iVar.f19258j) {
            iVar.c(i10, i11);
        } else {
            iVar.b(i10, i11);
            iVar.f19258j = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        i.f19257l.b(1, "callback: surfaceCreated.");
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        i.f19257l.b(1, "callback: surfaceDestroyed");
        i iVar = this.f19256a;
        iVar.f19239d = 0;
        iVar.e = 0;
        q qVar = iVar.f19236a;
        if (qVar != null) {
            q.T.b(1, "onSurfaceDestroyed");
            qVar.R(false);
            qVar.Q(false);
        }
        iVar.f19258j = false;
    }
}
