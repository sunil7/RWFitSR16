package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.os.SystemClock;
import androidx.camera.core.impl.z;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class h extends CameraDevice.StateCallback {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.camera.core.impl.utils.executor.b f1233a;

    /* renamed from: b, reason: collision with root package name */
    public final w.c f1234b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.fragment.app.h f1235c;

    /* renamed from: d, reason: collision with root package name */
    public ScheduledFuture f1236d;
    public final n.m e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i f1237f;

    public h(i iVar, androidx.camera.core.impl.utils.executor.b bVar, w.c cVar, long j4) {
        this.f1237f = iVar;
        this.f1233a = bVar;
        this.f1234b = cVar;
        this.e = new n.m(this, j4);
    }

    public final boolean a() {
        if (this.f1236d == null) {
            return false;
        }
        this.f1237f.s("Cancelling scheduled re-open: " + this.f1235c, null);
        this.f1235c.f2188b = true;
        this.f1235c = null;
        this.f1236d.cancel(false);
        this.f1236d = null;
        return true;
    }

    public final void b() {
        pd.f(null, this.f1235c == null);
        pd.f(null, this.f1236d == null);
        n.m mVar = this.e;
        mVar.getClass();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (mVar.f16251b == -1) {
            mVar.f16251b = uptimeMillis;
        }
        long j4 = uptimeMillis - mVar.f16251b;
        long c9 = mVar.c();
        i iVar = this.f1237f;
        if (j4 >= c9) {
            mVar.f16251b = -1L;
            a0.b("Camera2CameraImpl", "Camera reopening attempted for " + mVar.c() + "ms without success.");
            iVar.E(Camera2CameraImpl$InternalState.PENDING_OPEN, null, false);
            return;
        }
        this.f1235c = new androidx.fragment.app.h(this, this.f1233a);
        iVar.s("Attempting camera re-open in " + mVar.b() + "ms: " + this.f1235c + " activeResuming = " + iVar.D, null);
        this.f1236d = this.f1234b.schedule(this.f1235c, (long) mVar.b(), TimeUnit.MILLISECONDS);
    }

    public final boolean c() {
        i iVar = this.f1237f;
        if (!iVar.D) {
            return false;
        }
        int i3 = iVar.f1248l;
        return i3 == 1 || i3 == 2;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        this.f1237f.s("CameraDevice.onClosed()", null);
        pd.f("Unexpected onClose callback on camera device: " + cameraDevice, this.f1237f.f1247k == null);
        int ordinal = this.f1237f.e.ordinal();
        if (ordinal == 1 || ordinal == 4) {
            pd.f(null, this.f1237f.f1250n.isEmpty());
            this.f1237f.q();
            return;
        }
        if (ordinal != 5 && ordinal != 6) {
            throw new IllegalStateException("Camera closed while in state: " + this.f1237f.e);
        }
        i iVar = this.f1237f;
        int i3 = iVar.f1248l;
        if (i3 == 0) {
            iVar.I(false);
        } else {
            iVar.s("Camera closed due to error: ".concat(i.u(i3)), null);
            b();
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        this.f1237f.s("CameraDevice.onDisconnected()", null);
        onError(cameraDevice, 1);
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i3) {
        i iVar = this.f1237f;
        iVar.f1247k = cameraDevice;
        iVar.f1248l = i3;
        y yVar = iVar.H;
        ((i) yVar.f8774c).s("Camera receive onErrorCallback", null);
        yVar.l();
        int ordinal = this.f1237f.e.ordinal();
        if (ordinal != 1) {
            switch (ordinal) {
                case 4:
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    String id2 = cameraDevice.getId();
                    String u10 = i.u(i3);
                    String name = this.f1237f.e.name();
                    StringBuilder v6 = l0.v("CameraDevice.onError(): ", id2, " failed with ", u10, " while in ");
                    v6.append(name);
                    v6.append(" state. Will attempt recovering from error.");
                    a0.a("Camera2CameraImpl", v6.toString());
                    pd.f("Attempt to handle open error from non open state: " + this.f1237f.e, this.f1237f.e == Camera2CameraImpl$InternalState.OPENING || this.f1237f.e == Camera2CameraImpl$InternalState.OPENED || this.f1237f.e == Camera2CameraImpl$InternalState.CONFIGURED || this.f1237f.e == Camera2CameraImpl$InternalState.REOPENING || this.f1237f.e == Camera2CameraImpl$InternalState.REOPENING_QUIRK);
                    int i10 = 3;
                    if (i3 != 1 && i3 != 2 && i3 != 4) {
                        a0.b("Camera2CameraImpl", "Error observed on open (or opening) camera device " + cameraDevice.getId() + ": " + i.u(i3) + " closing camera.");
                        this.f1237f.E(Camera2CameraImpl$InternalState.CLOSING, new t.f(i3 == 3 ? 5 : 6, null), true);
                        this.f1237f.p();
                        return;
                    }
                    a0.a("Camera2CameraImpl", l0.q("Attempt to reopen camera[", cameraDevice.getId(), "] after error[", i.u(i3), "]"));
                    i iVar2 = this.f1237f;
                    pd.f("Can only reopen camera device after error if the camera device is actually in an error state.", iVar2.f1248l != 0);
                    if (i3 == 1) {
                        i10 = 2;
                    } else if (i3 == 2) {
                        i10 = 1;
                    }
                    iVar2.E(Camera2CameraImpl$InternalState.REOPENING, new t.f(i10, null), true);
                    iVar2.p();
                    return;
                default:
                    throw new IllegalStateException("onError() should not be possible from state: " + this.f1237f.e);
            }
        }
        String id3 = cameraDevice.getId();
        String u11 = i.u(i3);
        String name2 = this.f1237f.e.name();
        StringBuilder v9 = l0.v("CameraDevice.onError(): ", id3, " failed with ", u11, " while in ");
        v9.append(name2);
        v9.append(" state. Will finish closing camera.");
        a0.b("Camera2CameraImpl", v9.toString());
        this.f1237f.p();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        this.f1237f.s("CameraDevice.onOpened()", null);
        i iVar = this.f1237f;
        iVar.f1247k = cameraDevice;
        iVar.f1248l = 0;
        this.e.f16251b = -1L;
        int ordinal = iVar.e.ordinal();
        if (ordinal == 1 || ordinal == 4) {
            pd.f(null, this.f1237f.f1250n.isEmpty());
            this.f1237f.f1247k.close();
            this.f1237f.f1247k = null;
        } else {
            if (ordinal != 5 && ordinal != 6 && ordinal != 7) {
                throw new IllegalStateException("onOpened() should not be possible from state: " + this.f1237f.e);
            }
            this.f1237f.D(Camera2CameraImpl$InternalState.OPENED);
            z zVar = this.f1237f.r;
            String id2 = cameraDevice.getId();
            i iVar2 = this.f1237f;
            if (zVar.e(id2, iVar2.f1253q.c(iVar2.f1247k.getId()))) {
                this.f1237f.A();
            }
        }
    }
}
