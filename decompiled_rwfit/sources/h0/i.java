package h0;

import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.camera.core.impl.h0;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import java.util.Objects;
import t.f1;

/* loaded from: classes.dex */
public final class i implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    public Size f14231a;

    /* renamed from: b, reason: collision with root package name */
    public f1 f14232b;

    /* renamed from: c, reason: collision with root package name */
    public f1 f14233c;

    /* renamed from: d, reason: collision with root package name */
    public h0 f14234d;
    public Size e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14235f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14236g = false;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ j f14237h;

    public i(j jVar) {
        this.f14237h = jVar;
    }

    public final void a() {
        if (this.f14232b != null) {
            a0.a("SurfaceViewImpl", "Request canceled: " + this.f14232b);
            this.f14232b.c();
        }
    }

    public final boolean b() {
        j jVar = this.f14237h;
        Surface surface = jVar.e.getHolder().getSurface();
        if (this.f14235f || this.f14232b == null || !Objects.equals(this.f14231a, this.e)) {
            return false;
        }
        a0.a("SurfaceViewImpl", "Surface set on Preview.");
        h0 h0Var = this.f14234d;
        f1 f1Var = this.f14232b;
        Objects.requireNonNull(f1Var);
        f1Var.a(surface, a1.g.c(jVar.e.getContext()), new androidx.activity.k(h0Var, 2));
        this.f14235f = true;
        jVar.f14224d = true;
        jVar.f();
        return true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i10, int i11) {
        a0.a("SurfaceViewImpl", "Surface changed. Size: " + i10 + "x" + i11);
        this.e = new Size(i10, i11);
        b();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        f1 f1Var;
        a0.a("SurfaceViewImpl", "Surface created.");
        if (!this.f14236g || (f1Var = this.f14233c) == null) {
            return;
        }
        f1Var.c();
        f1Var.f18326i.a(null);
        this.f14233c = null;
        this.f14236g = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        a0.a("SurfaceViewImpl", "Surface destroyed.");
        if (!this.f14235f) {
            a();
        } else if (this.f14232b != null) {
            a0.a("SurfaceViewImpl", "Surface closed " + this.f14232b);
            this.f14232b.f18328k.a();
        }
        this.f14236g = true;
        f1 f1Var = this.f14232b;
        if (f1Var != null) {
            this.f14233c = f1Var;
        }
        this.f14235f = false;
        this.f14232b = null;
        this.f14234d = null;
        this.e = null;
        this.f14231a = null;
    }
}
