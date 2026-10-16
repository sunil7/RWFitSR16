package gf;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes2.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14054a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f14055b;

    public /* synthetic */ c(e eVar, int i3) {
        this.f14054a = i3;
        this.f14055b = eVar;
    }

    @Override // gf.a
    public final void a(e eVar, int i3) {
        switch (this.f14054a) {
            case 0:
                ((d) this.f14055b).k(i3);
                if (i3 == Integer.MAX_VALUE) {
                    eVar.f14056a.remove(this);
                    break;
                }
                break;
            case 1:
                if (i3 == Integer.MAX_VALUE) {
                    eVar.f14056a.remove(this);
                    ((h) this.f14055b).m();
                    break;
                }
                break;
            default:
                j jVar = (j) this.f14055b;
                if (i3 == Integer.MAX_VALUE) {
                    jVar.f14065f.remove(eVar);
                }
                if (jVar.f14065f.isEmpty()) {
                    jVar.k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
                    break;
                }
                break;
        }
    }
}
