package ff;

import android.graphics.PointF;
import com.otaliastudios.cameraview.CameraView;

/* loaded from: classes2.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f13611a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f13612b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f13613c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ PointF[] f13614d;
    public final /* synthetic */ n e;

    public g(n nVar, float f2, boolean z5, float f10, PointF[] pointFArr) {
        this.e = nVar;
        this.f13611a = f2;
        this.f13612b = z5;
        this.f13613c = f10;
        this.f13614d = pointFArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar = this.e;
        if (nVar.b0(nVar.Z, this.f13611a)) {
            nVar.Y();
            if (this.f13612b) {
                float f2 = this.f13613c;
                Object[] objArr = {"dispatchOnZoomChanged", Float.valueOf(f2)};
                ef.i iVar = nVar.f13647c;
                ((ef.b) iVar.f12629b).b(1, objArr);
                ((CameraView) iVar.f12630c).f11550j.post(new ef.g(iVar, f2, this.f13614d));
            }
        }
    }
}
