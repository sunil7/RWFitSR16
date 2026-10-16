package d4;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class v implements com.bumptech.glide.load.data.e, com.bumptech.glide.load.data.d {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f12287a;

    /* renamed from: b, reason: collision with root package name */
    public final n.l f12288b;

    /* renamed from: c, reason: collision with root package name */
    public int f12289c;

    /* renamed from: d, reason: collision with root package name */
    public Priority f12290d;
    public com.bumptech.glide.load.data.d e;

    /* renamed from: f, reason: collision with root package name */
    public List f12291f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12292g;

    public v(ArrayList arrayList, n.l lVar) {
        this.f12288b = lVar;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f12287a = arrayList;
        this.f12289c = 0;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        return ((com.bumptech.glide.load.data.e) this.f12287a.get(0)).a();
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        List list = this.f12291f;
        if (list != null) {
            this.f12288b.q(list);
        }
        this.f12291f = null;
        ArrayList arrayList = this.f12287a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((com.bumptech.glide.load.data.e) obj).b();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void c(Exception exc) {
        List list = this.f12291f;
        t4.f.c(list, "Argument must not be null");
        list.add(exc);
        g();
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.f12292g = true;
        ArrayList arrayList = this.f12287a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((com.bumptech.glide.load.data.e) obj).cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(Object obj) {
        if (obj != null) {
            this.e.d(obj);
        } else {
            g();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource e() {
        return ((com.bumptech.glide.load.data.e) this.f12287a.get(0)).e();
    }

    @Override // com.bumptech.glide.load.data.e
    public final void f(Priority priority, com.bumptech.glide.load.data.d dVar) {
        this.f12290d = priority;
        this.e = dVar;
        this.f12291f = (List) this.f12288b.c();
        ((com.bumptech.glide.load.data.e) this.f12287a.get(this.f12289c)).f(priority, this);
        if (this.f12292g) {
            cancel();
        }
    }

    public final void g() {
        if (this.f12292g) {
            return;
        }
        if (this.f12289c < this.f12287a.size() - 1) {
            this.f12289c++;
            f(this.f12290d, this.e);
        } else {
            t4.f.b(this.f12291f);
            this.e.c(new GlideException("Fetch failed", new ArrayList(this.f12291f)));
        }
    }
}
