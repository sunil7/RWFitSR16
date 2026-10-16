package gf;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import ff.q;

/* loaded from: classes2.dex */
public final class g extends e {

    /* renamed from: f, reason: collision with root package name */
    public static final ef.b f14060f = ef.b.a(q.class.getSimpleName());
    public String e;

    @Override // gf.e
    public final void e(b bVar, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_MODE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num3 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        String str = "aeMode: " + num + " aeLock: " + ((Boolean) totalCaptureResult.get(CaptureResult.CONTROL_AE_LOCK)) + " aeState: " + num2 + " aeTriggerState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER)) + " afState: " + num3 + " afTriggerState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_TRIGGER));
        if (str.equals(this.e)) {
            return;
        }
        this.e = str;
        f14060f.b(1, str);
    }

    @Override // gf.e
    public final void h(b bVar) {
        k(0);
        l(bVar);
    }
}
