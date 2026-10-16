package androidx.camera.camera2.internal;

import androidx.appcompat.app.i0;
import androidx.camera.core.impl.DeferrableSurface$SurfaceClosedException;
import androidx.camera.core.impl.g0;
import androidx.camera.core.impl.p1;
import androidx.camera.core.impl.s1;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.Iterator;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class d implements x.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f1225a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f1226b;

    public d(i iVar, m mVar) {
        this.f1226b = iVar;
        this.f1225a = mVar;
    }

    @Override // x.c
    public final void C(Throwable th2) {
        s1 s1Var = null;
        if (!(th2 instanceof DeferrableSurface$SurfaceClosedException)) {
            if (th2 instanceof CancellationException) {
                this.f1226b.s("Unable to configure camera cancelled", null);
                return;
            }
            Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = this.f1226b.e;
            Camera2CameraImpl$InternalState camera2CameraImpl$InternalState2 = Camera2CameraImpl$InternalState.OPENED;
            if (camera2CameraImpl$InternalState == camera2CameraImpl$InternalState2) {
                this.f1226b.E(camera2CameraImpl$InternalState2, new t.f(4, th2), true);
            }
            a0.c("Camera2CameraImpl", "Unable to configure camera " + this.f1226b, th2);
            i iVar = this.f1226b;
            if (iVar.f1249m == this.f1225a) {
                iVar.C();
                return;
            }
            return;
        }
        i iVar2 = this.f1226b;
        g0 deferrableSurface = ((DeferrableSurface$SurfaceClosedException) th2).getDeferrableSurface();
        Iterator it = iVar2.f1238a.q().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            s1 s1Var2 = (s1) it.next();
            if (s1Var2.b().contains(deferrableSurface)) {
                s1Var = s1Var2;
                break;
            }
        }
        if (s1Var != null) {
            i iVar3 = this.f1226b;
            iVar3.getClass();
            w.c d5 = a6.d();
            p1 p1Var = s1Var.f1489f;
            if (p1Var != null) {
                iVar3.s("Posting surface closed", new Throwable());
                d5.execute(new i0(24, p1Var, s1Var));
            }
        }
    }

    @Override // x.c
    public final void onSuccess(Object obj) {
        i iVar = this.f1226b;
        if (iVar.f1253q.f13516b == 2 && iVar.e == Camera2CameraImpl$InternalState.OPENED) {
            this.f1226b.D(Camera2CameraImpl$InternalState.CONFIGURED);
        }
    }
}
