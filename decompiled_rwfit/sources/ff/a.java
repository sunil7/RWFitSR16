package ff;

import android.graphics.PointF;
import android.hardware.Camera;
import com.bingoogolapple.qrcode.core.CameraPreview;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.wf;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.gesture.Gesture;

/* loaded from: classes2.dex */
public final class a implements Camera.AutoFocusCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13596a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13597b;

    public /* synthetic */ a(Object obj, int i3) {
        this.f13596a = i3;
        this.f13597b = obj;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public final void onAutoFocus(boolean z5, Camera camera) {
        Object obj = this.f13597b;
        switch (this.f13596a) {
            case 0:
                wf wfVar = (wf) obj;
                e eVar = (e) wfVar.f9653b;
                eVar.f13648d.e(0, "focus end");
                eVar.f13648d.e(0, "focus reset");
                eVar.f13647c.p((Gesture) wfVar.f9655d, z5, (PointF) wfVar.e);
                long j4 = eVar.M;
                if (j4 > 0 && j4 != Format.OFFSET_SAMPLE_RELATIVE) {
                    nf.e eVar2 = eVar.f13648d;
                    CameraState cameraState = CameraState.ENGINE;
                    androidx.activity.e eVar3 = new androidx.activity.e(this, 18);
                    eVar2.getClass();
                    eVar2.b(j4, "focus reset", new nf.a(new nf.d(eVar2, cameraState, eVar3, 1), 0), true);
                    break;
                }
                break;
            default:
                int i3 = CameraPreview.f6852h;
                ((CameraPreview) obj).e();
                break;
        }
    }
}
