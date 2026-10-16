package n;

import android.hardware.camera2.CameraCaptureSession;
import android.media.ImageWriter;
import android.view.Surface;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class t extends CameraCaptureSession.StateCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16303a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f16304b;

    public /* synthetic */ t(Object obj, int i3) {
        this.f16303a = i3;
        this.f16304b = obj;
    }

    private final void a(CameraCaptureSession cameraCaptureSession) {
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onActive(CameraCaptureSession cameraCaptureSession) {
        switch (this.f16303a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f16304b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((CameraCaptureSession.StateCallback) obj).onActive(cameraCaptureSession);
                }
                break;
            case 1:
                n0 n0Var = (n0) this.f16304b;
                n0Var.k(cameraCaptureSession);
                n0Var.a(n0Var);
                break;
            default:
                super.onActive(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onCaptureQueueEmpty(CameraCaptureSession cameraCaptureSession) {
        switch (this.f16303a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f16304b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((CameraCaptureSession.StateCallback) obj).onCaptureQueueEmpty(cameraCaptureSession);
                }
                break;
            case 1:
                n0 n0Var = (n0) this.f16304b;
                n0Var.k(cameraCaptureSession);
                n0Var.b(n0Var);
                break;
            default:
                super.onCaptureQueueEmpty(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onClosed(CameraCaptureSession cameraCaptureSession) {
        switch (this.f16303a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f16304b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((CameraCaptureSession.StateCallback) obj).onClosed(cameraCaptureSession);
                }
                break;
            case 1:
                n0 n0Var = (n0) this.f16304b;
                n0Var.k(cameraCaptureSession);
                n0Var.c(n0Var);
                break;
            default:
                super.onClosed(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        androidx.concurrent.futures.b bVar;
        switch (this.f16303a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f16304b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((CameraCaptureSession.StateCallback) obj).onConfigureFailed(cameraCaptureSession);
                }
                return;
            case 1:
                try {
                    ((n0) this.f16304b).k(cameraCaptureSession);
                    n0 n0Var = (n0) this.f16304b;
                    n0Var.d(n0Var);
                    synchronized (((n0) this.f16304b).f16257a) {
                        pd.e(((n0) this.f16304b).f16264i, "OpenCaptureSession completer should not null");
                        n0 n0Var2 = (n0) this.f16304b;
                        bVar = n0Var2.f16264i;
                        n0Var2.f16264i = null;
                    }
                    bVar.b(new IllegalStateException("onConfigureFailed"));
                    return;
                } catch (Throwable th2) {
                    synchronized (((n0) this.f16304b).f16257a) {
                        pd.e(((n0) this.f16304b).f16264i, "OpenCaptureSession completer should not null");
                        n0 n0Var3 = (n0) this.f16304b;
                        androidx.concurrent.futures.b bVar2 = n0Var3.f16264i;
                        n0Var3.f16264i = null;
                        bVar2.b(new IllegalStateException("onConfigureFailed"));
                        throw th2;
                    }
                }
            default:
                return;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
        androidx.concurrent.futures.b bVar;
        switch (this.f16303a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f16304b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((CameraCaptureSession.StateCallback) obj).onConfigured(cameraCaptureSession);
                }
                return;
            case 1:
                try {
                    ((n0) this.f16304b).k(cameraCaptureSession);
                    n0 n0Var = (n0) this.f16304b;
                    n0Var.e(n0Var);
                    synchronized (((n0) this.f16304b).f16257a) {
                        pd.e(((n0) this.f16304b).f16264i, "OpenCaptureSession completer should not null");
                        n0 n0Var2 = (n0) this.f16304b;
                        bVar = n0Var2.f16264i;
                        n0Var2.f16264i = null;
                    }
                    bVar.a(null);
                    return;
                } catch (Throwable th2) {
                    synchronized (((n0) this.f16304b).f16257a) {
                        pd.e(((n0) this.f16304b).f16264i, "OpenCaptureSession completer should not null");
                        n0 n0Var3 = (n0) this.f16304b;
                        androidx.concurrent.futures.b bVar2 = n0Var3.f16264i;
                        n0Var3.f16264i = null;
                        bVar2.a(null);
                        throw th2;
                    }
                }
            default:
                Surface inputSurface = cameraCaptureSession.getInputSurface();
                if (inputSurface != null) {
                    ((z0) this.f16304b).f16335i = ImageWriter.newInstance(inputSurface, 1);
                    return;
                }
                return;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onReady(CameraCaptureSession cameraCaptureSession) {
        switch (this.f16303a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f16304b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((CameraCaptureSession.StateCallback) obj).onReady(cameraCaptureSession);
                }
                break;
            case 1:
                n0 n0Var = (n0) this.f16304b;
                n0Var.k(cameraCaptureSession);
                n0Var.f(n0Var);
                break;
            default:
                super.onReady(cameraCaptureSession);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onSurfacePrepared(CameraCaptureSession cameraCaptureSession, Surface surface) {
        switch (this.f16303a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f16304b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((CameraCaptureSession.StateCallback) obj).onSurfacePrepared(cameraCaptureSession, surface);
                }
                break;
            case 1:
                n0 n0Var = (n0) this.f16304b;
                n0Var.k(cameraCaptureSession);
                n0Var.h(n0Var, surface);
                break;
            default:
                super.onSurfacePrepared(cameraCaptureSession, surface);
                break;
        }
    }

    public t(List list) {
        this.f16303a = 0;
        this.f16304b = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CameraCaptureSession.StateCallback stateCallback = (CameraCaptureSession.StateCallback) it.next();
            if (!(stateCallback instanceof u)) {
                ((ArrayList) this.f16304b).add(stateCallback);
            }
        }
    }
}
