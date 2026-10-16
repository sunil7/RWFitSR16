package uf;

import android.opengl.GLSurfaceView;
import androidx.camera.core.impl.y0;
import com.otaliastudios.cameraview.overlay.Overlay$Target;
import com.otaliastudios.cameraview.overlay.OverlayLayout;
import ff.q;

/* loaded from: classes2.dex */
public class o extends p {
    public final vf.g e;

    /* renamed from: f, reason: collision with root package name */
    public wf.a f19096f;

    /* renamed from: g, reason: collision with root package name */
    public final tf.a f19097g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f19098h;

    /* renamed from: i, reason: collision with root package name */
    public tf.b f19099i;

    /* renamed from: j, reason: collision with root package name */
    public qf.d f19100j;

    public o(y0 y0Var, q qVar, vf.g gVar, wf.a aVar, tf.a aVar2) {
        super(y0Var, qVar);
        this.e = gVar;
        this.f19096f = aVar;
        this.f19097g = aVar2;
        boolean z5 = false;
        if (aVar2 != null) {
            Overlay$Target overlay$Target = Overlay$Target.PICTURE_SNAPSHOT;
            OverlayLayout overlayLayout = (OverlayLayout) aVar2;
            int i3 = 0;
            while (true) {
                if (i3 >= overlayLayout.getChildCount()) {
                    break;
                }
                if (((tf.d) overlayLayout.getChildAt(i3).getLayoutParams()).a(overlay$Target)) {
                    z5 = true;
                    break;
                }
                i3++;
            }
        }
        this.f19098h = z5;
    }

    @Override // ab.n
    public void n() {
        this.f19096f = null;
        super.n();
    }

    @Override // ab.n
    public void u() {
        m mVar = new m(this);
        vf.f fVar = (vf.f) this.e;
        ((GLSurfaceView) fVar.f19237b).queueEvent(new ia.j(21, fVar, mVar));
    }
}
