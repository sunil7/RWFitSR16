package jf;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.otaliastudios.cameraview.engine.offset.Reference;
import ff.n;
import gf.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class g extends gf.d {

    /* renamed from: k, reason: collision with root package name */
    public static final ef.b f15433k = ef.b.a(g.class.getSimpleName());

    /* renamed from: f, reason: collision with root package name */
    public List f15434f;

    /* renamed from: g, reason: collision with root package name */
    public j f15435g;

    /* renamed from: h, reason: collision with root package name */
    public final l4.c f15436h;

    /* renamed from: i, reason: collision with root package name */
    public final n f15437i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f15438j;

    public g(n nVar, l4.c cVar, boolean z5) {
        super(0);
        this.f15436h = cVar;
        this.f15437i = nVar;
        this.f15438j = z5;
    }

    @Override // gf.d, gf.e
    public final void i(gf.b bVar) {
        ef.b bVar2 = f15433k;
        bVar2.b(2, "onStart:", "initializing.");
        List arrayList = new ArrayList();
        l4.c cVar = this.f15436h;
        if (cVar != null) {
            n nVar = this.f15437i;
            lf.b bVar3 = nVar.B;
            vf.a aVar = nVar.e;
            wf.b bVar4 = new wf.b(aVar.f19239d, aVar.e);
            wf.b j4 = nVar.j(Reference.VIEW);
            boolean z5 = nVar.e.f19238c;
            n nVar2 = (n) bVar;
            kf.b bVar5 = new kf.b(bVar3, bVar4, j4, z5, nVar2.X, nVar2.Z);
            arrayList = cVar.c(bVar5).a(SubsamplingScaleImageView.TILE_SIZE_AUTO, bVar5);
        }
        boolean z6 = this.f15438j;
        c cVar2 = new c(arrayList, z6);
        cVar2.f15428i = false;
        cVar2.f15429j = false;
        e eVar = new e(arrayList, z6);
        h hVar = new h(arrayList, z6);
        this.f15434f = Arrays.asList(cVar2, eVar, hVar);
        this.f15435g = new j(Arrays.asList(cVar2, eVar, hVar));
        bVar2.b(2, "onStart:", "initialized.");
        super.i(bVar);
    }

    @Override // gf.d
    public final gf.e o() {
        return this.f15435g;
    }
}
