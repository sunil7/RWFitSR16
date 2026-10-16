package jf;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class a extends gf.e {

    /* renamed from: h, reason: collision with root package name */
    public static final ef.b f15424h = ef.b.a(a.class.getSimpleName());
    public final List e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15425f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f15426g;

    public a(List list, boolean z5) {
        this.e = list;
        this.f15426g = z5;
    }

    @Override // gf.e
    public final void i(gf.b bVar) {
        this.f14058c = bVar;
        boolean z5 = this.f15426g && n(bVar);
        boolean m10 = m(bVar);
        ef.b bVar2 = f15424h;
        if (m10 && !z5) {
            bVar2.b(1, "onStart:", "supported and not skipped. Dispatching onStarted.");
            o(bVar, this.e);
        } else {
            bVar2.b(1, "onStart:", "not supported or skipped. Dispatching COMPLETED state.");
            this.f15425f = true;
            k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        }
    }

    public abstract boolean m(gf.b bVar);

    public abstract boolean n(gf.b bVar);

    public abstract void o(gf.b bVar, List list);
}
