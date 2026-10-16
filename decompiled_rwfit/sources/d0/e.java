package d0;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.appcompat.app.i0;
import c0.o;
import com.example.blesdk.service.z;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import e0.h;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import t.f1;
import t.r0;
import t.t;

/* loaded from: classes.dex */
public final class e implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a, reason: collision with root package name */
    public final c f12188a;

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f12189b;

    /* renamed from: c, reason: collision with root package name */
    public final w.c f12190c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f12191d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12192f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f12193g;

    /* renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f12194h;

    /* renamed from: i, reason: collision with root package name */
    public SurfaceTexture f12195i;

    /* renamed from: j, reason: collision with root package name */
    public SurfaceTexture f12196j;

    public e(t tVar, r0 r0Var, r0 r0Var2) {
        Map map = Collections.EMPTY_MAP;
        this.e = 0;
        this.f12192f = false;
        this.f12193g = new AtomicBoolean(false);
        this.f12194h = new LinkedHashMap();
        HandlerThread handlerThread = new HandlerThread("GL Thread");
        this.f12189b = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.f12191d = handler;
        this.f12190c = new w.c(handler);
        this.f12188a = new c(r0Var, r0Var2);
        try {
            try {
                ve.a(new c0.b(this, tVar)).get();
            } catch (InterruptedException | ExecutionException e) {
                e = e;
                e = e instanceof ExecutionException ? e.getCause() : e;
                if (!(e instanceof RuntimeException)) {
                    throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", e);
                }
                throw ((RuntimeException) e);
            }
        } catch (RuntimeException e10) {
            d();
            throw e10;
        }
    }

    public final void a() {
        if (this.f12192f && this.e == 0) {
            LinkedHashMap linkedHashMap = this.f12194h;
            Iterator it = linkedHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((o) it.next()).close();
            }
            linkedHashMap.clear();
            c cVar = this.f12188a;
            if (cVar.f3303a.getAndSet(false)) {
                h.c(cVar.f3305c);
                cVar.h();
            }
            cVar.f12181n = -1;
            cVar.f12182o = -1;
            this.f12189b.quit();
        }
    }

    public final void b(Runnable runnable, Runnable runnable2) {
        try {
            this.f12190c.execute(new androidx.camera.camera2.internal.compat.h(this, 8, runnable2, runnable));
        } catch (RejectedExecutionException e) {
            a0.f("DualSurfaceProcessor", "Unable to executor runnable", e);
            runnable2.run();
        }
    }

    public final void c(f1 f1Var) {
        if (this.f12193g.get()) {
            f1Var.c();
        } else {
            b(new i0(15, this, f1Var), new c0.c(f1Var, 0));
        }
    }

    public final void d() {
        if (this.f12193g.getAndSet(true)) {
            return;
        }
        b(new androidx.activity.b(this, 23), new z(6));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2;
        if (this.f12193g.get() || (surfaceTexture2 = this.f12195i) == null || this.f12196j == null) {
            return;
        }
        surfaceTexture2.updateTexImage();
        this.f12196j.updateTexImage();
        for (Map.Entry entry : this.f12194h.entrySet()) {
            Surface surface = (Surface) entry.getValue();
            o oVar = (o) entry.getKey();
            if (oVar.f3345c == 34) {
                try {
                    this.f12188a.l(surfaceTexture.getTimestamp(), surface, oVar, this.f12195i, this.f12196j);
                } catch (RuntimeException e) {
                    a0.c("DualSurfaceProcessor", "Failed to render with OpenGL.", e);
                }
            }
        }
    }
}
