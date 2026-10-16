package cf;

import android.graphics.PointF;
import android.media.MediaActionSound;
import android.view.ViewGroup;
import com.example.test.ui.device.activity.g0;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.loper7.date_time_picker.number_picker.NumberPicker;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.gesture.Gesture;
import ef.i;
import ff.n;
import ff.q;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3466a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3467b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3468c;

    public /* synthetic */ b(ViewGroup viewGroup, int i3) {
        this.f3466a = i3;
        this.f3468c = viewGroup;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraView cameraView;
        boolean z5;
        Object obj = this.f3468c;
        switch (this.f3466a) {
            case 0:
                boolean z6 = this.f3467b;
                f fVar = NumberPicker.f11493p1;
                NumberPicker numberPicker = (NumberPicker) obj;
                numberPicker.a(z6);
                numberPicker.postDelayed(this, numberPicker.G);
                break;
            case 1:
                i iVar = (i) obj;
                if (this.f3467b && (z5 = (cameraView = (CameraView) iVar.f12630c).f11542a) && z5) {
                    if (cameraView.f11557q == null) {
                        cameraView.f11557q = new MediaActionSound();
                    }
                    cameraView.f11557q.play(1);
                }
                CameraView cameraView2 = (CameraView) iVar.f12630c;
                ef.b bVar = CameraView.C;
                cameraView2.getClass();
                Iterator it = ((CameraView) iVar.f12630c).r.iterator();
                while (it.hasNext()) {
                    ((g0) it.next()).getClass();
                }
                break;
            case 2:
                ((ff.e) obj).Y(this.f3467b);
                break;
            case 3:
                n nVar = (n) obj;
                CameraState cameraState = nVar.f13648d.e;
                CameraState cameraState2 = CameraState.BIND;
                boolean isAtLeast = cameraState.isAtLeast(cameraState2);
                boolean z8 = this.f3467b;
                if (!isAtLeast || !nVar.n()) {
                    nVar.f13655l = z8;
                    if (nVar.f13648d.e.isAtLeast(cameraState2)) {
                        nVar.A();
                        break;
                    }
                } else {
                    nVar.E(z8);
                    break;
                }
                break;
            default:
                this.f3467b = false;
                int i3 = AspectRatioFrameLayout.f8901d;
                ((AspectRatioFrameLayout) obj).getClass();
                break;
        }
    }

    public /* synthetic */ b(q qVar, boolean z5, int i3) {
        this.f3466a = i3;
        this.f3468c = qVar;
        this.f3467b = z5;
    }

    public b(i iVar, boolean z5, Gesture gesture, PointF pointF) {
        this.f3466a = 1;
        this.f3468c = iVar;
        this.f3467b = z5;
    }
}
