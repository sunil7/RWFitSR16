package ff;

import androidx.camera.core.impl.y0;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.engine.offset.Reference;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13641a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y0 f13642b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f13643c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q f13644d;

    public /* synthetic */ p(q qVar, y0 y0Var, boolean z5, int i3) {
        this.f13641a = i3;
        this.f13644d = qVar;
        this.f13642b = y0Var;
        this.f13643c = z5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z5 = this.f13643c;
        y0 y0Var = this.f13642b;
        q qVar = this.f13644d;
        switch (this.f13641a) {
            case 0:
                q.T.b(1, "takePicture:", "running. isTakingPicture:", Boolean.valueOf(qVar.o()));
                if (qVar.o()) {
                    return;
                }
                if (qVar.G == Mode.VIDEO) {
                    throw new IllegalStateException("Can't take hq pictures while in VIDEO mode");
                }
                y0Var.f1524a = false;
                y0Var.f1526c = qVar.f13661s;
                y0Var.f1528f = qVar.r;
                qVar.w(y0Var, z5);
                return;
            default:
                q.T.b(1, "takePictureSnapshot:", "running. isTakingPicture:", Boolean.valueOf(qVar.o()));
                if (qVar.o()) {
                    return;
                }
                y0Var.f1526c = qVar.f13661s;
                y0Var.f1524a = true;
                y0Var.f1528f = PictureFormat.JPEG;
                wf.b k10 = qVar.k(Reference.OUTPUT);
                HashMap hashMap = wf.a.f19624c;
                qVar.x(y0Var, wf.a.a(k10.f19627a, k10.f19628b), z5);
                return;
        }
    }
}
