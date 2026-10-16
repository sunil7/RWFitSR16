package ff;

import android.graphics.PointF;
import android.hardware.Camera;
import com.otaliastudios.cameraview.CameraView;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f13598a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f13599b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PointF[] f13600c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f13601d;

    public b(e eVar, float f2, boolean z5, PointF[] pointFArr) {
        this.f13601d = eVar;
        this.f13598a = f2;
        this.f13599b = z5;
        this.f13600c = pointFArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = this.f13601d;
        Camera.Parameters parameters = eVar.V.getParameters();
        if (eVar.b0(parameters, this.f13598a)) {
            eVar.V.setParameters(parameters);
            if (this.f13599b) {
                float f2 = eVar.f13662t;
                Object[] objArr = {"dispatchOnZoomChanged", Float.valueOf(f2)};
                ef.i iVar = eVar.f13647c;
                ((ef.b) iVar.f12629b).b(1, objArr);
                ((CameraView) iVar.f12630c).f11550j.post(new ef.g(iVar, f2, this.f13600c));
            }
        }
    }
}
