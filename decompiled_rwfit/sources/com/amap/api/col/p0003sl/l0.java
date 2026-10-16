package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* loaded from: classes.dex */
public class l0 extends x0 implements IGLSurfaceView {

    /* renamed from: j, reason: collision with root package name */
    private IAMapDelegate f4441j;

    /* renamed from: k, reason: collision with root package name */
    private GLMapRender f4442k;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (l0.this.f4442k != null) {
                    l0.this.f4442k.onSurfaceDestory();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                v4.a(th2);
            }
        }
    }

    public l0(Context context, boolean z5) {
        super(context, null);
        this.f4441j = null;
        this.f4442k = null;
        if (Build.VERSION.SDK_INT >= 34) {
            x.a(this, 8, 8, 8, 0, 16, 8);
        } else {
            x.a(this, 5, 6, 5, 0, 16, 8);
        }
        this.f4441j = new b0(this, context, z5);
    }

    @Override // com.amap.api.col.p0003sl.x0
    public void d() {
        y4.b("[map][lifecycle]", "AMapGLTextureView onPause mMapRender.mSurfacedestoryed " + this.f4442k.mSurfacedestoryed);
        if (!this.f4442k.mSurfacedestoryed) {
            queueEvent(new a());
            int i3 = 0;
            while (!this.f4442k.mSurfacedestoryed) {
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
        super.d();
    }

    public IAMapDelegate f() {
        return this.f4441j;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.x0, android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        y4.b("[map][lifecycle]", "AMapGLTextureView onAttachedToWindow");
        try {
            GLMapRender gLMapRender = this.f4442k;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        super.e();
        y4.b("[map][lifecycle]", "AMapGLTextureView onResume");
    }

    @Override // com.amap.api.col.p0003sl.x0, android.view.View
    public void onDetachedFromWindow() {
        y4.b("[map][lifecycle]", "AMapGLTextureView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        d();
        try {
            GLMapRender gLMapRender = this.f4442k;
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
        y4.b("[map][lifecycle]", "AMapGLTextureView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            d();
            try {
                GLMapRender gLMapRender = this.f4442k;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // com.amap.api.col.p0003sl.x0, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        y4.b("[map][lifecycle]", "AMapGLTextureView onSurfaceTextureDestroyed");
        requestRender();
        try {
            if (MapsInitializer.getTextureDestroyRender()) {
                Thread.sleep(100L);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            v4.a(th2);
        }
        super.onSurfaceTextureDestroyed(surfaceTexture);
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.f4441j.onTouchEvent(motionEvent);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i3) {
        GLMapRender gLMapRender;
        super.onWindowVisibilityChanged(i3);
        y4.b("[map][lifecycle]", "AMapGLTextureView onWindowVisibilityChanged visibility " + i3);
        try {
            if (i3 == 8 || i3 == 4) {
                GLMapRender gLMapRender2 = this.f4442k;
                if (gLMapRender2 != null) {
                    gLMapRender2.renderPause();
                }
                requestRender();
                return;
            }
            if (i3 != 0 || (gLMapRender = this.f4442k) == null) {
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
        a(g4Var);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setEGLContextFactory(h4 h4Var) {
        a(h4Var);
    }

    @Override // com.amap.api.col.p0003sl.x0, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f4442k = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setZOrderOnTop(boolean z5) {
    }
}
