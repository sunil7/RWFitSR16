package ff;

import android.graphics.PointF;
import androidx.camera.core.impl.y0;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.wf;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.gesture.Gesture;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class m extends gf.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13627a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13628b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f13629c;

    public /* synthetic */ m(int i3, Object obj, Object obj2) {
        this.f13627a = i3;
        this.f13629c = obj;
        this.f13628b = obj2;
    }

    @Override // gf.f
    public final void b() {
        boolean z5;
        switch (this.f13627a) {
            case 0:
                n nVar = (n) this.f13629c;
                nVar.f13666x = false;
                nVar.f13648d.d("take picture snapshot", CameraState.BIND, new p(nVar, (y0) this.f13628b, false, 1));
                nVar.f13666x = true;
                break;
            case 1:
                n nVar2 = (n) this.f13629c;
                nVar2.f13665w = false;
                nVar2.f13648d.d("take picture", CameraState.BIND, new p(nVar2, (y0) this.f13628b, false, 0));
                nVar2.f13665w = true;
                break;
            default:
                wf wfVar = (wf) this.f13629c;
                n nVar3 = (n) wfVar.f9653b;
                ef.i iVar = nVar3.f13647c;
                Iterator it = ((jf.g) this.f13628b).f15434f.iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    ef.b bVar = jf.g.f15433k;
                    z5 = true;
                    if (!hasNext) {
                        bVar.b(1, "isSuccessful:", "returning true.");
                    } else if (!((jf.a) it.next()).f15425f) {
                        bVar.b(1, "isSuccessful:", "returning false.");
                        z5 = false;
                    }
                }
                iVar.p((Gesture) wfVar.f9654c, z5, (PointF) wfVar.f9655d);
                nVar3.f13648d.e(0, "reset metering");
                long j4 = nVar3.M;
                if (j4 > 0 && j4 != Format.OFFSET_SAMPLE_RELATIVE) {
                    nf.e eVar = nVar3.f13648d;
                    CameraState cameraState = CameraState.PREVIEW;
                    androidx.activity.e eVar2 = new androidx.activity.e(this, 20);
                    eVar.getClass();
                    eVar.b(j4, "reset metering", new nf.a(new nf.d(eVar, cameraState, eVar2, 1), 0), true);
                    break;
                }
                break;
        }
    }
}
