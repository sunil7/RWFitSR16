package z3;

import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public final class b implements e, com.bumptech.glide.load.data.d {

    /* renamed from: a, reason: collision with root package name */
    public final List f20209a;

    /* renamed from: b, reason: collision with root package name */
    public final f f20210b;

    /* renamed from: c, reason: collision with root package name */
    public final d f20211c;

    /* renamed from: d, reason: collision with root package name */
    public int f20212d = -1;
    public x3.c e;

    /* renamed from: f, reason: collision with root package name */
    public List f20213f;

    /* renamed from: g, reason: collision with root package name */
    public int f20214g;

    /* renamed from: h, reason: collision with root package name */
    public volatile d4.p f20215h;

    /* renamed from: i, reason: collision with root package name */
    public File f20216i;

    public b(List list, f fVar, d dVar) {
        this.f20209a = list;
        this.f20210b = fVar;
        this.f20211c = dVar;
    }

    @Override // z3.e
    public final boolean b() {
        while (true) {
            List list = this.f20213f;
            boolean z5 = false;
            if (list != null && this.f20214g < list.size()) {
                this.f20215h = null;
                while (!z5 && this.f20214g < this.f20213f.size()) {
                    List list2 = this.f20213f;
                    int i3 = this.f20214g;
                    this.f20214g = i3 + 1;
                    d4.q qVar = (d4.q) list2.get(i3);
                    File file = this.f20216i;
                    f fVar = this.f20210b;
                    this.f20215h = qVar.a(file, fVar.e, fVar.f20223f, fVar.f20226i);
                    if (this.f20215h != null && this.f20210b.c(this.f20215h.f12282c.a()) != null) {
                        this.f20215h.f12282c.f(this.f20210b.f20232o, this);
                        z5 = true;
                    }
                }
                return z5;
            }
            int i10 = this.f20212d + 1;
            this.f20212d = i10;
            if (i10 >= this.f20209a.size()) {
                return false;
            }
            x3.c cVar = (x3.c) this.f20209a.get(this.f20212d);
            f fVar2 = this.f20210b;
            File f2 = fVar2.f20225h.a().f(new c(cVar, fVar2.f20231n));
            this.f20216i = f2;
            if (f2 != null) {
                this.e = cVar;
                this.f20213f = this.f20210b.f20221c.f6917b.f(f2);
                this.f20214g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void c(Exception exc) {
        this.f20211c.a(this.e, exc, this.f20215h.f12282c, DataSource.DATA_DISK_CACHE);
    }

    @Override // z3.e
    public final void cancel() {
        d4.p pVar = this.f20215h;
        if (pVar != null) {
            pVar.f12282c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(Object obj) {
        this.f20211c.c(this.e, obj, this.f20215h.f12282c, DataSource.DATA_DISK_CACHE, this.e);
    }
}
