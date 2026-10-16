package vf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.mlkit_vision_barcode.xc;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import ff.o;
import ff.q;
import ff.r;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: i, reason: collision with root package name */
    public static final ef.b f19235i = ef.b.a(a.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public q f19236a;

    /* renamed from: b, reason: collision with root package name */
    public final View f19237b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f19238c;

    /* renamed from: d, reason: collision with root package name */
    public int f19239d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f19240f;

    /* renamed from: g, reason: collision with root package name */
    public int f19241g;

    /* renamed from: h, reason: collision with root package name */
    public int f19242h;

    public a(Context context, CameraView cameraView) {
        this.f19237b = h(context, cameraView);
    }

    public void a() {
    }

    public final void b(int i3, int i10) {
        f19235i.b(1, "dispatchOnSurfaceAvailable:", "w=", Integer.valueOf(i3), "h=", Integer.valueOf(i10));
        this.f19239d = i3;
        this.e = i10;
        if (i3 > 0 && i10 > 0) {
            a();
        }
        q qVar = this.f19236a;
        if (qVar != null) {
            a aVar = qVar.e;
            q.T.b(1, "onSurfaceAvailable:", "Size is", new wf.b(aVar.f19239d, aVar.e));
            qVar.f13648d.c(CameraState.ENGINE, CameraState.BIND, true, new r(qVar, 4));
            qVar.O();
        }
    }

    public final void c(int i3, int i10) {
        f19235i.b(1, "dispatchOnSurfaceSizeChanged:", "w=", Integer.valueOf(i3), "h=", Integer.valueOf(i10));
        if (i3 == this.f19239d && i10 == this.e) {
            return;
        }
        this.f19239d = i3;
        this.e = i10;
        if (i3 > 0 && i10 > 0) {
            a();
        }
        q qVar = this.f19236a;
        if (qVar != null) {
            q.T.b(1, "onSurfaceChanged:", "Size is", qVar.k(Reference.VIEW));
            qVar.f13648d.d("surface changed", CameraState.BIND, new o(qVar, 1));
        }
    }

    public abstract Object d();

    public abstract Class e();

    public abstract View f();

    public final boolean g() {
        return this.f19239d > 0 && this.e > 0;
    }

    public abstract View h(Context context, CameraView cameraView);

    public void i() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            View f2 = f();
            ViewParent parent = f2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(f2);
                return;
            }
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        ia.g gVar = new ia.g();
        handler.post(new ia.j(20, this, gVar));
        try {
            xc.a(gVar.f14382a);
        } catch (Exception unused) {
        }
    }

    public void j() {
    }

    public void k() {
    }

    public void l(int i3) {
        this.f19242h = i3;
    }

    public final void m(int i3, int i10) {
        f19235i.b(1, "setStreamSize:", "desiredW=", Integer.valueOf(i3), "desiredH=", Integer.valueOf(i10));
        this.f19240f = i3;
        this.f19241g = i10;
        if (i3 <= 0 || i10 <= 0) {
            return;
        }
        a();
    }

    public final void n(q qVar) {
        q qVar2;
        q qVar3;
        if (g() && (qVar3 = this.f19236a) != null) {
            q.T.b(1, "onSurfaceDestroyed");
            qVar3.R(false);
            qVar3.Q(false);
        }
        this.f19236a = qVar;
        if (!g() || (qVar2 = this.f19236a) == null) {
            return;
        }
        a aVar = qVar2.e;
        q.T.b(1, "onSurfaceAvailable:", "Size is", new wf.b(aVar.f19239d, aVar.e));
        qVar2.f13648d.c(CameraState.ENGINE, CameraState.BIND, true, new r(qVar2, 4));
        qVar2.O();
    }

    public boolean o() {
        return this instanceof f;
    }
}
