package com.amap.api.col.p0003sl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* loaded from: classes.dex */
public class k0 extends GLSurfaceView implements IGLSurfaceView {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f4363a;

    /* renamed from: b, reason: collision with root package name */
    private GLMapRender f4364b;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k0.this.f4364b != null) {
                try {
                    k0.this.f4364b.onSurfaceDestory();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    v4.a(th2);
                }
            }
        }
    }

    public k0(Context context, AttributeSet attributeSet, boolean z5) {
        super(context, null);
        this.f4363a = null;
        this.f4364b = null;
        x.a(this, 5, 6, 5, 0, 16, 8);
        this.f4363a = new b0(this, context, z5);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        y4.b("[map][lifecycle]", "AMapGLSurfaceView onAttachedToWindow");
        try {
            GLMapRender gLMapRender = this.f4364b;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            v4.a(th2);
        }
        onResume();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        y4.b("[map][lifecycle]", "AMapGLSurfaceView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        onPause();
        try {
            GLMapRender gLMapRender = this.f4364b;
            if (gLMapRender != null) {
                gLMapRender.onDetachedFromWindow();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void onDetachedGLThread() {
        y4.b("[map][lifecycle]", "AMapGLSurfaceView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            onPause();
            try {
                GLMapRender gLMapRender = this.f4364b;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                v4.a(th2);
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        y4.b("[map][lifecycle]", "AMapGLSurfaceView onPause mMapRender.mSurfacedestoryed " + this.f4364b.mSurfacedestoryed);
        if (!this.f4364b.mSurfacedestoryed) {
            queueEvent(new a());
            int i3 = 0;
            while (!this.f4364b.mSurfacedestoryed) {
                int i10 = i3 + 1;
                if (i3 >= 50) {
                    break;
                }
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException unused) {
                }
                i3 = i10;
            }
        }
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        y4.b("[map][lifecycle]", "AMapGLSurfaceView onPause");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.f4363a.onTouchEvent(motionEvent);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onWindowVisibilityChanged(int i3) {
        GLMapRender gLMapRender;
        super.onWindowVisibilityChanged(i3);
        y4.b("[map][lifecycle]", "AMapGLSurfaceView onWindowVisibilityChanged visibility " + i3);
        try {
            if (i3 == 8 || i3 == 4) {
                GLMapRender gLMapRender2 = this.f4364b;
                if (gLMapRender2 != null) {
                    gLMapRender2.renderPause();
                    return;
                }
                return;
            }
            if (i3 != 0 || (gLMapRender = this.f4364b) == null) {
                return;
            }
            gLMapRender.renderResume();
        } catch (Throwable th2) {
            th2.printStackTrace();
            v4.a(th2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setEGLConfigChooser(g4 g4Var) {
        setEGLConfigChooser((GLSurfaceView.EGLConfigChooser) g4Var);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setEGLContextFactory(h4 h4Var) {
        setEGLContextFactory((GLSurfaceView.EGLContextFactory) h4Var);
    }

    @Override // android.opengl.GLSurfaceView, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f4364b = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    public IAMapDelegate a() {
        return this.f4363a;
    }
}
