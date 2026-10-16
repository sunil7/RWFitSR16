package z3;

import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class t implements e, com.bumptech.glide.load.data.d {

    /* renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.b f20292a;

    /* renamed from: b, reason: collision with root package name */
    public final f f20293b;

    /* renamed from: c, reason: collision with root package name */
    public int f20294c;

    /* renamed from: d, reason: collision with root package name */
    public int f20295d = -1;
    public x3.c e;

    /* renamed from: f, reason: collision with root package name */
    public List f20296f;

    /* renamed from: g, reason: collision with root package name */
    public int f20297g;

    /* renamed from: h, reason: collision with root package name */
    public volatile d4.p f20298h;

    /* renamed from: i, reason: collision with root package name */
    public File f20299i;

    /* renamed from: j, reason: collision with root package name */
    public u f20300j;

    public t(f fVar, com.bumptech.glide.load.engine.b bVar) {
        this.f20293b = fVar;
        this.f20292a = bVar;
    }

    @Override // z3.e
    public final boolean b() {
        List list;
        boolean z5;
        List list2;
        boolean z6;
        ArrayList c9;
        ArrayList a3 = this.f20293b.a();
        if (a3.isEmpty()) {
            return false;
        }
        f fVar = this.f20293b;
        com.bumptech.glide.g gVar = fVar.f20221c.f6917b;
        Class<?> cls = fVar.f20222d.getClass();
        Class cls2 = fVar.f20224g;
        Class cls3 = fVar.f20228k;
        o4.c cVar = gVar.f6931h;
        t4.j jVar = (t4.j) ((AtomicReference) cVar.f16732a).getAndSet(null);
        if (jVar == null) {
            jVar = new t4.j(cls, cls2, cls3);
        } else {
            jVar.f18519a = cls;
            jVar.f18520b = cls2;
            jVar.f18521c = cls3;
        }
        synchronized (((m0.b) cVar.f16733b)) {
            list = (List) ((m0.b) cVar.f16733b).getOrDefault(jVar, null);
        }
        ((AtomicReference) cVar.f16732a).set(jVar);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            d4.u uVar = gVar.f6925a;
            synchronized (uVar) {
                c9 = uVar.f12285a.c(cls);
            }
            int size = c9.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = c9.get(i3);
                i3++;
                ArrayList f2 = gVar.f6927c.f((Class) obj, cls2);
                int size2 = f2.size();
                int i10 = 0;
                while (i10 < size2) {
                    Object obj2 = f2.get(i10);
                    i10++;
                    Class cls4 = (Class) obj2;
                    if (!gVar.f6929f.b(cls4, cls3).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            z5 = false;
            o4.c cVar2 = gVar.f6931h;
            List unmodifiableList = Collections.unmodifiableList(arrayList);
            synchronized (((m0.b) cVar2.f16733b)) {
                ((m0.b) cVar2.f16733b).put(new t4.j(cls, cls2, cls3), unmodifiableList);
            }
            list2 = arrayList;
        } else {
            z5 = false;
            list2 = list;
        }
        if (list2.isEmpty()) {
            if (File.class.equals(this.f20293b.f20228k)) {
                return z5;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f20293b.f20222d.getClass() + " to " + this.f20293b.f20228k);
        }
        while (true) {
            List list3 = this.f20296f;
            if (list3 != null && this.f20297g < list3.size()) {
                this.f20298h = null;
                while (!z5 && this.f20297g < this.f20296f.size()) {
                    List list4 = this.f20296f;
                    int i11 = this.f20297g;
                    this.f20297g = i11 + 1;
                    d4.q qVar = (d4.q) list4.get(i11);
                    File file = this.f20299i;
                    f fVar2 = this.f20293b;
                    this.f20298h = qVar.a(file, fVar2.e, fVar2.f20223f, fVar2.f20226i);
                    if (this.f20298h != null && this.f20293b.c(this.f20298h.f12282c.a()) != null) {
                        this.f20298h.f12282c.f(this.f20293b.f20232o, this);
                        z5 = true;
                    }
                }
                return z5;
            }
            int i12 = this.f20295d + 1;
            this.f20295d = i12;
            if (i12 >= list2.size()) {
                int i13 = this.f20294c + 1;
                this.f20294c = i13;
                if (i13 >= a3.size()) {
                    return z5;
                }
                this.f20295d = z5 ? 1 : 0;
            }
            x3.c cVar3 = (x3.c) a3.get(this.f20294c);
            Class cls5 = (Class) list2.get(this.f20295d);
            x3.i e = this.f20293b.e(cls5);
            f fVar3 = this.f20293b;
            this.f20300j = new u(fVar3.f20221c.f6916a, cVar3, fVar3.f20231n, fVar3.e, fVar3.f20223f, e, cls5, fVar3.f20226i);
            File f10 = fVar3.f20225h.a().f(this.f20300j);
            this.f20299i = f10;
            if (f10 != null) {
                this.e = cVar3;
                this.f20296f = this.f20293b.f20221c.f6917b.f(f10);
                z6 = false;
                this.f20297g = 0;
            } else {
                z6 = false;
            }
            z5 = z6;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void c(Exception exc) {
        this.f20292a.a(this.f20300j, exc, this.f20298h.f12282c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // z3.e
    public final void cancel() {
        d4.p pVar = this.f20298h;
        if (pVar != null) {
            pVar.f12282c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(Object obj) {
        this.f20292a.c(this.e, obj, this.f20298h.f12282c, DataSource.RESOURCE_DISK_CACHE, this.f20300j);
    }
}
