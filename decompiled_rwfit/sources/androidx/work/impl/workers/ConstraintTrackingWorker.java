package androidx.work.impl.workers;

import android.content.Context;
import androidx.activity.e;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import java.util.ArrayList;
import java.util.List;
import o2.m;
import t2.b;

/* loaded from: classes.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements b {

    /* renamed from: k, reason: collision with root package name */
    public static final String f3031k = m.i("ConstraintTrkngWrkr");

    /* renamed from: f, reason: collision with root package name */
    public final WorkerParameters f3032f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f3033g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f3034h;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.b f3035i;

    /* renamed from: j, reason: collision with root package name */
    public ListenableWorker f3036j;

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f3032f = workerParameters;
        this.f3033g = new Object();
        this.f3034h = false;
        this.f3035i = new androidx.work.impl.utils.futures.b();
    }

    @Override // androidx.work.ListenableWorker
    public final boolean a() {
        ListenableWorker listenableWorker = this.f3036j;
        return listenableWorker != null && listenableWorker.a();
    }

    @Override // androidx.work.ListenableWorker
    public final void b() {
        ListenableWorker listenableWorker = this.f3036j;
        if (listenableWorker == null || listenableWorker.f2994c) {
            return;
        }
        this.f3036j.f();
    }

    @Override // t2.b
    public final void c(ArrayList arrayList) {
        m.g().d(f3031k, String.format("Constraints changed for %s", arrayList), new Throwable[0]);
        synchronized (this.f3033g) {
            this.f3034h = true;
        }
    }

    @Override // androidx.work.ListenableWorker
    public final androidx.work.impl.utils.futures.b d() {
        this.f2993b.f3003c.execute(new e(this, 8));
        return this.f3035i;
    }

    @Override // t2.b
    public final void e(List list) {
    }
}
