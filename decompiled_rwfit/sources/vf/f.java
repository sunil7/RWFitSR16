package vf;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.R$id;
import com.otaliastudios.cameraview.R$layout;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public final class f extends a implements b, g {

    /* renamed from: j, reason: collision with root package name */
    public boolean f19248j;

    /* renamed from: k, reason: collision with root package name */
    public SurfaceTexture f19249k;

    /* renamed from: l, reason: collision with root package name */
    public qf.d f19250l;

    /* renamed from: m, reason: collision with root package name */
    public final CopyOnWriteArraySet f19251m;

    /* renamed from: n, reason: collision with root package name */
    public float f19252n;

    /* renamed from: o, reason: collision with root package name */
    public float f19253o;

    /* renamed from: p, reason: collision with root package name */
    public ViewGroup f19254p;

    /* renamed from: q, reason: collision with root package name */
    public of.a f19255q;

    public f(Context context, CameraView cameraView) {
        super(context, cameraView);
        this.f19251m = new CopyOnWriteArraySet();
        this.f19252n = 1.0f;
        this.f19253o = 1.0f;
    }

    @Override // vf.a
    public final void a() {
        int i3;
        int i10;
        float c9;
        float f2;
        if (this.f19240f <= 0 || this.f19241g <= 0 || (i3 = this.f19239d) <= 0 || (i10 = this.e) <= 0) {
            return;
        }
        wf.a a3 = wf.a.a(i3, i10);
        wf.a a10 = wf.a.a(this.f19240f, this.f19241g);
        if (a3.c() >= a10.c()) {
            f2 = a3.c() / a10.c();
            c9 = 1.0f;
        } else {
            c9 = a10.c() / a3.c();
            f2 = 1.0f;
        }
        this.f19238c = c9 > 1.02f || f2 > 1.02f;
        this.f19252n = 1.0f / c9;
        this.f19253o = 1.0f / f2;
        ((GLSurfaceView) this.f19237b).requestRender();
    }

    @Override // vf.a
    public final Object d() {
        return this.f19249k;
    }

    @Override // vf.a
    public final Class e() {
        return SurfaceTexture.class;
    }

    @Override // vf.a
    public final View f() {
        return this.f19254p;
    }

    @Override // vf.a
    public final View h(Context context, CameraView cameraView) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R$layout.cameraview_gl_view, (ViewGroup) cameraView, false);
        GLSurfaceView gLSurfaceView = (GLSurfaceView) viewGroup.findViewById(R$id.gl_surface_view);
        e eVar = new e(this);
        gLSurfaceView.setEGLContextClientVersion(2);
        gLSurfaceView.setRenderer(eVar);
        gLSurfaceView.setRenderMode(0);
        gLSurfaceView.getHolder().addCallback(new c(this, gLSurfaceView, eVar));
        cameraView.addView(viewGroup, 0);
        this.f19254p = viewGroup;
        return gLSurfaceView;
    }

    @Override // vf.a
    public final void i() {
        super.i();
        this.f19251m.clear();
    }

    @Override // vf.a
    public final void j() {
        ((GLSurfaceView) this.f19237b).onPause();
    }

    @Override // vf.a
    public final void k() {
        ((GLSurfaceView) this.f19237b).onResume();
    }
}
