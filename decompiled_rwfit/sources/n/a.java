package n;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.Range;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.Config$OptionPriority;

/* loaded from: classes.dex */
public final class a implements u0 {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.camera.camera2.internal.compat.n f16129a;

    /* renamed from: b, reason: collision with root package name */
    public final Range f16130b;

    /* renamed from: d, reason: collision with root package name */
    public androidx.concurrent.futures.b f16132d;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f16133f;

    /* renamed from: c, reason: collision with root package name */
    public float f16131c = 1.0f;
    public float e = 1.0f;

    public a(androidx.camera.camera2.internal.compat.n nVar) {
        CameraCharacteristics.Key key;
        CameraCharacteristics.Key key2;
        boolean z5 = false;
        this.f16133f = false;
        this.f16129a = nVar;
        key = CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE;
        this.f16130b = (Range) nVar.a(key);
        if (Build.VERSION.SDK_INT >= 34) {
            a2.d dVar = nVar.f1178b;
            key2 = CameraCharacteristics.CONTROL_AVAILABLE_SETTINGS_OVERRIDES;
            int[] iArr = (int[]) ((CameraCharacteristics) dVar.f23b).get(key2);
            if (iArr != null) {
                int length = iArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (iArr[i3] == 1) {
                        z5 = true;
                        break;
                    }
                    i3++;
                }
            }
        }
        this.f16133f = z5;
    }

    @Override // n.u0
    public final void a(TotalCaptureResult totalCaptureResult) {
        CaptureRequest.Key key;
        Float f2;
        if (this.f16132d != null) {
            CaptureRequest request = totalCaptureResult.getRequest();
            if (request == null) {
                f2 = null;
            } else {
                key = CaptureRequest.CONTROL_ZOOM_RATIO;
                f2 = (Float) request.get(key);
            }
            if (f2 == null) {
                return;
            }
            if (this.e == f2.floatValue()) {
                this.f16132d.a(null);
                this.f16132d = null;
            }
        }
    }

    @Override // n.u0
    public final void b(float f2, androidx.concurrent.futures.b bVar) {
        this.f16131c = f2;
        androidx.concurrent.futures.b bVar2 = this.f16132d;
        if (bVar2 != null) {
            bVar2.b(new CameraControl$OperationCanceledException("There is a new zoomRatio being set"));
        }
        this.e = this.f16131c;
        this.f16132d = bVar;
    }

    @Override // n.u0
    public final Rect c() {
        Rect rect = (Rect) this.f16129a.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        rect.getClass();
        return rect;
    }

    @Override // n.u0
    public final float d() {
        return ((Float) this.f16130b.getUpper()).floatValue();
    }

    @Override // n.u0
    public final void e(m.a aVar) {
        CaptureRequest.Key key;
        CaptureRequest.Key key2;
        key = CaptureRequest.CONTROL_ZOOM_RATIO;
        Float valueOf = Float.valueOf(this.f16131c);
        Config$OptionPriority priority = Config$OptionPriority.REQUIRED;
        aVar.c(key, valueOf, priority);
        if (this.f16133f) {
            kotlin.jvm.internal.e.f(priority, "priority");
            if (Build.VERSION.SDK_INT >= 34) {
                key2 = CaptureRequest.CONTROL_SETTINGS_OVERRIDE;
                aVar.c(key2, 1, priority);
            }
        }
    }

    @Override // n.u0
    public final float f() {
        return ((Float) this.f16130b.getLower()).floatValue();
    }

    @Override // n.u0
    public final void g() {
        this.f16131c = 1.0f;
        androidx.concurrent.futures.b bVar = this.f16132d;
        if (bVar != null) {
            bVar.b(new CameraControl$OperationCanceledException("Camera is not active."));
            this.f16132d = null;
        }
    }
}
