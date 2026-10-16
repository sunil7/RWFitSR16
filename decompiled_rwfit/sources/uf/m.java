package uf;

import android.graphics.Rect;
import androidx.camera.core.impl.y0;
import com.google.android.gms.internal.mlkit_vision_common.q;

/* loaded from: classes2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f19090a;

    public m(o oVar) {
        this.f19090a = oVar;
    }

    public final void a(of.a aVar) {
        qf.d dVar = this.f19090a.f19100j;
        of.b bVar = (of.b) aVar;
        bVar.getClass();
        try {
            of.b bVar2 = (of.b) of.b.class.newInstance();
            wf.b bVar3 = bVar.f16926c;
            if (bVar3 != null) {
                bVar2.getClass();
                bVar2.f16926c = new wf.b(bVar3.f19627a, bVar3.f19628b);
            }
            dVar.f17943d = bVar2;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e);
        } catch (InstantiationException e10) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e10);
        }
    }

    public final void b(int i3) {
        o oVar = this.f19090a;
        oVar.getClass();
        oVar.f19100j = new qf.d(new com.otaliastudios.opengl.texture.a(Integer.valueOf(i3)));
        Rect a3 = q.a((wf.b) ((y0) oVar.f194a).f1527d, oVar.f19096f);
        ((y0) oVar.f194a).f1527d = new wf.b(a3.width(), a3.height());
        if (oVar.f19098h) {
            oVar.f19099i = new tf.b(oVar.f19097g, (wf.b) ((y0) oVar.f194a).f1527d);
        }
    }
}
