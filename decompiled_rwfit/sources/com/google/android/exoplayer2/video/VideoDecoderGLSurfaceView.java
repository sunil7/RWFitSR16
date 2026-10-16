package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import j9.b;
import j9.c;
import j9.d;

/* loaded from: classes.dex */
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements d {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f9053b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final b f9054a;

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    @Deprecated
    public d getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(c cVar) {
        b bVar = this.f9054a;
        if (bVar.f15377f.getAndSet(cVar) != null) {
            throw new ClassCastException();
        }
        bVar.f15373a.requestRender();
    }

    public VideoDecoderGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b bVar = new b(this);
        this.f9054a = bVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(bVar);
        setRenderMode(0);
    }
}
