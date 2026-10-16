package ff;

import android.graphics.PointF;
import com.otaliastudios.cameraview.CameraView;

/* loaded from: classes2.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f13615a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f13616b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f13617c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float[] f13618d;
    public final /* synthetic */ PointF[] e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ n f13619f;

    public h(n nVar, float f2, boolean z5, float f10, float[] fArr, PointF[] pointFArr) {
        this.f13619f = nVar;
        this.f13615a = f2;
        this.f13616b = z5;
        this.f13617c = f10;
        this.f13618d = fArr;
        this.e = pointFArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar = this.f13619f;
        if (nVar.U(nVar.Z, this.f13615a)) {
            nVar.Y();
            if (this.f13616b) {
                float[] fArr = this.f13618d;
                float f2 = this.f13617c;
                Object[] objArr = {"dispatchOnExposureCorrectionChanged", Float.valueOf(f2)};
                ef.i iVar = nVar.f13647c;
                ((ef.b) iVar.f12629b).b(1, objArr);
                ((CameraView) iVar.f12630c).f11550j.post(new ef.g(iVar, f2, fArr, this.e));
            }
        }
    }
}
