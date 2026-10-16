package y2;

import android.content.Context;
import androidx.work.ListenableWorker;
import java.util.UUID;

/* loaded from: classes.dex */
public final class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19966a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.work.impl.utils.futures.b f19967b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f19968c;

    public /* synthetic */ l(m mVar, androidx.work.impl.utils.futures.b bVar, int i3) {
        this.f19966a = i3;
        this.f19968c = mVar;
        this.f19967b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f19966a) {
            case 0:
                this.f19968c.f19973d.getClass();
                androidx.work.impl.utils.futures.b bVar = new androidx.work.impl.utils.futures.b();
                bVar.k(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
                this.f19967b.l(bVar);
                return;
            default:
                m mVar = this.f19968c;
                androidx.work.impl.utils.futures.b bVar2 = mVar.f19970a;
                try {
                    o2.g gVar = (o2.g) this.f19967b.get();
                    x2.h hVar = mVar.f19972c;
                    if (gVar == null) {
                        throw new IllegalStateException("Worker was marked important (" + hVar.f19751c + ") but did not provide ForegroundInfo");
                    }
                    o2.m.g().d(m.f19969g, "Updating notification for " + hVar.f19751c, new Throwable[0]);
                    ListenableWorker listenableWorker = mVar.f19973d;
                    listenableWorker.e = true;
                    n nVar = mVar.e;
                    Context context = mVar.f19971b;
                    UUID uuid = listenableWorker.f2993b.f3001a;
                    nVar.getClass();
                    androidx.work.impl.utils.futures.b bVar3 = new androidx.work.impl.utils.futures.b();
                    nVar.f19975a.p(new gc.j(nVar, bVar3, uuid, gVar, context, 3));
                    bVar2.l(bVar3);
                    return;
                } catch (Throwable th2) {
                    bVar2.k(th2);
                    return;
                }
        }
    }
}
