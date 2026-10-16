package x;

import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import pe.o;

/* loaded from: classes.dex */
public final class l implements ob.a {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f19710a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f19711b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f19712c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicInteger f19713d;
    public final n0.i e = ve.a(new mc.g(this, 23));

    /* renamed from: f, reason: collision with root package name */
    public androidx.concurrent.futures.b f19714f;

    public l(ArrayList arrayList, boolean z5, w.a aVar) {
        this.f19710a = arrayList;
        this.f19711b = new ArrayList(arrayList.size());
        this.f19712c = z5;
        this.f19713d = new AtomicInteger(arrayList.size());
        a(new o(this, 12), a6.a());
        if (this.f19710a.isEmpty()) {
            this.f19714f.a(new ArrayList(this.f19711b));
            return;
        }
        for (int i3 = 0; i3 < this.f19710a.size(); i3++) {
            this.f19711b.add(null);
        }
        ArrayList arrayList2 = this.f19710a;
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            ob.a aVar2 = (ob.a) arrayList2.get(i10);
            aVar2.a(new androidx.activity.f(this, i10, aVar2, 8), aVar);
        }
    }

    @Override // ob.a
    public final void a(Runnable runnable, Executor executor) {
        this.e.f16358b.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z5) {
        ArrayList arrayList = this.f19710a;
        if (arrayList != null) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((ob.a) obj).cancel(z5);
            }
        }
        return this.e.cancel(z5);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) {
        return (List) this.e.f16358b.get(j4, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.e.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.e.f16358b.isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        ArrayList arrayList = this.f19710a;
        if (arrayList != null && !isDone()) {
            int size = arrayList.size();
            int i3 = 0;
            loop0: while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ob.a aVar = (ob.a) obj;
                while (!aVar.isDone()) {
                    try {
                        aVar.get();
                    } catch (Error e) {
                        throw e;
                    } catch (InterruptedException e10) {
                        throw e10;
                    } catch (Throwable unused) {
                        if (this.f19712c) {
                            break loop0;
                        }
                    }
                }
            }
        }
        return (List) this.e.f16358b.get();
    }
}
