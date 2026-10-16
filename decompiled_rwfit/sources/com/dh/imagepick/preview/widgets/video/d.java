package com.dh.imagepick.preview.widgets.video;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import j7.m;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class d implements GestureDetector.OnDoubleTapListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7194a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View.OnTouchListener f7195b;

    public /* synthetic */ d(View.OnTouchListener onTouchListener, int i3) {
        this.f7194a = i3;
        this.f7195b = onTouchListener;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent p02) {
        switch (this.f7194a) {
            case 0:
                e.f(p02, "p0");
                break;
            default:
                m mVar = (m) this.f7195b;
                try {
                    float d5 = mVar.d();
                    float x10 = p02.getX();
                    float y4 = p02.getY();
                    float f2 = mVar.f15351d;
                    if (d5 < f2) {
                        mVar.e(f2, x10, y4, true);
                    } else {
                        if (d5 >= f2) {
                            float f10 = mVar.e;
                            if (d5 < f10) {
                                mVar.e(f10, x10, y4, true);
                            }
                        }
                        mVar.e(mVar.f15350c, x10, y4, true);
                    }
                    break;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    break;
                }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent p02) {
        switch (this.f7194a) {
            case 0:
                e.f(p02, "p0");
                break;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent p02) {
        RectF rectF;
        switch (this.f7194a) {
            case 0:
                e.f(p02, "p0");
                ExoVideoView2 exoVideoView2 = (ExoVideoView2) this.f7195b;
                View.OnClickListener onClickListener = exoVideoView2.f7189n;
                if (onClickListener != null) {
                    onClickListener.onClick(exoVideoView2);
                    break;
                }
                break;
            default:
                m mVar = (m) this.f7195b;
                View.OnClickListener onClickListener2 = mVar.f15362p;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(mVar.f15354h);
                }
                mVar.b();
                Matrix c9 = mVar.c();
                if (mVar.f15354h.getDrawable() != null) {
                    rectF = mVar.f15360n;
                    rectF.set(0.0f, 0.0f, r2.getIntrinsicWidth(), r2.getIntrinsicHeight());
                    c9.mapRect(rectF);
                } else {
                    rectF = null;
                }
                float x10 = p02.getX();
                float y4 = p02.getY();
                if (rectF != null && rectF.contains(x10, y4)) {
                    rectF.width();
                    rectF.height();
                    break;
                }
                break;
        }
        return true;
    }
}
