package t7;

import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import v7.h;
import v7.i;

/* loaded from: classes.dex */
public final class a extends b {
    public Matrix e;

    /* renamed from: f, reason: collision with root package name */
    public Matrix f18569f;

    /* renamed from: g, reason: collision with root package name */
    public v7.d f18570g;

    /* renamed from: h, reason: collision with root package name */
    public v7.d f18571h;

    /* renamed from: i, reason: collision with root package name */
    public float f18572i;

    /* renamed from: j, reason: collision with root package name */
    public float f18573j;

    /* renamed from: k, reason: collision with root package name */
    public float f18574k;

    /* renamed from: l, reason: collision with root package name */
    public o7.d f18575l;

    /* renamed from: m, reason: collision with root package name */
    public VelocityTracker f18576m;

    /* renamed from: n, reason: collision with root package name */
    public long f18577n;

    /* renamed from: o, reason: collision with root package name */
    public v7.d f18578o;

    /* renamed from: p, reason: collision with root package name */
    public v7.d f18579p;

    /* renamed from: q, reason: collision with root package name */
    public float f18580q;
    public float r;

    public static float e(MotionEvent motionEvent) {
        float x10 = motionEvent.getX(0) - motionEvent.getX(1);
        float y4 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((y4 * y4) + (x10 * x10));
    }

    public final v7.d a(float f2, float f10) {
        i viewPortHandler = ((BarLineChartBase) this.f18584d).getViewPortHandler();
        float f11 = f2 - viewPortHandler.f19202b.left;
        b();
        return v7.d.b(f11, -((r0.getMeasuredHeight() - f10) - viewPortHandler.j()));
    }

    public final boolean b() {
        o7.d dVar = this.f18575l;
        Chart chart = this.f18584d;
        if (dVar == null) {
            BarLineChartBase barLineChartBase = (BarLineChartBase) chart;
            barLineChartBase.W.getClass();
            barLineChartBase.f8781a0.getClass();
        }
        if (dVar == null) {
            return false;
        }
        ((BarLineChartBase) chart).t(dVar.f16810d);
        return false;
    }

    public final void c(float f2, float f10) {
        this.e.set(this.f18569f);
        ((BarLineChartBase) this.f18584d).getOnChartGestureListener();
        b();
        this.e.postTranslate(f2, f10);
    }

    public final void d(MotionEvent motionEvent) {
        this.f18569f.set(this.e);
        float x10 = motionEvent.getX();
        v7.d dVar = this.f18570g;
        dVar.f19182b = x10;
        dVar.f19183c = motionEvent.getY();
        BarLineChartBase barLineChartBase = (BarLineChartBase) this.f18584d;
        q7.c j4 = barLineChartBase.j(motionEvent.getX(), motionEvent.getY());
        this.f18575l = j4 != null ? ((o7.c) barLineChartBase.f8792b).b(j4.f17801f) : null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        BarLineChartBase barLineChartBase = (BarLineChartBase) this.f18584d;
        barLineChartBase.getOnChartGestureListener();
        if (barLineChartBase.I && ((o7.c) barLineChartBase.getData()).d() > 0) {
            v7.d a3 = a(motionEvent.getX(), motionEvent.getY());
            float f2 = barLineChartBase.M ? 1.4f : 1.0f;
            float f10 = barLineChartBase.N ? 1.4f : 1.0f;
            float f11 = a3.f19182b;
            float f12 = a3.f19183c;
            i iVar = barLineChartBase.f8807s;
            Matrix matrix = barLineChartBase.f8789j0;
            iVar.getClass();
            matrix.reset();
            matrix.set(iVar.f19201a);
            matrix.postScale(f2, f10, f11, -f12);
            barLineChartBase.f8807s.k(matrix, barLineChartBase, false);
            barLineChartBase.f();
            barLineChartBase.postInvalidate();
            if (barLineChartBase.f8791a) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + a3.f19182b + ", y: " + a3.f19183c);
            }
            v7.d.c(a3);
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f10) {
        ((BarLineChartBase) this.f18584d).getOnChartGestureListener();
        return super.onFling(motionEvent, motionEvent2, f2, f10);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        ((BarLineChartBase) this.f18584d).getOnChartGestureListener();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        BarLineChartBase barLineChartBase = (BarLineChartBase) this.f18584d;
        barLineChartBase.getOnChartGestureListener();
        if (!barLineChartBase.f8793c) {
            return false;
        }
        q7.c j4 = barLineChartBase.j(motionEvent.getX(), motionEvent.getY());
        Chart chart = this.f18584d;
        if (j4 == null || j4.a(this.f18582b)) {
            chart.l(null);
            this.f18582b = null;
        } else {
            chart.l(j4);
            this.f18582b = j4;
        }
        return super.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        q7.c j4;
        VelocityTracker velocityTracker;
        if (this.f18576m == null) {
            this.f18576m = VelocityTracker.obtain();
        }
        this.f18576m.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.f18576m) != null) {
            velocityTracker.recycle();
            this.f18576m = null;
        }
        if (this.f18581a == 0) {
            this.f18583c.onTouchEvent(motionEvent);
        }
        Chart chart = this.f18584d;
        BarLineChartBase barLineChartBase = (BarLineChartBase) chart;
        int i3 = 0;
        if (!(barLineChartBase.K || barLineChartBase.L) && !barLineChartBase.M && !barLineChartBase.N) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f18584d.getOnChartGestureListener();
            v7.d dVar = this.f18579p;
            dVar.f19182b = 0.0f;
            dVar.f19183c = 0.0f;
            d(motionEvent);
        } else if (action != 1) {
            v7.d dVar2 = this.f18571h;
            if (action == 2) {
                int i10 = this.f18581a;
                v7.d dVar3 = this.f18570g;
                if (i10 == 1) {
                    ViewParent parent = barLineChartBase.getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    c(barLineChartBase.K ? motionEvent.getX() - dVar3.f19182b : 0.0f, barLineChartBase.L ? motionEvent.getY() - dVar3.f19183c : 0.0f);
                } else if (i10 == 2 || i10 == 3 || i10 == 4) {
                    ViewParent parent2 = barLineChartBase.getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    if ((barLineChartBase.M || barLineChartBase.N) && motionEvent.getPointerCount() >= 2) {
                        barLineChartBase.getOnChartGestureListener();
                        float e = e(motionEvent);
                        if (e > this.r) {
                            v7.d a3 = a(dVar2.f19182b, dVar2.f19183c);
                            i viewPortHandler = barLineChartBase.getViewPortHandler();
                            int i11 = this.f18581a;
                            Matrix matrix = this.f18569f;
                            if (i11 == 4) {
                                float f2 = e / this.f18574k;
                                boolean z5 = f2 < 1.0f;
                                boolean z6 = !z5 ? viewPortHandler.f19208i >= viewPortHandler.f19207h : viewPortHandler.f19208i <= viewPortHandler.f19206g;
                                if (!z5 ? viewPortHandler.f19209j < viewPortHandler.f19205f : viewPortHandler.f19209j > viewPortHandler.e) {
                                    i3 = 1;
                                }
                                float f10 = barLineChartBase.M ? f2 : 1.0f;
                                float f11 = barLineChartBase.N ? f2 : 1.0f;
                                if (i3 != 0 || z6) {
                                    this.e.set(matrix);
                                    this.e.postScale(f10, f11, a3.f19182b, a3.f19183c);
                                }
                            } else if (i11 == 2 && barLineChartBase.M) {
                                float abs = Math.abs(motionEvent.getX(0) - motionEvent.getX(1)) / this.f18572i;
                                if (abs >= 1.0f ? viewPortHandler.f19208i < viewPortHandler.f19207h : viewPortHandler.f19208i > viewPortHandler.f19206g) {
                                    this.e.set(matrix);
                                    this.e.postScale(abs, 1.0f, a3.f19182b, a3.f19183c);
                                }
                            } else if (i11 == 3 && barLineChartBase.N) {
                                float abs2 = Math.abs(motionEvent.getY(0) - motionEvent.getY(1)) / this.f18573j;
                                if (abs2 >= 1.0f ? viewPortHandler.f19209j < viewPortHandler.f19205f : viewPortHandler.f19209j > viewPortHandler.e) {
                                    this.e.set(matrix);
                                    this.e.postScale(1.0f, abs2, a3.f19182b, a3.f19183c);
                                }
                            }
                            v7.d.c(a3);
                        }
                    }
                } else if (i10 == 0) {
                    float x10 = motionEvent.getX() - dVar3.f19182b;
                    float y4 = motionEvent.getY() - dVar3.f19183c;
                    if (Math.abs((float) Math.sqrt((y4 * y4) + (x10 * x10))) > this.f18580q && (barLineChartBase.K || barLineChartBase.L)) {
                        i iVar = barLineChartBase.f8807s;
                        if (iVar.a() && iVar.b()) {
                            i iVar2 = barLineChartBase.f8807s;
                            if (iVar2.f19211l <= 0.0f && iVar2.f19212m <= 0.0f) {
                                boolean z8 = barLineChartBase.J;
                                if (z8 && z8 && (j4 = barLineChartBase.j(motionEvent.getX(), motionEvent.getY())) != null && !j4.a(this.f18582b)) {
                                    this.f18582b = j4;
                                    barLineChartBase.l(j4);
                                }
                            }
                        }
                        float abs3 = Math.abs(motionEvent.getX() - dVar3.f19182b);
                        float abs4 = Math.abs(motionEvent.getY() - dVar3.f19183c);
                        if ((barLineChartBase.K || abs4 >= abs3) && (barLineChartBase.L || abs4 <= abs3)) {
                            this.f18581a = 1;
                        }
                    }
                }
            } else if (action == 3) {
                this.f18581a = 0;
                this.f18584d.getOnChartGestureListener();
            } else if (action != 5) {
                if (action == 6) {
                    VelocityTracker velocityTracker2 = this.f18576m;
                    velocityTracker2.computeCurrentVelocity(1000, h.f19193c);
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    float xVelocity = velocityTracker2.getXVelocity(pointerId);
                    float yVelocity = velocityTracker2.getYVelocity(pointerId);
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i3 >= pointerCount) {
                            break;
                        }
                        if (i3 != actionIndex) {
                            int pointerId2 = motionEvent.getPointerId(i3);
                            if ((velocityTracker2.getYVelocity(pointerId2) * yVelocity) + (velocityTracker2.getXVelocity(pointerId2) * xVelocity) < 0.0f) {
                                velocityTracker2.clear();
                                break;
                            }
                        }
                        i3++;
                    }
                    this.f18581a = 5;
                }
            } else if (motionEvent.getPointerCount() >= 2) {
                ViewParent parent3 = barLineChartBase.getParent();
                if (parent3 != null) {
                    parent3.requestDisallowInterceptTouchEvent(true);
                }
                d(motionEvent);
                this.f18572i = Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
                this.f18573j = Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
                float e10 = e(motionEvent);
                this.f18574k = e10;
                if (e10 > 10.0f) {
                    if (barLineChartBase.H) {
                        this.f18581a = 4;
                    } else {
                        boolean z10 = barLineChartBase.M;
                        if (z10 != barLineChartBase.N) {
                            this.f18581a = z10 ? 2 : 3;
                        } else {
                            this.f18581a = this.f18572i > this.f18573j ? 2 : 3;
                        }
                    }
                }
                float x11 = motionEvent.getX(1) + motionEvent.getX(0);
                float y10 = motionEvent.getY(1) + motionEvent.getY(0);
                dVar2.f19182b = x11 / 2.0f;
                dVar2.f19183c = y10 / 2.0f;
            }
        } else {
            VelocityTracker velocityTracker3 = this.f18576m;
            int pointerId3 = motionEvent.getPointerId(0);
            velocityTracker3.computeCurrentVelocity(1000, h.f19193c);
            float yVelocity2 = velocityTracker3.getYVelocity(pointerId3);
            float xVelocity2 = velocityTracker3.getXVelocity(pointerId3);
            if ((Math.abs(xVelocity2) > h.f19192b || Math.abs(yVelocity2) > h.f19192b) && this.f18581a == 1 && barLineChartBase.f8794d) {
                v7.d dVar4 = this.f18579p;
                dVar4.f19182b = 0.0f;
                dVar4.f19183c = 0.0f;
                this.f18577n = AnimationUtils.currentAnimationTimeMillis();
                float x12 = motionEvent.getX();
                v7.d dVar5 = this.f18578o;
                dVar5.f19182b = x12;
                dVar5.f19183c = motionEvent.getY();
                v7.d dVar6 = this.f18579p;
                dVar6.f19182b = xVelocity2;
                dVar6.f19183c = yVelocity2;
                chart.postInvalidateOnAnimation();
            }
            int i12 = this.f18581a;
            if (i12 == 2 || i12 == 3 || i12 == 4 || i12 == 5) {
                barLineChartBase.f();
                barLineChartBase.postInvalidate();
            }
            this.f18581a = 0;
            ViewParent parent4 = barLineChartBase.getParent();
            if (parent4 != null) {
                parent4.requestDisallowInterceptTouchEvent(false);
            }
            VelocityTracker velocityTracker4 = this.f18576m;
            if (velocityTracker4 != null) {
                velocityTracker4.recycle();
                this.f18576m = null;
            }
            this.f18584d.getOnChartGestureListener();
        }
        i viewPortHandler2 = barLineChartBase.getViewPortHandler();
        Matrix matrix2 = this.e;
        viewPortHandler2.k(matrix2, chart, true);
        this.e = matrix2;
        return true;
    }
}
