package ef;

import com.example.test.ui.device.activity.g0;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12625a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f12626b;

    public /* synthetic */ h(i iVar, int i3, byte b3) {
        this.f12625a = i3;
        this.f12626b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12625a) {
            case 0:
                Iterator it = ((CameraView) this.f12626b.f12630c).r.iterator();
                while (it.hasNext()) {
                    ((g0) it.next()).getClass();
                }
                break;
            case 1:
                Iterator it2 = ((CameraView) this.f12626b.f12630c).r.iterator();
                while (it2.hasNext()) {
                    ((g0) it2.next()).getClass();
                }
                break;
            case 2:
                ((CameraView) this.f12626b.f12630c).requestLayout();
                break;
            case 3:
                Iterator it3 = ((CameraView) this.f12626b.f12630c).r.iterator();
                while (it3.hasNext()) {
                    ((g0) it3.next()).getClass();
                }
                break;
            default:
                Iterator it4 = ((CameraView) this.f12626b.f12630c).r.iterator();
                while (it4.hasNext()) {
                    ((g0) it4.next()).getClass();
                }
                break;
        }
    }

    public h(i iVar, int i3) {
        this.f12625a = 4;
        this.f12626b = iVar;
    }

    public h(i iVar, CameraException cameraException) {
        this.f12625a = 0;
        this.f12626b = iVar;
    }
}
