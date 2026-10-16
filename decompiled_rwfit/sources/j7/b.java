package j7;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.OverScroller;
import com.example.test.ui.device.activity.i0;
import com.github.chrisbanes.photoview.PhotoView;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public int f15329a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f15330b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final ScaleGestureDetector f15331c;

    /* renamed from: d, reason: collision with root package name */
    public VelocityTracker f15332d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public float f15333f;

    /* renamed from: g, reason: collision with root package name */
    public float f15334g;

    /* renamed from: h, reason: collision with root package name */
    public final float f15335h;

    /* renamed from: i, reason: collision with root package name */
    public final float f15336i;

    /* renamed from: j, reason: collision with root package name */
    public final i0 f15337j;

    public b(Context context, i0 i0Var) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f15336i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f15335h = viewConfiguration.getScaledTouchSlop();
        this.f15337j = i0Var;
        this.f15331c = new ScaleGestureDetector(context, new a(this));
    }

    public final void a(MotionEvent motionEvent) {
        float x10;
        float y4;
        float x11;
        float y10;
        RectF rectF;
        int i3;
        int i10;
        int i11;
        int i12;
        float x12;
        float y11;
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            i0 i0Var = this.f15337j;
            if (action == 1) {
                this.f15329a = -1;
                if (this.e && this.f15332d != null) {
                    try {
                        x11 = motionEvent.getX(this.f15330b);
                    } catch (Exception unused) {
                        x11 = motionEvent.getX();
                    }
                    this.f15333f = x11;
                    try {
                        y10 = motionEvent.getY(this.f15330b);
                    } catch (Exception unused2) {
                        y10 = motionEvent.getY();
                    }
                    this.f15334g = y10;
                    this.f15332d.addMovement(motionEvent);
                    this.f15332d.computeCurrentVelocity(1000);
                    float xVelocity = this.f15332d.getXVelocity();
                    float yVelocity = this.f15332d.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f15336i) {
                        m mVar = (m) i0Var.f7866b;
                        l lVar = new l(mVar, mVar.f15354h.getContext());
                        mVar.r = lVar;
                        PhotoView photoView = mVar.f15354h;
                        int width = (photoView.getWidth() - photoView.getPaddingLeft()) - photoView.getPaddingRight();
                        int height = (photoView.getHeight() - photoView.getPaddingTop()) - photoView.getPaddingBottom();
                        int i13 = (int) (-xVelocity);
                        int i14 = (int) (-yVelocity);
                        mVar.b();
                        Matrix c9 = mVar.c();
                        if (mVar.f15354h.getDrawable() != null) {
                            rectF = mVar.f15360n;
                            rectF.set(0.0f, 0.0f, r12.getIntrinsicWidth(), r12.getIntrinsicHeight());
                            c9.mapRect(rectF);
                        } else {
                            rectF = null;
                        }
                        if (rectF != null) {
                            int round = Math.round(-rectF.left);
                            float f2 = width;
                            if (f2 < rectF.width()) {
                                i3 = Math.round(rectF.width() - f2);
                                i10 = 0;
                            } else {
                                i3 = round;
                                i10 = i3;
                            }
                            int round2 = Math.round(-rectF.top);
                            float f10 = height;
                            if (f10 < rectF.height()) {
                                i11 = Math.round(rectF.height() - f10);
                                i12 = 0;
                            } else {
                                i11 = round2;
                                i12 = i11;
                            }
                            lVar.f15345b = round;
                            lVar.f15346c = round2;
                            if (round != i3 || round2 != i11) {
                                ((OverScroller) lVar.f15347d).fling(round, round2, i13, i14, i10, i3, i12, i11, 0, 0);
                            }
                        }
                        photoView.post(mVar.r);
                    }
                }
                VelocityTracker velocityTracker = this.f15332d;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.f15332d = null;
                }
            } else if (action == 2) {
                try {
                    x12 = motionEvent.getX(this.f15330b);
                } catch (Exception unused3) {
                    x12 = motionEvent.getX();
                }
                try {
                    y11 = motionEvent.getY(this.f15330b);
                } catch (Exception unused4) {
                    y11 = motionEvent.getY();
                }
                float f11 = x12 - this.f15333f;
                float f12 = y11 - this.f15334g;
                if (!this.e) {
                    this.e = Math.sqrt((double) ((f12 * f12) + (f11 * f11))) >= ((double) this.f15335h);
                }
                if (this.e) {
                    m mVar2 = (m) i0Var.f7866b;
                    if (!mVar2.f15356j.f15331c.isInProgress()) {
                        mVar2.f15359m.postTranslate(f11, f12);
                        mVar2.a();
                        ViewParent parent = mVar2.f15354h.getParent();
                        if (mVar2.f15352f && !mVar2.f15356j.f15331c.isInProgress() && !mVar2.f15353g) {
                            int i15 = mVar2.f15364s;
                            if ((i15 == 2 || ((i15 == 0 && f11 >= 1.0f) || (i15 == 1 && f11 <= -1.0f))) && parent != null) {
                                parent.requestDisallowInterceptTouchEvent(false);
                            }
                        } else if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    this.f15333f = x12;
                    this.f15334g = y11;
                    VelocityTracker velocityTracker2 = this.f15332d;
                    if (velocityTracker2 != null) {
                        velocityTracker2.addMovement(motionEvent);
                    }
                }
            } else if (action == 3) {
                this.f15329a = -1;
                VelocityTracker velocityTracker3 = this.f15332d;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f15332d = null;
                }
            } else if (action == 6) {
                int action2 = (motionEvent.getAction() & 65280) >> 8;
                if (motionEvent.getPointerId(action2) == this.f15329a) {
                    int i16 = action2 != 0 ? 0 : 1;
                    this.f15329a = motionEvent.getPointerId(i16);
                    this.f15333f = motionEvent.getX(i16);
                    this.f15334g = motionEvent.getY(i16);
                }
            }
        } else {
            this.f15329a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f15332d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            try {
                x10 = motionEvent.getX(this.f15330b);
            } catch (Exception unused5) {
                x10 = motionEvent.getX();
            }
            this.f15333f = x10;
            try {
                y4 = motionEvent.getY(this.f15330b);
            } catch (Exception unused6) {
                y4 = motionEvent.getY();
            }
            this.f15334g = y4;
            this.e = false;
        }
        int i17 = this.f15329a;
        this.f15330b = motionEvent.findPointerIndex(i17 != -1 ? i17 : 0);
    }
}
