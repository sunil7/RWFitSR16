package com.amap.api.col.p0003sl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* loaded from: classes.dex */
public class j0 implements IGLSurfaceView {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f4310a;

    public j0(Context context, AttributeSet attributeSet) {
        this.f4310a = null;
        this.f4310a = new b0(this, context, (AttributeSet) null);
    }

    public IAMapDelegate a() {
        return this.f4310a;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public int getHeight() {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public ViewParent getParent() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public int getRenderMode() {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public int getWidth() {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public boolean isEnabled() {
        return this.f4310a != null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void onDetachedGLThread() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public boolean post(Runnable runnable) {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public boolean postDelayed(Runnable runnable, long j4) {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void queueEvent(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void requestRender() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setBackgroundColor(int i3) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setEGLConfigChooser(g4 g4Var) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setEGLContextFactory(h4 h4Var) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setRenderMode(int i3) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setRenderer(GLSurfaceView.Renderer renderer) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setVisibility(int i3) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public void setZOrderOnTop(boolean z5) {
    }
}
