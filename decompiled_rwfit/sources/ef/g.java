package ef;

import android.graphics.PointF;
import com.example.test.ui.device.activity.g0;
import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12622a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f12623b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f12624c;

    public g(i iVar, float f2, PointF[] pointFArr) {
        this.f12624c = iVar;
        this.f12623b = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12622a) {
            case 0:
                Iterator it = ((CameraView) this.f12624c.f12630c).r.iterator();
                while (it.hasNext()) {
                    ((g0) it.next()).getClass();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "Zoom:" + this.f12623b, Boolean.FALSE);
                }
                break;
            default:
                Iterator it2 = ((CameraView) this.f12624c.f12630c).r.iterator();
                while (it2.hasNext()) {
                    ((g0) it2.next()).getClass();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "Exposure correction:" + this.f12623b, Boolean.FALSE);
                }
                break;
        }
    }

    public g(i iVar, float f2, float[] fArr, PointF[] pointFArr) {
        this.f12624c = iVar;
        this.f12623b = f2;
    }
}
