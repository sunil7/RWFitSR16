package t7;

import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import v7.h;

/* loaded from: classes.dex */
public final class g extends b {
    public v7.d e;

    /* renamed from: f, reason: collision with root package name */
    public float f18587f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f18588g;

    /* renamed from: h, reason: collision with root package name */
    public long f18589h;

    /* renamed from: i, reason: collision with root package name */
    public float f18590i;

    public final void a(float f2, float f10) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        ArrayList arrayList = this.f18588g;
        float s7 = ((PieRadarChartBase) this.f18584d).s(f2, f10);
        f fVar = new f();
        fVar.f18585a = currentAnimationTimeMillis;
        fVar.f18586b = s7;
        arrayList.add(fVar);
        for (int size = arrayList.size(); size - 2 > 0 && currentAnimationTimeMillis - ((f) arrayList.get(0)).f18585a > 1000; size--) {
            arrayList.remove(0);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        ((PieRadarChartBase) this.f18584d).getOnChartGestureListener();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        PieRadarChartBase pieRadarChartBase = (PieRadarChartBase) this.f18584d;
        pieRadarChartBase.getOnChartGestureListener();
        if (!pieRadarChartBase.f8793c) {
            return false;
        }
        q7.c j4 = pieRadarChartBase.j(motionEvent.getX(), motionEvent.getY());
        Chart chart = this.f18584d;
        if (j4 == null || j4.a(this.f18582b)) {
            chart.l(null);
            this.f18582b = null;
            return true;
        }
        chart.l(j4);
        this.f18582b = j4;
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        float abs;
        Chart chart = this.f18584d;
        if (!this.f18583c.onTouchEvent(motionEvent)) {
            PieRadarChartBase pieRadarChartBase = (PieRadarChartBase) chart;
            if (pieRadarChartBase.H) {
                float x10 = motionEvent.getX();
                float y4 = motionEvent.getY();
                int action = motionEvent.getAction();
                ArrayList arrayList = this.f18588g;
                v7.d dVar = this.e;
                if (action == 0) {
                    chart.getOnChartGestureListener();
                    this.f18590i = 0.0f;
                    arrayList.clear();
                    if (pieRadarChartBase.f8794d) {
                        a(x10, y4);
                    }
                    this.f18587f = pieRadarChartBase.s(x10, y4) - pieRadarChartBase.getRawRotationAngle();
                    dVar.f19182b = x10;
                    dVar.f19183c = y4;
                } else {
                    if (action == 1) {
                        if (pieRadarChartBase.f8794d) {
                            this.f18590i = 0.0f;
                            a(x10, y4);
                            if (arrayList.isEmpty()) {
                                abs = 0.0f;
                            } else {
                                f fVar = (f) arrayList.get(0);
                                f fVar2 = (f) l0.h(1, arrayList);
                                f fVar3 = fVar;
                                for (int size = arrayList.size() - 1; size >= 0; size--) {
                                    fVar3 = (f) arrayList.get(size);
                                    if (fVar3.f18586b != fVar2.f18586b) {
                                        break;
                                    }
                                }
                                float f2 = (fVar2.f18585a - fVar.f18585a) / 1000.0f;
                                if (f2 == 0.0f) {
                                    f2 = 0.1f;
                                }
                                boolean z5 = fVar2.f18586b >= fVar3.f18586b;
                                if (Math.abs(r7 - r10) > 270.0d) {
                                    z5 = !z5;
                                }
                                float f10 = fVar2.f18586b;
                                float f11 = fVar.f18586b;
                                if (f10 - f11 > 180.0d) {
                                    fVar.f18586b = (float) (f11 + 360.0d);
                                } else if (f11 - f10 > 180.0d) {
                                    fVar2.f18586b = (float) (f10 + 360.0d);
                                }
                                abs = Math.abs((fVar2.f18586b - fVar.f18586b) / f2);
                                if (!z5) {
                                    abs = -abs;
                                }
                            }
                            this.f18590i = abs;
                            if (abs != 0.0f) {
                                this.f18589h = AnimationUtils.currentAnimationTimeMillis();
                                DisplayMetrics displayMetrics = h.f19191a;
                                chart.postInvalidateOnAnimation();
                            }
                        }
                        ViewParent parent = pieRadarChartBase.getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(false);
                        }
                        this.f18581a = 0;
                        chart.getOnChartGestureListener();
                        return true;
                    }
                    if (action == 2) {
                        if (pieRadarChartBase.f8794d) {
                            a(x10, y4);
                        }
                        if (this.f18581a == 0) {
                            float f12 = x10 - dVar.f19182b;
                            float f13 = y4 - dVar.f19183c;
                            if (((float) Math.sqrt((f13 * f13) + (f12 * f12))) > h.c(8.0f)) {
                                this.f18581a = 6;
                                ViewParent parent2 = pieRadarChartBase.getParent();
                                if (parent2 != null) {
                                    parent2.requestDisallowInterceptTouchEvent(true);
                                }
                                chart.getOnChartGestureListener();
                                return true;
                            }
                        }
                        if (this.f18581a == 6) {
                            pieRadarChartBase.setRotationAngle(pieRadarChartBase.s(x10, y4) - this.f18587f);
                            pieRadarChartBase.invalidate();
                        }
                        chart.getOnChartGestureListener();
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
