package o6;

import android.os.Handler;
import android.os.Looper;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.qd;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public final class h extends Thread {

    /* renamed from: d, reason: collision with root package name */
    public final XXApplication f16769d;
    public final f e;

    /* renamed from: f, reason: collision with root package name */
    public final n6.a f16770f;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue f16766a = new LinkedBlockingQueue();

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f16767b = false;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f16768c = false;

    /* renamed from: g, reason: collision with root package name */
    public final Handler f16771g = new Handler(Looper.getMainLooper());

    public h(XXApplication xXApplication, f fVar, n6.a aVar) {
        this.f16769d = xXApplication;
        this.e = fVar;
        this.f16770f = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        final long id2 = getId();
        if (this.f16770f != null) {
            this.f16771g.post(new m5.a(this, id2, 9));
        }
        if (this.e == null || !qd.a(this.f16769d)) {
            if (this.f16770f != null) {
                final int i3 = 0;
                this.f16771g.post(new Runnable(this) { // from class: o6.d

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ h f16757b;

                    {
                        this.f16757b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i3) {
                            case 0:
                                p pVar = (p) this.f16757b.f16770f.f16381b;
                                h hVar = pVar.f16797m;
                                if (hVar != null && hVar.getId() == id2) {
                                    pVar.f16797m = null;
                                    break;
                                }
                                break;
                            default:
                                p pVar2 = (p) this.f16757b.f16770f.f16381b;
                                h hVar2 = pVar2.f16797m;
                                if (hVar2 != null && hVar2.getId() == id2) {
                                    pVar2.f16797m = null;
                                    break;
                                }
                                break;
                        }
                    }
                });
                return;
            }
            return;
        }
        synchronized (this.f16766a) {
            while (this.f16767b) {
                this.f16768c = this.f16766a.isEmpty();
                if (this.f16768c) {
                    ee.c.b(2, "SendSppDataThread", "queue is empty, so waiting for data");
                    try {
                        this.f16766a.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    g gVar = (g) this.f16766a.poll();
                    if (gVar != null) {
                        try {
                            this.f16771g.post(new e(gVar, ((p) this.e).j(gVar.f16762a, gVar.f16763b, gVar.f16764c), 0));
                        } catch (IOException e10) {
                            e10.printStackTrace();
                            this.f16767b = false;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        this.f16766a.clear();
        if (this.f16770f != null) {
            final int i10 = 1;
            this.f16771g.post(new Runnable(this) { // from class: o6.d

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ h f16757b;

                {
                    this.f16757b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i10) {
                        case 0:
                            p pVar = (p) this.f16757b.f16770f.f16381b;
                            h hVar = pVar.f16797m;
                            if (hVar != null && hVar.getId() == id2) {
                                pVar.f16797m = null;
                                break;
                            }
                            break;
                        default:
                            p pVar2 = (p) this.f16757b.f16770f.f16381b;
                            h hVar2 = pVar2.f16797m;
                            if (hVar2 != null && hVar2.getId() == id2) {
                                pVar2.f16797m = null;
                                break;
                            }
                            break;
                    }
                }
            });
        }
    }

    @Override // java.lang.Thread
    public final synchronized void start() {
        this.f16767b = true;
        super.start();
    }
}
