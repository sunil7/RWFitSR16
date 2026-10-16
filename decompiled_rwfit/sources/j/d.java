package j;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class d implements Iterator, e {

    /* renamed from: a, reason: collision with root package name */
    public c f15155a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15156b = true;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f15157c;

    public d(f fVar) {
        this.f15157c = fVar;
    }

    @Override // j.e
    public final void a(c cVar) {
        c cVar2 = this.f15155a;
        if (cVar == cVar2) {
            c cVar3 = cVar2.f15154d;
            this.f15155a = cVar3;
            this.f15156b = cVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f15156b) {
            return this.f15157c.f15158a != null;
        }
        c cVar = this.f15155a;
        return (cVar == null || cVar.f15153c == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f15156b) {
            this.f15156b = false;
            this.f15155a = this.f15157c.f15158a;
        } else {
            c cVar = this.f15155a;
            this.f15155a = cVar != null ? cVar.f15153c : null;
        }
        return this.f15155a;
    }
}
