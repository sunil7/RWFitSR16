package androidx.camera.camera2.internal;

import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import n.j0;
import n.n0;

/* loaded from: classes.dex */
public final class l extends j0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f1266a;

    public l(m mVar) {
        this.f1266a = mVar;
    }

    @Override // n.j0
    public final void d(n0 n0Var) {
        synchronized (this.f1266a.f1267a) {
            try {
                switch (this.f1266a.f1274i.ordinal()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                        throw new IllegalStateException("onConfigureFailed() should not be possible in state: " + this.f1266a.f1274i);
                    case 3:
                    case 5:
                    case 6:
                        this.f1266a.d();
                        break;
                    case 7:
                        a0.a("CaptureSession", "ConfigureFailed callback after change to RELEASED state");
                        break;
                }
                a0.b("CaptureSession", "CameraCaptureSession.onConfigureFailed() " + this.f1266a.f1274i);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // n.j0
    public final void e(n0 n0Var) {
        synchronized (this.f1266a.f1267a) {
            try {
                switch (this.f1266a.f1274i.ordinal()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                        throw new IllegalStateException("onConfigured() should not be possible in state: " + this.f1266a.f1274i);
                    case 3:
                        m mVar = this.f1266a;
                        mVar.f1274i = CaptureSession$State.OPENED;
                        mVar.e = n0Var;
                        a0.a("CaptureSession", "Attempting to send capture request onConfigured");
                        m mVar2 = this.f1266a;
                        mVar2.j(mVar2.f1271f);
                        m mVar3 = this.f1266a;
                        mVar3.f1280o.e().a(new m5.a(mVar3, 4), a6.a());
                        break;
                    case 5:
                        this.f1266a.e = n0Var;
                        break;
                    case 6:
                        n0Var.j();
                        break;
                }
                a0.a("CaptureSession", "CameraCaptureSession.onConfigured() mState=" + this.f1266a.f1274i);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // n.j0
    public final void f(n0 n0Var) {
        synchronized (this.f1266a.f1267a) {
            try {
                if (this.f1266a.f1274i.ordinal() == 0) {
                    throw new IllegalStateException("onReady() should not be possible in state: " + this.f1266a.f1274i);
                }
                a0.a("CaptureSession", "CameraCaptureSession.onReady() " + this.f1266a.f1274i);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // n.j0
    public final void g(n0 n0Var) {
        synchronized (this.f1266a.f1267a) {
            try {
                if (this.f1266a.f1274i == CaptureSession$State.UNINITIALIZED) {
                    throw new IllegalStateException("onSessionFinished() should not be possible in state: " + this.f1266a.f1274i);
                }
                a0.a("CaptureSession", "onSessionFinished()");
                this.f1266a.d();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
