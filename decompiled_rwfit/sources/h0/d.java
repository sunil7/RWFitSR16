package h0;

import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.camera.view.PreviewView;
import com.otaliastudios.cameraview.CameraView;

/* loaded from: classes.dex */
public final class d implements DisplayManager.DisplayListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14219a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14220b;

    public /* synthetic */ d(Object obj, int i3) {
        this.f14219a = i3;
        this.f14220b = obj;
    }

    private final void a(int i3) {
    }

    private final void b(int i3) {
    }

    private final void c(int i3) {
    }

    private final void d(int i3) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i3) {
        int i10 = this.f14219a;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i3) {
        switch (this.f14219a) {
            case 0:
                PreviewView previewView = (PreviewView) this.f14220b;
                Display display = previewView.getDisplay();
                if (display != null && display.getDisplayId() == i3) {
                    previewView.a();
                    break;
                }
                break;
            default:
                qf.g gVar = (qf.g) this.f14220b;
                int i10 = gVar.f17951g;
                int a3 = gVar.a();
                if (a3 != i10) {
                    gVar.f17951g = a3;
                    ef.i iVar = gVar.f17948c;
                    CameraView cameraView = (CameraView) iVar.f12630c;
                    if (cameraView.e()) {
                        ((ef.b) iVar.f12629b).b(2, "onDisplayOffsetChanged", "restarting the camera.");
                        cameraView.close();
                        cameraView.open();
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i3) {
        int i10 = this.f14219a;
    }
}
