package c0;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements k1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3284a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3285b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3286c;

    public /* synthetic */ d(int i3, Object obj, Object obj2) {
        this.f3284a = i3;
        this.f3286c = obj;
        this.f3285b = obj2;
    }

    @Override // k1.a
    public final void f(Object obj) {
        switch (this.f3284a) {
            case 0:
                f fVar = (f) this.f3286c;
                fVar.getClass();
                o oVar = (o) this.f3285b;
                oVar.close();
                Surface surface = (Surface) fVar.f3297h.remove(oVar);
                if (surface != null) {
                    h hVar = fVar.f3291a;
                    e0.h.d(hVar.f3303a, true);
                    e0.h.c(hVar.f3305c);
                    hVar.i(surface, true);
                    break;
                }
                break;
            case 1:
                d0.e eVar = (d0.e) this.f3286c;
                eVar.getClass();
                o oVar2 = (o) this.f3285b;
                oVar2.close();
                Surface surface2 = (Surface) eVar.f12194h.remove(oVar2);
                if (surface2 != null) {
                    d0.c cVar = eVar.f12188a;
                    e0.h.d(cVar.f3303a, true);
                    e0.h.c(cVar.f3305c);
                    cVar.i(surface2, true);
                    break;
                }
                break;
            default:
                ((Surface) this.f3286c).release();
                ((SurfaceTexture) this.f3285b).release();
                break;
        }
    }
}
