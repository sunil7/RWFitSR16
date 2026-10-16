package ff;

import android.graphics.PointF;
import android.hardware.Camera;
import com.otaliastudios.cameraview.CameraView;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f13602a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f13603b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float[] f13604c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ PointF[] f13605d;
    public final /* synthetic */ e e;

    public c(e eVar, float f2, boolean z5, float[] fArr, PointF[] pointFArr) {
        this.e = eVar;
        this.f13602a = f2;
        this.f13603b = z5;
        this.f13604c = fArr;
        this.f13605d = pointFArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = this.e;
        Camera.Parameters parameters = eVar.V.getParameters();
        if (eVar.U(parameters, this.f13602a)) {
            eVar.V.setParameters(parameters);
            if (this.f13603b) {
                float f2 = eVar.f13663u;
                float[] fArr = this.f13604c;
                Object[] objArr = {"dispatchOnExposureCorrectionChanged", Float.valueOf(f2)};
                ef.i iVar = eVar.f13647c;
                ((ef.b) iVar.f12629b).b(1, objArr);
                ((CameraView) iVar.f12630c).f11550j.post(new ef.g(iVar, f2, fArr, this.f13605d));
            }
        }
    }
}
