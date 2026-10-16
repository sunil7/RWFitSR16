package com.dh.imagepick.preview.widgets.video;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.contrarywind.view.WheelView;
import com.google.android.gms.internal.mlkit_common.o;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.gesture.g;
import j7.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class c extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7192a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7193b;

    public /* synthetic */ c(Object obj, int i3) {
        this.f7192a = i3;
        this.f7193b = obj;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent e) {
        switch (this.f7192a) {
            case 2:
                e.f(e, "e");
                e.getX();
                ((o) this.f7193b).getClass();
                e.getY();
                return true;
            case 3:
                e.f(e, "e");
                float x10 = e.getX();
                ie.c cVar = (ie.c) this.f7193b;
                cVar.f14416i = x10;
                cVar.f14417j = e.getY();
                cVar.f14418k = 1;
                return true;
            default:
                return super.onDoubleTap(e);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f10) {
        switch (this.f7192a) {
            case 4:
                ((m) this.f7193b).getClass();
                return false;
            case 5:
                WheelView wheelView = (WheelView) this.f7193b;
                wheelView.a();
                wheelView.f7064i = wheelView.f7063h.scheduleWithFixedDelay(new x4.a(wheelView, f10), 0L, 5L, TimeUnit.MILLISECONDS);
                return true;
            default:
                return super.onFling(motionEvent, motionEvent2, f2, f10);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent e) {
        switch (this.f7192a) {
            case 0:
                e.f(e, "e");
                ExoVideoView2 exoVideoView2 = (ExoVideoView2) this.f7193b;
                View.OnLongClickListener onLongClickListener = exoVideoView2.f7190o;
                if (onLongClickListener != null) {
                    onLongClickListener.onLongClick(exoVideoView2);
                    break;
                }
                break;
            case 1:
                g gVar = (g) this.f7193b;
                gVar.e = true;
                gVar.f11596b = Gesture.LONG_TAP;
                break;
            case 2:
            case 3:
            default:
                super.onLongPress(e);
                break;
            case 4:
                m mVar = (m) this.f7193b;
                View.OnLongClickListener onLongClickListener2 = mVar.f15363q;
                if (onLongClickListener2 != null) {
                    onLongClickListener2.onLongClick(mVar.f15354h);
                    break;
                }
                break;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        switch (this.f7192a) {
            case 1:
                g gVar = (g) this.f7193b;
                gVar.e = true;
                gVar.f11596b = Gesture.TAP;
                return true;
            default:
                return super.onSingleTapUp(motionEvent);
        }
    }

    public c(WheelView wheelView) {
        this.f7192a = 5;
        this.f7193b = wheelView;
    }
}
