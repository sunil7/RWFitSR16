package a2;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class k extends AbstractList {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f51k = 0;

    /* renamed from: a, reason: collision with root package name */
    public final w.a f52a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f53b;

    /* renamed from: c, reason: collision with root package name */
    public final o2.m f54c;

    /* renamed from: d, reason: collision with root package name */
    public final m f55d;
    public int e = 0;

    /* renamed from: f, reason: collision with root package name */
    public Object f56f = null;

    /* renamed from: g, reason: collision with root package name */
    public int f57g = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: h, reason: collision with root package name */
    public int f58h = Integer.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f59i = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f60j = new ArrayList();

    public k(m mVar, w.a aVar, Executor executor, o2.m mVar2) {
        this.f55d = mVar;
        this.f52a = aVar;
        this.f53b = executor;
        this.f54c = mVar2;
        mVar2.getClass();
    }

    public final void a(List list, a aVar) {
        if (list != null && list != this) {
            if (list.isEmpty()) {
                m mVar = this.f55d;
                if (!mVar.isEmpty()) {
                    aVar.f8a.f14a.onInserted(0, mVar.size());
                }
            } else {
                c((k) list, aVar);
            }
        }
        ArrayList arrayList = this.f60j;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((a) ((WeakReference) arrayList.get(size)).get()) == null) {
                arrayList.remove(size);
            }
        }
        arrayList.add(new WeakReference(aVar));
    }

    public abstract void c(k kVar, a aVar);

    public abstract h d();

    public abstract Object e();

    public abstract boolean f();

    public boolean g() {
        return this.f59i.get();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        Object obj = this.f55d.get(i3);
        if (obj != null) {
            this.f56f = obj;
        }
        return obj;
    }

    public boolean h() {
        return g();
    }

    public final void i(int i3) {
        m mVar = this.f55d;
        if (i3 < 0 || i3 >= mVar.size()) {
            StringBuilder q5 = android.support.v4.media.session.e.q(i3, "Index: ", ", Size: ");
            q5.append(mVar.size());
            throw new IndexOutOfBoundsException(q5.toString());
        }
        this.e = mVar.f66d + i3;
        j(i3);
        this.f57g = Math.min(this.f57g, i3);
        this.f58h = Math.max(this.f58h, i3);
    }

    public abstract void j(int i3);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f55d.size();
    }
}
