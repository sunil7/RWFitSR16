package a2;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.recyclerview.widget.b f14a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.recyclerview.widget.b f15b;

    /* renamed from: d, reason: collision with root package name */
    public boolean f17d;
    public k e;

    /* renamed from: f, reason: collision with root package name */
    public k f18f;

    /* renamed from: g, reason: collision with root package name */
    public int f19g;

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f16c = new CopyOnWriteArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final a f20h = new a(this);

    public c(h5.a aVar) {
        this.f14a = new androidx.recyclerview.widget.b(aVar);
        synchronized (androidx.recyclerview.widget.c.f2519a) {
            try {
                if (androidx.recyclerview.widget.c.f2520b == null) {
                    androidx.recyclerview.widget.c.f2520b = Executors.newFixedThreadPool(2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f15b = new androidx.recyclerview.widget.b(androidx.recyclerview.widget.c.f2520b);
    }

    public final void a() {
        Iterator it = this.f16c.iterator();
        while (it.hasNext()) {
            ((l) it.next()).f61a.getClass();
        }
    }
}
