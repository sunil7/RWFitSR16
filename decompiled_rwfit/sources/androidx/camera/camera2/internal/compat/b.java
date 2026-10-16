package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.core.impl.h0;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.jieli.bmp_convert.BmpConvert;
import com.jieli.bmp_convert.ConvertResult;
import com.jieli.bmp_convert.OnConvertListener;
import t.f1;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1147a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1148b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1149c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1150d;
    public final /* synthetic */ Object e;

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, Object obj4, int i3) {
        this.f1147a = i3;
        this.f1148b = obj;
        this.f1149c = obj2;
        this.f1150d = obj3;
        this.e = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1147a) {
            case 0:
                ((CameraCaptureSession.CaptureCallback) ((f) this.f1148b).f1165c).onCaptureCompleted((CameraCaptureSession) this.f1149c, (CaptureRequest) this.f1150d, (TotalCaptureResult) this.e);
                break;
            case 1:
                ((CameraCaptureSession.CaptureCallback) ((f) this.f1148b).f1165c).onCaptureProgressed((CameraCaptureSession) this.f1149c, (CaptureRequest) this.f1150d, (CaptureResult) this.e);
                break;
            case 2:
                ((CameraCaptureSession.CaptureCallback) ((f) this.f1148b).f1165c).onCaptureFailed((CameraCaptureSession) this.f1149c, (CaptureRequest) this.f1150d, (CaptureFailure) this.e);
                break;
            case 3:
                ((BmpConvert) this.f1148b).a((ConvertResult) this.f1149c, (OnConvertListener) this.f1150d, (String) this.e);
                break;
            default:
                h0.l lVar = (h0.l) this.f1148b;
                lVar.getClass();
                a0.a("TextureViewImpl", "Safe to release surface.");
                h0 h0Var = lVar.f14247l;
                if (h0Var != null) {
                    h0Var.a();
                    lVar.f14247l = null;
                }
                ((Surface) this.f1149c).release();
                if (lVar.f14242g == ((n0.i) this.f1150d)) {
                    lVar.f14242g = null;
                }
                if (lVar.f14243h == ((f1) this.e)) {
                    lVar.f14243h = null;
                    break;
                }
                break;
        }
    }
}
