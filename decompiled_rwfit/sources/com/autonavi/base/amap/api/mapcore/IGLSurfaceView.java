package com.autonavi.base.amap.api.mapcore;

import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.amap.api.col.p0003sl.g4;
import com.amap.api.col.p0003sl.h4;

/* loaded from: classes.dex */
public interface IGLSurfaceView {
    int getHeight();

    SurfaceHolder getHolder();

    ViewParent getParent();

    int getRenderMode();

    int getWidth();

    boolean isEnabled();

    void onDetachedGLThread();

    boolean post(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j4);

    void queueEvent(Runnable runnable);

    void requestRender();

    void setBackgroundColor(int i3);

    void setEGLConfigChooser(g4 g4Var);

    void setEGLContextFactory(h4 h4Var);

    void setRenderMode(int i3);

    void setRenderer(GLSurfaceView.Renderer renderer);

    void setVisibility(int i3);

    void setZOrderOnTop(boolean z5);
}
