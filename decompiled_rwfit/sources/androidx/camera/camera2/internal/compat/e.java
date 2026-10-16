package androidx.camera.camera2.internal.compat;

import android.bluetooth.le.ScanResult;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import java.util.Arrays;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1159a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1160b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1161c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1162d;

    public /* synthetic */ e(androidx.camera.core.impl.k kVar, int i3, Object obj, int i10) {
        this.f1159a = i10;
        this.f1161c = kVar;
        this.f1160b = i3;
        this.f1162d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1159a) {
            case 0:
                ((CameraCaptureSession.CaptureCallback) ((f) this.f1161c).f1165c).onCaptureSequenceAborted((CameraCaptureSession) this.f1162d, this.f1160b);
                break;
            case 1:
                ((CameraDevice.StateCallback) ((p) this.f1161c).f1185b).onError((CameraDevice) this.f1162d, this.f1160b);
                break;
            case 2:
                ((androidx.camera.core.impl.k) this.f1161c).c(this.f1160b, (n9.e) this.f1162d);
                break;
            case 3:
                ((androidx.camera.core.impl.k) this.f1161c).b(this.f1160b, (androidx.camera.core.impl.n) this.f1162d);
                break;
            case 4:
                rd.b bVar = (rd.b) this.f1161c;
                if (bVar != null) {
                    bVar.onSuccess(Arrays.copyOfRange((byte[]) this.f1162d, 0, this.f1160b));
                    break;
                }
                break;
            default:
                t5.c cVar = (t5.c) this.f1161c;
                cVar.f18540b.a(this.f1160b, ((t5.f) t5.b.a()).d((ScanResult) this.f1162d));
                break;
        }
    }

    public /* synthetic */ e(Object obj, Object obj2, int i3, int i10) {
        this.f1159a = i10;
        this.f1161c = obj;
        this.f1162d = obj2;
        this.f1160b = i3;
    }
}
