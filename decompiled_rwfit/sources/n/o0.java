package n;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class o0 extends j0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16287a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f16288b;

    public o0(List list, int i3) {
        this.f16287a = i3;
        switch (i3) {
            case 1:
                ArrayList arrayList = new ArrayList();
                this.f16288b = arrayList;
                arrayList.addAll(list);
                break;
            default:
                this.f16288b = list.isEmpty() ? new u() : list.size() == 1 ? (CameraCaptureSession.StateCallback) list.get(0) : new t(list);
                break;
        }
    }

    private final void i(n0 n0Var) {
    }

    @Override // n.j0
    public final void a(n0 n0Var) {
        switch (this.f16287a) {
            case 0:
                ((CameraCaptureSession.StateCallback) this.f16288b).onActive((CameraCaptureSession) ((ef.i) n0Var.r().f19953b).f12629b);
                break;
            default:
                ArrayList arrayList = (ArrayList) this.f16288b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((j0) obj).a(n0Var);
                }
                break;
        }
    }

    @Override // n.j0
    public final void b(n0 n0Var) {
        switch (this.f16287a) {
            case 0:
                ((CameraCaptureSession.StateCallback) this.f16288b).onCaptureQueueEmpty((CameraCaptureSession) ((ef.i) n0Var.r().f19953b).f12629b);
                break;
            default:
                ArrayList arrayList = (ArrayList) this.f16288b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((j0) obj).b(n0Var);
                }
                break;
        }
    }

    @Override // n.j0
    public final void c(n0 n0Var) {
        switch (this.f16287a) {
            case 0:
                ((CameraCaptureSession.StateCallback) this.f16288b).onClosed((CameraCaptureSession) ((ef.i) n0Var.r().f19953b).f12629b);
                break;
            default:
                ArrayList arrayList = (ArrayList) this.f16288b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((j0) obj).c(n0Var);
                }
                break;
        }
    }

    @Override // n.j0
    public final void d(n0 n0Var) {
        switch (this.f16287a) {
            case 0:
                ((CameraCaptureSession.StateCallback) this.f16288b).onConfigureFailed((CameraCaptureSession) ((ef.i) n0Var.r().f19953b).f12629b);
                break;
            default:
                ArrayList arrayList = (ArrayList) this.f16288b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((j0) obj).d(n0Var);
                }
                break;
        }
    }

    @Override // n.j0
    public final void e(n0 n0Var) {
        switch (this.f16287a) {
            case 0:
                ((CameraCaptureSession.StateCallback) this.f16288b).onConfigured((CameraCaptureSession) ((ef.i) n0Var.r().f19953b).f12629b);
                break;
            default:
                ArrayList arrayList = (ArrayList) this.f16288b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((j0) obj).e(n0Var);
                }
                break;
        }
    }

    @Override // n.j0
    public final void f(n0 n0Var) {
        switch (this.f16287a) {
            case 0:
                ((CameraCaptureSession.StateCallback) this.f16288b).onReady((CameraCaptureSession) ((ef.i) n0Var.r().f19953b).f12629b);
                break;
            default:
                ArrayList arrayList = (ArrayList) this.f16288b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((j0) obj).f(n0Var);
                }
                break;
        }
    }

    @Override // n.j0
    public final void g(n0 n0Var) {
        switch (this.f16287a) {
            case 0:
                break;
            default:
                ArrayList arrayList = (ArrayList) this.f16288b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((j0) obj).g(n0Var);
                }
                break;
        }
    }

    @Override // n.j0
    public final void h(n0 n0Var, Surface surface) {
        switch (this.f16287a) {
            case 0:
                ((CameraCaptureSession.StateCallback) this.f16288b).onSurfacePrepared((CameraCaptureSession) ((ef.i) n0Var.r().f19953b).f12629b, surface);
                break;
            default:
                ArrayList arrayList = (ArrayList) this.f16288b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((j0) obj).h(n0Var, surface);
                }
                break;
        }
    }
}
