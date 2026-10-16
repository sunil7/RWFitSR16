package y2;

import android.content.Context;
import androidx.work.ListenableWorker;
import com.google.android.gms.internal.mlkit_vision_barcode.ic;

/* loaded from: classes.dex */
public final class m implements Runnable {

    /* renamed from: g, reason: collision with root package name */
    public static final String f19969g = o2.m.i("WorkForegroundRunnable");

    /* renamed from: a, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.b f19970a = new androidx.work.impl.utils.futures.b();

    /* renamed from: b, reason: collision with root package name */
    public final Context f19971b;

    /* renamed from: c, reason: collision with root package name */
    public final x2.h f19972c;

    /* renamed from: d, reason: collision with root package name */
    public final ListenableWorker f19973d;
    public final n e;

    /* renamed from: f, reason: collision with root package name */
    public final de.o f19974f;

    public m(Context context, x2.h hVar, ListenableWorker listenableWorker, n nVar, de.o oVar) {
        this.f19971b = context;
        this.f19972c = hVar;
        this.f19973d = listenableWorker;
        this.e = nVar;
        this.f19974f = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f19972c.f19764q || ic.a()) {
            this.f19970a.j(null);
            return;
        }
        androidx.work.impl.utils.futures.b bVar = new androidx.work.impl.utils.futures.b();
        de.o oVar = this.f19974f;
        ((w.d) oVar.f12379d).execute(new l(this, bVar, 0));
        bVar.a(new l(this, bVar, 1), (w.d) oVar.f12379d);
    }
}
