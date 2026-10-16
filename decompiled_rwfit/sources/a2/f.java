package a2;

import com.autonavi.base.amap.mapcore.AeUtil;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.EmptyList;

/* loaded from: classes.dex */
public final class f extends k {

    /* renamed from: l, reason: collision with root package name */
    public final h5.b f27l;

    /* renamed from: m, reason: collision with root package name */
    public int f28m;

    /* renamed from: n, reason: collision with root package name */
    public int f29n;

    /* renamed from: o, reason: collision with root package name */
    public int f30o;

    /* renamed from: p, reason: collision with root package name */
    public int f31p;

    public f(h5.b bVar, Executor executor, o2.m mVar) {
        super(new m(), i.a.f14327c, executor, mVar);
        this.f28m = 0;
        this.f29n = 0;
        this.f30o = 0;
        this.f31p = 0;
        d dVar = new d(this, 0);
        this.f27l = bVar;
        this.e = -1;
        if (((AtomicBoolean) bVar.f36a).get()) {
            this.f59i.set(true);
        } else {
            int i3 = this.f54c.f16720b;
            w.a aVar = this.f52a;
            g gVar = new g(bVar, dVar);
            ((j5.a) ((j5.d) bVar.f14263c.f7132a.getValue())).getClass();
            EmptyList emptyList = EmptyList.INSTANCE;
            ArrayList arrayList = new ArrayList(kotlin.collections.j.g(emptyList));
            Iterator<E> it = emptyList.iterator();
            if (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                kotlin.jvm.internal.e.f(null, AeUtil.ROOT_DATA_PATH_OLD_NAME);
                throw null;
            }
            int size = emptyList.size();
            if (((AtomicBoolean) bVar.f36a).get()) {
                gVar.f(j.f48c);
            } else {
                if (arrayList.size() > size) {
                    throw new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
                }
                if (arrayList.size() == 0 && size > 0) {
                    throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
                }
                gVar.f(new j(size - arrayList.size(), arrayList));
            }
            synchronized (gVar.f34c) {
                gVar.f35d = aVar;
            }
        }
        this.f54c.getClass();
    }

    @Override // a2.k
    public final void c(k kVar, a aVar) {
        m mVar = kVar.f55d;
        m mVar2 = this.f55d;
        int i3 = mVar2.f70i - mVar.f70i;
        int i10 = mVar2.f69h - mVar.f69h;
        int i11 = mVar.f65c;
        int i12 = mVar.f63a;
        if (mVar.isEmpty() || i3 < 0 || i10 < 0 || mVar2.f65c != Math.max(i11 - i3, 0) || mVar2.f63a != Math.max(i12 - i10, 0) || mVar2.f67f != mVar.f67f + i3 + i10) {
            throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
        }
        if (i3 != 0) {
            int min = Math.min(i11, i3);
            int i13 = i3 - min;
            int i14 = mVar.f63a + mVar.f67f;
            if (min != 0) {
                aVar.f8a.f14a.onChanged(i14, min, null);
            }
            if (i13 != 0) {
                aVar.f8a.f14a.onInserted(i14 + min, i13);
            }
        }
        if (i10 != 0) {
            int min2 = Math.min(i12, i10);
            int i15 = i10 - min2;
            if (min2 != 0) {
                aVar.f8a.f14a.onChanged(i12, min2, null);
            }
            if (i15 != 0) {
                aVar.f8a.f14a.onInserted(0, i15);
            }
        }
    }

    @Override // a2.k
    public final h d() {
        return this.f27l;
    }

    @Override // a2.k
    public final Object e() {
        Object obj = this.f56f;
        h5.b bVar = this.f27l;
        if (obj == null) {
            bVar.getClass();
            return null;
        }
        bVar.getClass();
        throw new ClassCastException();
    }

    @Override // a2.k
    public final boolean f() {
        return true;
    }

    @Override // a2.k
    public final void j(int i3) {
        this.f54c.getClass();
        m mVar = this.f55d;
        int i10 = mVar.f63a;
        int i11 = 1 - (i3 - i10);
        int i12 = (i3 + 2) - (i10 + mVar.f67f);
        int max = Math.max(i11, this.f30o);
        this.f30o = max;
        if (max > 0 && this.f28m == 0) {
            this.f28m = 1;
            m mVar2 = this.f55d;
            this.f53b.execute(new e(this, mVar2.f63a + mVar2.f66d, ((List) mVar2.f64b.get(0)).get(0), 0));
        }
        int max2 = Math.max(i12, this.f31p);
        this.f31p = max2;
        if (max2 <= 0 || this.f29n != 0) {
            return;
        }
        this.f29n = 1;
        m mVar3 = this.f55d;
        int i13 = ((mVar3.f63a + mVar3.f67f) - 1) + mVar3.f66d;
        List list = (List) l0.h(1, mVar3.f64b);
        this.f53b.execute(new e(this, i13, list.get(list.size() - 1), 1));
    }
}
