package j;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class b implements Iterator, e {

    /* renamed from: a, reason: collision with root package name */
    public c f15148a;

    /* renamed from: b, reason: collision with root package name */
    public c f15149b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15150c;

    public b(c cVar, c cVar2, int i3) {
        this.f15150c = i3;
        this.f15148a = cVar2;
        this.f15149b = cVar;
    }

    @Override // j.e
    public final void a(c cVar) {
        c cVar2;
        c cVar3 = null;
        if (this.f15148a == cVar && cVar == this.f15149b) {
            this.f15149b = null;
            this.f15148a = null;
        }
        c cVar4 = this.f15148a;
        if (cVar4 == cVar) {
            switch (this.f15150c) {
                case 0:
                    cVar2 = cVar4.f15154d;
                    break;
                default:
                    cVar2 = cVar4.f15153c;
                    break;
            }
            this.f15148a = cVar2;
        }
        c cVar5 = this.f15149b;
        if (cVar5 == cVar) {
            c cVar6 = this.f15148a;
            if (cVar5 != cVar6 && cVar6 != null) {
                cVar3 = b(cVar5);
            }
            this.f15149b = cVar3;
        }
    }

    public final c b(c cVar) {
        switch (this.f15150c) {
            case 0:
                return cVar.f15153c;
            default:
                return cVar.f15154d;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f15149b != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar = this.f15149b;
        c cVar2 = this.f15148a;
        this.f15149b = (cVar == cVar2 || cVar2 == null) ? null : b(cVar);
        return cVar;
    }
}
